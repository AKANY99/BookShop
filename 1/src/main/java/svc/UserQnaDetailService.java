package svc;

import java.sql.Connection;

import dao.QnaDAO;
import db.JdbcUtil;
import vo.QnaDTO;

public class UserQnaDetailService {

	public QnaDTO getQnaDetail(int qna_num) {
		
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		QnaDTO dto = dao.getQnaDetail(qna_num);
		
		JdbcUtil.close(con);
		
		
		
		return dto;
	}

}
