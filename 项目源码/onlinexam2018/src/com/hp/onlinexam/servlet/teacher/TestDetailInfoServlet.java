package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/testDetailInfoServlet")
public class TestDetailInfoServlet extends HttpServlet {

	private ITestService ts = new TestService();
	private IQuestionService qs = new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		Teacher teacher = (Teacher) req.getSession().getAttribute("user");
		Map<String, Object> test = ts.findTestById(id,teacher.getId());
		if(test.get("id") == null){
			JOptionPane.showMessageDialog(null, "您没有权限！请您重新登录！");
			resp.sendRedirect("login.jsp");
		}
		else {
			req.setAttribute("test", test);
			List<Question> quesList = qs.findQuestionByIds(test.get("questions").toString());
			req.setAttribute("quesList", quesList);
			req.getRequestDispatcher("teacher/viewtest.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/testQueryServlet");
	}
	
	
}
