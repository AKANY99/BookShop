package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminDesignService;
import vo.ActionForward;
import vo.PageInfo;
import vo.ProductDTO;

public class AdminChangeMainAdAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminDesignService service = new AdminDesignService();
		int ad_num = Integer.parseInt(request.getParameter("main_ad_num"));
		String productObject = "";
		if(request.getParameter("productObject") == null || request.getParameter(productObject) == "") {
			request.setAttribute("productObject", "");
			productObject = "%%";
		}else {
			request.setAttribute("productObject", request.getParameter("productObject"));
			productObject = '%'+request.getParameter("productObject")+'%';
		}
		
		int pdPageNum = 1;
		int listLimit = 5;
		int pdPageLimit = 10;
		if(request.getParameter("pdPageNum") != null) {
			pdPageNum = Integer.parseInt(request.getParameter("pdPageNum"));
		}
		System.out.println(pdPageNum);
		int listCount = service.getListCount(productObject);
		int maxpdPage = (int)Math.ceil((double)listCount / listLimit);
		int startpdPage = ((int)((double)pdPageNum / pdPageLimit + 0.9) - 1) * pdPageLimit + 1;
		int endpdPage = startpdPage + pdPageLimit - 1;
	   
		if(endpdPage > maxpdPage) {
			endpdPage = maxpdPage;
		}
		
		PageInfo pdPageInfo = new PageInfo(pdPageNum, maxpdPage, startpdPage, endpdPage, listCount);
		ArrayList<ProductDTO> list = service.getAdProduct(productObject,pdPageNum,listLimit);
		
		request.setAttribute("searchObject2", request.getParameter("productObject"));
		request.setAttribute("ad_num", ad_num);
		request.setAttribute("pdPageInfo", pdPageInfo);
		request.setAttribute("pdList", list);
		ActionForward forward = new ActionForward();
		forward.setPath("design/admin_setmainAd.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
