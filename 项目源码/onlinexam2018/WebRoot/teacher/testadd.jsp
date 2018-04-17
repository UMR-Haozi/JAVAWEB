<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/calendar-blue.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
}

.text2 {
	width: 450px;
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
	background-image: url(./img/teacherbg2.png);
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
	<form id="form1" name="form1"  method="post" onsubmit="return InputM();" action='<%=path%>/testAddServlet'>
		<div class = "form-group">
			<label>考试科目为： </label>
			<select name="courseid" id="courseid" class = "form-control">
						<c:forEach var="course" items="${courseList}">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
			</select>
		</div>
		<div class = "form-group">
			<label>试卷名称为：</label>
			<input type="text" name="testname" class = "form-control" id="testname" onblur="isNotNull('testname');"/>
		</div>
		<div class = "form-group">
			<label>考试截止时间为： </label>
			<input name="enddate" type="text" class = "form-control" id="control_date" size="20" maxlength="10" readonly="readonly" value='' />
		</div>
		<div class = "form-group">
			<label>单项选择题</label>
		</div>
		<div class = "form-group">
			<label>总分</label>
			<input name="sinscores" class = "form-control" id="sinscores" type="text" size="1"
					onblur="isNotNull('sinscores');" />
		</div>
		<div class = "form-group">
			<label>题数</label>
			<input name="sinnum" class = "form-control" type="text" id="sinnum" size="5"
					onblur="isNotNull('sinnum');" />
		</div>
			 
		<div>
			<label>考试时间(分钟)：</label>
			<input name="testtime" class = "form-control" id="testtime" value="45"
					type="text" size="5" onblur="isNotNull('testtime')" />
		</div>
		<div class = "form-group">
			<label>面向班级:</label>
			<c:forEach var="stuclass" items="${classesList}">
				<label class="checkbox-inline">
					<input type="checkbox" name="classCheck" class = "" value="${stuclass.id}" checked="checked"/>${stuclass.name}
				</label>
			</c:forEach>
		</div>
		<div>
			<input type="submit" class="btn btn-info btn-lg" value="自动出题" />
		</div>
	</form>
	<p>
<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
<script>
Calendar.setup({
inputField : "control_date",
ifFormat : "%Y-%m-%d %H:%M:%S",
showsTime : true,
timeFormat : "24"
});
</script>
	</p>
</div>
</body>${hint }
</html>