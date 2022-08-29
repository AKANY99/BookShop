package dao;
import static db.JdbcUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.adDTO;

public class adDAO {
	private static adDAO instance = new adDAO();
	private adDAO() {};
	public static adDAO getInstance() {
		return instance;
	}
	
	Connection con;
	public void setCon(Connection con) {
		this.con = con;
	}
	public int changeAd(String ad_file, int ad_index, int ad_pd_num, String ad_subject) {
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int count = 0;
		String sql2 = "";
		System.out.println(ad_index);
		try {
			String sql = "SELECT * FROM main_ad WHERE ad_index = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ad_index);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sql2 = "UPDATE main_ad SET ad_pd_num = ?, ad_file = ?, ad_subject = ? WHERE ad_index = ?";
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, ad_pd_num);
				pstmt2.setString(2, ad_subject);
				pstmt2.setString(3, ad_file);
				pstmt2.setInt(4, ad_index);
				count = pstmt2.executeUpdate();
			}else {
				sql2 = "INSERT INTO main_ad VALUES(?,?,?,?)";
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, ad_index);
				pstmt2.setInt(2, ad_pd_num);
				pstmt2.setString(3, ad_file);
				pstmt2.setString(4, ad_subject);
				count = pstmt2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("changeAd 구문오류");
		}finally {
			close(rs);
			close(pstmt);
			close(pstmt2);
		}
		return count;
	}
	public ArrayList<adDTO> getMainAdList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<adDTO> list = new ArrayList<adDTO>();
		adDTO dto = null;
		try {
			String sql = "SELECT * FROM main_ad ORDER BY ad_index";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new adDTO();
				dto.setAd_index(rs.getInt("ad_index"));
				dto.setAd_file(rs.getString("ad_file"));
				dto.setAd_pd_num(rs.getInt("ad_pd_num"));
				dto.setAd_subject(rs.getString("ad_subject"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getMainAdList 구문 오류");
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return list;
	}
	
	
	
	
	
	
}
