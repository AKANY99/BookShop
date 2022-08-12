package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminQnaRepService;
import vo.ActionForward;
import vo.QnaDTO;

public class AdminQnaRepAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		AdminQnaRepService service = new AdminQnaRepService();
		QnaDTO rep = service.getQnaRepOk(qna_num);
		
		request.setAttribute("rep", rep);
		ActionForward forward = new ActionForward();
		forward.setPath("qna/admin_qna_rep.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
