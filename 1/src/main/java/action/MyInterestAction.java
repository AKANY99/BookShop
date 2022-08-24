package action;

import java.util.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class MyInterestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MyInterestAction");
		String sId = request.getParameter("sId");
		
//		System.out.println(sId);
		
		MyInterestService service = new MyInterestService();
		ArrayList<ProductDTO> list = service.myInterest(sId);
		
		request.setAttribute("list", list);
		ActionForward forward = new ActionForward();
		forward.setPath("interest/user_my_interest.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
