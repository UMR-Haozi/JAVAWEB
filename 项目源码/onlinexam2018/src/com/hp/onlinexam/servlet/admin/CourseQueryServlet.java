package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.CourseService;

@WebServlet("/courseQueryServlet")
public class CourseQueryServlet extends HttpServlet {

	private ICourseService cs = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String courseName = req.getParameter("searchCname");
		if(null == courseName)courseName = "";
		List courseList = cs.findAllCourses(courseName);
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("manager/coursemanage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
