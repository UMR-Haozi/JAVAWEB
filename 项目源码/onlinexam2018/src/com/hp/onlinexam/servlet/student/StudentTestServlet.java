package com.hp.onlinexam.servlet.student;

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

import com.hp.onlinexam.dao.teacher.IPaperDao;
import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.PaperService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;
import com.hp.onlinexam.util.ToolUtil;

@WebServlet("/studentTestServlet")
public class StudentTestServlet extends HttpServlet {

	private ITestService ts = new TestService();
	private IQuestionService qs = new QuestionService();
	private IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student s = (Student) req.getSession().getAttribute("user");
		int testid = Integer.valueOf(req.getParameter("testId"));
		Map<String,Object> test = ts.findStudentTestsById(s.getId(), testid);
		req.setAttribute("test", test);
		String ids = test.get("questions").toString();
		List queList = qs.findQuestionByIds(ids);
		req.setAttribute("quesList", queList);
		double scores = Double.valueOf(test.get("scores").toString())/queList.size();
		req.setAttribute("scoreperques", scores);
		
		req.getSession().setAttribute("test", test);
		req.getSession().setAttribute("quesList", queList);
		req.getRequestDispatcher("student/exam.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String time = req.getParameter("hidden1");
		List quesList = (List) req.getSession().getAttribute("quesList");
		Map test = (Map) req.getSession().getAttribute("test");
		/**
		 * 从session中能够获取试题集合
		 * 试题集合中有试题的id号和答案
		 * 页面上展示了试题信息，能够提供每道题的答案
		 * 页面上的试题和我们保存到session中的试题是一样的
		 * 通过迭代session中的试题，我们能够获得具体的每一道试题
		 * 通过当前试题的id号能够获取页面上这道题的答案。
		 * 通过页面上针对选项的标识--ques_+试题id号能够获得本道题的答案
		 * 试题答案和正确答案做对比，如果不一致，则记录试题的id号和错误答案
		 * 然后需要对wrongQueId和wrongAns 两个stringbuffer做处理
		 * 如果试卷全对，则这两个都是“”，否则会多一个逗号
		 * 需要把多余的逗号去掉
		 * 另外还需要记录错误题目的数量，用来计算分值
		 * 分值的计算方式为：试卷总分/试题数量*正确的题目数量
		 * 把以上信息封装成paper对象，持久化到数据库
		 */
		if(quesList == null || quesList.size() < 1){
			return ;
		}
		StringBuffer wrongQueId = new StringBuffer();
		StringBuffer wrongAns = new StringBuffer();
		//目的是遍历试卷中的试题的集合
		int wrongQueNum = 0;
		for (int i = 0 ; i < quesList.size();i++){
			Question q = (Question) quesList.get(i);
			//页面接收的答案
			String ans = req.getParameter("ques_"+q.getId()).toUpperCase();
			//如果和标准答案不匹配，则记录错误的题号和错误答案
			if (!q.getAns().equals(ans)){
				if(wrongQueNum > 0){
					wrongQueId.append(",");
					wrongAns.append(",");
				}
				wrongQueId.append(q.getId());
				wrongAns.append(ans);
				wrongQueNum++;
			}
		}
//		System.out.println(wrongQueId.toString());
//		System.out.println(wrongAns.toString());
//		System.out.println(test.get("id"));
		
		Paper p = new Paper();
		p.setTestId(Integer.valueOf(test.get("id").toString()));
		p.setCourseId(Integer.valueOf(test.get("courseId").toString()));
		p.setTime(time);
		//获得试题的总分和错误试题的数量
		if (quesList.size()>wrongQueNum)
			p.setScore(1.0*Integer.parseInt((String) (test.get("scores")))/quesList.size()*(quesList.size()-wrongQueNum));
		else
			p.setScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空
		 * 如果有错题，那么多带了一个逗号
		 */
		String wrongQueIdString = wrongQueId.toString();
		String wrongAnsString = wrongAns.toString();
		p.setWrongQueId(wrongQueIdString);
		p.setWrongAns(wrongAnsString);
		Student s = (Student) req.getSession().getAttribute("user");
		p.setStudentId(s.getId());
		
		String createDate = ToolUtil.getCurrentTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		try {
			date = sdf.parse(createDate);
		} catch (ParseException e) {
			date = new Date();
			e.printStackTrace();
		}
		p.setCreateDate(date);
		ps.save(p);
		/**
		 * 开始考试的时候，在页面的超链接上，使用了target="_parent"
		 * 跳出了frame框架，因此，重定向的时候需要再定向到frame里
		 */
		resp.sendRedirect(req.getContextPath()+"/student/index.jsp");
		
	}
	
}
