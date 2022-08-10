package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.QnaDAO;
import db.JdbcUtil;
import vo.QnaDTO;

public class AdminQnaListService {

	
	public int getListCount() {
		int listCount = 0;
		Connection con = getConnection();
		
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		listCount = dao.selectListCount();
		close(con);
		
		return listCount;
	}
	
	public ArrayList<QnaDTO> getQnaList(int pageNum, int listLimit, String type) {
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		
		
		ArrayList<QnaDTO> list = dao.getQnaList(pageNum, listLimit,type);
		
		JdbcUtil.close(con);
		return list;
	}

	
	
	
	
	

}
