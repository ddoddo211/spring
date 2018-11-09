package kr.or.ddit.mvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;
public class MvcControllerTest extends ControllerTestConfig {

private Logger logger = LoggerFactory.getLogger(MvcControllerTest.class); 
	
	
	
	@Test
	public void mcvViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/view")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		List<String> rangers = (List<String>) mav.getModel().get("rangers"); 
		String viewName = mav.getViewName();

		/***Then***/
		assertEquals("mvc/view",viewName);
		
		//model 객체에서 rangers 얻어와서 사이즈 체크
		assertEquals(4, rangers.size());
		
		
	}
	
	@Test
	public void fileuploadViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/fileupload")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals("mvc/fileuploadView", mav.getViewName());
	}
	
	
	
	
	
	
	

}


















