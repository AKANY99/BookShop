package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import vo.ProductDTO;
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
	// 답변달기 메서드
	public int qnaRep(QnaDTO qna) {
		int repCount = 0;
		
		try {
			PreparedStatement pstmt = null;
			String sql = "UPDATE qna SET qna_rep = ? WHERE qna_num = ?";
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
		public int qnaIsnullCount(String type) {
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
	public ArrayList<QnaDTO> getQnaList(String qna_rep, String qna_type, String orderBy, String searchObject, String startDate, String endDate, int pageNum, int listLimit) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRow = (pageNum - 1) * listLimit;
		
		ArrayList<QnaDTO> list = null;
		try {
			String sql;
			if(qna_rep.equals("repno")){
				sql = "SELECT * FROM qna WHERE qna_date >= ? AND qna_date <= ? AND  qna_type "+qna_type+" AND qna_subject like ? AND qna_rep IS NULL ORDER BY qna_date "+orderBy+" LIMIT ?,?";
				}else{
				sql = "SELECT * FROM qna WHERE qna_date >= ? AND qna_date <= ? AND qna_type "+qna_type+" AND qna_subject like ? AND qna_rep IS NOT NULL ORDER BY qna_date "+orderBy+" LIMIT ?,?";
				}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, searchObject);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, listLimit);
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
	public int selectListCount(String qna_rep, String qna_type, String orderBy, String searchObject, String startDate,
			String endDate) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(qna_rep.equals("repno")){
				sql = "SELECT COUNT(*) FROM qna WHERE qna_date >= ? AND qna_date <= ? AND  qna_type "+qna_type+" AND qna_subject like ? AND qna_rep IS NULL ORDER BY qna_date "+orderBy;
				}else{
				sql = "SELECT COUNT(*) FROM qna WHERE qna_date >= ? AND qna_date <= ? AND qna_type "+qna_type+" AND qna_subject like ? AND qna_rep IS NOT NULL ORDER BY qna_date "+orderBy;
				}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, searchObject);
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
	public ArrayList<QnaDTO> getQnaMyList(String qap, String sId, int qnaPageNum, int listLimit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QnaDTO> list = null;
		QnaDTO dto = null;
		int startRow = (qnaPageNum - 1) * listLimit;
		try {
			String sql = "";
			if(qap.equals("public")) {
				sql = "SELECT * FROM qna where qna_accesspermission = ? ORDER BY qna_num DESC LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, qap);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, listLimit);
			}else {
				sql = "SELECT * FROM qna WHERE qna_accesspermission = ? AND qna_user_email = ? ORDER BY qna_num DESC LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, qap);
				pstmt.setString(2, sId);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, listLimit);
			}
			list = new ArrayList<QnaDTO>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
				dto.setQna_accesspermission("qna_accesspermission");
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user qna list 구문 오류");
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public int selectListCount(String qap, String sId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "";
			if(qap.equals("public")) {
				sql = "SELECT COUNT(*) FROM qna where qna_accesspermission = ? ORDER BY qna_num DESC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, qap);
			}else {
				sql = "SELECT COUNT(*) FROM qna WHERE qna_accesspermission = ? AND qna_user_email = ? ORDER BY qna_num DESC";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, qap);
				pstmt.setString(2, sId);
			}
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("QnA listCount 구문오류");
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
	public ArrayList<ProductDTO> getQnaProduct(String productObject, int qnaPageNum, int listLimit) {
		
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		ProductDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRow = (qnaPageNum - 1) * listLimit;
		
		try {
			String sql = "SELECT * FROM product WHERE pd_subject like ? LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productObject);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, listLimit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new ProductDTO();
				dto.setPd_file(rs.getString("pd_file"));
				dto.setPd_subject(rs.getString("pd_subject"));
				dto.setPd_num(rs.getInt("pd_num"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public int getQnaProductCount(String productObject) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM product WHERE pd_subject like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productObject);
			rs = pstmt.executeQuery();
			rs.next();
			Count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getQnaProductCount 구문 오류");
		}
		
		return Count;
	}
	public int writeQna(QnaDTO dto) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int Count = 0;
		int num = dto.getQna_pd_num();
		
		
		try {
			String sql = "SELECT MAX(qna_num) FROM qna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			int qna_num = rs.getInt(1);
			qna_num++;
			close(pstmt);
			if(num == 0) {
				sql = "INSERT INTO qna VALUES(?,?,?,?,now(),NULL,?,?,NULL,?)";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, qna_num);
				pstmt2.setString(2, dto.getQna_user());
				pstmt2.setString(3, dto.getQna_subject());
				pstmt2.setString(4, dto.getQna_content());
				pstmt2.setString(5, dto.getQna_user_email());
				pstmt2.setString(6, dto.getQna_type());
				pstmt2.setString(7, dto.getQna_accesspermission());
				Count = pstmt2.executeUpdate();
			}else {
				sql = "INSERT INTO qna VALUES(?,?,?,?,now(),?,?,?,null,?)";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, qna_num);
				pstmt2.setString(2, dto.getQna_user());
				pstmt2.setString(3, dto.getQna_subject());
				pstmt2.setString(4, dto.getQna_content());
				pstmt2.setInt(5, dto.getQna_pd_num());
				pstmt2.setString(6, dto.getQna_user_email());
				pstmt2.setString(7, dto.getQna_type());
				pstmt2.setString(8, dto.getQna_accesspermission());
				Count = pstmt2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("writeQna 구문 오류");
		}finally {
			close(rs);
			close(pstmt2);
		}
		return Count;
	}
	public QnaDTO getQnaDetail(int qna_num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaDTO dto = new QnaDTO();
		String sql = "SELECT * FROM qna WHERE qna_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setQna_num(rs.getInt("qna_num"));
				dto.setQna_user(rs.getString("qna_user"));
				dto.setQna_subject(rs.getString("qna_subject"));
				dto.setQna_content(rs.getString("qna_content"));
				dto.setQna_date(rs.getDate("qna_date"));
				dto.setQna_pd_num(rs.getInt("qna_pd_num"));
				dto.setQna_user_email(rs.getString("qna_user_email"));
				dto.setQna_type(rs.getString("qna_type"));
				dto.setQna_rep(rs.getString("qna_rep"));
				dto.setQna_accesspermission(rs.getString("qna_accesspermission"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getQnaDetail 구문오류");
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return dto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
