package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IStuClassDao;
import com.hp.onlinexam.dao.admin.StuClassDao;
import com.hp.onlinexam.po.StuClass;

public class StuClassService implements IStuClassService{

	private IStuClassDao scd = new StuClassDao();
	@Override
	public List findAll(String value) {
		return scd.findAllStuClassInfo(value);
	}

	@Override
	public void addstuClass(StuClass sc) {
		scd.addStuClass(sc);
	}

	@Override
	public void updateStuClass(StuClass sc) {
		scd.updateStuClassById(sc);
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		return scd.findStuClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		return scd.findClassNamesByIds(ids);
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		return scd.findStuClassesByTeacherId(teaId);
	}

	@Override
	public void deleteStuClassById(int id) {
		scd.deleteStuClassById(id);
	}
	
}
