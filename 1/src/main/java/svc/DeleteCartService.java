package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;

public class DeleteCartService {

	public int removeCart(int pd_num, String sId) {
		int isDeleteSuccess = 0;
		
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
			
		// ProductDAO 의 deleteCart() 메서드를 호출하여 삭제 작업 수행
		// => 파라미터 : 글번호, sId    리턴타입 : int(isDeleteSuccess)
		isDeleteSuccess = dao.deleteCart(pd_num, sId);
			
		// isDeleteSuccess 가 0 보다 크면 commit, 아니면 rollback 작업 수행
		if(isDeleteSuccess > 0) {
			commit(con);
		} else {
			rollback(con);
		}
			
		close(con);
		
		return isDeleteSuccess;
	}

}
