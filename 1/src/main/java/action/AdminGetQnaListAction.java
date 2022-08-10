package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminQnaListService;
import vo.ActionForward;
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
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		
		if(request.getParameter("startDate") == null){
			startDate = "1999-04-17";
		}else{
			startDate = request.getParameter("startDate");
		}
		if(request.getParameter("endDate") == null){
			
			endDate = formatedNow.toString();
		}else{
			endDate = request.getParameter("endDate");
		}
		
		ArrayList<QnaDTO> list = service.getQnaList(qna_rep, qna_type, orderBy, searchObject, startDate, endDate);
		
		
		
		
		
		request.setAttribute("qnaList", list);
		forward = new ActionForward();
		forward.setPath("qna/admin_getqna_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}

