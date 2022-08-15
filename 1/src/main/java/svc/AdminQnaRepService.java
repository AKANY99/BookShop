package svc;

import java.sql.Connection;

import dao.QnaDAO;
import db.JdbcUtil;
import vo.QnaDTO;

public class AdminQnaRepService {

	public QnaDTO getQnaRepOk(int qna_num) {
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		QnaDTO dto = dao.getQna(qna_num);
		
		JdbcUtil.close(con);
		
		return dto;
	}

	public boolean repModify(QnaDTO qna) {
		boolean modify = false;
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		int updateCount = dao.qnaModify(qna);
		
		if(updateCount == 1) {
			modify = true;
			JdbcUtil.commit(con);
		}else {
			JdbcUtil.rollback(con);
		}
		JdbcUtil.close(con);
		
		return modify;
	}
	

}
