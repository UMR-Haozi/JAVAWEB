package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.PaperService;
import com.hp.onlinexam.service.teacher.QuestionService;

@WebServlet("/paperDetailInfoServlet")
public class PaperDetailInfoServlet extends HttpServlet {
	IPaperService ps = new PaperService();
	IQuestionService qs = new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		Student s = (Student) req.getSession().getAttribute("user");
		Map<String,Object> paper = ps.getPaperByStudentId(s.getId(),Integer.valueOf(id));
		String ids = paper.get("wrongQueId").toString();
		List quesList = qs.findQuestionByIds(ids);
		String wrongAns = paper.get("wrongAns").toString();
		req.setAttribute("paper", paper);
		req.setAttribute("quesList", quesList);
		req.setAttribute("wrongAns", wrongAns);
		req.getRequestDispatcher("student/viewpaper.jsp").forward(req, resp);
	}
	
}
