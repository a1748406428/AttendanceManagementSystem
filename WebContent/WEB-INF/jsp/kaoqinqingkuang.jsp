<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%;width:100%;">
<head>
<meta charset="UTF-8">
<title>考勤情况</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/echarts.min.js"></script>
	<script type="text/javascript" src="js/departcharts.js"></script>
</head>

<body style="text-align: center;height: 100%;width:100%;">

<div style="height:100%;width:100%; text-align:center;" class="container-fluid">
	<nav class="navbar navbar-default" role="navigation" style="margin-left: 50px">
	<div align="center">
		<form action="" class="form-inline">
			<span>选择日期</span>
			<label style="margin-left: 0px"><input type="date" id="start" class="form-control"></label>to
			<label style="margin-left: 0px"><input type="date" id="end" class="form-control"></label>&nbsp;&nbsp;&nbsp;
			<button type="button" id="bumenchart" class="btn btn-primary" class="form-control">部门情况表</button>&nbsp;&nbsp;
			<button type="button" id="gangweichart" class="btn btn-primary" class="form-control">岗位考勤情况表</button>&nbsp;&nbsp;
			<button type="button" id="totalchart" class="btn btn-primary" class="form-control">考勤总览表</button>
			</form>
		</div>
		</nav>
			
     	<!-- 各部门情况汇总表 -->
     	<!-- 汇总各个部门的表 -->
     	<!-- 用Echarts展现 -->
     	<!-- 表中的内容有全勤情况，迟到人数，早退人数汇总，根据各个部门汇总，增加一个查询接口
     		接口内容：
     			查询迟到最多的人员
     			查询迟到最少的人员
     			查询全勤的部门  	
    	 -->
<!--     	 根据时间查询 年月日 
    	 每个部门情况表   			每个岗位情况表 		总览表
    	 ^						^			  ^
    	 |						|			  |		
    	 每个部门正常打卡人数		每个岗位打卡人数		公司总体打卡情况
    	 每个部门缺勤人数		每个部门缺勤人数		公司总体缺勤人数
    	 每个部门迟到早退人数		每个部门迟到早退		公司迟到早退人数 -->
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<!--     
     -->
     <div class="row">
     	<div class="col-md-6" id="main1" style="width: 600px;height:400px;"></div>
		<div class="col-md-6" id="main2" style="width: 600px;height:400px;" ></div>
		<div class="col-md-6" id="main3" style="width: 600px;height:400px;" ></div>
		<div class="col-md-6" id="main4" style="width: 600px;height:400px;" ></div>
		<div class="col-md-6" id="main5" style="width: 600px;height:400px;" ></div>
		<div class="col-md-6" id="main6" style="width: 600px;height:400px;" ></div>
		<div class="col-md-12" id="main7" style="width: 600px;height:400px;" ></div>
     </div>
    </div>
</body>
</html>