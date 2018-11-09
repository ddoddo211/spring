package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.user.util.model.PageVo;

@RequestMapping("/user")
@Controller
public class UserController {

	// userService 스프링 빈 주입
	@Resource(name = "userService")
	private UserServiceInf userService;

	public final String ID = "brown";
	public final String PW = "brownpass";

	@RequestMapping("/loginView")
	public String login() {

		return "/login/login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(UserVo userVo) {

		if (userVo.getUserId().equals(ID) && userVo.getPass().equals(PW)) {
			return "main";
		} else {
			return "/login/login";

		}

	}

	/**
	 * Method : userAllList 작성자 : bms 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 조회
	 */
	@RequestMapping("/userAllList")
	public String userAllList(Model model) {

		// userService 사용자 전체 정보조회
		List<UserVo> userList = userService.selectUserAll();

		model.addAttribute("userList", userList);

		return "user/userAllList";
	}

	@RequestMapping("/userPageList")
	public String userPageList(Model model, PageVo pageVo) {

//		// 전체 사용자 정보 조회
//		//List<UserVo> userList = userService.selectUserAll();
		// pagenation
//		int page = 0;
//		if (pageVo.getPage() == 0) {
//			page = 1;
//		} else {
//			page = pageVo.getPage();
//		}
//		int pageSize = 10;
//		pageVo.setPage(page);
//		pageVo.setPageSize(pageSize);
//
//		// userServiceInf userService
//		// spring 컨테이너로부터 bean 을부입받기 때문에 new 연산자를 통해 생성할 필요 없음
//		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
//		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
//
//		//model.addAttribute("userListP", userListP);
//		model.addAttribute("totalCnt", userService.getUserCnt());
//		model.addAttribute("userList", userList);
//		model.addAttribute("pageVo", pageVo);

		return "user/userPageList";
	} // userPageList 종료
	
	@RequestMapping("/userPageListAjax")
	public String userPageListAjax(Model model, PageVo pageVo) {
		
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		
		model.addAttribute("userList", userList);
		model.addAttribute("pageVo",pageVo);
		model.addAttribute("page",pageVo.getPage());
		model.addAttribute("totalCnt", userService.getUserCnt());
		
		return "jsonView";
	}
	
	@RequestMapping("/userPageListAjaxHtml")
	public String userPageListAjaxHtml(Model model, PageVo pageVo) {
		
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		
		model.addAttribute("userList", userList);
		model.addAttribute("pageVo",pageVo);
		model.addAttribute("page",pageVo.getPage());
		model.addAttribute("totalCnt", userService.getUserCnt());
		
		return "user/pageListHtml";
	}
	
	@RequestMapping("/pageListHtml")
	public String userPagenationHtml(Model model, PageVo pageVo) {
		
		
		
		model.addAttribute("pageVo",pageVo);
		model.addAttribute("page",pageVo.getPage());
		model.addAttribute("totalCnt", userService.getUserCnt());
		
		return "user/userPagenationHtml";
	}
	
	

	@RequestMapping("/userDetail")
	public String userDetail(@RequestParam("userId") String userId, Model model) {

		UserVo userVo = userService.selectUser(userId);

		model.addAttribute("userVo", userVo);

		return "user/userDetail";
	}

	@RequestMapping(value = "/userForm", method = { RequestMethod.GET })
	public String userFormView() {

		return "user/userForm";
	}

	@RequestMapping(value = "/userForm", method = { RequestMethod.POST })
	public String userInsert(@RequestPart("profilePic") MultipartFile part, HttpServletRequest request, UserVo userVo) {

		try {
			if (part.getSize() > 0) {

				String path = request.getServletContext().getRealPath("/profile");

				String fileName = part.getOriginalFilename();

				userVo.setProfile("/profile/" + fileName);

				part.transferTo(new File(path + File.separator + fileName));
			} else {
				userVo.setProfile("");
			}

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int insertCnt = userService.insertUser(userVo);

		return "redirect:/user/userPageList?page=1";
	}
	
	
	
	
	@RequestMapping(value = "/userUpdate", method = { RequestMethod.GET })
	public String userUpdateView(UserVo userVo, Model model) {
		
		userVo = userService.selectUser(userVo.getUserId());
		
		model.addAttribute("userVo",userVo);
		
		return "user/userUpdate";
	}
	
	@RequestMapping(value = "/userUpdate", method = { RequestMethod.POST })
	public String userUpdate(@RequestPart("profilePic") MultipartFile part, HttpServletRequest request, UserVo userVo) {
		
		try {
			if (part.getSize() > 0) {
				
				String path = request.getServletContext().getRealPath("/profile");
				
				String fileName = part.getOriginalFilename();
				
				userVo.setProfile("/profile/" + fileName);
				
				part.transferTo(new File(path + File.separator + fileName));
			} else {
				userVo.setProfile("");
			}
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int insertCnt = userService.userUpdate(userVo);
		
		return "redirect:/user/userDetail?userId="+userVo.getUserId();
	}

}

//
