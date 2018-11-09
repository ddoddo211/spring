package kr.or.ddit.file.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoTestConfig;



public class FileDaoTest extends ServiceDaoTestConfig{

	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**  
	* Method   : FileDaoTest 
	* 작성자 : bms 
	* 변경이력 :    
	* Method 설명 : 파일정보 입력 테스트  
	*/
	@Test(timeout=5000)
	public void FileDaoTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("산삼");
		fileVo.setFile_path("C:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\");
		fileVo.setFile_ext(".jsp");
		fileVo.setOrg_file_name("0ad39078-7424-447b-801c-60ff5333e131.jpg");

		/***When***/
		int insertCnt = fileDao.insertFile(fileVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}

}
