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
							<li><a href="javascript:void(0)"><span id="register" src="">员工注册</span></a></li>
							<li><a href="javascript:void(0)"><span id="yuangong" src="toList.action">员工查询</span></a></li>
						</ul></li>
					<li><a href="#exampledropdownDropdown1" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>考勤管理
					</a>
						<ul id="exampledropdownDropdown1" class="collapse list-unstyled ">
							<li><a href="javascript:void(0)"><span id="kaoqinqingkuang" src="kqqk.action">考勤情况</span></a></li>
							<li><a href="javascript:void(0)"><span id="shoudongtianjia" src="sdtj.action">手动添加考勤</span></a></li>
						</ul></li>
					<li><a href="#exampledropdownDropdown2" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>部门管理
					</a>
						<ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
							<li><a href="javascript:void(0)"><span id="departinfo" src="tobmgl.action">部门信息管理</span></a></li>
							<li><a href="javascript:void(0)"><span id="chengyuangaikuang" src="">部门成员概况</span></a></li>
							<li><a href="javascript:void(0)"><span id="zongtiqingkuang" src="">人员调度</span></a></li>
							<li><a href="javascript:void(0)"><span id="jixiaokaohe" src="">绩效评定与考核</span></a></li>
						</ul></li>
					<!-- 日常管理 -->	
					<li><a href="#exampledropdownDropdown4" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>员工日常管理
					</a>
						<ul id="exampledropdownDropdown4" class="collapse list-unstyled ">
							<li><a href="javascript:void(0)"><span id="departinfo" src="">请假申请单</span></a></li>
							<li><a href="javascript:void(0)"><span id="chengyuangaikuang" src="">调补休管理</span></a></li>
							<li><a href="javascript:void(0)"><span id="chengyuangaikuang" src="">补偿计划</span></a></li>
						</ul></li>
					<li><a href="javascript:void(0)"><span id="chengyuangaikuang" src="">排班管理</span></a></li>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="page">
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
		<footer class="main-footer">
			<!-- <div class="container-fluid"> -->
				<!-- <div class="row"> -->
					<!-- <div class="col-sm-6"> -->
						<p>Copyright &copy; 2019.Company name All rights reserved.</p>
					<!-- </div> -->
					<!-- <div class="col-sm-6 text-right"></div> -->
				<!-- </div> -->
			<!-- </div> -->
		</footer>
	</div>
	<!-- JavaScript files-->
	<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="vendor/popper.js/umd/popper.min.js">
		
	</script>
	<script src="https://www.jq22.com/jquery/bootstrap-4.2.1.js"></script>
	<script src="js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
	<script src="vendor/jquery.cookie/jquery.cookie.js">
		
	</script>
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
	<script
		src="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/charts-home.js"></script>
	<!-- Main File-->
	<script src="js/front.js"></script>
	
</body>
<script type="text/javascript">
	$(function() {
		$("#departinfo").click(function() {
			var url = $("#departinfo").attr('src')
			$("#mframe").attr('src',url);
		})
		$("#yuangong").click(function() {
			var url = $("#yuangong").attr('src')
			$("#mframe").attr('src',url);
		})
		$("#kaoqinqingkuang").click(function() {
			var url = $("#kaoqinqingkuang").attr('src')
			$("#mframe").attr('src',url);
		})
		$("#shoudongtianjia").click(function() {
			var url = $("#shoudongtianjia").attr('src')
			$("#mframe").attr('src',url);
		})
		$("#departinfo").click(function() {
			var url = $("#departinfo").attr('src')
			$("#mframe").attr('src',url);
		})
	})
	</script>
		
</html>