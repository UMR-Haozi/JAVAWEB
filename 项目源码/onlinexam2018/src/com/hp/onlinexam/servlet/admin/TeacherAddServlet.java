package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//通过req.setAttribute把请求的信息送到页面上
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teacheradd.jsp").forward(req, resp);
	}

	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 获取请求参数
		 */
		String teaName = req.getParameter("teaname");
		String teaPwd = req.getParameter("teapwd");
		String depInfo = req.getParameter("depInfo");
		/*
		 * 把请求参数封装成对象
		 * 封装的目的是为了调用业务层的方法
		 */
		Teacher tea = new Teacher(teaName,teaPwd,depInfo);
		TeacherService ts = new TeacherService();
		ts.addTeacher(tea);
		/*
		 * getRequestDispatcher可以跳转请求路径
		 * /stuClassQueryServlet
		 * 带着request和response跳转,有时候不需要继续保留者两个包含的信息
		 * 就用resp.sendRedirect
		 */
		resp.sendRedirect(req.getContextPath() + "/teacherQueryServlet");
	}
}
