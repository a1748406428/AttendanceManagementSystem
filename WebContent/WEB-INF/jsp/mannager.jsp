<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
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
<title>管理员</title>
</head>

<body>
	当前用户：${USER_SESSION}
	<nav class="side-navbar">
		<div class="side-navbar-wrapper">
			<!-- Sidebar Header    -->
			<div
				class="sidenav-header d-flex align-items-center justify-content-center">
				<!-- User Info-->
				<div class="sidenav-header-inner text-center">
					<img src="image/avatar-7.jpg" alt="person"
						class="img-fluid rounded-circle">
					<h2 class="h5">许梦园</h2>
					<span>管理员</span>
				</div>
				<!-- Small Brand information, appears on minimized sidebar-->
				<div class="sidenav-header-logo">
					<a href="index.html" class="brand-small text-center"> <strong>B</strong><strong
						class="text-primary">D</strong></a>
				</div>
			</div>
			<!-- Sidebar Navigation Menus-->
			<div class="main-menu">
				<h5 class="sidenav-heading">导航栏</h5>
				<ul id="side-main-menu" class="side-menu list-unstyled">
					<li><a href="#exampledropdownDropdown0" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>员工管理
					</a>
						<ul id="exampledropdownDropdown0" class="collapse list-unstyled ">
							<li id="register" src=""><a href="javascript:void(0)"><span >员工注册</span></a></li>
							<li id="yuangong" src="toList.action"><a href="javascript:void(0)"><span >员工信息详情</span></a></li>
						</ul></li>
					<li><a href="#exampledropdownDropdown1" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>考勤管理
					</a>
						<ul id="exampledropdownDropdown1" class="collapse list-unstyled ">
							<li id="kaoqinqingkuang" src="kqqk.action"><a href="javascript:void(0)"><span >考勤实时分布图</span></a></li>
							<li id="shoudongtianjia" src="sdtj.action"><a href="javascript:void(0)"><span >手动添加考勤</span></a></li>
							<li id="kaoqinzongbiao" src="kqzb.action"><a href="javascript:void(0)"><span >考勤总表</span></a></li>
						</ul></li>
					<li><a href="#exampledropdownDropdown2" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>部门管理
					</a>
						<ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
							<li id="departinfo" src="tobmgl.action"><a href="javascript:void(0)"><span >部门信息管理</span></a></li>
							<li id="renshidiaodong" src="bmcygl.action"><a href="javascript:void(0)"><span >人事调动与任务分发</span></a></li>
							<li id="jixiaokaohe" src="jxpd.action"><a href="javascript:void(0)"><span >绩效评定与考核</span></a></li>
						</ul></li>
					<!-- 日常管理 -->	
					<li><a href="#exampledropdownDropdown4" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>员工日常管理
					</a>
						<ul id="exampledropdownDropdown4" class="collapse list-unstyled ">
							<li id="qingjiashenqing" src="qjsq.action"><a href="javascript:void(0)"><span >请假申请单</span></a></li>
							<li id="tiaoxiuguanli" src="txgl.action"><a href="javascript:void(0)"><span >调补休管理</span></a></li>
							<li id="buchangjiahua" src="bcjh.action"><a href="javascript:void(0)"><span >补偿计划</span></a></li>
							<li id="tongzhiguangbo" src="tzgb.action"><a href="javascript:void(0)"><span >通知广播</span></a></li>
						</ul></li>
					<li id="paibanguanli" src="pbgl.action"><a href="javascript:void(0)"><span><i class="icon-interface-windows"></i>排班管理</span></a></li>
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
							<!-- Notifications dropdown-->
							<li class="nav-item dropdown"><a id="notifications"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false" class="nav-link"><i
									class="fa fa-bell"></i><span class="badge badge-warning">12</span></a>
								<ul aria-labelledby="notifications" class="dropdown-menu">
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification d-flex justify-content-between">
												<div class="notification-content">
													<i class="fa fa-envelope"></i>You have 6 new messages
												</div>
												<div class="notification-time">
													<small>4 minutes ago</small>
												</div>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification d-flex justify-content-between">
												<div class="notification-content">
													<i class="fa fa-twitter"></i>You have 2 followers
												</div>
												<div class="notification-time">
													<small>4 minutes ago</small>
												</div>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification d-flex justify-content-between">
												<div class="notification-content">
													<i class="fa fa-upload"></i>Server Rebooted
												</div>
												<div class="notification-time">
													<small>4 minutes ago</small>
												</div>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<div class="notification d-flex justify-content-between">
												<div class="notification-content">
													<i class="fa fa-twitter"></i>You have 2 followers
												</div>
												<div class="notification-time">
													<small>10 minutes ago</small>
												</div>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#"
										class="dropdown-item all-notifications text-center"> <strong>
												<i class="fa fa-bell"></i>view all notifications
										</strong></a></li>
								</ul></li>
							<!-- Messages dropdown-->
							<li class="nav-item dropdown"><a id="messages"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false" class="nav-link"><i
									class="fa fa-envelope"></i><span class="badge badge-info">10</span></a>
								<ul aria-labelledby="notifications" class="dropdown-menu">
									<li><a rel="nofollow" href="#"
										class="dropdown-item d-flex">
											<div class="msg-profile">
												<img src="image/avatar-1.jpg" alt="..."
													class="img-fluid rounded-circle">
											</div>
											<div class="msg-body">
												<h3 class="h5">Jason Doe</h3>
												<span>sent you a direct message</span><small>3 days
													ago at 7:58 pm - 10.06.2019</small>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#"
										class="dropdown-item d-flex">
											<div class="msg-profile">
												<img src="image/avatar-2.jpg" alt="..."
													class="img-fluid rounded-circle">
											</div>
											<div class="msg-body">
												<h3 class="h5">Frank Williams</h3>
												<span>sent you a direct message</span><small>3 days
													ago at 7:58 pm - 10.06.2019</small>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#"
										class="dropdown-item d-flex">
											<div class="msg-profile">
												<img src="image/avatar-3.jpg" alt="..."
													class="img-fluid rounded-circle">
											</div>
											<div class="msg-body">
												<h3 class="h5">Ashley Wood</h3>
												<span>sent you a direct message</span><small>3 days
													ago at 7:58 pm - 10.06.2019</small>
											</div>
									</a></li>
									<li><a rel="nofollow" href="#"
										class="dropdown-item all-notifications text-center"> <strong>
												<i class="fa fa-envelope"></i>Read all messages
										</strong></a></li>
								</ul></li>
							<!-- Languages dropdown    -->
							<li class="nav-item dropdown"><a id="languages"
								rel="nofollow" data-target="#" href="#" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"
								class="nav-link language dropdown-toggle"><img
									src="image/flags/16/GB.png" alt="English"><span
									class="d-none d-sm-inline-block">简体中文</span></a>
								<ul aria-labelledby="languages" class="dropdown-menu">
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<img src="image/flags/16/DE.png" alt="English" class="mr-2"><span>中文</span>
									</a></li>
									<li><a rel="nofollow" href="#" class="dropdown-item">
											<img src="image/flags/16/FR.png" alt="English" class="mr-2"><span>French
										</span>
									</a></li>
								</ul></li>
							<!-- Log out-->
							<li class="nav-item"><a href="login.html"
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
			<iframe name="manage" id="mframe" class="embed-responsive-item" src=""></iframe>
		 </div>
	</div>
	<!-- JavaScript files-->
	<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="vendor/popper.js/umd/popper.min.js"></script>
	<script src="https://www.jq22.com/jquery/bootstrap-4.2.1.js"></script>
	<script src="js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
	<script src="vendor/jquery.cookie/jquery.cookie.js"></script>
	<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
	<script
		src="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- Main File-->
	<script src="js/front.js"></script>
	
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
		document.onreadystatechange = function () {//即在加载的过程中执行下面的代码
			if(document.readyState=="complete"){//complete加载完成
				$(".loading").fadeOut();
			}
		}
	})
	</script>
</html>