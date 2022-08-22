package svc;

import java.sql.Connection;

import dao.ProductDAO;

import static db.JdbcUtil.*;
import vo.ProductDTO;

public class AdminProductDetailService {

	public ProductDTO getProductDetail(int pd_num) {
		ProductDTO product = null;
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		product = dao.getProductDetail(pd_num);

		close(con);
		
		return product;
	}

}
