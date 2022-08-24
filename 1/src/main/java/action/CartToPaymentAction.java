package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MyCartService;
import svc.PaymentService;
import vo.ActionForward;
import vo.ProductDTO;

public class CartToPaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println("CartToPaymentAction 진입");
		String sId = request.getParameter("sId");
		
		PaymentService service = new PaymentService();
		ArrayList<ProductDTO> list = service.myCart(sId);
		
		int userPoint = service.getUserpoints(sId);
	
		request.setAttribute("list", list);
		request.setAttribute("userPoint",userPoint);
		ActionForward forward = new ActionForward();
		forward.setPath("payment/payment.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
