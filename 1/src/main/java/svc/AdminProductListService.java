package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.ProductDTO;

public class AdminProductListService {
	public ArrayList<ProductDTO> getProductList(String start_date, String end_date, String search_input, int pdPageNum, int listLimit) {
		ArrayList<ProductDTO> list = null;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		list = dao.getProductList(start_date, end_date, search_input, pdPageNum, listLimit);
		
		close(con);
		
		return list;
	}
	
	public int getListCount(String start_date, String end_date, String search_input) {
		int listCount = 0;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.getListCount(start_date, end_date, search_input);
		
		close(con);
		
		return listCount;
	}
	
	public ArrayList<ProductDTO> getProductList(String start_date, String end_date, String pd_type, String pd_quan, String search_input, int pdPageNum, int listLimit) {
		System.out.println(start_date + "/" + end_date + "/" + pd_type + "/" + pd_quan + "/" + search_input);
		ArrayList<ProductDTO> list = null;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		list = dao.getProductList(start_date, end_date, pd_type, pd_quan, search_input, pdPageNum, listLimit);
		
		close(con);
		
		return list;
	}

	public int getListCount(String start_date, String end_date, String pd_type, String pd_quan, String search_input) {
		System.out.println(start_date + "/" + end_date + "/" + pd_type + "/" + pd_quan + "/" + search_input);
		int listCount = 0;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.getListCount(start_date, end_date, pd_type, pd_quan, search_input);
		
		close(con);
		
		return listCount;
	}
	

}
