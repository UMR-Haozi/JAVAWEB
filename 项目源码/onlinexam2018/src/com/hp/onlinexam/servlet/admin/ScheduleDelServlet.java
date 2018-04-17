package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.CourseService;

@WebServlet("/scheduleDelServlet")
public class ScheduleDelServlet extends HttpServlet {

private ICourseService cs = new CourseService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		cs.deleteTeacherCourse(Integer.valueOf(id));
		req.getRequestDispatcher("/scheduleQueryServlet").forward(req, resp);
	}
}
