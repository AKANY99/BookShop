package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.ProductDAO;
import dao.QnaDAO;
import vo.OrdDAO;

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
		pdNoArr[0] = dao.selectProductQuan("품절");
		
		close(con);
		
		return pdNoArr;
	}

	public int[] OrderNoticeCount() {
		Connection con = getConnection();
		OrdDAO dao = OrdDAO.getInstance();
		dao.setCon(con);
		
		int[] ordNoArr = new int[2];
		ordNoArr[0] = dao.selectOrderStatus("결제완료");
		ordNoArr[1] = dao.selectOrderStatus("결제취소");
		
		close(con);
		return ordNoArr;
	}

}
