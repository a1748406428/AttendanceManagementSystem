<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<link rel="stylesheet" href="css/sys.css" />
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
 
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<body>
		<div class="xtgl-content">
			<div>
			<div class="container-fluid">
			<div class="card border-primary">
				<div class="card-header border-primary">
					<!-- <h4 class="card-title">个人基本信息</h4> -->个人基本信息
				 </div>
			<div class="card-body mb-3  text-dark" style="background: white;">
				 
				<div class="row">
				<div class="col-md-6"></div>
				<div class="col-md-2"><img class="card-img-top" src="https://www.w3cschool.cn/attachments/image/20180524/1527144620597215.png" alt="Card image cap"></div>
			</div>
			<div class="row">
				<div class="col-md-1">姓名</div>
				<div class="col-md-1"><u>${empselfinfo.getName()}</u></div>
				<div class="col-md-1">个人编号</div>
				<div class="col-md-1"><u>${empselfinfo.getId()}</u></div>
				<div class="col-md-1">性别</div>
				<div class="col-md-1"><u>${empselfinfo.getSex()}</u></div>
			</div>
			<p></p>
			<div class="row">
				<div class="col-md-1">隶属部门</div>
				<div class="col-md-1"><u>${empselfinfo.getDepname()}</u></div>
				<div class="col-md-1">所属岗位</div>
				<div class="col-md-2"><u>${empselfinfo.getPostname()}</u></div>
			</div><p></p>
			<div class="row">
				<div class="col-md-1">我的等级</div>
				<div class="col-md-1"><u>${empselfinfo.getLevel()}</u></div>
				<div class="col-md-1">政治面貌</div>
				<div class="col-md-1"><u>${empselfinfo.getPoliticalstatus()}</u></div>
			</div><p></p>
			<div class="row">
				<div class="col-md-1">家庭地址</div>
				<div class="col-md-8"><u>${empselfinfo.getAddress()}</u></div>
			</div><p></p>
			<div class="row">
				<div class="col-md-1">手机号</div>
				<div class="col-md-2"><u>${empselfinfo.getPhone()}</u></div>
				<div class="col-md-1">学历</div>
				<div class="col-md-1"><u>${empselfinfo.getEducation()}</u></div>
			</div><p></p>
			<div class="row">
				<div class="col-md-1">入职年份</div>
				<div class="col-md-1"><u>${empselfinfo.getEntrytime()}</u></div>
				<div class="col-md-1">工龄</div>
				<div class="col-md-1"><u>${empselfinfo.getGongling()}月</u></div>
				<div class="col-md-1">基础工资</div>
				<div class="col-md-1"><u>${empselfinfo.getBasesalary()}</u></div>
			</div>
		</div>
		</div>
			</div>
			</div>
		</div>
	</body>

</html>