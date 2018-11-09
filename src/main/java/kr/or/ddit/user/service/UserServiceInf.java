package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.util.model.PageVo;


public interface UserServiceInf {
	public List<UserVo> selectUserAll();
	
	public UserVo selectUser(String userId);
	
	
	public UserVo selectUser(UserVo userVo);
	
	public Map<String, Object> selectUserPageList(PageVo pageVo);
	
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

	public int userUpdate(UserVo userVo);
	
	
	public int cntProdList ();
	
}
