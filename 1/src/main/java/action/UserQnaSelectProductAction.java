package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.userQnaSelectProductService;
import vo.ActionForward;
import vo.PageInfo;
import vo.ProductDTO;

public class UserQnaSelectProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		userQnaSelectProductService service = new userQnaSelectProductService();
		String productObject = "";
		if(request.getParameter("productObject") == null || request.getParameter(productObject) == "") {
			productObject = "%%";
		}else {
			productObject = '%'+request.getParameter("productObject")+'%';
		}
		
		int qnaPageNum = 1;
		int listLimit = 12;
		int qnaPageLimit = 10;
		if(request.getParameter("qnaPageNum") != null) {
			qnaPageNum = Integer.parseInt(request.getParameter("qnaPageNum"));
		}
		int listCount = service.getListCount(productObject);
		int maxqnaPage = (int)Math.ceil((double)listCount / listLimit);
		int startqnaPage = ((int)((double)qnaPageNum / qnaPageLimit + 0.9) - 1) * qnaPageLimit + 1;
		int endqnaPage = startqnaPage + qnaPageLimit - 1;
	   
		if(endqnaPage > maxqnaPage) {
			endqnaPage = maxqnaPage;
		}
		
		
		PageInfo qnaPageInfo = new PageInfo(qnaPageNum, maxqnaPage, startqnaPage, endqnaPage, listCount);
		ArrayList<ProductDTO> productList = service.getQnaProduct(productObject,qnaPageNum, listLimit );
		request.setAttribute("searchObject2", request.getParameter("productObject"));
		request.setAttribute("qnaPageInfo", qnaPageInfo);
		request.setAttribute("productList", productList);
		ActionForward forward = new ActionForward();
		forward.setPath("qna/user_qna_selectproduct.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
