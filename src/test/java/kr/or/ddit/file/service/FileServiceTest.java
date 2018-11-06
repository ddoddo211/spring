package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.model.FileVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:kr/or/ddit/config/spring/root-context.xml")
public class FileServiceTest {

	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	@Test
	public void fileServiceTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("산삼2");
		fileVo.setFile_path("C:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\");
		fileVo.setFile_ext(".jsp");
		fileVo.setOrg_file_name("0ad39078-7424-447b-801c-60ff5333e132.jpg");

		/***When***/
		int insertCnt = fileService.insertFile(fileVo);

		/***Then***/
		assertEquals(1, insertCnt);
	
		
	}

}
