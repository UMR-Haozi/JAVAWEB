package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.util.DBUtil;

public class StuClassDao implements IStuClassDao{
	
	private DBUtil db = new DBUtil();
	@Override
	public List findAllStuClassInfo(String value) {
		String sql = "select * from stuclass";
		if(value != null && !"".equals(value))sql += " where name like" + "'%"+ value + "%'";
		List stuClassList = new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[]{});
		} catch (Exception e) {
			stuClassList = new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		String sql = "select * from stuclass where id = ?";
		Map<String,Object> stuMap = new HashMap<String,Object>();
		try {
			stuMap = db.getObject(sql, new Object[]{classId});
		} catch (Exception e) {
			stuMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return stuMap;
	}

	@Override
	public void addStuClass(StuClass sc) {
		String sql = "insert into stuclass (name,deptName) values(?,?)";
		try {
			db.execute(sql, new Object[]{sc.getName(),sc.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		String sql = "update stuclass set name = ?,deptName = ? where id = ?";
		try {
			db.execute(sql, new Object[]{sc.getName(),sc.getDeptName(),sc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String findClassNamesByIds(String ids) {
		String sql = "select name from stuclass where id in(" + ids + ")";
		List<Map<String, Object>> nameList = new ArrayList();
		try {
			nameList = db.getQueryList(sql);
		} catch (Exception e) {
			nameList = new ArrayList();
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < nameList.size(); i ++) {
			sb.append(nameList.get(i).get("name") + " ");
		}
		return sb.toString();
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		String sql = "select * from stuclass where id in (select classId from teachercourse"
				+ " where teaId = ?)";
		List stuClassList = new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[]{teaId});
		} catch (Exception e) {
			stuClassList = new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}

//	public static void main(String [] args){
//		/*
//		 * 声明的时候一般会向上转型，向上转型，有父类和子类的关系，
//		 * 有接口和实现类之前的关系
//		 * 优点之一：如果这个接口有多个实现，例如StuClassDao2
//		 * 使用向上转型，直接改定义这一行即可
//		 */
//		IStuClassDao scd = new StuClassDao();
//		List  scList = scd.findAllStuClassInfo();
//	}

	@Override
	public void deleteStuClassById(int id) {
		String sql = "delete from stuclass where id = ?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
