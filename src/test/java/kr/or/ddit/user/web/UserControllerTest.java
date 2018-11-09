package kr.or.ddit.user.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;


public class UserControllerTest extends ControllerTestConfig {

	
	
	
	/**  
	* Method   : loginViewTest 
	* 작성자 : bms 
	* 변경이력 :    
	* Method 설명 :  
	 * @throws Exception 
	*/
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/user/loginView")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals("/login/login", mav.getViewName());
	}
	
	/**  
	* Method   : loginProcessTest 
	* 작성자 : bms 
	* 변경이력 :    
	* Method 설명 :  
	 * @throws Exception 
	*/
	@Test
	public void loginSuccessProcessTest() throws Exception {
		/***Given***/
		String userId = "brown";
		String pass = "brownpass";
		MvcResult mvcResult = mockMvc.perform(post("/user/loginProcess")
				.param("userId", userId).param("pass", pass)).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
			assertEquals("main", mav.getViewName());
	}
	@Test
	public void loginFailProcessTest() throws Exception {
		/***Given***/
		String userId = "brown11";
		String pass = "brownpass11";
		MvcResult mvcResult = mockMvc.perform(post("/user/loginProcess")
				.param("userId", userId).param("pass", pass)).andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
			assertEquals("/login/login", mav.getViewName());
	}
	
	
	
	
	
	

}


















//

