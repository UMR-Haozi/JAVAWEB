<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<title>无标题文档</title>
<style>
body {
	background-size:100%;
	background-attachment: fixed;
	background-repeat: no-repeat;
	margin: 0;
	background-image: url(./img/teacherbg1.jpg);
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
	<h3>班级成绩汇总</h3>
	<br />
	<table class="table table-hover">
		<tr align="center">
			<td><b>班级</b></td>
			<td><b>考试科目</b></td>
			<td><b>考试名称</b></td>
			<td><b>考试截止时间</b></td>
			<td><b>方向</b></td>
			<td><b>班级平均分</b></td>
		</tr>
		<c:forEach var="paper" items="${paperList }">
			<tr align="center">
				<td>${paper.className }</td>
				<td>${paper.courseName }</td>
				<td>${paper.testName }</td>
				<td><fmt:formatDate value="${paper.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${paper.deptName }</td>
				<td>${paper.avgScore }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>