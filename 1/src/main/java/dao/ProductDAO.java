package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.ProductDTO;

public class ProductDAO {
	// 싱글톤 디자인 패턴 사용하여 인스턴스 생성
	private static ProductDAO instance = new ProductDAO();
	private ProductDAO() {};
	public static ProductDAO getInstance() {
		return instance;
	}
	
	Connection con;
	public void setCon(Connection con) {
		this.con = con;
	}
	
	// 전체 게시물수 조회 기능
	public int getListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("getListCount() - SQL 구문 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	// 타입별 상품현황란 건수 표시
	public int selectListCount(String Condition) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM product WHERE pd_condition=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Condition);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("selectListCount() - SQL구문 오류 - " + e.getMessage());
			e.printStackTrace();
		}
		return count;
	}
	
	public ArrayList<ProductDTO> getProductList(String start_date, String end_date, String pd_subject, String pd_condition, String search_input, int pdPageNum, int listLimit) {
		ArrayList<ProductDTO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRow = (pdPageNum - 1) * listLimit;
		
			try {
				String sql = "";
				
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, start_date);
				pstmt.setString(2, end_date);
				pstmt.setString(3, pd_subject);
				pstmt.setString(4, pd_condition);
				pstmt.setString(5, search_input);
				pstmt.setInt(6, startRow);
				pstmt.setInt(7, listLimit);
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				System.out.println("getProductList() - SQL구문 오류 - " + e.getMessage());
				e.printStackTrace();
			}
		
		return list;
	}
	
}
















