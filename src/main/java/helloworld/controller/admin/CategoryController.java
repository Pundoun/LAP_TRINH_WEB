package helloworld.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import helloworld.models.CategoryModel;
import helloworld.services.CategoryService;
import helloworld.services.implement.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig()
@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/delete", "/admin/category/edit", "/admin/category/"})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		} else if (url.contains("/admin/categories")) {
			List<CategoryModel> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		} else if (url.contains("/admin/category/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			cateService.delete(id);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/insert")) {
			// Lấy dữ liệu từ view
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String images = req.getParameter("images");
			// đưa vào Model
			CategoryModel category = new CategoryModel();
			category.setCategoryname(categoryname);
			category.setStatus(status);
			// xử lý upload file
			String fname = "";
			String uploadPath = "E:\\upload";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("images1");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					// đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index + 1);
					fname = System.currentTimeMillis() + "." + ext;
					// upload file
					part.write(uploadPath + "/" + fname);
					// ghi tên file vào data
					category.setImages(fname);
				} else if (images != null) {
					category.setImages(images);
				} else {
					category.setImages("avatar.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

//			category.setImages(images);
			// truyền Model vào insert
			cateService.insert(category);
			// trả về view
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}

}
