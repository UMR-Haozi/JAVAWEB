package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;


@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet {

	private ITeacherService ts = new TeacherService();
	/*
	 * 用来获取当前对象，把当前对象送到要跳转的页面
	 * 页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		Map<String,Object> teaMap = ts.findTeacherInfo(Integer.valueOf(id));
		req.setAttribute("teacher", teaMap);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teachermodify.jsp").forward(req, resp);
	}
	/*
	 * 在页面上修改当前的值
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("teacherId");
		String teaName = req.getParameter("teaname");
		String deptName = req.getParameter("depInfo");
		String pwd = req.getParameter("teapwd");
		Teacher teacher = new Teacher(Integer.valueOf(id),teaName,pwd,deptName);
		ITeacherService ts = new TeacherService();
		ts.updateTeacher(teacher);
		resp.sendRedirect(req.getContextPath() + "/teacherQueryServlet");
	}
}
