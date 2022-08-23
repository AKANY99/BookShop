package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminProductDeleteService;
import vo.ActionForward;

public class AdminProductDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String pd_num = request.getParameter("pd_num");
		
		AdminProductDeleteService service = new AdminProductDeleteService();
		int deleteCount = service.deleteProduct(pd_num);
		
		if(deleteCount == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품삭제 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("ProductList.ad?pd_quan=all");
			forward.setRedirect(true);			
		}
		return forward;
	}

}
