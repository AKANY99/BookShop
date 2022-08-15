package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import dao.QnaDAO;
import db.JdbcUtil;
import vo.ProductDTO;
import vo.QnaDTO;

import static db.JdbcUtil.*;

public class AdminProductListService {

	public int getListCount() {
		int listCount = 0;
		Connection con = getConnection();
		
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.selectListCount();
		close(con);
		
		return listCount;
	}

	public ArrayList<ProductDTO> getProductList(String start_date, String end_date, String pd_subject, String pd_condition, String search_input, int pdPageNum, int listLimit) {
		ArrayList<ProductDTO> list = null;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		list = dao.getProductList(start_date, end_date, pd_subject, pd_condition, search_input, pdPageNum, listLimit);
		
		JdbcUtil.close(con);
		return list;
	}
	

}
