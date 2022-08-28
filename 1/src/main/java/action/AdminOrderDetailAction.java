package action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminOrderDetailService;
import vo.ActionForward;
import vo.OrdDetailDTO;

public class AdminOrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String order_num = request.getParameter("order_num");
		
		AdminOrderDetailService service = new AdminOrderDetailService();
		List<OrdDetailDTO> orderList = service.getOrderDetail(order_num);
		
		request.setAttribute("orderList", orderList);
		
		forward = new ActionForward();
		forward.setPath("ord/admin_order_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
