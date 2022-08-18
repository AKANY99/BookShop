package svc;

import java.sql.*;

import dao.*;
import db.*;
import vo.*;

public class UserProductDetailService {
	public ProductDTO getProduct(int pd_num) {
		ProductDTO product = new ProductDTO();
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		// 관리자 페이지 상품 상세 페이지때 구현했던 상세 조회 재사용
		product = dao.getProductDetail(pd_num);
		
		return product;
	}
}
