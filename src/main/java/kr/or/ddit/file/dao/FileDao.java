package kr.or.ddit.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.file.model.FileVo;

//spring bean 으로 등록 :
//@Repository(이름을 안붙이면 class 명에서 앞글자만 소문자로 변경한 텍스트가 spring bean 이름)
@Repository // fileDao
public class FileDao implements FileDaoInf {

	SqlSessionFactory sessionFactory;
	
	FileDao(){
		sessionFactory = SqlFactoryBuilder.getSqlSessionFactory();
	}
	
	/**  
	* Method   : insertFile 
	* 작성자 : bms 
	* 변경이력 :  
	* @param fileVo
	* @return  
	* Method 설명 : 파일정보 저장  
	*/
	@Override
	public int insertFile(FileVo fileVo) {
		
		SqlSession session = sessionFactory.openSession();

		//sql 호출
		int insertCnt = session.insert("file.insertFile", fileVo);
		
		//트랙잭션 commit, session close
		session.commit();
		session.close();
		return insertCnt;
	}
	
}
