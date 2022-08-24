package svc;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.*;

public class MyInterestService {

	public ArrayList<ProductDTO> myInterest(String sId) {
		ArrayList<ProductDTO> list = null;
//		System.out.println(sId);
		
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		list = dao.MyInterest(sId);
				
		close(con);
	
		return list;
	}

}
