<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生在线考试系统</title>
</head>
<frameset rows="130,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="<%=path%>/manager/mtop.jsp" name="topFrame" scrolling="no"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<frame src="<%=path%>/manager/mleft.jsp" name="leftFrame"
			scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="<%=path%>/manager/mmain.jsp" name="mainFrame"
			id="mainFrame" title="mainFrame" />
	</frameset>
</frameset>
<body>

</body>
</html>