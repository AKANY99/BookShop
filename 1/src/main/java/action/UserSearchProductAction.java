package action;

import java.util.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class UserSearchProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UserSearchProductAction");
		
		String searchType = request.getParameter("searchType");
//		System.out.println(searchType);
		String search = request.getParameter("search");
//		System.out.println(search);
		String sort = request.getParameter("sort");
//		System.out.println(sort);
		
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
		
		ArrayList<ProductDTO> searchProductList = service.SearchProductList(searchType, search, sort);
		
		request.setAttribute("searchType", searchType);
		request.setAttribute("search", search);
		request.setAttribute("sort", sort);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("searchProductList", searchProductList);
		
		forward = new ActionForward();
		forward.setPath("product/search_product_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
