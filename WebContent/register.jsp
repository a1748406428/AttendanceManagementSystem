<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/checkisnull.js"></script>
</head>
<script type="text/javascript">
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>

<body>
<!-- 利用Ajax进行注册 -->
<div  align="center">
<form action="" method="post">
用户名：<input type="text" name="name" id="userid" onblur="check()"><span id="usercheck"></span><br>
密码：<input type="password" name="password" id="pwd"><span id="pwdcheck"></span><br>
确认密码：<input type="password" id="pwd2" onkeyup="validate()"><span id="pwd2check"></span><br>
性别：<input type="radio" value="男" id="sex" >男 <input type="radio" value="女" name="sex" id="sex">女<span id=""></span><br>
电话：<input type="text" name="phone" value="123" id="phoneid" onblur="checkphone()"><span id="checkphone" ></span><br>
籍贯：<select id="province">
			<option value="">--请选择--
			<option value="1">江苏省</option>
			<option value="2">浙江省</option>
			<option value="3">安徽省</option>
			<option value="4">山东省</option>
		</select>
		<select id="city">
			<option value="">--请选择--
		</select>
		<select id="town">
			<option value="">--请选择--
		</select><span></span><br>
详细地址：<br>
<textarea rows="5" cols="30" name="detailedAddress" style="resize:none" id="detailed"></textarea><span id=""></span><br>
</form>
<button type="button" id="registerButton" >注册</button>
</div>
<div id="tiaozhuan" align="center" style="align-content: center;">

</div>
</body>
</html>