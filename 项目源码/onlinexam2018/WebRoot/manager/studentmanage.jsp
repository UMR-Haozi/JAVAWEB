<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background-size:100%;
	background-attachment: fixed;
	background-repeat: no-repeat;
	margin: 0;
	background-image: url(./img/managebg.jpg);
}
.container {
	background: rgba(255, 255, 255, 0.65);
	padding: 16px;
	position: relative;
	height: auto;
	width: 1200px;
	margin:0 auto;
	margin-top: 40px;
}
</style>
</head>
<body>
<div class = "container">
		<h2>
			学生管理 &nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-primary btn-lg active"
				href="<%=path%>/studentAddServlet">增加学生</a>
		</h2>
			<form id="form1" class="form-inline" method="get" action="studentQueryServlet">
				<div class = "form-group">
					<select name="attribute" class = "form-control">
					<option value="s.name" selected="selected">学生姓名</option>
					<option value="school">所属学校</option>
					<option value="sc.name">所在班级</option>
					<option value="sex">性别</option>
					<option value="born">生日</option>
					</select>
					<input type = "text" class = "form-control" name = "search" id = "search">
					<input type = "submit" class = "btn btn-warning" value = "搜索"/>
				</div>
			</form>
	<br/>
<table class="table table-hover">
		<tr align="center">
			<td width="90">学生姓名</td>
			<td width="90">所属学校</td>
			<td width="94">所在班级</td>
			<td width="94">所属方向</td>
			<td width="60">性别</td>
			<td width="116">生日</td>
			<td width="116">修改操作</td>
			<td width="116">删除操作</td>
		</tr><!-- 页面元素的遍历可以使用jstl
1.导入jar包--jstl.jar,standard.jar
2.在页面导入一行代码
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
 -->
 <c:forEach var="s" items="${sList}">
 <tr align="center">
 	<td>${s.sname}</td>
 	<td>${s.school}</td>
 	<td>${s.scname}</td>
 	<td>${s.deptName}</td>
 	<td>${s.sex}</td>
 	<td>${s.born}</td>
 	<td><a class="btn btn-info" href = "<%=path%>/studentModifyServlet?id=${s.id}">修改</a></td>
 	<td><a class="btn btn-danger" href = "<%=path%>/studentDelServlet?id=${s.id}"
 	 onclick="javascript: return confirm('确认删除此学生吗?');">删除</a></td>
 </tr>
 </c:forEach>
</table>
</div>
</body>
</html>