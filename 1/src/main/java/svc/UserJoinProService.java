package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import vo.UserDTO;

public class UserJoinProService {
		public boolean joinUser(UserDTO user) {
			boolean isJoinSuccess = false;
			Connection con = getConnection();
			UserDAO dao = UserDAO.getInstance();
			dao.setConnection(con);
			
			int insertCount = dao.insertUser(user);
			
			if (insertCount > 0) {
				commit(con);
				isJoinSuccess = true;
			} else {
				rollback(con);
			}
			
			close(con);
			
			return isJoinSuccess;
		}
}
