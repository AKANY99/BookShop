package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;
import vo.ActionForward;

@WebServlet("*.us")
public class UserFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserFrontController123");
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("command : " + command);

		Action action = null;
		ActionForward forward = null;	
		
		if(command.equals("/UserJoinForm.us")) {
			forward = new ActionForward();
			forward.setPath("user/user_join.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/UserJoinPro.us")) {
			action = new UserJoinProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UserLoginPro.us")) {
			action = new UserLoginProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UserLogoutPro.us")) {
			action = new UserLogoutProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CheckDuplicateId.us")) {
			action = new UserCheckDuplicateIdAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UserCheckIdForm.us")) {
			forward = new ActionForward();
			forward.setPath("user/user_check_id.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/UserLogin.us")) {
			forward = new ActionForward();
			forward.setPath("user/user_login.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/UserList.us")) {
			forward = new ActionForward();
			forward.setPath("user/user_list.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MyPage.us")) {
			forward = new ActionForward();
			forward.setPath("board/my_page.jsp");
			forward.setRedirect(false);
		} 
//		else if(command.equals("/UserProductList.us")){
//			try {
//				action = new UserProductListProAction();
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} 
//		else if(command.equals("/UserProductDetail.us")) {
//			action = new userProductDetailAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} 
		else if(command.equals("/Popup.us")) {
			//팝업창 페이지 popup.jsp
			forward = new ActionForward();
			forward.setPath("/main/popup.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MakeCookie.us")) {
			//팝업창 쿠키를 만드는 makeCookie.jsp
			forward = new ActionForward();
			forward.setPath("/main/makeCookie.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/Cat.us")) {
			//팝업창 사진출력
			forward = new ActionForward();
			forward.setPath("/main/cat.jpg");
			forward.setRedirect(false);
		} 
//		else if(command.equals("/Search.us")) {
//			action = new UserSearchProductAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} 
		else if(command.equals("/UserTerms.us")) {
            forward = new ActionForward();
            forward.setPath("user/user_terms.jsp");
            forward.setRedirect(false);
		} else if(command.equals("/CustomerSupporter.us")) {
			try {
				forward = new UsercustomerSupporterAction().execute(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		// --------------------------------------------------------------------------------------
		// ActionForward 객체에 저장된 포워딩 정보에 따른 포워딩 작업 수행하기 위한 공통코드 작성
		if(forward != null) { // ActionForward 객체가 null 이 아닐 경우에만 포워딩 작업 수행
			// Redirect 방식 vs Dispatcher 방식 판별하여 각 방식에 대한 포워딩 작업 수행
			if(forward.isRedirect()) { // Redirect 방식
				response.sendRedirect(forward.getPath());
			} else { // Dispatcher 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}







