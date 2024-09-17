package helloworld.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/login", "/dang-nhap" }) // more than 1 url for page

public class Konichiwa extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6381352272309790658L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  // String username = req.getParameter("username"); String password =
		  // req.getParameter("password");
		 
		  //PrintWriter out = resp.getWriter();
		  //out.print("hello");
		RequestDispatcher rd = req.getRequestDispatcher("/views/login.html");
		rd.forward(req, resp);
		 
	}
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a;
		String b;
		a =  req.getParameter("fname");
		b =  req.getParameter("lname");
		PrintWriter out = resp.getWriter();
		out.print(a + b);
		
	}

}
