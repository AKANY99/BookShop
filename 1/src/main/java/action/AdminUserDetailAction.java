package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminUserDetailService;
import vo.ActionForward;
import vo.UserDTO;

public class AdminUserDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		AdminUserDetailService service = new AdminUserDetailService();
		UserDTO user = service.getUserDetail(user_num);
		
		
		
		
		
		
		
		request.setAttribute("userDetail", user);
		forward = new ActionForward();
		forward.setPath("user/admin_user_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
