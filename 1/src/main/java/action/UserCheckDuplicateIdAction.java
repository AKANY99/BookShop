package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserCheckDuplicateIdService;
import vo.ActionForward;

public class UserCheckDuplicateIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		UserCheckDuplicateIdService service = new UserCheckDuplicateIdService();
		
		boolean isDuplicate = service.checkDuplicateId(id);
		
		if(isDuplicate) {
			System.out.println("중복");
		} else {
			System.out.println("안중복");
		}
		forward = new ActionForward();
		System.out.println("UserCheckIdForm.us?id=" + id + "&isDuplicate=" + isDuplicate);
		forward.setPath("UserCheckIdForm.us?id=" + id + "&isDuplicate=" + isDuplicate);
		forward.setRedirect(true);
		return forward;
	}

}
