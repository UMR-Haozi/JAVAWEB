package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet {

	private IStudentService ss = new StudentService();
	private IStuClassService scs = new StuClassService();
	/*
	 * 用来获取当前对象，把当前对象送到要跳转的页面
	 * 页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		
		Student student = ss.findStudentById(Integer.valueOf(id));
		req.setAttribute("student", student);
		
		List stuClassList = scs.findAll("");
		req.setAttribute("stuClassList", stuClassList);
		
		req.getRequestDispatcher("manager/studentmodify.jsp").forward(req, resp);
	}
	/*
	 * 在页面上修改当前的值
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("studentId");
		String sname = req.getParameter("sname");
		String pwd = req.getParameter("pwd");
		String school = req.getParameter("school");
		String classId = req.getParameter("classId");
		String sex = req.getParameter("sex");
		String born = req.getParameter("born");
		/*
		 * 把请求参数封装成对象
		 * 封装的目的是为了调用业务层的方法
		 */
		Student s = new Student(Integer.valueOf(id),sname,pwd,school,sex,born,Integer.valueOf(classId));
		ss.updateStudent(s);
		
		resp.sendRedirect(req.getContextPath() + "/studentQueryServlet");
	}
}
