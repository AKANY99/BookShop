package action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import svc.*;
import vo.*;

public class CartOnAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartOnAction");
		ActionForward forward = null;
		int pd_num = Integer.parseInt(request.getParameter("pd_num"));
		String sId = request.getParameter("sId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		System.out.println(pd_num + sId + quantity);
		
		CartOnService service = new CartOnService();
		int CartOnCount = service.cartOn(pd_num, sId, quantity);
		
		if(CartOnCount==0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('장바구니 담기 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('선택하신 상품이 장바구니에 담겼습니다!')");
			out.println("history.back()");
			out.println("</script>");
			
		}
		return forward;
	}

}
