package com.stusys162.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stusys162.pojo.Admininfo;
import com.stusys162.service.AdminService;

@WebServlet(urlPatterns = { "/dologin.do" })
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Admininfo admin = new Admininfo();
		admin.setUsername(username);
		admin.setPassword(password);
		AdminService service = new AdminServiceImpl();
		boolean result = service.login(admin);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if (result) {
			admin = service.getAdminByUsername(username);
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", admin);
			resp.sendRedirect(req.getContextPath() + "/admin/index.jsp");
		} else {
			out.print("<script>alert('登录失败!');history.go(-1);</script>");
		}
	}
}
