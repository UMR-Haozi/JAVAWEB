package com.hp.onlinexam.po;

public class Student {
	private int id;
	private String name;
	private String pwd;
	private String school;
	private String sex;
	private String born;
	private int classId;
	
	public Student(){
		
	}
	public Student(int id,String name,String pwd,String school,String sex,String born,int classId){
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.school = school;
		this.sex = sex;
		this.born = born;
		this.classId = classId;
	}
	public Student(String name,String pwd,String school,String sex,String born,int classId){
		this.name = name;
		this.pwd = pwd;
		this.school = school;
		this.sex = sex;
		this.born = born;
		this.classId = classId;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBorn() {
		return born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
//	public static void main(String[] args){
//		/*
//		 * 构造方法用来创建对象，可以初始化成员变量
//		 * 如果没有提供构造方法，系统提供默认构造方法，无参
//		 * 构造方法可以重载
//		 * 构造方法和普通方法有区别，构造方法名和类名要完全相同
//		 * 如果提供了构造方法，系统就不提供默认无参方法
//		 */
//		Student s = new Student();
//		s.setName("lixiaolu");
//		Student s2 = new Student(0,"jianailiang","123","绿色大学","艺术系","男","1985",1);
//	}
	
}
