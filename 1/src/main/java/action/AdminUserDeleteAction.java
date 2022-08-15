package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminUserDeleteService;
import vo.ActionForward;

public class AdminUserDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("passwd");
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		boolean isDeleteSuccess = false;
		AdminUserDeleteService service = new AdminUserDeleteService();
		boolean isLoginSuccess = service.isAdmin(id, password);
		if(!isLoginSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			isDeleteSuccess = service.userDelete(user_num);
		}
		if(!isDeleteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}else {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제 완료.')");
		out.println("window.close()");
		out.println("</script>");
		}
		return null;
	}

}
