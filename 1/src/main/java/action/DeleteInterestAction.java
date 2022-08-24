package action;

import java.io.*;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class DeleteInterestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteInterestAction");
		
		ActionForward forward = null;
		
		// 전달받은 파라미터 가져오기
		int pd_num = Integer.parseInt(request.getParameter("pd_num"));
		String sId = request.getParameter("sId");
		
		// DeleteInterestService - removeInterest() 메서드를 호출하여 찜목록에서 상품 삭제 요청
		DeleteInterestService service = new DeleteInterestService();
		int isDeleteSuccess = service.removeInterest(pd_num, sId);
			
		// 삭제 결과 판별
		// 삭제 실패 시 자바스크립트로 "찜목록에서 상품 삭제 실패!" 출력 후 이전페이지로 돌아가기
		// 삭제 성공 시 찜목록으로 돌아가기
		if(isDeleteSuccess==0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('찜목록에서 상품 삭제 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("MyInterest.us?sId=" + sId);
			forward.setRedirect(true);
		}

		return forward;
	}

}
