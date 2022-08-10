package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserLoginProService;
import vo.ActionForward;

public class UserLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserLoginProAction");
		ActionForward forward = null;

		String user_email = request.getParameter("user_email");
		String user_passwd = request.getParameter("user_passwd");

		System.out.println(user_email +  user_passwd);
		UserLoginProService service = new UserLoginProService();
		boolean isLoginSuccess = service.loginUser(user_email, user_passwd);
		
		if(!isLoginSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			request.getSession().setAttribute("sId", user_email);
			forward = new ActionForward();
			forward.setPath("./");
			forward.setRedirect(true);
		}
		return forward;
	}

}
