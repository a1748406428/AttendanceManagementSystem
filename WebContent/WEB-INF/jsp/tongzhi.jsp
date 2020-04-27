<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知管理</title>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
</head>

<body>
<a>历史记录</a>
通知对象:<input type="text" placeholder="工号或everyone" id="senduser" value="everyone"><br/>
通知内容:<textarea rows="20" cols="30" id="inputMsg">
</textarea><br>
发件人:<input type="text" id="username">
<button type="button" onclick="doSendUser()">发送</button>
<button type="button" onclick="doSendUsers()">群发</button>
</body>
</html>