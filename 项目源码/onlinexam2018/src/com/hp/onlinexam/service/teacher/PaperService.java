package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.IPaperDao;
import com.hp.onlinexam.dao.teacher.PaperDao;
import com.hp.onlinexam.po.Paper;

public class PaperService implements IPaperService{

	private IPaperDao pd = new PaperDao();
	@Override
	public int save(Paper paper) {
		// TODO Auto-generated method stub
		return pd.save(paper);
	}

	@Override
	public Map<String,Object> getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return pd.getPaperByStudentId(studentId, testId);
	}

	@Override
	public List getPaperByStudentId(int studentId,String value) {
		return pd.getPaperByStudentId(studentId,value);
	}

	@Override
	public List getPaperCompare(int teaId) {
		return pd.getPaperCompare(teaId);
	}


}
