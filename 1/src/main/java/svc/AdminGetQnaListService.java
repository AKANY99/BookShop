package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.QnaDAO;
import db.JdbcUtil;
import vo.QnaDTO;

public class AdminGetQnaListService {

	
	public int getListCount() {
		int listCount = 0;
		Connection con = getConnection();
		
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.selectListCount();
		close(con);
		
		return listCount;
	}
	
	public ArrayList<QnaDTO> getQnaList(String qna_rep, String qna_type, String orderBy, String searchObject, String startDate, String endDate, int pageNum, int listLimit) {
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		ArrayList<QnaDTO> list = dao.getQnaList(qna_rep, qna_type, orderBy, searchObject, startDate, endDate, pageNum, listLimit);
		
		JdbcUtil.close(con);
		return list;
	}

	public int getListCount(String qna_rep, String qna_type, String orderBy, String searchObject, String startDate, String endDate) {
		int listCount = 0;
		Connection con = getConnection();
		
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.selectListCount(qna_rep, qna_type, orderBy, searchObject, startDate, endDate);
		close(con);
		
		return listCount;
	}
	
	
	
	

}
