package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminDesignService;
import vo.ActionForward;
import vo.adDTO;

public class DesginManagementAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AdminDesignService service = new AdminDesignService();
		ArrayList<adDTO> MainAdlist = service.getMainAdList();
		
		
		request.setAttribute("ad", MainAdlist);
		ActionForward forward = new ActionForward();
		forward.setPath("design/admin_design.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
