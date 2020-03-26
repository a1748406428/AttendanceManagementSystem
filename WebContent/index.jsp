<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<script type="text/javascript">
	function register() {
		window.open("http://localhost:8080/BootMannager/register.jsp")
	}
</script>
<body>
<script type="text/javascript">
$(function() {
	$("#loginButton").click(function(){
		$("#loginId").submit();
		});
});
</script>
	${msg}
	<form action="login.action" method="GET" id="loginId">
		用户名：<input type="text" id="userInput" name="name"><span
			id="userCheck"></span><br> 密&nbsp;&nbsp;&nbsp;码：<input
			type="password" id="userPassword" name="password"><span
			id="passwordCheck"></span>
	</form>
	<button type="submit" id="loginButton">登陆</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" id="wangjiPassword">忘记密码</button>
	没有账号？点击
	<button type="button" id="register" onclick="register()">注册</button>
</body>
</html>