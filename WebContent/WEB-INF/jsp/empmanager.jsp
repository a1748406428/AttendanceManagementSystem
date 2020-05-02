<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	</head>
	<link rel="stylesheet" href="css/sys.css" />
	<style type="text/css">
		body {
			min-width: 1220px;
		}
	</style>
	
	<body>
		<div class="top">
			<img src="img/logo.png" alt="" class="logo-img" />
			<span class="logo-text">员工后台管理系统</span>
			<!-- <span class="erji-text"><em>服务管理系统</em></span> -->
			<div class="top-right">
				<div class="top-right-list" id="message">
					<img src="img/info.png" alt="" style="width: 20px;" />&nbsp;<span>消息通知<span class="badge badge-pill badge-danger" id="tz"></span></span>
					<div class="message-hide" id="receive">
						
					</div>
				</div>
				<div class="top-right-list" id="user">
					<img src="img/person.png" alt="" />&nbsp;<span>${empname}</span>
					<div class="userInfo-hide">
						<div class="userInfo-hide-title">${empname}</div>
						<div class="userInfo-list">${GONG_HAO}</div>
						<div class="userInfo-list go-back-img" style="text-align: center;">
							退出登录
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="navs">
			<div class="navs-lists" id="nav-lists"></div>
			<div class="navs-sz">
				<span id="pDate"></span>&nbsp;&nbsp;
			</div>
			<div class="navs-sz">
				<span><a href="rewu.action?gonghao=${GONG_HAO}" target="_blank">任务中心</a></span>&nbsp;&nbsp;
			</div>
			<div class="navs-sz">
				<span style="color: red">上/下班请—></span><span><button class="btn btn-outline-primary" id="daka">一键打卡</button></span>&nbsp;&nbsp;
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="fenge"></div>
		<!--下方内容-->
		<div class="cons">
			<iframe src="personinfo.action?gonghao=${GONG_HAO}" id="mainFrame" name="main" frameborder="0" width="100%" height="100%" ></iframe>
		</div>
	</body>
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="js/sys.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
		$(function() {
			
			var str = window.screen.availHeight -200;
				$(".cons").css({
					"min-height": str
				})
			var arr = [{
					tit: "个人基本信息",
					urls: "personinfo.action?gonghao=${GONG_HAO}"
				},
				{
					tit: "职位变更申请",
					urls: "gsck.action"
				},
				{
					tit: "薪资明细",
					urls: "xzmx.action?gonghao=${GONG_HAO}"
				},
				{
					tit: "请假申请",
					urls: "qjsqq.action?gonghao=${GONG_HAO}"
				},
				{
					tit: "消息中心",
					urls: "xxzx.action"
				}
			]

			function navList() {
				for(var i = 0; i < arr.length; i++) {
					var html = "";
					html += "<div class='list'>";
					html += "<a href='" + arr[i].urls + "'  target='main'>" + arr[i].tit + "</a>";
					html += "</div>";
					$("#nav-lists").append(html)
				};
				$(".list a").eq(0).addClass("selected-list");
			};
			navList();

			$(".go-back-img").on("click", function() {
				window.location.href = "index.html"
			})

		})
	</script>
<script type="text/javascript">
	var websocket = null;
	if('WebSocket' in window){
		websocket = new WebSocket("ws://localhost:8080/AttendanceManagementSystem/myHandler.action");
	}
	websocket.onopen = onOpen;
	websocket.onmessage = onMessage;
	websocket.onerror = onError;
	websocket.onclose = onClose;
	var count = 0;
	function onOpen(result){
		if(result.data!=null){
		$("#receive").html('<div class="message-hide-list">'+result.data+'</div>')
		}
	}
	function onMessage(result) {
		if(result.data!=null){
       $("#receive").append("<a href='xxzx.action' target='main'><div class='message-hide-list' style='white-space: nowrap;text-overflow:ellipsis;overflow:hidden;'>"+result.data+"</div><a/>")
        count = count+1
        $("#tz").text(count)
        $(".message-hide-list").text($(".message-hide-list").html().slice(0,14)+'...')
		}
    }
    function onError(result) {
        alert("通信发生错误时触发:"+result.data);
    }
    function onClose(result) {
    	$("#duankai").html("已断开")
    }
    window.close=function websocketClose()
    {
        websocket.onclose();
    }
    
</script>
<script type="text/javascript">
	$(function () {
		$("#daka").click(function () {
			var today = new Date();
			var year = today.getFullYear();
			var month = (today.getMonth() + 1 )<10?'0'+(today.getMonth() + 1 ):(today.getMonth() + 1 );
			var hour = today.getHours()<10?'0'+today.getHours():today.getHours();
			var min = today.getMinutes()<10?'0'+today.getMinutes():today.getMinutes();
			var daytime = today.getDate()<10?'0'+today.getDate():today.getDate();
			var checktime = year+'/'+month+'/'+daytime;
			var gonghao = '${GONG_HAO}';
			var startcheckorendcheck = hour+':'+min;
			$.post("daka.action",{gonghao:gonghao,checktime:checktime,startcheckorendcheck:startcheckorendcheck},function(data,status){
				if(data!=null){
					alert("打卡成功！")
				}else{
					alert("打卡失败，请与管理员联系！")
				}
			})
		})
	})
</script>
</html>