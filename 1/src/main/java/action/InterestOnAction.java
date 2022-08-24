package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class InterestOnAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InterestOnAction");
		ActionForward forward = null;
		int pd_num = Integer.parseInt(request.getParameter("pd_num"));
		String sId = request.getParameter("sId");
		
//		System.out.println(pd_num + sId);
		
		InterestOnService service = new InterestOnService();
		int InterestOnCount = service.interestOn(pd_num, sId);
		
		if(InterestOnCount==0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('찜목록에 해당 상품이 이미 존재합니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('선택하신 상품을 찜목록에 추가하였습니다!')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}
	

}
