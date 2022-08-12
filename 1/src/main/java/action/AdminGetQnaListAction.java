package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminQnaListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.QnaDTO;

public class AdminGetQnaListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		AdminQnaListService service = new AdminQnaListService();
		String qna_rep = request.getParameter("qna_rep");
		String qna_type = request.getParameter("qna_type");
		String orderBy = request.getParameter("order_by");
		String searchObject = '%'+request.getParameter("searchObject")+'%';
		String startDate;
		String endDate;
		
		if(qna_type.equals("전체")){
			qna_type = " != 1 ";
		}else{
			qna_type = "= '" + qna_type +"'";
		}
		// 날짜 선택을 안했을경우 startDate = 정적 날짜, endDate = 현재 날짜 저장
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		if(request.getParameter("startDate") == ""){
			startDate = "1999-04-17";
		}else{
			startDate = request.getParameter("startDate");
		}
		if(request.getParameter("endDate") == ""){
			endDate = formatedNow.toString();
		}else{
			endDate = request.getParameter("endDate");
		}
		
	// 조건에 부합한 동적인 qnaPageNum 받기===============================================
		int qnaPageNum = 1;
		int listLimit = 10;
		int qnaPageLimit = 10;
		if(request.getParameter("qnaPageNum") != null) {
			qnaPageNum = Integer.parseInt(request.getParameter("qnaPageNum"));
		}
		int listCount = service.getListCount(qna_rep, qna_type, orderBy, searchObject, startDate, endDate);
		int maxqnaPage = (int)Math.ceil((double)listCount / listLimit);
		int startqnaPage = ((int)((double)qnaPageNum / qnaPageLimit + 0.9) - 1) * qnaPageLimit + 1;
		int endqnaPage = startqnaPage + qnaPageLimit - 1;
	   
		if(endqnaPage > maxqnaPage) {
			endqnaPage = maxqnaPage;
		}
		
		PageInfo qnaPageInfo = new PageInfo(qnaPageNum, maxqnaPage, startqnaPage, endqnaPage, listCount);
	// =========================================================================	
		ArrayList<QnaDTO> list = service.getQnaList(qna_rep, qna_type, orderBy, searchObject, startDate, endDate, qnaPageNum, listLimit);
		
		
		request.setAttribute("qnaPageInfo", qnaPageInfo);
		request.setAttribute("qnaList", list);
		forward = new ActionForward();
		forward.setPath("qna/admin_qna_getlist.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}

