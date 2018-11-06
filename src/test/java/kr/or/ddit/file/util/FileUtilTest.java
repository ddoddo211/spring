package kr.or.ddit.file.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/servlet-context.xml",
									"classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration	
public class FileUtilTest {
	
	Logger logger = LoggerFactory.getLogger(FileUtilTest.class);

	@Test
	public void fileUtilTest() {
		/***Given***/
		FileUtil fu = new FileUtil();

		/***When***/
		String fileNameEx = "sally.png";
		String fileNameNoEx = "sally";
		
		String ext = fu.getFileExt(fileNameEx);
		String whitespace = fu.getFileExt(fileNameNoEx);
		/***Then***/
		logger.debug("확장자있는 파일명 : {}",fileNameEx);
		logger.debug("확장자없는 파일명 : {}",fileNameNoEx);
		
		logger.debug("확장자있을때 확장자명 : {}",ext);
		logger.debug("공백일때 결과 : {}",whitespace);
		
		assertEquals(".png", ext);
		assertEquals("", whitespace);
		
		
		
		
	}

}
