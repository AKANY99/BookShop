package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AdminPageAction;
import vo.ActionForward;

@WebServlet("*.ad")
public class AdminFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminFrontController");
		request.setCharacterEncoding("UTF-8");
		String command = request.getServletPath();
		System.out.println("command : " + command);
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/AdminPage.ad")) {
			action = new AdminPageAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("/AdminPage.ad 오류!");
				e.printStackTrace();
			}
		} else if(command.equals("/QnaList.ad")) {
			forward = new ActionForward();
			forward.setPath("qna/admin_qna_list.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/ProductList.ad")) {
			forward = new ActionForward();
			forward.setPath("product/admin_product_list.jsp");
			forward.setRedirect(false);
		}
		
		
		// -------------------------------------------------------------------------------------------------------
		
		if(forward != null) {
			if(forward.isRedirect()) { // Redirect 방식
				response.sendRedirect(forward.getPath());
			} else { // Dispatcher 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	// ----------------------------------------------------------------------------------------------------------
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
