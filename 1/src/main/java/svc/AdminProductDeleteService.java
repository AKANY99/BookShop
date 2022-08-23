package svc;

import java.sql.Connection;

import dao.ProductDAO;

import static db.JdbcUtil.*;

public class AdminProductDeleteService {

	public int deleteProduct(String pd_num) {
		int deleteCount = 0;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		deleteCount = dao.deleteProduct(pd_num);
		
		if(deleteCount == 0) {
			rollback(con);
		} else {
			commit(con);
		}
		close(con);
		return deleteCount;
	}

}
