package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminProductListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.ProductDTO;

public class AdminProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdminProductListAction");
		ActionForward forward = null;
		AdminProductListService service = null;
		
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
		String pd_quan = request.getParameter("pd_quan");
		String pd_type = request.getParameter("pd_type");
		String search_input = request.getParameter("search_input");
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		if(start_date == "" && end_date == ""){
			start_date = "2022-07-01";
			end_date = formatedNow.toString();
		}
		if(search_input == null) {
			search_input = "";
		}
		
		// 상품관리에 필요한 페이징처리
		int pdPageNum = 1;
		int listLimit = 10;
		int pdPageLimit = 10;
		if(request.getParameter("pdPageNum") != null) {
			pdPageNum = Integer.parseInt(request.getParameter("pdPageNum"));
		}
		service = new AdminProductListService();
		int listCount = 0;
		if(pd_quan.equals("all") && pd_type.equals("all")) {
			listCount = service.getListCount(start_date, end_date, search_input);
		} else {			
			listCount = service.getListCount(start_date, end_date, pd_type, pd_quan, search_input);
		}
		int maxPdPage = (int)Math.ceil((double)listCount / listLimit);
		int startPdPage = ((int)((double)pdPageNum / pdPageLimit + 0.9) - 1) * pdPageLimit + 1;
		int endPdPage = startPdPage + pdPageLimit - 1;
		if(endPdPage > maxPdPage) {
			endPdPage = maxPdPage;
		}
		
		PageInfo pdPageInfo = new PageInfo(pdPageNum, maxPdPage, startPdPage, endPdPage, listCount);
		
		ArrayList<ProductDTO> list = null;
		if(pd_quan.equals("all") && pd_type.equals("all")) {
			list = service.getProductList(start_date, end_date, search_input, pdPageNum, listLimit);
		} else {
			list = service.getProductList(start_date, end_date, pd_type, pd_quan, search_input, pdPageNum, listLimit);			
		}
		
		request.setAttribute("start_date", start_date);
		request.setAttribute("end_date", end_date);
		request.setAttribute("pd_quan", pd_quan);
		request.setAttribute("pd_type", pd_type);
		request.setAttribute("search_input", search_input);
		request.setAttribute("pdPageInfo", pdPageInfo);
		request.setAttribute("pdList", list);
		
		forward = new ActionForward();
		forward.setPath("product/admin_product_getlist.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
