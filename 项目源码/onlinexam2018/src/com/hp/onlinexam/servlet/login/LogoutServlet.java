package com.hp.onlinexam.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 令当前的Session失效
		 */
		req.getSession().invalidate();
		/*
		 * 当前页面是在teacher文件夹下，而login.jsp是和teacher在一个文件夹
		 */
		resp.sendRedirect("./login.jsp");
	}

	
}
