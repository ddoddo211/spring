package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.util.model.PageVo;

public interface UserDaoInf {
	
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);
	
	public List<UserVo> selectUserPageList(PageVo pageVo);
	
	public int getUserCnt();
	
	/**
	 * 
	 * Method : insertUser
	 * 작성자 : bms
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	public int insertUser(UserVo userVo);
	
	/**
	 * 
	 * Method : deleteUser
	 * 작성자 : bms
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 삭제
	 */
	int deleteUser(String userId);
	
	int userUpdate(UserVo userVo);
	
	
	public int cntProdList();
}
