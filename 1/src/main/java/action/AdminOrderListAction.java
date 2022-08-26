package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminOrderListService;
import svc.AdminProductListService;
import vo.ActionForward;
import vo.OrdDTO;
import vo.PageInfo;

public class AdminOrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		AdminOrderListService service = new AdminOrderListService();;
		
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
		String min_price = request.getParameter("min_price");
		String max_price = request.getParameter("max_price");
		String order_status = request.getParameter("order_status");
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		if(start_date == "" && end_date == ""){
			start_date = "2022-07-01";
			end_date = formatedNow.toString();
		}
		if(min_price == "" && max_price == ""){
			min_price = "0";
			max_price = "9999999999999";
		}
		// 상품관리에 필요한 페이징처리
		int ordPageNum = 1;
		int listLimit = 10;
		int ordPageLimit = 10;
		if(request.getParameter("ordPageNum") != null) {
			ordPageNum = Integer.parseInt(request.getParameter("ordPageNum"));
		}
		int listCount = 0;
		if(order_status.equals("all")) {
			listCount = service.getListCount(start_date, end_date, min_price, max_price);
		} else {
			listCount = service.getListCount(start_date, end_date, min_price, max_price, order_status);
		}
		int maxOrdPage = (int)Math.ceil((double)listCount / listLimit);
		int startOrdPage = ((int)((double)ordPageNum / ordPageLimit + 0.9) - 1) * ordPageLimit + 1;
		int endOrdPage = startOrdPage + ordPageLimit - 1;
		if(endOrdPage > maxOrdPage) {
			endOrdPage = maxOrdPage;
		}

		PageInfo ordPageInfo = new PageInfo(ordPageNum, maxOrdPage, startOrdPage, endOrdPage, listCount);
		
		List<OrdDTO> orderList = null;
		service = new AdminOrderListService();
		if(order_status.equals("all")) {
			orderList = service.getOrderList(start_date, end_date, min_price, max_price, ordPageNum, listLimit);
		} else {
			orderList = service.getOrderList(start_date, end_date, min_price, max_price, order_status, ordPageNum, listLimit);
		}
		
		System.out.println(orderList.get(1));
		request.setAttribute("start_date", start_date);
		request.setAttribute("end_date", end_date);
		request.setAttribute("min_price", min_price);
		request.setAttribute("max_price", max_price);
		request.setAttribute("order_status", order_status);
		request.setAttribute("ordPageInfo", ordPageInfo);
		request.setAttribute("orderList", orderList);
		
		forward = new ActionForward();
		forward.setPath("ord/admin_order_getlist.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
