package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import dao.adDAO;
import db.JdbcUtil;
import vo.ProductDTO;
import vo.adDTO;

public class AdminDesignService {

	public ArrayList<ProductDTO> getAdProduct(String productObject, int pageNum, int listLimit) {
		
		Connection con =JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		ArrayList<ProductDTO> list = dao.getQnaProduct(productObject, pageNum, listLimit);
		
		
		JdbcUtil.close(con);
		
		
		return list;
	}

	public int getListCount(String productObject) {
		Connection con =JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		int count = dao.getQnaProductCount(productObject);
		JdbcUtil.close(con);
		
		return count;
	}

	public int changeAd(String ad_file, int ad_index, int ad_pd_num, String ad_subject) {
		int count = 0;
		Connection con =JdbcUtil.getConnection();
		adDAO dao = adDAO.getInstance();
		dao.setCon(con);
		
		count = dao.changeAd(ad_file,ad_index,ad_pd_num,ad_subject);
		if(count > 0) {
			JdbcUtil.commit(con);
			JdbcUtil.close(con);
		}else {
			JdbcUtil.rollback(con);
			JdbcUtil.close(con);
		}
		return count;
	}

	public ArrayList<adDTO> getMainAdList() {
		Connection con =JdbcUtil.getConnection();
		adDAO dao = adDAO.getInstance();
		dao.setCon(con);
		ArrayList<adDTO> list = dao.getMainAdList();
		
		JdbcUtil.close(con);
		
		
		
		
		return list;
	}
	
	

}
