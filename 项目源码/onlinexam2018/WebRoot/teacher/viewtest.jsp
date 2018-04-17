<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.hp.onlinexam.po.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 查看试卷时候使用 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
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
	<div>
		<form id="form1" name="form1" method="post"
			action="<%=path%>/testDetailInfoServlet">
			<h3>
				<center>
					试卷名称：${test.name}<br/>
				</center>
			</h3>
			<h5>
				<center>
					考试科目：${test.courseName}<br/>
				</center>
			</h5>
			<h5>
				<center>
					考试班级：${test.classNames}<br/> 
				</center>
			</h5>
			<h5>
				<center>
					考试截止时间：${test.endDate}<br/>
				</center>
			</h5>
			<h5>
				<center>
					考试时长：${test.testTime} min<br/>
				</center>
			</h5>
			<h5>
				<center>
					考试分值：${test.scores}分
				</center>
			</h5>
			
			<p>
				<b>单项选择题</b>
			</p>
			<c:forEach var="que" items="${quesList}" varStatus="status">

				<p></p>
				<p class="text">${status.index + 1} .${que.queTitle}</p>
				<p></p>

				<p>A.${que.choiceA }</p>
				<p>B.${que.choiceB }</p>
				<p>C.${que.choiceC }</p>
				<p>D.${que.choiceD }</p>
				<p>
					<font color="blue"> 正确答案：${que.ans }</font>
				</p>
			</c:forEach>

			<p class="text"></p>
			<p>&nbsp;</p>
				<center>
					<input type="submit" name="button" id="button" class="btn btn-info btn-lg"
						value="返回" />
				</center>
		</form>
		<br /><br /><br /><br />
	</div>
</div>
</body>
</html>