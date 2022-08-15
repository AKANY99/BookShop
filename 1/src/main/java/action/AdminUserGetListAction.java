package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminGetUserListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.UserDTO;

public class AdminUserGetListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminGetUserListService service = new AdminGetUserListService();
		
//		int startWon = Integer.parseInt(request.getParameter("startWon"));
//		int endWon = Integer.parseInt(request.getParameter("endWon"));
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String gender = request.getParameter("gender");
		String searchType = request.getParameter("searchType");
		String searchObject = '%'+request.getParameter("searchObject")+'%';
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
		
		
		if(startDate == "") {
			startDate = "1999-04-17";
		}
		
		if(endDate == "") {
			endDate = formatedNow.toString();
		}
		
		
		// 조건에 부합한 동적인 userPageNum 받기=========================
		int userPageNum = 1;
		int listLimit = 10;
		int userPageLimit = 10;
		if(request.getParameter("userPageNum") != null) {
			userPageNum = Integer.parseInt(request.getParameter("userPageNum"));
		}
		int listCount = service.getListCount(startDate, endDate, gender, searchType, searchObject);
		int maxuserPage = (int)Math.ceil((double)listCount / listLimit);
		int startuserPage = ((int)((double)userPageNum / userPageLimit + 0.9) - 1) * userPageLimit + 1;
		int enduserPage = startuserPage + userPageLimit - 1;
	   
		if(enduserPage > maxuserPage) {
			enduserPage = maxuserPage;
		}
		// 페이징 작업을위한 value 값 ====================================
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("gender", gender);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchObject", request.getParameter("searchObject"));
		PageInfo userPageInfo = new PageInfo(userPageNum, maxuserPage, startuserPage, enduserPage, listCount);
		request.setAttribute("userPageInfo", userPageInfo);
		// ===========================================================
		ArrayList<UserDTO> list = service.getUserList(startDate, endDate, gender, searchType, searchObject, userPageNum, listLimit);
		
		
		request.setAttribute("userList", list);
		ActionForward forward = new ActionForward();
		forward.setPath("user/admin_user_getlist.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
