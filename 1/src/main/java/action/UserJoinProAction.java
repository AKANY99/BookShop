package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserJoinProService;
import vo.ActionForward;
import vo.UserDTO;

public class UserJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserJoinProAction");
		
		ActionForward forward = null;
		
		UserDTO user = new UserDTO();
		user.setUser_name(request.getParameter("name"));
		user.setUser_email(request.getParameter("user_email")+"@"+request.getParameter("user_email2"));
		user.setUser_passwd(request.getParameter("user_passwd"));
		user.setUser_gender(request.getParameter("user_gender"));
		user.setUser_jumin(request.getParameter("user_jumin")+"-"+request.getParameter("user_jumin2"));
		user.setUser_address_code(Integer.parseInt(request.getParameter("user_address_code")));
		user.setUser_address(request.getParameter("user_address")+request.getParameter("user_address2"));
		user.setUser_phone(request.getParameter("user_phone"));
		
		UserJoinProService service = new UserJoinProService();
		boolean isJoinSuccess = service.joinUser(user);
		if(!isJoinSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("./");
			forward.setRedirect(true);
		}
		return forward;
	}
}
