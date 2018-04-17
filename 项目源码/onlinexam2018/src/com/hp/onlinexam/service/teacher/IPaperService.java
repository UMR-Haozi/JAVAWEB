package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Paper;

public interface IPaperService { 
	
	public int save(Paper paper);
	/**
	 * 学生试题
	 * @return
	 */
	public Map<String,Object> getPaperByStudentId(int studentId, int testId);
	
	/**
	 * 学生以往答过的试卷
	 * @return
	 */
	public List getPaperByStudentId(int studentId,String value);
	
	/**
	 * 获得班级评估信息
	 * @return
	 */
	public List getPaperCompare(int teaId);
	
}
