package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import dao.UserDAO;
import db.JdbcUtil;
import vo.ProductDTO;
import vo.UserDTO;

public class UserListService {
	public int getUserCount() {
		int userCount = 0;
		Connection con = JdbcUtil.getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		
		// UserDAO 객체에서 전체 회원을 조회할 getUserCount() 메서드 조회
		// 파라미터 : 없음     리턴타입 : int(userCount)
		userCount = dao.getUserCount();
		
		JdbcUtil.close(con);
		
		return userCount;
	}

	public ArrayList<UserDTO> getUserList(int pageNum, int listLimit) {
		ArrayList<UserDTO> userList = null;
		Connection con = JdbcUtil.getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		
		// UserDAO객체에서 전체 상품목록을 조회할 getUserList() 메서드 정의
		// 파라미터 : pageNum(int), listLimit(int)     리턴타입 : ArrayList<UserDTO>(userList)
		userList = dao.getUserList(pageNum, listLimit);
		
		JdbcUtil.close(con);
		
		return userList;
	}
	
	
}
