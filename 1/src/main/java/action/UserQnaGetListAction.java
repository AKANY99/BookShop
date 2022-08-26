package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserQnaGetListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.QnaDTO;

public class UserQnaGetListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sId = request.getParameter("sId");
		String qap = request.getParameter("qna_access_permission");
		if(qap == null) {
			qap = "public";
		}
		UserQnaGetListService service = new UserQnaGetListService();
		int qnaPageNum = 1;
		int listLimit = 5;
		int qnaPageLimit = 10;
		if(request.getParameter("qnaPageNum") != null) {
			qnaPageNum = Integer.parseInt(request.getParameter("qnaPageNum"));
		}
		int listCount = service.getListCount(qap,sId);
		int maxqnaPage = (int)Math.ceil((double)listCount / listLimit);
		int startqnaPage = ((int)((double)qnaPageNum / qnaPageLimit + 0.9) - 1) * qnaPageLimit + 1;
		int endqnaPage = startqnaPage + qnaPageLimit - 1;
	   
		if(endqnaPage > maxqnaPage) {
			endqnaPage = maxqnaPage;
		}
		PageInfo qnaPageInfo = new PageInfo(qnaPageNum, maxqnaPage, startqnaPage, endqnaPage, listCount);
		ArrayList<QnaDTO> list = service.getQnaList(qap, sId,qnaPageNum, listLimit);
		
		
		
		
		ActionForward forward = new ActionForward();
		request.setAttribute("qnaPageInfo", qnaPageInfo);
		request.setAttribute("qna_accesspermission", qap);
		request.setAttribute("qnaList", list);
		forward.setPath("qna/user_qna_getlist.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
