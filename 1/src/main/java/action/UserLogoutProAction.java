package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class UserLogoutProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserLogoutProAction");
		ActionForward forward = null;

		request.getSession().invalidate();
		
		forward = new ActionForward();
		forward.setPath("./");
		forward.setRedirect(true);
		return forward;
	}

}
