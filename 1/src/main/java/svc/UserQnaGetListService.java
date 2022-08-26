package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import db.JdbcUtil;
import vo.QnaDTO;

public class UserQnaGetListService {

	public ArrayList<QnaDTO> getQnaList(String qap, String sId, int qnaPageNum, int listLimit) {
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		ArrayList<QnaDTO> list = dao.getQnaMyList(qap,sId,qnaPageNum, listLimit);
		
		
		JdbcUtil.close(con);
		
		return list;
	}

	public int getListCount(String qap, String sId) {
		
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		int count = dao.selectListCount(qap, sId);
		JdbcUtil.close(con);
		
		return count;
	}

}
