package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;

/*
 * 增加班级的交互
 * 
 */
@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//通过req.setAttribute把请求的信息送到页面上
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/stuclassadd.jsp").forward(req, resp);
	}

	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 获取请求参数
		 */
		String stuName = req.getParameter("stuname");
		String depInfo = req.getParameter("depInfo");
		/*
		 * 把请求参数封装成对象
		 * 封装的目的是为了调用业务层的方法
		 */
		StuClass sc = new StuClass(stuName,depInfo);
		StuClassService stu = new StuClassService();
		stu.addstuClass(sc);
		/*
		 * getRequestDispatcher可以跳转请求
		 */
		resp.sendRedirect(req.getContextPath() + "/stuClassQueryServlet");
	}

	
	

}
