package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;



@WebServlet("/questionAddServlet")
public class QuestionAddServlet extends HttpServlet {

	ICourseService cs = new CourseService();
	IQuestionService qs = new QuestionService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List courseList = cs.findAllCourses("");
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("teacher/quesadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int courseId = Integer.valueOf(req.getParameter("courseId"));
		int queType = Integer.valueOf(req.getParameter("queType"));
		String queTitle = req.getParameter("queTitle");
		String choiceA = req.getParameter("choiceA");
		String choiceB = req.getParameter("choiceB");
		String choiceC = req.getParameter("choiceC");
		String choiceD = req.getParameter("choiceD");
		String ans = req.getParameter("ans");
		int queExist = 1;
		Question q = new Question(courseId, queType, queTitle, choiceA, choiceB, choiceC,
				choiceD, ans, queExist);
		qs.addQuestion(q);
		resp.sendRedirect(req.getContextPath() + "/questionQueryServlet");
	}
	
}
