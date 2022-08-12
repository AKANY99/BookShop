package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminQnaRepService;
import vo.ActionForward;
import vo.QnaDTO;

public class AdminQnaRepModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		String rep_content = request.getParameter("rep_content");
		QnaDTO qna = new QnaDTO();
		qna.setQna_num(qna_num);
		qna.setQna_rep(rep_content);
		AdminQnaRepService service = new AdminQnaRepService();
		boolean modify = service.repModify(qna);
		
		if(!modify) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글 수정 실패!')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setPath("Qnarepok.ad?qna_num="+qna_num);
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
