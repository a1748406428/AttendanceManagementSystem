<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
    姓名：<input type="text"><br>
    工号：<input type="text"><br>
    学历：<select>
    	<option value="">--请选择--博士</option>
    	<option value="博士">博士</option>
    	<option value="硕士">硕士</option>
    	<option value="本科">本科</option>
    	<option value="专科">专科</option>
    </select><br>
    性别：<input type="radio" value="男" name="sex" checked="checked"> 男  <input type="radio" name="sex" value="女"> 女<br> 
    年龄：<input type="text"><br>
    家庭住址：<textarea rows="" cols=""></textarea><br>
    电话号码：<input type="text"><br>
    基础工资：<input type="text"><br>
    入职时间：<input type="date"><br>
    部门ID：<input type="text"><br>
</form>
</body>
</html>