package com.stusys162.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stusys162.pojo.Dept;
import com.stusys162.service.DeptService;
import com.stusys162.service.impl.DeptServiceImpl;

@WebServlet(urlPatterns = { "/admin/doadd.do" })
public class DeptServlet extends HttpServlet {
	private DeptService deptService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String action = req.getParameter("op");
		if ("doadd".equals(action)) {
			doAdd(req, resp);
		} else if ("list".equals(action)) {
			dolist(req, resp);
		}
	}

	protected void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String deptname = req.getParameter("deptname");
		String deptinfo = req.getParameter("deptinfo");
		Dept dept = new Dept(deptname, deptinfo);
		DeptService deptService = new DeptServiceImpl();
		int result = deptService.addDept(dept);
		PrintWriter out = resp.getWriter();
		if (result == 0) {

			out.println("<script>alert('添加失败');history.go(-1);</script>");
		} else if (result == -1) {
			out.println("<script>alert('部门名称重复,请重新添加');history.go(-1);</script>");
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin/dodept.do?op=list");
		}
	}

	public void dolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dept> depts = deptService.getAllDepts();
		request.setAttribute("depts", depts);
		request.getRequestDispatcher("/admin/dept_list.jsp").forward(request, response);
	}
}
