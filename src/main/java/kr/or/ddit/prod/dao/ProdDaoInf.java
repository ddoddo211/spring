package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.util.model.PageVo;

public interface ProdDaoInf {

	/**  
	* Method   : selectProdAll 
	* 작성자 : bms 
	* 변경이력 :  
	* @return  
	* Method 설명 :  상품 전체 조회
	*/
	public List<ProdVo> selectProdAll(PageVo pageVo);

	/**  
	* Method   : selectProdAllCnt 
	* 작성자 : bms 
	* 변경이력 :  
	* @return  
	* Method 설명 :  전체 상품 갯수
	*/
	public int selectProdAllCnt();

	/**  
	* Method   : selectProd 
	* 작성자 : bms 
	* 변경이력 :  
	* @param prod_id
	* @return  
	* Method 설명 : 상품 하나 조회  
	*/
	public ProdVo selectProd(String prod_id);

}
