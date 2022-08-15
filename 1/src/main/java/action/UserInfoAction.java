package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserInfoService;
import vo.ActionForward;
import vo.UserDTO;

public class UserInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sId= request.getParameter("sId");
		System.out.println("action 진입"+sId);
		ActionForward forward = null;
		
		UserInfoService service = new UserInfoService();
		UserDTO user = service.userInfoChecked(sId);
		System.out.println("user 받아옴");

		request.setAttribute("user", user);
		System.out.println(user);
		
		forward = new ActionForward();
		forward.setPath("user/my_page.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
