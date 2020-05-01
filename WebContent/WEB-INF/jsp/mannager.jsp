<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>简人事</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<link rel="shortcut icon" href="image/favicon.ico" />
<link rel="icon"href="image/favicon.ico" />
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style3.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="https://www.jq22.com/jquery/font-awesome.4.7.0.css">
<!-- Fontastic Custom icon font-->
<link rel="stylesheet" href="css/fontastic.css">
<!-- Google fonts - Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<!-- jQuery Circle-->
<link rel="stylesheet"
	href="css/grasp_mobile_progress_circle-1.0.0.min.css">
<!-- Custom Scrollbar-->
<link rel="stylesheet"
	href="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon" href="image/favicon.ico">
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<title>管理员</title>
<script type="text/javascript" src="js/jquery.nicescroll.js"></script>
</head>

<body onload="showTime()">
	<nav class="side-navbar">
		<div class="side-navbar-wrapper">
			<!-- Sidebar Header    -->
			<div
				class="sidenav-header d-flex align-items-center justify-content-center">
				<!-- User Info-->
				<div class="sidenav-header-inner text-center">
					<img src="image/hm.jpg" alt="person"
						class="img-fluid rounded-circle">
					<span class="fa fa-user-md" style="color: white;">&nbsp;&nbsp;账号:${GONG_HAO}</span>
					<span class="fa fa-user" style="color: white;">&nbsp;&nbsp;${manname}</span>
				</div>
				<!-- Small Brand information, appears on minimized sidebar-->
				<div class="sidenav-header-logo">
					<a href="index.html" class="brand-small text-center"> <strong>H</strong><strong
						class="text-primary">R</strong></a>
				</div>
			</div>
			<!-- Sidebar Navigation Menus-->
			<div class="main-menu">
				<h5 class="sidenav-heading">导航栏</h5>
				<ul id="side-main-menu" class="side-menu list-unstyled">
					<li><a href="#exampledropdownDropdown0" aria-expanded="false"
						data-toggle="collapse"> <i class="fa fa-folder-open"></i>人事信息
					</a>
						<ul id="exampledropdownDropdown0" class="collapse list-unstyled ">
							<li id="register" src="empreg.action"><a href="javascript:void(0)"><span class="fa fa-edit">&nbsp;员工注册</span></a></li>
							<li id="yuangong" src="toList.action"><a href="javascript:void(0)"><span class="fa fa-list">&nbsp;员工档案</span></a></li>
						</ul></li>
					<li><a href="#exampledropdownDropdown1" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>考勤管理
					</a>
						<ul id="exampledropdownDropdown1" class="collapse list-unstyled ">
							<li id="kaoqinqingkuang" src="kqqk.action"><a href="javascript:void(0)"><span class="fa fa-eye">&nbsp;考勤实时分布图</span></a></li>
							<li id="kaoqinzongbiao" src="kqzb.action"><a href="javascript:void(0)"><span class="fa fa-table">&nbsp;考勤信息总表</span></a></li>
							<li id="shoudongtianjia" src="sdtj.action"><a href="javascript:void(0)"><span class="fa fa-plus">&nbsp;手动录入考勤</span></a></li>
						</ul></li>
					<li><a href="#exampledropdownDropdown2" aria-expanded="false"
						data-toggle="collapse"> <i class="fa fa-tags"></i >部门与任务
					</a>
						<ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
							<li id="departinfo" src="tobmgl.action"><a href="javascript:void(0)"><span class="fa fa-chevron-right">&nbsp;部门信息管理</span></a></li>
							<li id="renshidiaodong" src="bmcygl.action"><a href="javascript:void(0)"><span class="fa fa-chevron-right">&nbsp;人事调动与任务分发</span></a></li>
							<li id="jixiaokaohe" src="jxpd.action"><a href="javascript:void(0)"><span class="fa fa-chevron-right">&nbsp;部门绩效考核</span></a></li>
							<li id="kaohehuizong" src="khhztable.action"><a href="javascript:void(0)"><span class="fa fa-chevron-right">&nbsp;考核汇总表</span></a></li>
						</ul></li>
					<!-- 日常管理 -->	
					<li><a href="#exampledropdownDropdown4" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>公司日常管理
					</a>
						<ul id="exampledropdownDropdown4" class="collapse list-unstyled ">
							<li id="qingjiashenqing" src="qjsq.action"><a href="javascript:void(0)"><span class="fa fa-chevron-right">&nbsp;请假申请单</span></a></li>
							<li id="tiaoxiuguanli" src="txgl.action"><a href="javascript:void(0)"><span class="fa fa-chevron-right">&nbsp;调补休管理</span></a></li>
							<li id="buchangjiahua" src="bcjh.action"><a href="javascript:void(0)"><span class="fa fa-chevron-right">&nbsp;奖惩管理</span></a></li>
							<li data-toggle="modal"  data-target="#broadmodal"><a href="javascript:void(0)"><span class="fa fa-bullhorn">&nbsp;通知广播</span></a></li>
						</ul></li>
					<li id="paibanguanli" src="pbgl.action"><a href="javascript:void(0)"><span><i class="fa fa-money"></i>薪资管理</span></a></li>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="page">
		<div class="loading">
				<div id="app">
	<div class="text-wrapper">
		<div class="text part1">
			<div>
				<span class="letter"><div class="character">L</div> <span></span></span>
				<span class="letter"><div class="character">o</div> <span></span></span>
				<span class="letter"><div class="character">a</div> <span></span></span>
				<span class="letter"><div class="character">d</div> <span></span></span>
				<span class="letter"><div class="character">i</div> <span></span></span>
				<span class="letter"><div class="character">n</div> <span></span></span>
				<span class="letter"><div class="character">g</div> <span></span></span>
			</div>
		</div>
		<div class="how-to"><span>正在加载中，请您耐心等待...</span></div>
	</div>
