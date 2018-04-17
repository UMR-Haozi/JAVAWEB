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
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
-->
body {
	background-size: 100%;
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
	margin: 0 auto;
	margin-top: 40px;
}
</style>
</head>
<body>
	<div class="container">
		<h2>
			班级管理 &nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-primary btn-lg active"
				href="<%=path%>/stuClassAddServlet">增加班级</a>
		</h2>
		<form id="form1" class="form-inline" method="get" action="stuClassQueryServlet">
				<div class="form-group">
					<label>班级名称：</label> 
					<input type="text" class="form-control"
						placeholder="输入关键字" name="value" id="value"> <input
						type="submit" class="btn btn-warning" value="搜索" />
				</div>
		</form>
		<br />
		<table class="table table-hover">
			<tr align="center">
				<td width="162">班级名称</td>
				<td width="90">所属方向</td>
				<td width="94">修改操作</td>
				<td width="116">删除操作</td>
			</tr>
			<!-- 页面元素的遍历可以使用jstl
1.导入jar包--jstl.jar,standard.jar
2.在页面导入一行代码
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
 -->
			<c:forEach var="sc" items="${scList}">
				<tr align="center">
					<td>${sc.name}</td>
					<td>${sc.deptName}</td>
					<td><a class="btn btn-info" href="<%=path%>/stuClassModifyServlet?id=${sc.id}">修改</a></td>
					<td><a class="btn btn-danger" href="<%=path%>/stuClassDelServlet?id=${sc.id}"
						onclick="javascript: return confirm('确认删除课程吗?');">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>