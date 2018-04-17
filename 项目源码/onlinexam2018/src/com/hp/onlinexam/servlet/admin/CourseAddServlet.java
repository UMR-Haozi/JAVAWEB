package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.CourseService;



@WebServlet("/courseAddServlet")
public class CourseAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("manager/courseadd.jsp").forward(req, resp);
	}

	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String courseName = req.getParameter("coursename");
		CourseService cs = new CourseService();
		cs.addCourse(courseName);
		resp.sendRedirect(req.getContextPath() + "/courseQueryServlet");
	}
}
