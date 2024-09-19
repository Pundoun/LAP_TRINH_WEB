package helloworld.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.tags.shaded.org.apache.bcel.classfile.Constant;

import helloworld.models.UserModel;
import helloworld.services.UserService;
import helloworld.services.implement.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/login", "/dang-nhap" }) // more than 1 url for page

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// Lấy toàn bộ hàm trong service
	UserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// String username = req.getParameter("username"); String password =
		// req.getParameter("password");

		// PrintWriter out = resp.getWriter();
		// out.print("hello");
		RequestDispatcher rd = req.getRequestDispatcher("/views/login.html");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
//		String a;
//		String b;
//		a = req.getParameter("fname");
//		b = req.getParameter("lname");
//		PrintWriter out = resp.getWriter();
//		out.print(a + b);

		// Lấy tham số từ view
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		String remember = req.getParameter("remember");
		// kiểm tra tham số
		boolean isRememberMe = false;
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.html").forward(req, resp);
			return;
		}
		// Xử lý bài toán
		UserModel user = service.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.html").forward(req, resp);
		}

	}

	private void saveRemeberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		resp.addCookie(cookie);

	}

}
