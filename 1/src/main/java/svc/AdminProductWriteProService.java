package svc;

import java.sql.Connection;

import dao.ProductDAO;
import vo.ProductDTO;

import static db.JdbcUtil.*;

public class AdminProductWriteProService {

	public int insertProduct(ProductDTO product) {
		int insertCount = 0;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		insertCount = dao.insertProduct(product);
		
		if(insertCount == 0) {
			rollback(con);
		} else {
			commit(con);
		}
		
		return insertCount;
	}

}
