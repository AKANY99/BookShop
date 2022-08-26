package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserQnaWriteService;
import vo.ActionForward;
import vo.QnaDTO;

public class UserQnaWriteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserQnaWriteService service = new UserQnaWriteService();
		ActionForward forward = null;
		QnaDTO dto = new QnaDTO();
		int pd_num;
		if(request.getParameter("qna_type").equals("상품") && request.getParameter("pd_num") == "") {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품을 선택해 주세요')");
			out.println("history.back()");	
			out.println("</script>");
		}else {
		
		if(request.getParameter("pd_num") == null || request.getParameter("pd_num") == "") {
			pd_num = 0;
		}else {
			pd_num = Integer.parseInt(request.getParameter("pd_num"));
		}
		
		dto.setQna_pd_num(pd_num);
		dto.setQna_subject(request.getParameter("subject"));
		dto.setQna_user_email(request.getParameter("email"));
		dto.setQna_user(request.getParameter("name"));
		dto.setQna_accesspermission(request.getParameter("disclosure"));
		dto.setQna_content(request.getParameter("content"));
		dto.setQna_type(request.getParameter("qna_type"));
		int qnaInsertCount = service.writeQna(dto);
		
		if(qnaInsertCount < 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패!')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setPath("CustomerSupporter.us");
			forward.setRedirect(true);
			
		}
	}
		return forward;
	}
}
