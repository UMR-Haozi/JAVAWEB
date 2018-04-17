<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


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
	function anscheck(eeId) {
		var a = document.getElementById("ans").value;
		var re = /^[A-D]{1,4}$/;
		if (re.test(a)) {
			return true;
		} else {
			var msg = "正确答案只能为大写英文！";
			showErrorMsg(msg, eeId);
			return false;
		}
	}
	function isNotNull(uuid) {
		var value = document.getElementById(uuid).value;
		if (value == null || value == "") {
			return false;
		} else {
			return true;
		}
	}
	function showErrorMsg(msg, eeId) {
		document.getElementById(eeId).style.display = "";
		document.getElementById(eeId).innerHTML = msg;
	}
	//当获得焦点 错误信息就不显示
	function clearErrorMsg(eId) {
		document.getElementById(eId).style.display = "none";
	}

	function verInput() {
		var obj = document.getElementById("type");
		var value = obj.selectedIndex;
		if (value == 2) {
			if (anscheck('ans_hint') && isNotNull('ques')
					&& isNotNull('choice_A') && isNotNull('choice_B')) {
				return true;
			} else {
				alert("添加失败，请将信息填写完整、正确！");
				return false;
			}
		} else {
			if (anscheck('ans_hint') && isNotNull('ques')
					&& isNotNull('choice_A') && isNotNull('choice_B')
					&& isNotNull('choice_C') && isNotNull('choice_D')) {
				return true;
			} else {
				alert("添加失败，请将信息填写完整、正确！");
				return false;
			}
		}
	}
	function selectChoice() {
		var obj = document.getElementById("type");
		var value = obj.selectedIndex;
		if (value == 2) {
			document.getElementById("choice_C").style.display = "none";
			document.getElementById("choice_D").style.display = "none";
		}
		if (value == 0 || value == 1) {
			document.getElementById("choice_A").style.display = "block";
			document.getElementById("choice_B").style.display = "block";
			document.getElementById("choice_C").style.display = "block";
			document.getElementById("choice_D").style.display = "block";
		}
	}
</script>
</head>

<body>
<div class = "container">
	<div class="text2">
		<form id="form1" name="form1" method="post"
			action='<%=path%>/questionModifyServlet'
			onsubmit="return verInput();">
			<input type="hidden" name = "id" value = "${questionMap.id}"/>
			<div class = "form-group">
				<label>科目：</label>
				<select name="courseId" id="courseId" class = "form-control">
							<c:forEach var="course" items="${courseList}">
								<c:choose>
									<c:when test="${course.id == questionMap.courseId}">
										<option value=${course.id } selected="selected">${course.name}</option>
									</c:when>
									<c:otherwise>
										<option value=${course.id }>${course.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
			</div>
			<div class = "form-group">
				<label>题目类型：</label>
				<select name="queType" id="queType" class = "form-control">
							<option value="1" selected="selected">单项选择</option>
				</select>
			</div>
			<div class = "form-group">
				<label>题目：</label>
				<textarea name="queTitle" class = "form-control" id="queTitle" style="resize: none;">${questionMap.queTitle}</textarea>
			</div>
			<div class = "form-group">
				<label>选项A：</label>
				<input type="text" name="choiceA" class = "form-control" id="choiceA" value='${questionMap.choiceA}' />
			</div>
			<div class = "form-group">
				<label>选项B：</label>
				<input type="text" name="choiceB" class = "form-control" id="choiceB" value='${questionMap.choiceB}' />
			</div>
			<div class = "form-group">
				<label>选项C：</label>
				<input type="text" name="choiceC" class = "form-control" id="choiceC" value='${questionMap.choiceC}' />
			</div>
			<div class = "form-group">
				<label>选项D：</label>
				<input type="text" name="choiceD" class = "form-control" id="choiceD" value='${questionMap.choiceD}' />
			</div>
			<div class = "form-group">
				<label>正确答案：</label>
				<input type="text" name="ans" class = "form-control" id="ans" value='${questionMap.ans}' />
			</div>
			<input type="submit" name="button" id="button" class="btn btn-info"  value="修改试题" />
		</form>
	</div>
</div>
</body>
</html>