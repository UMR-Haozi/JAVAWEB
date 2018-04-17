<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>以往试卷成绩查询</title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background-size:100%;
	background-attachment: fixed;
	background-repeat: no-repeat;
	margin: 0;
	background-image: url(./img/studentbg2.png);
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
	<h2>${user.name }，以往试卷成绩查询</h2>
			<form class="form-inline" action="<%=path%>/pastTestServlet" method = "post">
			<div class="form-group">
				<label>课程名称 :	</label>
				<input type="text" class = "form-control" name= "value" placeholder="输入关键字"> 
				<input type="submit" class="btn btn-warning" value="搜索">
			</div>
			</form>
	<br />
	<table class="table table-hover">
		<tr align="center">
			<td width="138" >考试科目</td>
			<td width="162">试卷名称</td>
			<td width="162">考试时长</td>
			<td width="162">考试时间</td>
			<td width="162">考试得分</td>
			<td width="162">查看错题</td>
		</tr>
		<c:forEach var="paper" items="${paperList}">
			<tr align="center">
				<td>${paper.courseName}</td>
				<td>${paper.testName}</td>
				<td>${paper.time}</td>
				<td>${paper.createDate}</td>
				<td>${paper.score}</td>
				<td><a class="btn btn-danger" href='<%=path%>/paperDetailInfoServlet?id=${paper.id}'>查看错题</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>