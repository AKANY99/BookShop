package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminPageService;
import vo.ActionForward;

public class AdminPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		AdminPageService service = new AdminPageService();
//		int[] odNoArr = service.OrderNoticeCount();
//		int[] pdNoArr = service.ProductNoticeCount();
		int[] qnaNoArr = service.QnaNoticeCount();
		
//		request.setAttribute("odNoArr", odNoArr);
//		request.setAttribute("pdNoArr", pdNoArr);
		request.setAttribute("qnaNoArr", qnaNoArr);
		
		forward = new ActionForward();
		forward.setPath("board/admin_page.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