</div>
		</div>
		<!-- navbar-->
		<header class="header">
			<nav class="navbar">
				<div class="container-fluid">
					<div
						class="navbar-holder d-flex align-items-center justify-content-between">
						<div class="navbar-header">
							<a id="toggle-btn" href="#" class="menu-btn"><i
								class="icon-bars"> </i></a><a href="index.html" class="navbar-brand">
								<div class="brand-text d-none d-md-inline-block">
									<strong class="text-primary">系统控制台</strong>
								</div>
							</a>
						</div>
						<ul
							class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
							<li><span id="time"></span></li>
							<!-- Notifications dropdown-->
							<li class="nav-item dropdown"><a id="notifications"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false" class="nav-link">
								<i class="fa fa-bell"></i><span class="badge badge-warning" id="tx"></span></a>
								<ul aria-labelledby="notifications" class="dropdown-menu">
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification d-flex justify-content-between">
												<div class="notification-content">
												</div>
											</div>
									</a></li>
								</ul></li>
							
							<!-- Log out-->
							<li class="nav-item"><a href="logout.action"
								class="nav-link logout"> <span
									class="d-none d-sm-inline-block">退出</span><i
									class="fa fa-sign-out"></i></a></li>

						</ul>
					</div>
				</div>
			</nav>
		</header>
		<!-- 添加iframe src内容动态添加-->
		<div class="embed-responsive embed-responsive-21by9">
			<iframe name="manage" id="mframe" class="embed-responsive-item" src="userhelp.html"></iframe>
		 </div>
	</div>
	<!-- JavaScript files-->

	<script src="vendor/popper.js/umd/popper.min.js"></script>
<!-- 	<script src="https://www.jq22.com/jquery/bootstrap-4.2.1.js"></script> -->
	<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script> -->
	<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script src="js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
	<script src="vendor/jquery.cookie/jquery.cookie.js"></script>
	<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
	
	<script
		src="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- Main File-->
	<script src="js/front.js"></script>
	<!-- 广播通知模态框 -->
