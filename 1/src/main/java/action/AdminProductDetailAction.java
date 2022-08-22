package action;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminProductDetailService;
import vo.ActionForward;
import vo.ProductDTO;

public class AdminProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int pd_num = Integer.parseInt(request.getParameter("pd_num"));
		
		AdminProductDetailService service = new AdminProductDetailService();
		ProductDTO product = service.getProductDetail(pd_num);
		
		request.setAttribute("product", product);
		
		forward = new ActionForward();
		forward.setPath("product/admin_product_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
