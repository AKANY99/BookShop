package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.AdminDesignService;
import vo.ActionForward;

public class AdminChangeMainAdProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uploadPath = "upload/ad";
		
		int fileSize = 1024 * 1024 * 10;
		ServletContext context = request.getServletContext();
		
		String realPath = context.getRealPath(uploadPath);
		MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		AdminDesignService service = new AdminDesignService();
		String ad_file = multi.getFilesystemName("ad_file");
		int ad_index = Integer.parseInt(multi.getParameter("ad_num"));
		int ad_pd_num = Integer.parseInt(multi.getParameter("ad_pd_num"));
		String ad_subject = multi.getParameter("ad_subject");
		ActionForward forward = new ActionForward();
		
		int count = service.changeAd(ad_file,ad_index,ad_pd_num,ad_subject);
		
		if(count < 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('ad change failed!!')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward.setPath("Design.ad");
			forward.setRedirect(true);
		}
		
		return forward;
		
	}

}
