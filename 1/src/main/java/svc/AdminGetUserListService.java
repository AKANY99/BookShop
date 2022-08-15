package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAO;
import db.JdbcUtil;
import vo.UserDTO;

public class AdminGetUserListService {

	public ArrayList<UserDTO> getUserList(String startDate, String endDate, String gender, String searchType, String searchObject, int userPageNum, int listLimit) {
		Connection con = JdbcUtil.getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		ArrayList<UserDTO> list = dao.getUserList(startDate, endDate, gender, searchType, searchObject, userPageNum, listLimit);
		JdbcUtil.close(con);
		
		return list;
	}

	public int getListCount(String startDate, String endDate, String gender, String searchType, String searchObject) {
		Connection con = JdbcUtil.getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		int count = dao.getUserCount(startDate, endDate, gender, searchType, searchObject);
		JdbcUtil.close(con);
		
		return count;
	}

}
