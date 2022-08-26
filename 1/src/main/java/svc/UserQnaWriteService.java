package svc;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.QnaDAO;
import db.JdbcUtil;
import vo.QnaDTO;

public class UserQnaWriteService {

	public int writeQna(QnaDTO dto) {
		Connection con = getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		int Count = dao.writeQna(dto);
		
		if(Count > 0) {
		JdbcUtil.commit(con);
		JdbcUtil.close(con);
		}else {
		JdbcUtil.rollback(con);
		JdbcUtil.close(con);
		}
		
		return Count;
	}

}
