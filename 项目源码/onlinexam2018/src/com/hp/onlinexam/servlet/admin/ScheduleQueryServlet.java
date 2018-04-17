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
@WebServlet("/scheduleQueryServlet")
public class ScheduleQueryServlet extends HttpServlet {
	private ICourseService cs = new CourseService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		List tcList = cs.findAllTeacherCourse(key,value);
		req.setAttribute("tcList", tcList);
		req.getRequestDispatcher("manager/schedulemanage.jsp").forward(req, resp);
	}
}
