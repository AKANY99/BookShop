package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminProductWriteProService;
import vo.ActionForward;

public class AdminProductWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		AdminProductWriteProService service = new AdminProductWriteProService();
		int insertCount = service.insertProduct();
		
		if(insertCount == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글등록 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("ProductList.ad?pd_quan=전체");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
