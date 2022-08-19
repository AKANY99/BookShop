package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UsergetPopupActionService;
import vo.ActionForward;

public class UsergetPopupAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		UsergetPopupActionService service = new UsergetPopupActionService();
		Object[] popupPath = service.getPopup();
		
		ActionForward forward = new ActionForward();
		if(popupPath[0] != null) {
			request.setAttribute("pd_num", popupPath[0]);
		}
		forward.setPath("upload/" + popupPath[1] );
		forward.setRedirect(false);
		
		return forward;
	}

}
