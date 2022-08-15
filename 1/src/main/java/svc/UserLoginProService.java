package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;

public class UserLoginProService {

	public boolean loginUser(String user_email, String user_passwd) {
		boolean isLoginSuccess = false;
		Connection con = getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);

		isLoginSuccess = dao.loginUser(user_email, user_passwd);
		
		close(con);
		
		return isLoginSuccess;
	}
	
	public String getLoginUserName(String user_email) {
		String userName = "";
		Connection con = getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);

		userName = dao.getLoginUserName(user_email);
		
		close(con);
		
		return userName;
	}
}
