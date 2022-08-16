package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.ProductDTO;
import vo.UserDTO;

public class UserDAO {
	// 싱글톤 디자인 패턴 사용하여 인스턴스 생성
	private static UserDAO instance = new UserDAO();
	private UserDAO() {}
	public static UserDAO getInstance() {
		return instance;
	};
	
	Connection con;
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// 관리자 페이지에서 사용할 전체 회원수 조회 기능
	public int getUserCount() {
		int userCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("getUserCount() - SQL 구문 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return userCount;
	}
	
	// 관리자페이지에서 사용할 전체 회원목록 조회 기능
	public ArrayList<UserDTO> getUserList(int pageNum, int listLimit) {
		ArrayList<UserDTO>userList = new ArrayList<UserDTO>();
		int startRow = (pageNum-1)*listLimit;
		UserDTO user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM user ORDER BY user_num DESC LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user = new UserDTO();
				user.setUser_num(rs.getInt("user_num"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_passwd(rs.getString("user_passwd"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_jumin(rs.getString("user_jumin"));
				user.setUser_address_code(rs.getInt("user_address_code"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_phone(rs.getString("user_phone"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getUserList() - SQL 구문 오류 : " + e.getMessage());
		}finally {
			close(pstmt);
			close(rs);
		}
		return userList;
	}
	
	// 사용자 개인정보 조회
	public int insertUser(UserDTO user) {
		int insertCount = 0;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 신규 회원 번호 지정
			int uNum = 1;
			sql = "SELECT MAX(user_num) FROM user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				uNum = rs.getInt(1)+1;
			}
			
			// 먼저 쓴 pstmt 자원반환
			close(pstmt);
			
			sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uNum);
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_email());
			pstmt.setString(4, user.getUser_passwd());
			pstmt.setString(5, user.getUser_gender());
			pstmt.setString(6, user.getUser_jumin());
			pstmt.setInt(7, user.getUser_address_code());
			pstmt.setString(8, user.getUser_address());
			pstmt.setString(9, user.getUser_phone());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insertUser() - SQL 구문 오류 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}
	
	// 로그인 기능
	public boolean loginUser(String user_email, String user_passwd) {
		boolean isLoginSuccess = false;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			sql = "SELECT * FROM user WHERE user_email=? AND user_passwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			pstmt.setString(2, user_passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isLoginSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insertUser() - SQL 구문 오류 : " + e.getMessage());
		} finally {
			close(pstmt);
		}
		return isLoginSuccess;
	}
	
	// 회원가입에서 회원 중복 체크
	public boolean selectDuplicateId(String user_email) {
		boolean isDuplicate = false;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			sql = "SELECT * FROM user WHERE user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isDuplicate = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectDuplicateId() - SQL 구문 오류 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isDuplicate;
	}
	public String getLoginUserName(String user_email) {
		String userName = null;
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			sql = "SELECT user_name FROM user WHERE user_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userName = rs.getString("user_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("selectDuplicateId() - SQL 구문 오류 : " + e.getMessage());
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return userName;
	}
	
	public UserDTO getUserInfo(String sId) {
		System.out.println("DAO 진입");
		UserDTO user = new UserDTO();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "select * from user where user_email=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setUser_num(rs.getInt("user_num"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_passwd(rs.getString("user_passwd"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_jumin(rs.getString("user_jumin"));
				user.setUser_address_code(rs.getInt("user_address_code"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_date(rs.getDate("user_date"));
				
			}
		} catch (SQLException e) {
			System.out.println("sql 구문오류"+e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return user;
	}
	public UserDTO MyInfoModify(String sId) {
		System.out.println("DAO 진입");
		UserDTO user = new UserDTO();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "select * from user where user_email=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setUser_num(rs.getInt("user_num"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_passwd(rs.getString("user_passwd"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_jumin(rs.getString("user_jumin"));
				user.setUser_address_code(rs.getInt("user_address_code"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_date(rs.getDate("user_date"));
				
			}
		} catch (SQLException e) {
			System.out.println("sql 구문오류"+e.getMessage());
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return user;
	}
	public UserDTO MyInfoModifyPro(UserDTO user2) {
		int updateCount=0;
		System.out.println("DAO 진입");
		UserDTO user = new UserDTO();
		PreparedStatement pstmt = null;
		
		String sql="update user set user_name=?,user_email=?,user_passwd=?,user_gender=?,user_jumin=?,user_address_code=?,user_address=?,user_phone=?,user_date=? where user_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user2.getUser_name());
			pstmt.setString(2, user2.getUser_email());
			pstmt.setString(3, user2.getUser_passwd());
			pstmt.setString(4, user2.getUser_gender());
			pstmt.setString(5, user2.getUser_jumin());
			pstmt.setInt(6, user2.getUser_address_code());
			pstmt.setString(7, user2.getUser_address());
			pstmt.setString(8, user2.getUser_phone());
			pstmt.setDate(9, user2.getUser_date());
			pstmt.setInt(10, user2.getUser_num());
			
			updateCount = pstmt.executeUpdate();
			System.out.println(updateCount);
			
			if(updateCount>0) {
				System.out.println("수정작업완료");
				user.setUser_num(user2.getUser_num());
				user.setUser_name(user2.getUser_name());
				user.setUser_email(user2.getUser_email());
				user.setUser_passwd(user2.getUser_passwd());
				user.setUser_gender(user2.getUser_gender());
				user.setUser_jumin(user2.getUser_jumin());
				user.setUser_address_code(user2.getUser_address_code());
				user.setUser_address(user2.getUser_address());
				user.setUser_phone(user2.getUser_phone());
				user.setUser_date(user2.getUser_date());
				
			}
		} catch (SQLException e) {
		System.out.println("sql 구문 오류" + e.getMessage());
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return user;
		
		
		
	}
	public int userDel(String sId) {
		int deleteCount = 0;
		
		System.out.println("DAO 진입");
		UserDTO user = new UserDTO();
		PreparedStatement pstmt = null;
		
		String sql = "delete from user where user_email=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 구문오류 !"+e.getMessage());
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
}
