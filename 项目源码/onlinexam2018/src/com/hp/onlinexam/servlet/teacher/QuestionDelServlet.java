package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.IQuestionService;

@WebServlet("/questionDelServlet")
public class QuestionDelServlet extends HttpServlet {

	IQuestionService qs = new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		qs.deleteQuestion(Integer.valueOf(id));
		resp.sendRedirect(req.getContextPath() + "/questionQueryServlet");
	}

}
