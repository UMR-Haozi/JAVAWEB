package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IStudentDao;
import com.hp.onlinexam.dao.admin.StudentDao;
import com.hp.onlinexam.po.Student;

public class StudentService implements IStudentService{

	private IStudentDao sd = new StudentDao();
	@Override
	public void addStudent(Student s) {
		sd.addStudent(s);
		
	}

	@Override
	public void updateStudent(Student s) {
		sd.updateStudent(s);
		
	}

	@Override
	public Student findStudentById(int id) {
		return sd.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll(String search, String attribute) {
		return sd.findAll(search, attribute);
	}
	
	@Override
	public void deleteStudentById(int id) {
		sd.deleteStudentById(id);
	}

	

}
