package action;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class MyCartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MyCartAction");
		String sId = request.getParameter("sId");
		
		System.out.println(sId);
		
		MyCartService service = new MyCartService();
		ArrayList<ProductDTO> list = service.myCart(sId);
		
		request.setAttribute("list", list);
		ActionForward forward = new ActionForward();
		forward.setPath("cart/user_my_cart.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
