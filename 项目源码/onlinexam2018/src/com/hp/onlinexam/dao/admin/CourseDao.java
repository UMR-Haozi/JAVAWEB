package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao{

	private DBUtil db = new DBUtil();
	@Override
	public List<TeacherCourseView> findAllTeaCourInfo(String key,String value) {
		String sql = "select tc.id id, tc.teaId, tc.courseId,tc.classId,"
				+ "c.name courseName,t.name teaName,sc.name stuClassName from teachercourse tc, "
				+ "teacher t,course c,stuclass sc where tc.teaId=t.id "
				+ "and tc.courseId = c.id and tc.classId=sc.id";
		if(value != null && !"".equals(value)){
			sql += " and "+ key + " like '%" + value + "%'";
		}
		List tcList = new ArrayList();
		try {
			tcList = db.getQueryList(sql);
		} catch (Exception e) {
			tcList = new ArrayList();
			e.printStackTrace();
		}
		return tcList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		String sql = "select * from teachercourse where id = ?";
		TeacherCourse tc = new TeacherCourse();
		try {
			tc = (TeacherCourse) db.getObject(TeacherCourse.class,sql,new Object[]{id});
		} catch (Exception e) {
			tc = new TeacherCourse();
			e.printStackTrace();
		}
		return tc;
	}

	@Override
	public void addCourse(String name) {
		String sql = "insert into course (name) values(?)";
		try {
			db.execute(sql, new Object[]{name});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCourse(Course course) {
		String sql = "update course set name = ? where id = ?";
		try {
			db.execute(sql, new Object[]{course.getName(),course.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Course findCourseById(int id) {
		String sql = "select * from course where id = ?";
		Course course = new Course();
		try {
			course = (Course) db.getObject(Course.class,sql,new Object[]{id});
		} catch (Exception e) {
			course = new Course();
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		String sql = "insert into teachercourse (courseId,teaId,classId) values(?,?,?)";
		try {
			db.execute(sql, new Object[]{tc.getCourseId(),tc.getTeaId(),tc.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeacherCourseViewById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		String sql = "select * from course";
		if(!"".equals(name))
			sql += " where name like '%" + name + "%'";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(sql);
		} catch (Exception e) {
			/*
			 * 出了异常后，teaList有可能是null或者出了异常后，程序执行有问题
			 */
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		String sql = "update teachercourse set courseId = ?,teaId = ?,classId = ?"
				+ " where id = ?";
		try {
			db.execute(sql, new Object[]{tc.getCourseId(),tc.getTeaId(),tc.getClassId(),
					tc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTourse(int tcId) {
		String sql = "delete from teachercourse where id = ?";
		try {
			db.execute(sql, new Object[]{tcId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		String sql = "select * from course where id in (select courseId from teachercourse"
				+ " where teaId = ?)";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(Course.class, sql, new Object[]{teaId});
		} catch (Exception e) {
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}
	@Override
	public void deleteCourseById(int id) {
		String sql = "delete from course where id = ?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
