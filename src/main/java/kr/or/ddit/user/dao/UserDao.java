package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.util.model.PageVo;

@Repository
public class UserDao implements UserDaoInf {
	
	//DB 에 값 변화 줄때 session.close() , session.commit(), session.rollback() 해주기
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<UserVo> userList = session.selectList("user.selectUserAll");
		session.close();
		return userList;
	}
	
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		UserVo userVo = session.selectOne("user.selectUser", userId);
		session.close();
		return userVo;
	}
	
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		UserVo userVoSel = session.selectOne("user.selectUserByVo", userVo);
		session.close();
		return userVoSel;
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<UserVo> userList = session.selectList("user.selectUserPageList", pageVo);
		session.close();
		return userList;
	}
	
	@Override
	public int getUserCnt() {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int totalCnt = session.selectOne("user.getUserCnt");
		session.close();
		return totalCnt;
	}

	
	/**
	 * 
	 * Method : insertUser
	 * 작성자 : bms
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int chk  = session.insert("user.insertUser",userVo);
		session.commit();
		session.close();
		return chk;
	}

	/**
	 * 
	 * Method : deleteUser
	 * 작성자 : bms
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 :사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int chk  = session.insert("user.deleteUser",userId);
		session.commit();
		session.close();
		return chk;
	}

	@Override
	public int userUpdate(UserVo userVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int chk  = session.insert("user.updateUser",userVo);
		session.commit();
		session.close();
		return chk;
	}


	@Override
	public int cntProdList() {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int totalCnt = session.selectOne("user.cntProdList");
		session.close();
		return totalCnt;
	}
}
