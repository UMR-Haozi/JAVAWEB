package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;
import com.hp.onlinexam.vo.TeacherCourseView;

@WebServlet("/scheduleModifyServlet")
public class ScheduleModifyServlet extends HttpServlet {

	IStuClassService scs = new StuClassService();
	ITeacherService ts = new TeacherService();
	ICourseService cs = new CourseService();
	/*
	 * 用来获取当前对象，把当前对象送到要跳转的页面
	 * 页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		
		TeacherCourse tc = cs.findTeacherCourseById(Integer.valueOf(id));
		req.setAttribute("tc", tc);
		List stuClassList = scs.findAll("");
		req.setAttribute("stuClassList", stuClassList);
		List teacherList = ts.findTeachers("");
		req.setAttribute("teacherList", teacherList);
		List courseList = cs.findAllCourses("");
		req.setAttribute("courseList", courseList);
		
		req.getRequestDispatcher("manager/schedulemodify.jsp").forward(req, resp);
	}
	/*
	 * 在页面上修改当前的值
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String id = req.getParameter("tcId");
		String courseId = req.getParameter("course");
		String teaId = req.getParameter("teacher");
		String classId = req.getParameter("stuclass");
		TeacherCourse tc = new TeacherCourse(Integer.valueOf(id),Integer.valueOf(courseId),
				Integer.valueOf(teaId),Integer.valueOf(classId));
		cs.updateTeacherCourse(tc);
		resp.sendRedirect(req.getContextPath() + "/scheduleQueryServlet");
	}
}
