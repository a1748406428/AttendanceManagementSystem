<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>请假申请</title>
		<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	</head>
	<link rel="stylesheet" href="css/sys.css" />
	<body>
	<div class="container">
		<div class="card" style="height: 100%">
			<div class="card-header">
				<h5>请假申请单</h5>
			</div>
			<form action="form" style="margin:0 auto;">
			<div class="form-row">
				<div class="form-group col-md-4">
				<label for="name">姓名</label>
				<input type="text" class="form-control" id="name">
				</div>
				<div class="form-group col-md-4">
				<label for="empid">员工编号</label>
				<input type="text" id="empid" class="form-control">
				</div>
				<div class="form-group col-md-4">
				<label for="reasonid">请假类型</label>
				<select class="form-control custom-select" id="reasonid">
					<option>-请选择-</option>
					<option>生病</option>
					<option>事假</option>
					<option>产假</option>
				</select>
				</div>
				
				<div class="form-group col-md-4">
				<label for="qita">其他类型</label>
				<input type="text" class="form-control" id="qita" placeholder="如果请假类型已选择则不填此项">
				</div>
				<div class="form-group col-md-4">
				<label>请假天数</label>
				<input type="text" class="form-control" id="totalday">
				</div>
				<div class="form-group col-md-4">
				<label>去向</label>
				<input type="text" class="form-control" id="togo">
				</div>
				<div class="form-group col-md-4">
				<label>手机号码</label>
				<input type="text" class="form-control" id="phone">
				</div>
				<div class="form-group col-md-4">
				<label for="depid">部门</label>
				<select class="form-control custom-select" id="depid">
				<option>-请选择-</option>
				<option value="1">研发部</option>
				<option value="2">运营部</option>
				<option value="3">运维部</option>
				<option value="4">产品部</option>
				<option value="5">财务部</option>
				<option value="6">法务部</option>
				</select>
				</div>
				</div>
				</form>
				<button type="button" class="btn btn-success" id="submitqingjiadan">提交</button>
				</div>
				
				<input type="text" style="display: none;" id="status" value="未审核">
		</div>
	</body>
	<script type="text/javascript">
		$(function(){
			//websocket通信
			//提交事件
			$("#submitqingjiadan").click(function () {
				var name = $("#name").val();
				var empid = $("#empid").val();
				var selectreason = $("#reasonid").find("option:selected").text();
				var qita = $("#qita").val();
				var reason;
				var totalday = $("#totalday").val();
				var day = new Date();
				day.setTime(day.getTime());
				var year = day.getFullYear();
				var month = (day.getMonth()+1)<10? "0"+(day.getMonth()+1):(day.getMonth()+1);
				var datetime = day.getDate()<10? ("0"+day.getDate()):day.getDate();
				var togo = $("#togo").val();
				var phone = $("#phone").val();
				var depid = $("#depid").val();
				var status = $('#status').val();
				var daytime = year+"/"+month+"/"+datetime
				if (selectreason!=null || selectreason != undefined || selectreason != '') {
					reason = selectreason;
				}else if(qita!=null || qita != undefined || qita != ''){
					reason = qita;
				}
				
				$.ajax(
		        		{
		        			url:"empqingjia.action",
		        			type:"post",
		        			data:JSON.stringify({
		            			name:name,
		            			totalday:totalday,
		            			reason:reason,
		            			daytime:daytime,
		            			togo:togo,
		            			phone:phone,
		            			eid:empid,
		            			did:depid,
		            			status:status
		            		  }),
		            		 contentType:"application/json;charset=UTF-8",
		            		 success:function(data){
		            			if(data!=null){
		            				alert("提交成功")
		            			}
		           		  }
		        		});
			})
			})
			
	</script>
<script type="text/javascript">
$(function() {
	var websocket = null;
	if('WebSocket' in window){
		websocket = new WebSocket("ws://localhost:8080/AttendanceManagementSystem/myHandler.action");
	}
	websocket.onopen = onOpen;
	websocket.onmessage = onMessage;
	websocket.onerror = onError;
	websocket.onclose = onClose;
	function onOpen(result){
	}
	function onMessage(result) {
	}
	function onError(result) {
	    alert("通信发生错误时触发:"+result.data);
	}
	function onClose(result) {
	}
	$("#submitqingjiadan").click(function () {
		if (websocket.readyState == websocket.OPEN) {
		     websocket.send("13218039275"+"|"+"您有新的请假信息，请到请假中心查看"+"|"+"${GONG_HAO}");//调用后台handleTextMessage方法
		     console.log("发送成功!");
		 } else {
		     alert("连接失败!");
		 }
	})
	window.close=function websocketClose()
	{
	    websocket.onclose();
	}
})
</script>
</html>