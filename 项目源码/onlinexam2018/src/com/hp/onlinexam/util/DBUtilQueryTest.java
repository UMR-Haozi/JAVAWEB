package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Test;

public class DBUtilQueryTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
//		String sql = "select * from test";
//		List<Map<String, Object>> testList = db.getQueryList(sql);
//		for(int i = 0; i < testList.size(); i++){
//			Map<String,Object> testMap = testList.get(i);
//			Iterator<Entry<String,Object>> it = testMap.entrySet().iterator();
//			while(it.hasNext()){
//				Entry<String,Object> entry = it.next();
//				System.out.println(entry.getKey() + "@@@" + entry.getValue());
//			}
//			System.out.println("");
//		}
//		String sql2 = "select * from test where courseId = ? and teacherId = ?";
//		List<Map<String,Object>> testList2 = db.getQueryList(sql2,new Object[]{1,2});
//		for(int i = 0; i < testList2.size(); ++i){
//			Map<String,Object> testMap2 = testList2.get(i);
//			Iterator<Entry<String,Object>> it = testMap2.entrySet().iterator();
//			while(it.hasNext()){
//				Entry<String,Object> entry = it.next();
//				System.out.println(entry.getKey() + "@@@" + entry.getValue());
//			}
//			System.out.println("");
//		}
		/*
		 * 数组是一类相同数据类型的集合
		 * 声明：仅仅是定义数据类型和变量名
		 * 定义：除了声明外，有赋值
		 * 数组声明时，[]可以放变量前，也可以放变量后
		 */
//		String [] strArray;
//		String strArray2 [];
//		String [] strArray3 = new String[]{"pgthree","liuxiaolu"};
//		String [] strArray4 = {"pgthree","liuxiaolu"};
//		String [] strArray5 = new String[3];
//		
//		List testList = db.getQueryList(Test.class, sql2, new Object[]{1,2});
//		for(Object o : testList){
//			Test t = (Test) o;
//			System.out.println(t.toString());
//		}
		/*
		 * 1.查询姓"张"的学生的学生成绩，查询结果包括学生姓名
		 * 2.查询李四这个老师的排课表
		 * 3.查询所有的试题信息
		 */
		String sql = "select papers.score,student.name from papers,student where "
				+ "student.name like '张%' and student.id = papers.studentId";
		List<Map<String,Object>> testList = db.getQueryList(sql);
		for(int i = 0; i < testList.size(); ++i){
			Map<String,Object> testMap = testList.get(i);
			Iterator<Entry<String,Object>> it = testMap.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,Object> entry = it.next();
				System.out.print(entry.getValue() + ":");
				entry = it.next();
				System.out.println(entry.getValue());
			}
			System.out.println("");
		}
		
		String sql2 = "SELECT course.name as cname,teacher.name from course,teacher,teachercourse "
				+ "where course.id = teachercourse.courseId and "
				+ "teachercourse.teaId = teacher.id and teacher.name = '李四'";
		 testList = db.getQueryList(sql2,new Object[]{});
		for(int i = 0; i < testList.size(); ++i){
			Map<String,Object> testMap = testList.get(i);
			Iterator<Entry<String,Object>> it = testMap.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,Object> entry = it.next();
				System.out.print(entry.getValue() + ":");
				entry = it.next();
				System.out.println(entry.getValue());
			}
			System.out.println("");
		}
		
		String sql3 = "select * from test";
		 testList = db.getQueryList(sql3,new Object[]{});
		for(int i = 0; i < testList.size(); ++i){
			Map<String,Object> testMap = testList.get(i);
			for(Map.Entry<String, Object> entry: testMap.entrySet()){
				System.out.println(entry.getKey() + "@@@" + entry.getValue());
			}
			System.out.println("");
		}
		/*
		 * SELECT s.name,p.scorefrom student s,papers p
		 * where s.id = p.studentId and s.name like '张%'
		 * select后跟要查询的字段，多个字段之间以逗号隔开
		 * from后跟查询的表，多个表时间用逗号隔开
		 * 表可以起别名student s 或者student as s. as可以忽略
		 * 起别名的好处在于多表查询可以表名简写
		 * 字段也可以起别名
		 * where后跟条件，多个条件之间用and号不是&&号
		 * 模糊查询使用like：以张开头，张%
		 */
	}

}
