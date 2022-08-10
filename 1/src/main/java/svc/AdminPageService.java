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
		qnaNoArr[0] = dao.selectListCount("상품");
		qnaNoArr[1] = dao.selectListCount("일반");
		
		close(con);
		return qnaNoArr;
	}

}
