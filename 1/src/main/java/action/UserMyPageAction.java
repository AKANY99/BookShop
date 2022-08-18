package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class UserMyPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		forward = new ActionForward();
		forward.setPath("board/my_page.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
