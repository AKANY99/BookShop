package svc;

import java.sql.Connection;

import vo.OrdDAO;

import static db.JdbcUtil.*;

public class AdminOrderListService {
	
	public int getListCount(String start_date, String end_date, String min_price, String max_price) {
		int listCount = 0;
		Connection con = getConnection();
		OrdDAO dao = OrdDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.getListCount(start_date, end_date, min_price, max_price);
		
		return listCount;
	}

}
