package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;
import com.hp.onlinexam.util.ToolUtil;

@WebServlet("/recentTestServlet")
public class RecentTestServlet extends HttpServlet {

	private ITestService ts = new TestService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student s = (Student) req.getSession().getAttribute("user");
		String currentTime = ToolUtil.getCurrentTime();
		List testsList = ts.getTestByStudent(s.getId(),currentTime);
		req.setAttribute("testsList", testsList);
		req.getRequestDispatcher("student/main.jsp").forward(req, resp);
	}
}
