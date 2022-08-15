package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.UserDAO;

public class AdminUserDeleteService {

	public boolean isAdmin(String id, String password) {
		boolean isLoginSuccess = false;
		Connection con = getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);

		isLoginSuccess = dao.loginUser(id, password);
		
		close(con);
		
		return isLoginSuccess;
	}

	public boolean userDelete(int user_num) {
		boolean isDeleteSuccess = false;
		Connection con = getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		
//		isDeleteSuccess = dao.userDelete();
		
		close(con);
		
		return isDeleteSuccess;
	}

}
