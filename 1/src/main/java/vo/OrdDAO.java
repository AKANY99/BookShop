package vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		// 전체 주문목록 카운팅
		public int getListCount(String start_date, String end_date, String min_price, String max_price) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT COUNT(*) FROM ord WHERE pd_date>=? AND pd_date<=? AND order_price<=? AND order_price>=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, min_price);
				pstmt.setString(4, max_price);
			} catch (SQLException e) {
				System.out.println("selectOrderStatus(S,S,S,S) - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			}
			
			return listCount;
		}
		
		
}
