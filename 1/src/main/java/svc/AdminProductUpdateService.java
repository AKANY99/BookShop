package svc;

import java.sql.Connection;

import dao.ProductDAO;
import vo.ProductDTO;

import static db.JdbcUtil.*;

public class AdminProductUpdateService {

	public int updateProduct(ProductDTO product) {
		int updateCount = 0;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		updateCount = dao.updateProduct(product);
		
		if(updateCount == 0) {
			rollback(con);
		} else {
			commit(con);
		}
		close(con);
		return updateCount;
	}

}
