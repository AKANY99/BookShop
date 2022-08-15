package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.ProductDAO;
import dao.QnaDAO;

public class AdminPageService {

	public int[] QnaNoticeCount() {
		Connection con = getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setCon(con);
		
		int[] qnaNoArr = new int[2];
		qnaNoArr[0] = dao.qnaIsnullCount("상품");
		qnaNoArr[1] = dao.qnaIsnullCount("일반");
		
		close(con);
		
		return qnaNoArr;
	}

	public int[] ProductNoticeCount() {
		Connection con = getConnection();
		ProductDAO dao = ProductDAO.getInstance();
		dao.setCon(con);
		
		int[] pdNoArr = new int[1];
		pdNoArr[0] = dao.selectListCount("품절");
		
		close(con);
		
		return pdNoArr;
	}

}
