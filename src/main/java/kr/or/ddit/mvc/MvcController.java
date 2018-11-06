package kr.or.ddit.mvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.util.FileUtil;

//@ModelAttribute 에 의해 저장된 속성이 있을경우
// 재요청시 @ModelAttribute 가 적용된 메소드를 재실행하지 않고 
//세션에 저장하여 값을 재활용(잘 변경되지않는 값을 저장할 경우 메소드가 매번 호출되는 과부하를 줄일 수 있다)
@SessionAttributes("rangers")
@Controller
public class MvcController {
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	/*
	 * @RequestMapping 이 붙은 메소드가 실행되기 전에 먼저 실행됨
	 * 해당 컨트롤러에서 공통적으로 사용될 속성이 있을경우
	 * 중복을 피하기위해 @ModelAttribute 어노테이션을 적용한 메소드를 통해 코드 중복을 막을 수 있음
	 */
	//리턴타입 변경 테스트 (void >>> List<String> )
	@ModelAttribute(value="rangers")
	public List<String> setup() {
		
		logger.debug("{}","setup");
		
		List<String> rangers = new ArrayList<>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		//model.addAttribute("rangers",rangers);
		return rangers;
		
	}
	
	
	@RequestMapping("/mvc/view")
	public String mvcView(@ModelAttribute("rangers")List<String> rangers) {
//		for(String ranger : rangers) {
//		logger.debug("mvcV ranger : {}",ranger);
//		}
		rangers.add("james");
		
		return "mvc/view";
	}
	
	//@pathvariable : 요청 urld 의 일부를 메소드 인자로 쉽게 받을 수 있는 어노테이션
	// http://localhost:8081/mvc/central : logger central
	// htpp://localhost:8081/mvc/left : logger left
	@RequestMapping ("/mvc/{libcd}")
	public String pathvariable(@PathVariable("libcd") String libcd) {
		logger.debug("ligcd : {}",libcd);
		return "mvc/view";
	}
	
	//fileupload 테스트를 위한 view(get)
	@RequestMapping(value ="/mvc/fileupload", method= {RequestMethod.GET})
	public String fileuploadView() {
		
		return "mvc/fileuploadView";
	}
	
	//fileupload (파일전송) 을 처리하기 위한 controller method(post)
	@RequestMapping(value ="/mvc/fileupload", method= {RequestMethod.POST})
	public String fileupload(@RequestPart("uploadFile") MultipartFile part, @RequestParam("userId") String userId) {
		
		logger.debug("requestParam userId : {}",userId);
		logger.debug("partSize : {}",part.getSize());
		logger.debug("originalFIleName : {}",part.getOriginalFilename());
		FileUtil fu = new FileUtil();
		//1. File객체 생성 (경로 + 파일명 ==> 파일명 중복방지를 위해 유니크한 임의의 파일명을 생성)
		String path = "C:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\";
		String orginameFileName = part.getOriginalFilename();	//사용자가 업로드한 실제 파일명
		String fileExt = FileUtil.getFileExt(orginameFileName);// 확장자 // FileUtil.getFileExt(String fileName) 메소드 생성
		String fileName = UUID.randomUUID().toString() + fileExt;			//충돌 방지를 위한 임의의 파일명
		
								//확장자 있을때 .을 포함한 확장자 값을 리턴
								//없을때 "" 리턴
								//테스트 값 : sally.png ==>png
								//테스트값 : sally ==> "" 리턴
		File file = new File(path + File.separator + fileName);
		
		FileVo fileVo = new FileVo();
		fileVo.setFile_name(fileName);
		fileVo.setFile_path(path);
		fileVo.setOrg_file_name(orginameFileName);
		fileVo.setFile_ext(fileExt);
		
		logger.debug("fileVo : {}",fileVo);
		
		try {
			if(part.getSize() > 0) {
			//정해진 path 에 업로드 파일을 작성
			part.transferTo(file);
			
			//데이터 베이스에 첨부파일 정보저장 
			// 1. fileService
			
			// 2. 로직호출
			int insertCnt = fileService.insertFile(fileVo);
			}
		} catch (IllegalStateException | IOException e) {
			// TODO: handle exception
		}
		
		 return "mvc/fileuploadView";
	}
	
	
	
	
}
