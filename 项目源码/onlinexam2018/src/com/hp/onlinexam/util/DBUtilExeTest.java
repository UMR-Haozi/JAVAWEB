package com.hp.onlinexam.util;
/*
 * 用于execute方法练习
 */
public class DBUtilExeTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBUtil db = new DBUtil();
		/*
		 * insert语句：
		 * insert into + 表名
		 * 如果是插入所有的列，则+valuse（值1，值2……）
		 * 如果插入部分字段，在表名后，（字段1，字段2……）
		 */
		//String sql = "insert into course (name) values ('ssp')";
		//db.execute(sql);
//		String sql2 = "insert into course (name) values (?)";
//		db.execute(sql2, new Object[]{"Rem"});
		
		String sql3 = "delete from course where name = ?";
		db.execute(sql3,new Object[]{"ssm"});
	}

}
