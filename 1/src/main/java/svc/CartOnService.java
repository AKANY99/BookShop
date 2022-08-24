package svc;

import static db.JdbcUtil.*;
import java.sql.*;

import dao.*;
import db.*;

public class CartOnService {

	public int cartOn(int pd_num, String sId, int quantity) {
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		int CartOnCount = dao.cartOn(pd_num, sId, quantity);
		
		if(CartOnCount > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return CartOnCount;
	}

	
}
