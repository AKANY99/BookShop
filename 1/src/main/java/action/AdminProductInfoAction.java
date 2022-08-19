package action;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminProductInfoService;
import vo.ActionForward;
import vo.ProductDTO;

public class AdminProductInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int pd_num = Integer.parseInt(request.getParameter("pd_num"));
		
		AdminProductInfoService service = new AdminProductInfoService();
		ProductDTO product = service.getProductDetail(pd_num);
		
		request.setAttribute("product", product);
		
		forward = new ActionForward();
		forward.setPath("product/admin_product_info.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
