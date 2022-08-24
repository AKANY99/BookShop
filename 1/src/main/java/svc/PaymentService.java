package svc;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import db.JdbcUtil;
import vo.ProductDTO;

public class PaymentService {

	public ArrayList<ProductDTO> myCart(String sId) {
		System.out.println("pay 서비스 진입");
		ArrayList<ProductDTO> list = null;
//		System.out.println(sId);
		
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		list = dao.MyCart(sId);
//		System.out.println(list);
				
		close(con);
	
		return list;
	}

	public int getUserpoints(String sId) {
		int userPoint = 0;
		
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		
		userPoint = dao.getUserPoints(sId);
		System.out.println(userPoint);
		close(con);
		
		return userPoint;
	}

}
