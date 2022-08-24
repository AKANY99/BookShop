package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.*;

public class CartQuanChangeService {

	public int cartQuanChangeService(String sId, int pd_num, int quan) {
		int changeCount = 0;
		
		Connection con = JdbcUtil.getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		changeCount = dao.CartQuanChange(sId, pd_num, quan);
		
		if(changeCount > 0) {
			commit(con);
		}else {
			rollback(con);
		}
				
		close(con);
		
		return changeCount;
		
	}

}
