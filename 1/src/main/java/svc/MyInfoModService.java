package svc;

import static db.JdbcUtil.close;

import java.sql.Connection;

import dao.UserDAO;
import db.JdbcUtil;
import vo.UserDTO;

public class MyInfoModService {

	public UserDTO MyInfoModify(String sId) {
		System.out.println("service 내 메서드 진입");
		UserDTO user = new UserDTO();
		
		Connection con = JdbcUtil.getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		
		user = dao.MyInfoModify(sId);
		System.out.println("user 받아옴");
		
		close(con);
		
		return user;
	}
}
