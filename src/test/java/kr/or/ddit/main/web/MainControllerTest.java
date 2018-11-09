package kr.or.ddit.main.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.hello.HelloControllerTest;
import kr.or.ddit.test.ControllerTestConfig;

public class MainControllerTest extends ControllerTestConfig {

private Logger logger = LoggerFactory.getLogger(HelloControllerTest.class); 
	
	
	
	@Test
	public void mainControllerTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/main")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("main", mav.getViewName());
	}

}
