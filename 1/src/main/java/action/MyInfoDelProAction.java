package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import svc.MyInfoDelProService;
import svc.UserInfoService;
import vo.ActionForward;
import vo.UserDTO;

public class MyInfoDelProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sId= request.getParameter("sId");
		System.out.println("action 진입"+sId);
		ActionForward forward = null;
		int isDeleteOk = 0;
		
		MyInfoDelProService service = new MyInfoDelProService();
		isDeleteOk = service.userInfoDel(sId);
		System.out.println("user 받아옴");
		
		if(isDeleteOk==1) {
			System.out.println("삭제 작업 완료 - 메인으로");
			request.getSession().invalidate();
		}else {
			System.out.println("삭제 작업 최종 실패 - 오류찾기");
		}
		
		forward = new ActionForward();
		forward.setPath("./");
		forward.setRedirect(true);
		
		return forward;
	}

}
