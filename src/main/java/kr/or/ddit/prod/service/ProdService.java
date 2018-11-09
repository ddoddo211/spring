package kr.or.ddit.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.util.model.PageVo;

@Service
public class ProdService implements ProdServiceInf {

	@Resource(name="prodDao")
	ProdDaoInf prodDao;
	
	@Override
	public List<ProdVo> selectProdAll(PageVo pageVo) {
		// TODO Auto-generated method stub
		return prodDao.selectProdAll(pageVo);
	}

	@Override
	public int selectProdAllCnt() {
		// TODO Auto-generated method stub
		return prodDao.selectProdAllCnt();
	}

	@Override
	public ProdVo selectProdAll(String prod_id) {
		// TODO Auto-generated method stub
		return prodDao.selectProd(prod_id);
	}

}
