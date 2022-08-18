package action;

import java.util.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class UserProductListProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserProductListProAction");
		
		// 파라미터로 받아온 타입(all ,국내도서, 해외도서)
		String type = request.getParameter("pd_type");
		System.out.println(type);
		// 파라미터로 받아온 sort 방식(last, price, rate)
		String sort = request.getParameter("sort_type");
		System.out.println(sort);
		
		ActionForward forward = null;
		
		int pageNum = 1;
		int listLimit = 10;
		int pageLimit = 10;

		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		UserProductListProService service = new UserProductListProService();
		int listCount = service.getListCount();
		
		int maxPage = (int)Math.ceil((double)listCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
	   
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, listCount);
		
		ArrayList<ProductDTO> productList = service.ProductList(type,sort);
		
		request.setAttribute("type", type);
		request.setAttribute("sort", sort);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("productList", productList);
		
		forward = new ActionForward();
		forward.setPath("product/user_product_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
