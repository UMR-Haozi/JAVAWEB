package com.hp.onlinexam.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.login.ILoginService;
import com.hp.onlinexam.service.login.LoginService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private ILoginService ls = new LoginService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("username");
		String pwd = req.getParameter("password");
		String role = req.getParameter("role");
		if ("admin".equals(role)) {
			if ("admin".equals(userName) && "123".equals(pwd)) {
				req.getSession().setAttribute("user", userName);
				req.getRequestDispatcher("/manager/mindex.jsp").forward(req,
						resp);
			} else {
				JOptionPane.showMessageDialog(null, "账户名或密码错误，请重新登录！");
				resp.sendRedirect("login.jsp");
			}
		} else if ("teacher".equals(role)) {
			Teacher t = new Teacher();
			t.setName(userName);
			t.setPwd(pwd);
			t = ls.canLogin(t);
			if (null != t) {
				HttpSession session = req.getSession();
				session.setAttribute("user", t);
				session.setAttribute("userName", t.getName());
				req.getRequestDispatcher("/teacher/tindex.jsp").forward(req,
						resp);
			} else {
				JOptionPane.showMessageDialog(null, "账户名或密码错误，请重新登录！");
				resp.sendRedirect("login.jsp");
			}
		} else if ("student".equals(role)) {
			Student s = new Student();
			s.setName(userName);
			s.setPwd(pwd);
			s = ls.canLogin(s);
			if (s != null) {
				HttpSession session = req.getSession();
				session.setAttribute("user", s);
				session.setAttribute("userName", s.getName());
				req.getRequestDispatcher("/student/index.jsp").forward(req,
						resp);
			} else {
				JOptionPane.showMessageDialog(null, "账户名或密码错误，请重新登录！");
				resp.sendRedirect("login.jsp");
			}

		}

	}

}
