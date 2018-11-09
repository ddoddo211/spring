package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.Builder;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.util.model.PageVo;

@Service
public class UserService implements UserServiceInf {
	UserDao ud = new UserDao();

	/**
	 * Method : selectUserAll 작성자 : bms 변경이력 :
	 * 
	 * @return Method 설명 :
	 */
	@Override
	public List<UserVo> selectUserAll() {

		return ud.selectUserAll();
	}

	/**
	 * Method : selectUser 작성자 : bms 변경이력 :
	 * 
	 * @param userId
	 * @return Method 설명 :
	 */
	@Override
	public UserVo selectUser(String userId) {
		// TODO Auto-generated method stub
		return ud.selectUser(userId);
	}

	/**
	 * Method : selectUser 작성자 : bms 변경이력 :
	 * 
	 * @param userVo
	 * @return Method 설명 :
	 */
	@Override
	public UserVo selectUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return ud.selectUser(userVo);
	}

	/**
	 * 
	 * Method : selectUserPageList 작성자 : bms 변경이력 :
	 * 
	 * @param pageVo
	 * @return Method 설명 : 사용자 페이징 조회
	 */
	@Override
	public Map<String, Object> selectUserPageList(PageVo pageVo) {
		// 페이지에 해당하는 유저리스트
		List<UserVo> userList = ud.selectUserPageList(pageVo);

		// 페이지 네비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = ud.getUserCnt();

		// 결과를 담는 맵
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCnt", totalUserCnt);
		return resultMap;
	}

	@Override
	public int getUserCnt() {
		// TODO Auto-generated method stub
		return ud.getUserCnt();
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
		return ud.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return ud.deleteUser(userId);
	}

	@Override
	public int userUpdate(UserVo userVo) {
		// TODO Auto-generated method stub
		return ud.userUpdate(userVo);
	}

		

	@Override
	public int cntProdList() {
		// TODO Auto-generated method stub
		return ud.cntProdList();
	}

}
