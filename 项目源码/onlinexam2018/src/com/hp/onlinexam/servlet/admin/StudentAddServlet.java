package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

@WebServlet("/studentAddServlet")
public class StudentAddServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IStuClassService scs = new StuClassService();
		List stuClassList = scs.findAll("");
		req.setAttribute("stuClassList", stuClassList);
		req.getRequestDispatcher("manager/studentadd.jsp").forward(req, resp);
	}

	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 获取请求参数
		 */
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
		Student s = new Student(sname,pwd,school,sex,born,Integer.valueOf(classId));
		IStudentService ss = new StudentService();
		ss.addStudent(s);
		/*
		 * getRequestDispatcher可以跳转请求
		 */
		resp.sendRedirect(req.getContextPath() + "/studentQueryServlet");
	}
}
