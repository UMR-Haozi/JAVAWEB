package com.hp.onlinexam.po;

public class TeacherCourse {
	private int id;
	private int courseId;
	private int teaId;
	private int classId;
	
	public TeacherCourse(){
		
	}
	public TeacherCourse(int id,int courseId,int teaId,int classId){
		this.id = id;
		this.courseId = courseId;
		this.teaId = teaId;
		this.classId = classId;
	}
	public TeacherCourse(int courseId,int teaId,int classId){
		this.courseId = courseId;
		this.teaId = teaId;
		this.classId = classId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
}
