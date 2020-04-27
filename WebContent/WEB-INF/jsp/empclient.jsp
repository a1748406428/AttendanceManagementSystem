<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工端</title>
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
</head>
<script type="text/javascript">
	var websocket = null;
	if('WebSocket' in window){
		websocket = new WebSocket("ws://localhost:8080/AttendanceManagementSystem/myHandler.action");
	}
	websocket.onopen = onOpen;
	websocket.onmessage = onMessage;
	websocket.onerror = onError;
	websocket.onclose = onClose;
	function onOpen(event){
	}
	function onMessage(result) {
        $("#jieshou").append(result.data)
    }
    function onError(result) {
        alert("通信发生错误时触发:"+result.data);
    }
    function onClose(result) {
    	$("#duankai").html("已断开")
    }
    function doSendUser() {
    	 if (websocket.readyState == websocket.OPEN) {
             var msg = document.getElementById("inputMsg").value;
             var sendtouser = document.getElementById("username").value;
             var senduser = document.getElementById("senduser").value;
             websocket.send(sendtouser+"|"+msg+"|"+senduser);//调用后台handleTextMessage方法
         } else {
             alert("连接失败!");
         }
	}
    function doSendUsers() {
        if (websocket.readyState == websocket.OPEN) {
            var msg = document.getElementById("inputMsg").value;
            websocket.send("everyone"+msg);//调用后台handleTextMessage方法
            console.log("发送成功!");
        } else {
            alert("连接失败!");
        }
    }
    window.close=function websocketClose()
    {
        websocket.onclose();
    }
</script>
<body>
请输入：<textarea rows="5" cols="10" id="inputMsg" name="inputMsg"></textarea>
<input type="text" placeholder="发件人" id="senduser">
请你输入要发送的人<input type="text" name="username" id="username">
<button type="button" onclick="doSendUser()">发送</button>
<button type="button" onclick="doSendUsers()">群发</button>
<button type="button" onclick="onClose()">关闭连接</button>
离线消息：<input type="text" id="lixian">
<textarea id="jieshou" rows="20" cols="40">
</textarea><span id="duankai"></span>
</body>
</html>