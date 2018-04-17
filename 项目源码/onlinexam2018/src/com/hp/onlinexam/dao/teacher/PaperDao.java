package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.ToolUtil;

public class PaperDao implements IPaperDao{

	DBUtil db = new DBUtil();
	@Override
	public int save(Paper paper) {
		String sql = "insert into paper (testId,courseId,time,score,wrongQueId,wrongAns,"
				+ "studentId,createDate) values (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[]{paper.getTestId(),paper.getCourseId(),paper.getTime(),
					paper.getScore(),paper.getWrongQueId(),paper.getWrongAns(),
					paper.getStudentId(),paper.getCreateDate()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Map<String,Object> getPaperByStudentId(int studentId, int testId) {
		String sql = "select t.name ,c.name courseName,createDate,wrongQueId,wrongAns,time "
				+ "from paper p,course c ,test t ,student s "
				+ "where s.id = ? and t.id = ? and s.id = p.studentId "
				+ "and c.id = p.courseId and p.testId = t.id";
		Map<String,Object> paper= new HashMap();
		try {
			paper = db.getObject(sql,new Object[]{studentId,testId});
		} catch (Exception e) {
			paper= new HashMap();
			e.printStackTrace();
		}
		return paper;
	}

	@Override
	public List getPaperByStudentId(int studentId,String value) {
		String sql = "select t.id, c.name courseName,t.name testName,time,createDate,score "
				+ "from course c ,test t,paper p where p.testId = t.id and "
				+ "p.courseId = c.id and studentId = ?";
		if(!"".equals(value)){
			sql += " and c.name like '%" + value + "%' ";
		}
		sql += " order by createDate";
		List paper = new ArrayList();
		try {
			paper = db.getQueryList(sql, new Object[]{studentId});
		} catch (Exception e) {
			paper = new ArrayList();
			e.printStackTrace();
		}
		return paper;
	}

	@Override
	public List getPaperCompare(int teaId) {
		String sql = "select sc.name className,sc.deptName,c.name courseName,"
				+ "t.name testName,t.endDate ,avg(p.score) avgScore from "
				+ "stuclass sc,course c,test t,paper p,student s "
				+ "where t.endDate < ? and  t.courseId = c.id and "
				+ "find_in_set(s.classId,t.classIds)and t.teacherId = ? "
				+ "and p.testId = t.id and p.studentId = s.id and "
				+ "s.classId = sc.id group by s.classId,t.id order by endDate";
		String currentTime = ToolUtil.getCurrentTime();
		List paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql, new Object[]{currentTime,teaId});
		} catch (Exception e) {
			paperList = new ArrayList();
			e.printStackTrace();
		}
		return paperList;
	}

}
