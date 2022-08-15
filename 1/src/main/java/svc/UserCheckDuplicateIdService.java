package svc;

import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.close;

import java.sql.Connection;

import dao.UserDAO;

public class UserCheckDuplicateIdService {
	public Boolean checkDuplicateId(String user_email) {
		boolean isDuplicate = false;
		Connection con = getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);

		isDuplicate = dao.selectDuplicateId(user_email);
		
		close(con);
		
		return isDuplicate;
	}
}
