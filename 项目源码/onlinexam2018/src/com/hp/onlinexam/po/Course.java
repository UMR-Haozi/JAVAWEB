package com.hp.onlinexam.po;

/*
 * 课程类，描述课程实体
 */
public class Course {
	/*
	 * java的数据类型有哪些？
	 * 基本数据类型和引用数据类型
	 * 基本数据类型：
	 * byte,short,int,long,float,double,boolean,char
	 * 引用数据类型：
	 * 类，接口，数组
	 */
	private int id;
	/*
	 * java里访问权限有几种？
	 * private,public,protected
	 */
	private String name;
	public Course(){
		
	}
	public Course(int id,String name){
		this.id = id;
		this.name = name;
	}
	public Course(String name){
		this.name = name;
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
	
}
