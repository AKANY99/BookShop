package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.UserDAO;

public class UserSendAuthMailService {

	public boolean registAuthCode(String email, String authCode) {
		boolean isRegistSuccess = false;
		
		Connection con = getConnection();
		UserDAO dao = UserDAO.getInstance();
		dao.setConnection(con);
		
		// MemberDAO 객체의 registAuthCode() 메서드를 호출하여 인증코드 등록 작업 수행
		// => 파라미터 : 아이디, 인증코드   리턴타입 : int(registCount)
		int registCount = dao.registAuthCode(email, authCode);
		
		if(registCount > 0) {
			commit(con);
			isRegistSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isRegistSuccess;
	}

}











