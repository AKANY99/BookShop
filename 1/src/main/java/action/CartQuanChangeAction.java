package action;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class CartQuanChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("CartQuanChangeAction.java");
		
		ActionForward forward = null;
		
		String sId= request.getParameter("sId");
		int pd_num = Integer.parseInt(request.getParameter("pd_num"));
		int quan = Integer.parseInt(request.getParameter("quan"));
		int changeCount = 0;
		
//		System.out.println(sId +","+ pd_num +","+ quan);
		
		CartQuanChangeService service = new CartQuanChangeService();
		changeCount = service.cartQuanChangeService(sId, pd_num, quan);
		
		request.setAttribute("sId", sId);

		if(changeCount==0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품 수량 변경 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("MyCart.us?sId=" + sId);
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
