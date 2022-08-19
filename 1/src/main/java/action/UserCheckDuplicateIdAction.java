package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserCheckDuplicateIdService;
import vo.ActionForward;

public class UserCheckDuplicateIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String user_email = request.getParameter("user_email")+'@'+request.getParameter("user_email2");
		System.out.println(user_email);
		
		UserCheckDuplicateIdService service = new UserCheckDuplicateIdService();

		boolean isDuplicate = service.checkDuplicateId(user_email);
		
		if(isDuplicate) {
			System.out.println("중복");
		} else {
			System.out.println("안중복");
		}
		forward = new ActionForward();
		System.out.println("UserCheckIdForm.us?user_email=" + user_email + "&isDuplicate=" + isDuplicate);
		forward.setPath("UserCheckIdForm.us?user_email=" + user_email + "&isDuplicate=" + isDuplicate);
		return forward;
	}

}
