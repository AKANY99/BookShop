package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import db.JdbcUtil;
import vo.ProductDTO;

public class userQnaSelectProductService {

	public ArrayList<ProductDTO> getQnaProduct(String productObject, int qnaPageNum, int listLimit ) {
		QnaDAO dao = QnaDAO.getInstance();
		Connection con = JdbcUtil.getConnection();
		dao.setCon(con);
		
		ArrayList<ProductDTO> productList = dao.getQnaProduct(productObject, qnaPageNum, listLimit);
		
		JdbcUtil.close(con);
		
		return productList;
	}

	public int getListCount(String productObject) {
		QnaDAO dao = QnaDAO.getInstance();
		Connection con = JdbcUtil.getConnection();
		dao.setCon(con);
		
		int Count = dao.getQnaProductCount(productObject);
		
		JdbcUtil.close(con);
		
		
		
		
		
		return Count;
	}

}
