package com.hp.onlinexam.service.teacher;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.IQuestionDao;
import com.hp.onlinexam.dao.teacher.QuestionDao;
import com.hp.onlinexam.po.Question;

public class QuestionService implements IQuestionService{

	private IQuestionDao qd = new QuestionDao();
	@Override
	public List<Map<String, Object>> findAll(String key, String value) {
		return qd.findAllQuestionInfo(key, value);
	}

	@Override
	public void addQuestion(Question q) {
		qd.addQuestion(q);
		
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		return qd.findQuestionById(id);
	}

	@Override
	public void updateQuestionInfo(Question q) {
		qd.updateQuestionInfo(q);
		
	}

	@Override
	public void deleteQuestion(int id) {
		qd.deleteQuestion(id);
		
	}

	@Override
	public List<Map<String, Object>> collectQuestions(int courseId, int num) {
		List<Map<String,Object>> queList = qd.findQuestionsByCourseId(courseId);
		//通过shuffle方法做随机
		Collections.shuffle(queList);
		if(num >= queList.size())
			return queList;
		else queList.subList(0, num);
		return queList;
	}

	@Override
	public String testQuestionIds(List<Map<String, Object>> list) {
		if(null == list)return "";
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < list.size(); ++i){
			Map<String,Object> questionMap = list.get(i);
			sb.append(questionMap.get("id"));
			if(i != list.size() - 1)sb.append(",");
		}
		return sb.toString();
	}

	@Override
	public List findQuestionByIds(String ids) {
		return qd.findQuestionByIds(ids);
	}


}
