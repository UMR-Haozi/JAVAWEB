package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.CourseService;

@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet {

	private ICourseService cs = new CourseService();
	/*
	 * 用来获取当前对象，把当前对象送到要跳转的页面
	 * 页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		Course course = cs.findCourseById(Integer.valueOf(id));
		req.setAttribute("course", course);
		req.getRequestDispatcher("manager/coursemodify.jsp").forward(req, resp);
	}
	/*
	 * 在页面上修改当前的值
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("courseId");
		String courseName = req.getParameter("coursename");
		Course course = new Course(Integer.valueOf(id),courseName);
		ICourseService cs = new CourseService();
		cs.updateCourse(course);
		resp.sendRedirect(req.getContextPath() + "/courseQueryServlet");
	}
}
