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
<title>Insert title here</title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<style>
p {
	text-indent: 2em;
}

textarea {
	　　resize: none;
}

.text2 {
	width: 700px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
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
	<div class="text2">
		<form action="<%=path%>/scheduleAddServlet" method="post">
			<div class = "form-group">
				<label>讲师姓名</label>
				<select name="teacher" class = "form-control">
					<c:forEach var="tea" items="${teacherList}">
						<option value="${tea.id}">${tea.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class = "form-group">
				<label>负责班级</label>
				<select name="stuclass" class = "form-control">
					<c:forEach var="sc" items="${stuClassList}">
						<option value="${sc.id}">${sc.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class = "form-group">
				<label>课程名称</label>
				<select name="course" class = "form-control">
							<c:forEach var="course" items="${courseList}">
								<option value="${course.id}">${course.name}</option>
							</c:forEach>
				</select>
			</div>
			<input type="submit" name="submit" class="btn btn-success"value="提交班级排课信息">
		</form>
	</div>
</div>
</body>
</html>