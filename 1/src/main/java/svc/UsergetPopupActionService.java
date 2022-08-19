package svc;

import java.sql.Connection;

import dao.UserDAO;
import db.JdbcUtil;

public class UsergetPopupActionService {

	public Object[] getPopup() {
		Connection con = JdbcUtil.getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		Object[] popupPath = dao.getPopup();
		
		
		
		JdbcUtil.close(con);
		
		return popupPath;
	}

}
