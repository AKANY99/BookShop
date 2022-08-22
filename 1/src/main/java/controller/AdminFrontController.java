package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AdminGetQnaListAction;
import action.AdminPageAction;
import action.AdminProductDetailAction;
import action.AdminProductListAction;
import action.AdminProductWriteProAction;
import action.AdminQnaRepAction;
import action.AdminQnaRepModifyAction;
import action.AdminUserDeleteAction;
import action.AdminUserDetailAction;
import action.AdminUserGetListAction;
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
		} else if(command.equals("/QnaGetList.ad")) {
			try {
			forward = new AdminGetQnaListAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("/QnaGetList.ad 오류!");
			}
		} else if(command.equals("/Qnarep.ad")) {
			try {
				forward = new AdminQnaRepAction().execute(request,response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("/Qnarep.ad 오류!");
			}
		} else if(command.equals("/QnaRepModify.ad")) {
			try {
				forward = new AdminQnaRepModifyAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("/QnaRepModify.ad 오류!");
			}
		} else if(command.equals("/UserManagement.ad")) {
				forward = new ActionForward();
				forward.setPath("user/admin_user_list.jsp");
				forward.setRedirect(false);
		} else if(command.equals("/UserGetList.ad")) {
			try {
				forward = new AdminUserGetListAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("/UserGetList.ad 오류!");
			}
		} else if(command.equals("/UserDetail.ad")) {
			try {
				forward = new AdminUserDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("/UserDetail.ad 오류!");
			}
		} else if(command.equals("/UserDelete.ad")) {
			try {
				forward = new AdminUserDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("/UserDelete.ad 오류!");
			}
		} else if(command.equals("/ProductGetList.ad")) {
			try {
				action = new AdminProductListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("/ProductGetList.ad 오류!");
			}
		} else if(command.equals("/ProductInfo.ad")) {
			try {
				action = new AdminProductDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/ProductWrite.ad")) {
			forward = new ActionForward();
			forward.setPath("product/admin_product_write.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/ProductWritePro.ad")) {
			try {
				action = new AdminProductWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UserDetail.ad")) {
			try {
				forward = new AdminUserDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("/UserDetail.ad 오류!!");
			}
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
