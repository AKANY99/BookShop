package action;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class userProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int pd_num = Integer.parseInt(request.getParameter("pd_num"));
		
		UserProductDetailService service = new UserProductDetailService();
		ProductDTO product = service.getProduct(pd_num);
		
		request.setAttribute("product", product);
		
		forward = new ActionForward();
		forward.setPath("product/user_product_detail.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
