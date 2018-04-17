package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao{

	private DBUtil db = new DBUtil();
	@Override
	public void addStudent(Student s) {
		
		String sql = "insert into student (name,pwd,school,sex,born,classId) "
				+ "values(?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{s.getName(),s.getPwd(),s.getSchool(),s.getSex(),s.getBorn(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		String sql = "update student set name = ?,pwd = ?, school = ?,"
				+ " sex = ?,born = ?, classId = ? where id = ?";
		try {
			db.execute(sql, new Object[]{s.getName(),s.getPwd(),s.getSchool(),s.getSex(),s.getBorn(),s.getClassId(),s.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Student findStudentById(int id) {
		String sql = "select * from student where id = ?";
		Student student = new Student();
		try {
			student = (Student) db.getObject(Student.class,sql,new Object[]{id});
		} catch (Exception e) {
			student = new Student();
			e.printStackTrace();
		}
		return student;
	}
	
	@Override
	public List<Map<String, Object>> findAll(String search, String attribute) {
		String sql = "select s.id id,s.name sname,school,sc.name scname,sc.deptName deptName,sex,born"
				+ " from student s,stuclass sc where s.classId = sc.id";
		if(!"".equals(search)){
			sql += " and " + attribute + " like '%" + search + "%'";
		}
		List studentList = new ArrayList();
		try {
			studentList = db.getQueryList(sql);
		} catch (Exception e) {
			studentList = new ArrayList();
			e.printStackTrace();
		}
		return studentList;
	}
	
	@Override
	public void deleteStudentById(int id) {
		String sql = "delete from student where id = ?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