<div class="modal fade" id="broadmodal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">通知</h4>
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
			<div class="modal-body">
	<form class="bs-example bs-example-form" role="form">
      <div class="input-group">
      	 <span class="input-group-addon">通知对象:</span>
         <input type="text" class="form-control" value="everyone" id="username">
      </div>
      <br>
      <div class="input-group">
         通知内容:<textarea type="text" rows="10" class="form-control" placeholder="通知内容" id="inputMsg"></textarea>
         <span class="input-group-addon"></span>
      </div>
      <br>
      <div class="input-group">
        发件人:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="form-control" placeholder="发件人" id="senduser">
         <span class="input-group-addon"></span>
      </div>
   </form>
			</div>
            <div class="modal-footer">
            <button type="button" class="btn" data-dismiss="modal">关闭 </button>
            <button type="button" onclick="doSendUser()" class="btn btn-primary btn-sm" data-dismiss="modal">发送</button>
         </div>
			
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	$(function() {
		function toSomeWhere(someid) {
			$("#"+someid).click(function() {
				var url = $("#"+someid).attr('src')
				$("#mframe").attr('src',url);
			})
		}
		toSomeWhere("register")
		toSomeWhere("yuangong")
		toSomeWhere("kaoqinqingkuang")
		toSomeWhere("shoudongtianjia")
		toSomeWhere("departinfo")
		toSomeWhere("renshidiaodong")
		toSomeWhere("jixiaokaohe")
		toSomeWhere("kaoqinzongbiao")
		toSomeWhere("tiaoxiuguanli");
		toSomeWhere("qingjiashenqing");
		toSomeWhere("buchangjiahua");
		toSomeWhere("tongzhiguangbo");
		toSomeWhere("paibanguanli");
		toSomeWhere("kaohehuizong");
		document.onreadystatechange = function () {//即在加载的过程中执行下面的代码
			if(document.readyState=="complete"){//complete加载完成
				$(".loading").fadeOut();
			}
		}
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

	}
	function onMessage(result) {
		if(result.data!=null){
			count = count+1;
       	 	$("#tx").text(count);
       	 	$(".notification-content").append(result.data+'<br>');
		}
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
             var thetotalmsg = sendtouser+"|"+msg+"|"+senduser;
             var temptime = new Date();
             var year = temptime.getFullYear();
             var month = temptime.getMonth()+1;
             var day = temptime.getDay();
             month = month<10?'0'+month:month;
             day = day<10?'0'+day:day;
             var daytime = year+'/'+month+'/'+day;
             websocket.send(sendtouser+"|"+msg+"|"+senduser);//调用后台handleTextMessage方法
             //并且更新数据库
             if(sendtouser == "everyone"){
            	 $.post("updatepublicnotice.action",{content:thetotalmsg,daytime:daytime},function(data,status){
            		 
            	 })
             }else {
				$.post("updateprivatenotice.action",{content:thetotalmsg,daytime:daytime,gonghao:sendtouser,status:"未读"},function(data,status){
            		 
            	 })
             }
             alert("发送成功！")
         } else {
             alert("连接失败!");
         }
	}
    window.close=function websocketClose()
    {
        websocket.onclose();
    }
</script>
<script type="text/javascript">

window.setInterval('showTime()',1000)
		function showTime()
		{
		var enabled = 0; 
		today = new Date();
		var day; 
		var date;
		if(today.getDay()==0) day = "星期日"
		if(today.getDay()==1) day = "星期一"
		if(today.getDay()==2) day = "星期二"
		if(today.getDay()==3) day = "星期三"
		if(today.getDay()==4) day = "星期四"
		if(today.getDay()==5) day = "星期五"
		if(today.getDay()==6) day = "星期六"
		var month = (today.getMonth() + 1 )<10?'0'+(today.getMonth() + 1 ):(today.getMonth() + 1 );
		var hour = today.getHours()<10?'0'+today.getHours():today.getHours();
		var seconds = today.getSeconds()<10?'0'+today.getSeconds():today.getSeconds();
		var min = today.getMinutes()<10?'0'+today.getMinutes():today.getMinutes();
		date = (today.getFullYear()) + "年" + month + "月" + today.getDate() + "日 " + 
		day+hour+":"+min+":"+seconds;
		$("#time").html(date).css('color','white')
}
</script>
<script type="text/javascript">
$(function () {
 	$('body').css('overflow','auto');
 	/*$('ele').niceScroll({ ...});
	$(ele).css('overflow','hidden'); */
	$("body").niceScroll({
	    cursorcolor: "rgb(110, 110, 109)", //滚动条的颜色   
	    cursoropacitymax: 1, //滚动条的透明度，从0-1   
	    touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备   
	    cursorwidth: "8px", //滚动条的宽度   
	    cursorborder: "0", // 游标边框css定义    
	    cursorborderradius: "5px", //以像素为光标边界半径  圆角   
	    autohidemode: false, //是否隐藏滚动条  true的时候默认不显示滚动条，当鼠标经过的时候显示滚动条   
	    zindex: "auto", //给滚动条设置z-index值    
	    railpadding: {
	        top: 0,
	        right: -4,
	        left: 0,
	        bottom: 0
	    }, //滚动条的位置
	});
})

</script>
</html>