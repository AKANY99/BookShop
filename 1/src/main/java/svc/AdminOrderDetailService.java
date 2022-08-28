package svc;

import java.sql.Connection;
import java.util.List;

import dao.OrdDetailDAO;
import vo.OrdDetailDTO;

import static db.JdbcUtil.*;

public class AdminOrderDetailService {

	public List<OrdDetailDTO> getOrderDetail(String order_num) {
		List<OrdDetailDTO> orderList = null;
		Connection con = getConnection();
		OrdDetailDAO dao = OrdDetailDAO.getInstance();
		dao.setCon(con);
		
		orderList = dao.getOrderDetail(order_num);
		
		return orderList;
	}

}
