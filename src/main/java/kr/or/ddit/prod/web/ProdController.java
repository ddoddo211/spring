package kr.or.ddit.prod.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.util.model.PageVo;

@RequestMapping("/prod")
@Controller
public class ProdController {
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	
	@RequestMapping("/prodList")
	public String prodAllList(Model model, PageVo pageVo) {

		
		int page = 0;
		if(pageVo.getPage()==0) {
			page = 1;
		} else {
			page = pageVo.getPage();
		}
		int pageSize = 10;
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		int totalCnt = prodService.selectProdAllCnt();
		
		
		// prodService 사용자 전체 정보조회
		List<ProdVo> prodList = prodService.selectProdAll(pageVo);

		model.addAttribute("pageVo",pageVo);
		model.addAttribute("totalCnt",totalCnt);
		
		model.addAttribute("prodList", prodList);

		return "prod/prodList";
	}
	@RequestMapping("/prodDetail")
	public String prodDetail(Model model,@RequestParam("prod_id") String prod_id) {
		
		ProdVo prodVo = prodService.selectProdAll(prod_id);
		
		model.addAttribute("prodVo",prodVo);
		
		return "prod/prodDetail";
	}

}
