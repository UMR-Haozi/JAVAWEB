package com.hp.onlinexam.vo;

/**
 * 教师课程信息视图类
 * 
 * @author Administrator
 *
 */
public class TeacherCourseView {
	private int id;
	private int teaId;
	private int courseId;
	private int classId;
	private String courseName;
	private String teaName;
	private String stuClassName;

	public TeacherCourseView() {

	}

	public TeacherCourseView(int id,int teaId,int courseId,int classId,String courseName,
			String teaName,String stuClassName) {
		this.id = id;
		this.courseId = courseId;
		this.teaId = teaId;
		this.classId = classId;
		this.courseName = courseName;
		this.teaName = teaName;
		this.stuClassName = stuClassName;
	}
	
	public TeacherCourseView(int teaId,int courseId,int classId,String courseName,
			String teaName,String stuClassName) {
		this.courseId = courseId;
		this.teaId = teaId;
		this.classId = classId;
		this.courseName = courseName;
		this.teaName = teaName;
		this.stuClassName = stuClassName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeaId() {
		return teaId;
	}

	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getStuClassName() {
		return stuClassName;
	}

	public void setStuClassName(String stuClassName) {
		this.stuClassName = stuClassName;
	}
	

}
