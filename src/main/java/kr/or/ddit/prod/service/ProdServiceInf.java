package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.util.model.PageVo;

public interface ProdServiceInf {
	
	/**  
	* Method   : selectProdAll 
	* 작성자 : bms 
	* 변경이력 :  
	* @return  
	* Method 설명 :  전체 상품목록을 조회
	*/
	public List<ProdVo> selectProdAll(PageVo pageVo);
	
	/**  
	* Method   : selectProdAllCnt 
	* 작성자 : bms 
	* 변경이력 :  
	* @return  
	* Method 설명 :  상품리스트 갯수
	*/
	public int selectProdAllCnt();

	/**  
	* Method   : selectProdAll 
	* 작성자 : bms 
	* 변경이력 :  
	* @param prod_id
	* @return  
	* Method 설명 :  상품 하나조회
	*/
	public ProdVo selectProdAll(String prod_id);
}
