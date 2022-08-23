package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.AdminProductUpdateService;
import vo.ActionForward;
import vo.ProductDTO;

public class AdminProductUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String uploadPath = "/upload";
		String realPath = request.getServletContext().getRealPath(uploadPath);
		int fileSize = 1024 * 1024 * 100;
		MultipartRequest multi = new MultipartRequest(
				request,
				realPath,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy()
		);
		
		AdminProductUpdateService service = new AdminProductUpdateService();
		ProductDTO product = new ProductDTO();
		product.setPd_num(Integer.parseInt(multi.getParameter("pd_num")));
		product.setPd_type(multi.getParameter("pd_type"));
		product.setPd_name(multi.getParameter("pd_name"));
		product.setPd_price(Integer.parseInt(multi.getParameter("pd_price")));
		product.setPd_quan(Integer.parseInt(multi.getParameter("pd_quan")));
		product.setPd_file(multi.getFilesystemName("pd_file"));
		product.setPd_subject(multi.getParameter("pd_subject"));
		product.setPd_content(multi.getFilesystemName("pd_content"));
		System.out.println(product);
		int updateCount = service.updateProduct(product);
		
		request.setAttribute("product", product);
		
		if(updateCount == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품수정 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("product/admin_product_detail.jsp");
			forward.setRedirect(false);			
		}
		return forward;
	}

}
