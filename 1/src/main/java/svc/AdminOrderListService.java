package svc;

import java.sql.Connection;
import java.util.List;

import dao.OrdDAO;
import vo.OrdDTO;

import static db.JdbcUtil.*;

public class AdminOrderListService {
	
	public int getListCount(String start_date, String end_date, String min_price, String max_price) {
		int listCount = 0;
		Connection con = getConnection();
		OrdDAO dao = OrdDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.getListCount(start_date, end_date, min_price, max_price);
		
		close(con);
		return listCount;
	}

	public int getListCount(String start_date, String end_date, String min_price, String max_price, String order_status) {
		int listCount = 0;
		Connection con = getConnection();
		OrdDAO dao = OrdDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.getListCount(start_date, end_date, min_price, max_price, order_status);
		
		close(con);
		return listCount;
	}

	public List<OrdDTO> getOrderList(String start_date, String end_date, String min_price, String max_price, int ordPageNum, int listLimit) {
		List<OrdDTO> orderList = null;
		Connection con = getConnection();
		OrdDAO dao = OrdDAO.getInstance();
		dao.setCon(con);
		
		orderList = dao.getOrderList(start_date, end_date, min_price, max_price, ordPageNum, listLimit);
		
		close(con);
		return orderList;
	}

	public List<OrdDTO> getOrderList(String start_date, String end_date, String min_price, String max_price, String order_status, int ordPageNum, int listLimit) {
		List<OrdDTO> orderList = null;
		Connection con = getConnection();
		OrdDAO dao = OrdDAO.getInstance();
		dao.setCon(con);
		
		orderList = dao.getOrderList(start_date, end_date, min_price, max_price, order_status, ordPageNum, listLimit);
		
		close(con);
		return orderList;
	}

}
