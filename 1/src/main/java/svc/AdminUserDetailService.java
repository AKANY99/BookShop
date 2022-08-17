package svc;

import java.sql.Connection;

import dao.UserDAO;
import db.JdbcUtil;
import vo.UserDTO;

public class AdminUserDetailService {

	public UserDTO getUserDetail(int user_num) {
		Connection con = JdbcUtil.getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		UserDTO user = dao.userDetail(user_num);
		
		JdbcUtil.close(con);
		
		return user;
	}	

}
