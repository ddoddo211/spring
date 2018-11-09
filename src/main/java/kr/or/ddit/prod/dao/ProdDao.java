package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.dao.Builder;
import kr.or.ddit.user.util.model.PageVo;

@Repository
public class ProdDao implements ProdDaoInf{

	@Override
	public List<ProdVo> selectProdAll(PageVo pageVo) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<ProdVo> prodList = session.selectList("prod.selectProdAll",pageVo); 
		
		session.close();
		return prodList;
	}

	@Override
	public int selectProdAllCnt() {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.selectOne("prod.selectProdAllCnt");
		
		session.close();
		return cnt;
	}

	@Override
	public ProdVo selectProd(String prod_id) {
		SqlSessionFactory factory = Builder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		ProdVo prodVo = session.selectOne("prod.selectProd",prod_id);
		
		session.close();
		return prodVo;
	}

}
