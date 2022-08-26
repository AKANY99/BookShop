package vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.JdbcUtil.*;

public class OrdDAO {
	// 싱글톤 디자인 패턴 사용하여 인스턴스 생성
		private static OrdDAO instance = new OrdDAO();
		private OrdDAO() {};
		public static OrdDAO getInstance() {
			return instance;
		}
		
		Connection con;
		public void setCon(Connection con) {
			this.con = con;
		}
		
		// 주문상태별 건수 확인
		public int selectOrderStatus(String status) {
			int statusCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "";
				if(status.equals("결제완료")) {
					sql = "SELECT COUNT(*) FROM ord WHERE order_date = CURDATE() AND order_status=?";
				} else if(status.equals("결제취소")) {
					sql = "SELECT COUNT(*) FROM ord WHERE order_date = CURDATE() AND order_status=?";
				}
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, status);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					statusCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("selectOrderStatus(S) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return statusCount;
		}
		
		// 전체 주문목록 수량조회
		public int getListCount(String start_date, String end_date, String min_price, String max_price) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT COUNT(*) FROM ord WHERE order_date>=? AND order_date<=? AND order_price>=? AND order_price<=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, min_price);
				pstmt.setString(4, max_price);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					listCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("selectOrderStatus(S,S,S,S) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return listCount;
		}
		
		// 검색조건에 따른 주문목록 수량조회
		public int getListCount(String start_date, String end_date, String min_price, String max_price, String order_status) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "";
				if(order_status.equals("yes")) {
					order_status = "yes";
					sql = "SELECT COUNT(*) FROM ord WHERE order_date>=? AND order_date<=? AND order_price>=? AND order_price<=? AND order_status=?";
				} else if(order_status.equals("no")) {
					order_status = "no";
					sql = "SELECT COUNT(*) FROM ord WHERE order_date>=? AND order_date<=? AND order_price>=? AND order_price<=? AND order_status=?";
				}
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, min_price);
				pstmt.setString(4, max_price);
				pstmt.setString(4, order_status);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					listCount = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("selectOrderStatus(S,S,S,S,S) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return listCount;
		}
		
		// 전체 주문리스트 조회
		public List<OrdDTO> getOrderList(String start_date, String end_date, String min_price, String max_price, int ordPageNum, int listLimit) {
			List<OrdDTO> orderList = null;
			int startRow = (ordPageNum - 1) * listLimit;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM ord WHERE order_date>=? AND order_date<=? AND order_price>=? AND order_price<=? ORDER BY order_num DESC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, min_price);
				pstmt.setString(4, max_price);
//				pstmt.setInt(5, startRow);
//				pstmt.setInt(6, listLimit);
				rs = pstmt.executeQuery();
				orderList = new ArrayList<OrdDTO>();
				while(rs.next()) {
					OrdDTO order = new OrdDTO();
					order.setOrder_num(rs.getInt("order_num"));
					order.setOrder_user_email(rs.getString("order_user_email"));
					order.setOrder_status(rs.getString("order_status"));
					order.setOrder_price(rs.getInt("order_price"));
					order.setOrder_date(rs.getDate("order_date"));
					orderList.add(order);
				}
			} catch (SQLException e) {
				System.out.println("selectOrderStatus(S,S,S,S,I,I) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return orderList;
		}
		
		// 검색조건에 따른 주문리스트 조회
		public List<OrdDTO> getOrderList(String start_date, String end_date, String min_price, String max_price, String order_status, int ordPageNum, int listLimit) {
			List<OrdDTO> orderList = null;
			int startRow = (ordPageNum - 1) * listLimit;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				String sql = "SELECT * FROM ord WHERE order_date>=? AND order_date<=? AND order_price>=? AND order_price<=? ORDER BY order_num DESC LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, min_price);
				pstmt.setString(4, max_price);
				pstmt.setInt(5, startRow);
				pstmt.setInt(6, listLimit);
				rs = pstmt.executeQuery();
				orderList = new ArrayList<OrdDTO>();
				while(rs.next()) {
					OrdDTO order = new OrdDTO();
					order.setOrder_num(rs.getInt("order_num"));
					order.setOrder_user_email(rs.getString("order_user_email"));
					order.setOrder_status(rs.getString("order_status"));
					order.setOrder_price(rs.getInt("order_price"));
					order.setOrder_date(rs.getDate("order_date"));
					orderList.add(order);
				}
			} catch (SQLException e) {
				System.out.println("selectOrderStatus(S,S,S,S,S,I,I) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return orderList;
		}
		
		
}
