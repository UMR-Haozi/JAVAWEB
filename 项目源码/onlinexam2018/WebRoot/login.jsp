<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/fontawesome-all.min.css">
	<link rel="stylesheet" href="css/acmpx.css">
	
	<title>登录 - 学生在线考试系统</title>
	<style>
		body{
			background-size:100%;
			background-attachment: fixed;
			background-repeat: no-repeat;
			background-image: url(img/loginbg.png);
		}
		.main {
			background-color: rgba(255, 255, 255, 0.85);
		}
		.top{
			font-weight: bold;
			margin: 0 120px;
			letter-spacing:17px;
			font-size:25px;
		}
		.text {
			font-weight: bold;
			font-size: 15px;
		}
		.select { 
			width: auto;
			padding: 0 100px;
			margin: 0;
			font-weight: bold;
		}
		.select option{
			text-align: center;
		}
	</style>
		<script type="text/javascript">
			if(window != top){
				top.location.href = location.href;
			}
		</script>
</head>
<body>
<nav class="nnavbar navbar-inverse navbar-fixed-top main">
	<div class="container">
		<div>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
							aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="navbar-brand top">不要在无奈的时候才去后悔当初自己的不努力</div>
		</div>
	</div>
</nav>
<div class="nav-gap"></div>
	<div class="container">
		<div class="panel panel-default login-panel">
			<div class="panel-body">
				<h4 class="text-center panel-header">学生在线考试系统</h4>
				<form action="<%=path%>/loginServlet" method="post">
					<input type='hidden' name='csrfmiddlewaretoken' value='VbYvVS5ynUtcZzT2jSLjoqYd5gGTWIHjtO0Zf0L4nyEMwWESy2y3fdRQPyNlg8Tw' />
					<input type="hidden" name="next" id="id_next" />
					<div class="form-group">
						<input type="text" name="username" placeholder="用户名" class="form-control" id="id_username" maxlength="128" required />
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder="密码" class="form-control" id="id_password" maxlength="128" required />
					</div>
					<div>
						<label class = "text">选择身份：&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<label>
								<select class = "select" name="role" id = "role">
								<option value="admin"  selected="selected">管理员</option>
								<option value="teacher">教师</option>
								<option value="student">学生</option>
								</select>
						</label>
					</div>
					<button type="submit" class="btn btn-block btn-primary">登录</button>
				</form>
			</div>
		</div>
	</div>




<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/acmpx.js"></script>

</body>
</html>
