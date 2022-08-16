package action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MyInfoModProService;
import svc.MyInfoModService;
import vo.ActionForward;
import vo.UserDTO;

public class MyInfoModProAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Proaction 진입");
		ActionForward forward = null;
		
		UserDTO user2 = new UserDTO();
		user2.setUser_num(Integer.parseInt(request.getParameter("num")));
		user2.setUser_name(request.getParameter("name"));
		user2.setUser_email(request.getParameter("email"));
		user2.setUser_passwd(request.getParameter("passwd"));
		user2.setUser_gender(request.getParameter("gender"));
		user2.setUser_jumin(request.getParameter("jumin"));
		user2.setUser_address(request.getParameter("address"));
		user2.setUser_phone(request.getParameter("phone"));
		System.out.println("user2"+user2);
		
		
		
		MyInfoModProService service = new MyInfoModProService();
		UserDTO user = service.MyInfoModifyPro(user2);
		System.out.println("user2 받아옴"+user);
	

		request.setAttribute("user", user);
		
		forward = new ActionForward();
		forward.setPath("user/my_page.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
