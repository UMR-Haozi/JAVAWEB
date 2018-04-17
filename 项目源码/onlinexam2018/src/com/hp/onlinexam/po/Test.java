package com.hp.onlinexam.po;

import java.util.Date;



public class Test {
	private int id;
	private String name;
	private int courseId;
	private Date endDate;
	private int testTime;
	private String questions;
	private int teacherId;
	private String classIds;
	private String scores;
	
	public Test(){
		
	}
	public Test(int id,String name,int courseId,Date endDate,int testTime,String questions,
			int teacherId,String classIds,String scores){
		this.id = id;
		this.name = name;
		this.courseId = courseId;
		this.endDate = endDate;
		this.testTime = testTime;
		this.questions = questions;
		this.teacherId = teacherId;
		this.classIds = classIds;
		this.scores = scores;
	}
	public Test(String name,int courseId,Date endDate,int testTime,String questions,
			int teacherId,String classIds,String scores){
		this.name = name;
		this.courseId = courseId;
		this.endDate = endDate;
		this.testTime = testTime;
		this.questions = questions;
		this.teacherId = teacherId;
		this.classIds = classIds;
		this.scores = scores;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTestTime() {
		return testTime;
	}
	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getClassIds() {
		return classIds;
	}
	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}
	public String getScores() {
		return scores;
	}
	public void setScores(String scores) {
		this.scores = scores;
	}
	
	
}
