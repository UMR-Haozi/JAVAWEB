package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.util.ToolUtil;

public class TestDao implements ITestDao{

	DBUtil db = new DBUtil();
	@Override
	public void createTest(Test t) {
		String sql = "insert into test (name,courseId,endDate,testTime,questions,teacherId,"
				+ "classIds,scores) values (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql,new Object[]{t.getName(),t.getCourseId(),t.getEndDate(),
					t.getTestTime(),t.getQuestions(),t.getTeacherId(),t.getClassIds(),
					t.getScores()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		/*
		 * 增加表,stuclass sc,
		 * group_concat(sc.name)可以把查询出的sc.name多条记录字段的值转换成一个字段
		 * find_in_set(sc.id,t.classIds) 第一个是一个字段的值，第二个是一个集合，凡是第一个字段能够在这个集合的，
		 * 记录都可以查出来，可以查字段，查的是sc.name
		 * 要查的是试卷，需要根据试卷分组group by t.id
		 */
		String currentTime = ToolUtil.getCurrentTime();
		String sql = "select t.*,c.name courseName ,group_concat(sc.name) classNames from "
				+ "test t,course c,stuclass sc where t.courseId = c.id and "
				+ "t.endDate > ? and find_in_set(sc.id,t.classIds) "
				+ "and teacherId = ? group by t.id";
		sql += " order by t.endDate";
		List testList = new ArrayList();
		try {
			testList = db.getQueryList(sql,new Object[]{currentTime,teaId});
		} catch (Exception e) {
			testList = new ArrayList();
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		String sql = "select t.id,t.name,questions,c.name courseName,group_concat(sc.name ) "
				+ "classNames,endDate,testTime,scores from test t,course c,stuclass sc "
				+ "where t.courseId = c.id and find_in_set(sc.id ,t.classIds) and t.id = ?"
				+ " and t.teacherId = ?";
		Map<String,Object> testInfoMap = new HashMap();
		try {
			testInfoMap = db.getObject(sql, new Object[]{id,teaId});
		} catch (Exception e) {
			testInfoMap = new HashMap();
			e.printStackTrace();
		}
		return testInfoMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		String sql = "select distinct t.id,t.courseId,t.name testName,t.questions,c.name courseName, "
				+ "sc.name className, t.scores from test t,course c,stuclass sc,student s "
				+ "where t.id = ? and s.id = ? and t.courseId = c.id and sc.id = s.classId"
				+ " and find_in_set(s.classId,t.classIds)";
		Map<String, Object> test = new HashMap();
		try {
			test = db.getObject(sql,new Object[]{testid,studentid});
		} catch (Exception e) {
			test = new HashMap();
			e.printStackTrace();
		}
		return test;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int id, String currData) {
		String sql = "select distinct t.id,c.name courseName ,t.name testName,t.endDate "
				+ "from test t,student s,course c where t.courseId = c.id and "
				+ "find_in_set(s.classId,t.classIds) and s.id = ? and t.endDate > ? and "
				+ "t.id not in (select paper.testId from paper "
				+ "where s.id = paper.studentId) order by t.endDate";
		List testList = new ArrayList();
		try {
			testList = db.getQueryList(sql,new Object[]{id,currData});
		} catch (Exception e) {
			testList = new ArrayList();
			e.printStackTrace();
		}
		return testList;
		
	}

}
