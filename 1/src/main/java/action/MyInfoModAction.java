package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MyInfoModService;
import svc.UserInfoService;
import vo.ActionForward;
import vo.UserDTO;

public class MyInfoModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sId= request.getParameter("sId");
		System.out.println("action 진입"+sId);
		ActionForward forward = null;
		
		MyInfoModService service = new MyInfoModService();
		UserDTO user = service.MyInfoModify(sId);
		System.out.println("user 받아옴");

		request.setAttribute("user", user);
		System.out.println(user);
		
		forward = new ActionForward();
		forward.setPath("user/my_pageMod.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
