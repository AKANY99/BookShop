package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserQnaDetailService;
import vo.ActionForward;
import vo.QnaDTO;

public class UserQnaDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		UserQnaDetailService service = new UserQnaDetailService();
		QnaDTO dto = service.getQnaDetail(qna_num);
		
		
		request.setAttribute("qna", dto);
		ActionForward forward = new ActionForward();
		forward.setPath("qna/user_qna_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
