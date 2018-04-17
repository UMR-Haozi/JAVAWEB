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
		<form action="scheduleModifyServlet" method="post">
			<input type = "hidden" name = "tcId" value = "${tc.id}"></input>
			<h4>课程名称不允许修改,只能修改课程和老师班级之间的关联</h4>
			<div class = "form-group">
				<label>讲师姓名</label>
				<select name="teacher" class = "form-control">
					<c:forEach var="tea" items="${teacherList}">
						<c:choose>
							<c:when test="${tea.id==tc.teaId}">
								<option value="${tea.id}" selected="selected">${tea.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${tea.id}">${tea.name}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class = "form-group">
				<label>负责班级</label>
				<select name="stuclass" class = "form-control">
					<c:forEach var="sc" items="${stuClassList}">
						<c:choose>
							<c:when test="${sc.id==tc.classId}">
								<option value="${sc.id}" selected="selected">${sc.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${sc.id}">${sc.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
			</div>
			<div class = "form-group">
				<label>课程名称</label>
				<select name="course" class = "form-control">
						<c:forEach var="course" items="${courseList}">
							<c:choose>
								<c:when test="${course.id==tc.courseId}">
									<option value="${course.id}" selected="selected">${course.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${course.id}">${course.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</div>
				<input type="submit" name="submit" value="修改课程关联"
						class="btn btn-info" >
		</form>
	</div>
	</div>
</body>
</html>