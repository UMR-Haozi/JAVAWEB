package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.CourseService;

@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet {

	IStuClassService scs = new StuClassService();
	ITeacherService ts = new TeacherService();
	ICourseService cs = new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List stuClassList = scs.findAll("");
		req.setAttribute("stuClassList", stuClassList);
		List teacherList = ts.findTeachers("");
		req.setAttribute("teacherList", teacherList);
		List courseList = cs.findAllCourses("");
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("manager/scheduleadd.jsp").forward(req, resp);
	}

	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String courseId = req.getParameter("course");
		String teaId = req.getParameter("teacher");
		String classId = req.getParameter("stuclass");
		TeacherCourse tc = new TeacherCourse(Integer.valueOf(courseId),
				Integer.valueOf(teaId),Integer.valueOf(classId));
		cs.addSchedule(tc);
		resp.sendRedirect(req.getContextPath() + "/scheduleQueryServlet");
	}
}
