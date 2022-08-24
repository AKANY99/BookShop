package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;

public class InterestOnService {


	public int interestOn(int pd_num, String sId) {
		int InterestOnCount = 0;
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
			
		InterestOnCount = dao.InterestOn(pd_num, sId);
			
		if(InterestOnCount > 0) {
			commit(con);
		}else {
			rollback(con);
		}
			
		close(con);
		
		return InterestOnCount;
	}

}
