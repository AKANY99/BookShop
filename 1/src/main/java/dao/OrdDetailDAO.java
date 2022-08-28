package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.OrdDetailDTO;

public class OrdDetailDAO {
	private static OrdDetailDAO instance = new OrdDetailDAO();
	private OrdDetailDAO() {};
	public static OrdDetailDAO getInstance() {
		return instance;
	}
	
	Connection con;
	public void setCon(Connection con) {
		this.con = con;
	}
	
	// 주문번호에 맞는 주문상세 조회
	public List<OrdDetailDTO> getOrderDetail(String order_num) {
		List<OrdDetailDTO> orderList = null;
		OrdDetailDTO orderDetail = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT o.order_pd_num, o.order_quan, o.order_pd_price*o.order_quan AS order_pd_price, p.pd_file, p.pd_subject "
					+ "FROM ordDetail o JOIN product p "
					+ "ON o.order_pd_num = p.pd_num AND o.order_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_num);
			rs = pstmt.executeQuery();
			orderList = new ArrayList<OrdDetailDTO>();
			while(rs.next()) {
				orderDetail = new OrdDetailDTO();
				orderDetail.setOrder_pd_num(rs.getInt("order_pd_num"));
				orderDetail.setOrder_quan(rs.getInt("order_quan"));
				orderDetail.setOrder_pd_price(rs.getInt("order_pd_price"));
				orderDetail.setPd_file(rs.getString("pd_file"));
				orderDetail.setPd_subject(rs.getString("pd_subject"));
				orderList.add(orderDetail);
			}
		} catch (SQLException e) {
			System.out.println("getOrderDetail(S) - SQL구문 오류 - " + e.getMessage());
			e.printStackTrace();
		}
		return orderList;
	}
	
	
}
