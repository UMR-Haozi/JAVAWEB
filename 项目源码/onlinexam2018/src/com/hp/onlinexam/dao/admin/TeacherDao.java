package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao{

	private DBUtil db = new DBUtil();
	@Override
	public List<Teacher> findAllTeacherByInfo(String name) {
		String sql = "select * from teacher";
		if(!"".equals(name))
			sql += " where name like '%" + name + "%'";
		List teaList = new ArrayList();
		try {
			teaList = db.getQueryList(sql);
		} catch (Exception e) {
			/*
			 * 出了异常后，teaList有可能是null或者出了异常后，程序执行有问题
			 */
			teaList = new ArrayList();
			e.printStackTrace();
		}
		return teaList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		String sql = "insert into teacher (name,pwd,deptName) values(?,?,?)";
		try {
			db.execute(sql, new Object[]{teacher.getName(),teacher.getPwd(),teacher.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		String sql = "update teacher set name = ?,pwd = ?,deptName = ? where id = ?";
		try {
			db.execute(sql, new Object[]{teacher.getName(),teacher.getPwd(),
					teacher.getDeptName(),teacher.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		String sql = "select * from teacher where id = ?";
		Map<String,Object> teaMap = new HashMap<String,Object>();
		try {
			teaMap = db.getObject(sql, new Object[]{id});
		} catch (Exception e) {
			teaMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return teaMap;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void deleteTeacherById(int id) {
		String sql = "delete from teacher where id = ?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
