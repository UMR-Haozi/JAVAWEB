<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'stuclassadd.jsp' starting page</title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
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

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<div class = "container">
	<div class="text2">
		<form action="studentModifyServlet" method="post">
			<!-- 定义一个新的标签来存id -->
			<input type = "hidden" name = "studentId" value = "${student.id}"></input>
			<div class = "form-group">
				<label>学生姓名</label>
				<input type="text" class = "form-control" name="sname" id="sname" value = "${student.name}">
			</div>
			<div class = "form-group">
				<label>密码</label>
				<input type="text" class = "form-control" name="pwd" id="pwd" value = "${student.pwd}">
			</div>
			<div class = "form-group">
				<label>所属学校</label>
				<input type="text" class = "form-control" name="school" id="school" value = "${student.school}">
			</div>
			<div class = "form-group">
				<label>所在班级</label>
				<select name="classId" class = "form-control">
							<c:forEach var="sc" items="${stuClassList}">
								<!-- 要把迭代出来的值跟查询的值对应 -->
								<c:choose>
									<c:when test = "${sc.id==student.classId}">
										<option value = "${sc.id}" selected = "selected">${sc.name}</option>
									</c:when>
									<c:otherwise>
										<option value= ${sc.id} >${sc.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
				</select>
			</div>
			<div class = "form-group">
				<label>性别：</label>
				<label class="radio-inline">
				<input type="radio" name="sex" value = "男"<c:if test="${student.sex =='男' }">checked="checked"</c:if>/> 男
    			</label>
    			<label class="radio-inline">
    			<input type="radio" name="sex" value = "女"<c:if test="${student.sex =='女' }">checked="checked"</c:if>/> 女
				</label>
			</div>
			<div class = "form-group">
				<label>出生日期</label>
				<input type="text" class = "form-control" name="born" id="born" value = "${student.born}">
			</div>
			<input type="submit" name="submit" value="修改学生信息" class="btn btn-info" >
		</form>
	</div>
	</div>
</body>
</html>
