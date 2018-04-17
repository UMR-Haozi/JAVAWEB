package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;

@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet {
	
	private IStuClassService scs = new StuClassService();
	/*
	 * 用来获取当前对象，把当前对象送到要跳转的页面
	 * 页面跳转
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		Map<String,Object> stuMap = scs.findStuClassById(Integer.valueOf(id));
		req.setAttribute("stuClass", stuMap);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/stuclassmodify.jsp").forward(req, resp);
	}
	/*
	 * 在页面上修改当前的值
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("stuClassId");
		String stuName = req.getParameter("stuname");
		String deptName = req.getParameter("depInfo");
		
		StuClass sc = new StuClass(Integer.valueOf(id),stuName,deptName);
		IStuClassService scs = new StuClassService();
		scs.updateStuClass(sc);
		resp.sendRedirect(req.getContextPath() + "/stuClassQueryServlet");
	}
	
}
