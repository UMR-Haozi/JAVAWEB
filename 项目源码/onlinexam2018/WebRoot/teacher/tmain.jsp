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
<script>
	history.go(1);//屏蔽回退
	document.oncontextmenu = function(e) {
		if (e == null)
			e = window.event;
		e.cancelBubble = true;
		e.returnValue = false;
		return true;//右键屏蔽
	};
</script>
</head>

<body>
<div class = "container">
	<h3>近期考试</h3>
	<br />
	<table class="table table-hover">
		<tr align="center">
			<td><b>考试科目</b></td>
			<td><b>考试名称</b></td>
			<td><b>考试截止时间</b></td>
			<td><b>考试时长</b></td>
			<td><b>考试对象</b></td>
			<td><b>考试分值</b></td>
			<td width="81"><b>考试状态</b></td>
		</tr>
		<c:forEach var="test" items="${testsList }">
			<tr align="center">
				<td>${test.courseName }</td>
				<td><a class="btn btn-primary" href = '<%=path%>/testDetailInfoServlet?id=${test.id}'>${test.name }</a></td>
				<td><fmt:formatDate value="${test.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${test.testTime }</td>
				<td>${test.classNames }</td>
				<td>${test.scores }</td>
				<td width="81">正在考试</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>