package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.util.ToolUtil;

@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet {

	private ICourseService cs = new CourseService();
	private IStuClassService scs = new StuClassService();
	private IQuestionService qs = new QuestionService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Teacher tself = (Teacher) session.getAttribute("user");
		List<Course> courseList = cs.findCoursesByTeacherId(tself.getId());
		req.setAttribute("courseList", courseList);
		List<StuClass> classesList = scs.findStuClassesByTeacherId(tself.getId());
		req.setAttribute("classesList", classesList);
		req.getRequestDispatcher("teacher/testadd.jsp").forward(req, resp);;
	}
	
	/*
	 * 组卷
	 * 1.从页面上获取试卷的基本信息，把基本信息要传递给下一个页面
	 * 2.获取试卷题目相关信息，随机抽题组卷，把试题传递给下一个页面
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 从页面接收数据
		 */
		String name = req.getParameter("testname");
		int courseId = Integer.valueOf(req.getParameter("courseid"));
		String endDate = req.getParameter("enddate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(endDate);
		} catch (ParseException e) {
			date = new Date();
			e.printStackTrace();
		}
		int testTime = Integer.valueOf(req.getParameter("testtime"));
		Teacher tea = (Teacher)req.getSession().getAttribute("user");
		int teacherId = tea.getId();
		/*
		 * 页面如果是复选框，通过getParameterValues获取数组值
		 */
		String[] classCheck = req.getParameterValues("classCheck");
		String scores = req.getParameter("sinscores");
		int num = Integer.valueOf(req.getParameter("sinnum"));
		/*
		 * 目的：为了封装成Test对象，然后插入到数据库
		 * 1.日期格式需要转换，String类型需要转换成Date类型
		 * 2.班级的id号需要格式转换，String类型的数组需要转换成String类型
		 * 3.根据试卷基本信息提供的试题数量随机出题（集合），并拿到题号组成的数组
		 */
		String classIds = ToolUtil.arraytoString(classCheck);
		List<Map<String,Object>>queList = qs.collectQuestions(courseId, num);
		String questions = qs.testQuestionIds(queList);
		String classNames = scs.findClassNamesByIds(classIds);
		Test test = new Test(name,courseId,date,testTime,questions,teacherId,classIds,scores);
		Course c = cs.findCourseById(courseId);
		/*
		 * 把班级名称，试卷对象和试题集合的数据放到页面上
		 */
		req.setAttribute("classNames", classNames);
		req.getSession().setAttribute("test", test);
		req.setAttribute("quesList", queList);
		req.setAttribute("c", c);
		req.getRequestDispatcher("teacher/test.jsp").forward(req, resp);
		
	}
	
	
	
}
