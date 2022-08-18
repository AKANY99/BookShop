package svc;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.*;

public class UserProductListProService {
	public int getListCount() {
		int listCount = 0;
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.getListCount();
		
		JdbcUtil.close(con);
		
		return listCount;
	}
	
	public ArrayList<ProductDTO> ProductList(String type, String sort) {
		ArrayList<ProductDTO> Productlist = null;
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
	
		Productlist = dao.getUserProductList(type, sort);
		
		JdbcUtil.close(con);
		
		return Productlist;
	}
	
	
	public ArrayList<ProductDTO> SearchProductList(String searchType, String search, String sort) {
		ArrayList<ProductDTO> Productlist = null;
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
//		System.out.println(searchType + search + sort);
	
		Productlist = dao.getSearchProductList(searchType, search, sort);
		
		JdbcUtil.close(con);
		
		return Productlist;
	}
}

