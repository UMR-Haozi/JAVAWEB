package com.hp.onlinexam.dao.login;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao{

	private DBUtil db = new DBUtil();
	@Override
	public Teacher canLogin(Teacher t) {
		String sql = "select * from teacher where name = ? and pwd = ?";
		Teacher t2 = new Teacher();
		try {
			t2 = (Teacher)db.getObject(Teacher.class,sql, new Object[]{t.getName(),t.getPwd()});
		} catch (Exception e) {
			t2 = null;
			e.printStackTrace();
		}
		return t2;
	}

	@Override
	public Student canLogin(Student s) {
		String sql = "select * from student where name = ? and pwd = ?";
		Student s2 = new Student();
		try {
			s2 = (Student) db.getObject(Student.class,sql, new Object[]{s.getName(),s.getPwd()});
		} catch (Exception e) {
			s2 = null;
			e.printStackTrace();
		}
		return s2;
	}

}
