package svc;

import static db.JdbcUtil.close;

import java.sql.Connection;

import dao.UserDAO;
import db.JdbcUtil;

public class MyInfoDelProService {

	public int userInfoDel(String sId) {
		int deleteCount = 0;
		System.out.println("service 내 메서드 진입");
		
		Connection con = JdbcUtil.getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
			
		deleteCount = dao.userDel(sId);
		System.out.println("isDeleteOK "+deleteCount);
		
		if(deleteCount > 0) {
			JdbcUtil.commit(con);
			close(con);
		}else {
			System.out.println("회원 삭제 실패!");
		
		}
		return deleteCount;
	}

	
}
