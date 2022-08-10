package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import vo.QnaDTO;

public class QnaDAO {
	private static QnaDAO instance = new QnaDAO();
	private QnaDAO() {};
	public static QnaDAO getInstance() {
		return instance;
	}
	
	Connection con;
	public void setCon(Connection con) {
		this.con = con;
	}
	public QnaDTO getQna(int qna_num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaDTO qna = new QnaDTO();
		
		try {
			String sql = "SELECT * FROM qna WHERE qna_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qna.setQna_num(rs.getInt("qna_num"));
				qna.setQna_user(rs.getString("qna_user"));
				qna.setQna_subject(rs.getString("qna_subject"));
				qna.setQna_content(rs.getString("qna_content"));
				qna.setQna_date(rs.getDate("qna_date"));
				qna.setQna_pd_num(rs.getInt("qna_pd_num"));
				qna.setQna_user_email(rs.getString("qna_user_email"));
				qna.setQna_type(rs.getString("qna_type"));
				qna.setQna_rep(rs.getString("qna_rep"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getQna 구문 오류" + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return qna;
	}
	public int qnaRep(QnaDTO qna) {
		int repCount = 0;
		
		try {
			PreparedStatement pstmt = null;
			String sql = "UPDATE qna SET qna_rep = ? WHERE qna_num = ?";
			System.out.println(qna.getQna_rep());
			System.out.println(qna.getQna_num());
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna.getQna_rep());
			pstmt.setInt(2, qna.getQna_num());
			
			repCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("qnaRep 구문 오류");
		}
		
		
		
		return repCount;
	}
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT COUNT(*) FROM qna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			listCount = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectListCount 구문 오류" + e.getMessage());
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return listCount;
	}
	
//	타입별 QNA 미답변 게시글 갯수
		public int selectListCount(String type) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM qna WHERE qna_type = ? AND qna_rep IS NULL";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectListCount 구문 오류" + e.getMessage());
		}finally {
			close(rs);	
			close(pstmt);
		}
		return count;
	}
	
	public int qnaModify(QnaDTO qna) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE qna SET qna_rep = ? WHERE qna_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna.getQna_rep());
			pstmt.setInt(2, qna.getQna_num());
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("qnaModify sql 구문 오류" + e.getMessage());
		}
		return updateCount;
	}
	public ArrayList<QnaDTO> getUserQnaList(int pageNum, int listLimit) {
		QnaDTO qna = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
		int startRow = (pageNum - 1) * listLimit;
		
		
		try {
			String sql = "SELECT * FROM qna ORDER BY qna_num DESC limit ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qna = new QnaDTO();
				qna.setQna_num(rs.getInt("qna_num"));
				qna.setQna_user(rs.getString("qna_user"));
				qna.setQna_subject(rs.getString("qna_subject"));
				qna.setQna_content(rs.getString("qna_content"));
				qna.setQna_date(rs.getDate("qna_date"));
				qna.setQna_pd_num(rs.getInt("qna_pd_num"));
				qna.setQna_user_email(rs.getString("qna_user_email"));
				qna.setQna_type(rs.getString("qna_type"));
				qna.setQna_rep(rs.getString("qna_rep"));
				
				list.add(qna);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<QnaDTO> getQnaList(String qna_rep, String qna_type, String orderBy, String searchObject, String startDate, String endDate) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		ArrayList<QnaDTO> list = null;
		try {
			String sql = "";
			if(qna_rep.equals("repno")){
				sql = "SELECT * FROM qna WHERE qna_date >= ? AND qna_date <= ? AND  qna_type "+qna_type+" AND qna_subject like ? AND qna_rep IS NULL ORDER BY qna_date "+orderBy;
				}else{
				sql = "SELECT * FROM qna WHERE qna_date >= ? AND qna_date <= ? AND qna_type "+qna_type+" AND qna_subject like ? AND qna_rep IS NOT NULL ORDER BY qna_date "+orderBy;
				}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, searchObject);
			rs = pstmt.executeQuery();
			
			QnaDTO dto = null;
			list = new ArrayList<QnaDTO>();
				while(rs.next()){
					dto = new QnaDTO();
					dto.setQna_num(rs.getInt("qna_num"));
					dto.setQna_user(rs.getString("qna_user"));
					dto.setQna_subject(rs.getString("qna_subject"));
					dto.setQna_content(rs.getString("qna_content"));
					dto.setQna_date(rs.getDate("qna_date"));
					dto.setQna_pd_num(rs.getInt("qna_pd_num"));
					dto.setQna_user_email(rs.getString("qna_user_email"));
					dto.setQna_type(rs.getString("qna_type"));
					dto.setQna_rep(rs.getString("qna_rep"));
					
					list.add(dto);
				}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getQnaList 구문 에러");
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
