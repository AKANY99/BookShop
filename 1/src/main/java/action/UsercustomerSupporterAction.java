package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class UsercustomerSupporterAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("qna/user_customersupporter.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
