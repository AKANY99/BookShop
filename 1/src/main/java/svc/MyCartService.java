package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.*;

public class MyCartService {

	public ArrayList<ProductDTO> myCart(String sId) {
		ArrayList<ProductDTO> list = null;
//		System.out.println(sId);
		
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		list = dao.MyCart(sId);
				
		close(con);
	
		return list;
	}

}
