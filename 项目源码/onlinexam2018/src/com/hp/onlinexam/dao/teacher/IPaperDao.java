package com.hp.onlinexam.dao.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Paper;

public interface IPaperDao {
	
	public int save(Paper  paper);
	
	public Map<String,Object> getPaperByStudentId(int studentId,int testId);
	
	public List getPaperByStudentId(int studentId,String value);
	
	//所有的班级平级成绩。
	public List getPaperCompare(int teaId);
}
