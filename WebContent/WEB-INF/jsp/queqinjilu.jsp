<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手动记录</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/sdjl.js"></script>
</head>
<body>
	<div class="container">
		<div>
		<!-- 手动签到可能会面临一个极端问题是：如何判定该员工当天是否签到呢，即使签过到了
		但也是存在误会，或者系统故障，使该员工已经签到，但是该员工觉得没签到
		如果已经签过到了，岂不是重复了？
			在后端判定一下该员工，是否已经签过到了，如果该员工的id在当天已经出现在签到表中那么则不插入数据，否则插入数据
				--实现：在数据库中写一个存储函数在数据库中判定是否插入数据
		 -->
		<p><input type="text" placeholder="输入员ID" id="inputGongHao"></p>
		<button type="button" id="scanisattd">查看是否签到</button>
		<span id="isattd">haha</span>
		<!-- 利用ajax向后台添加数据 -->
			
				打卡日期:<input type="date" id="start"><br>
				上班打卡时间:<input type="text" id="shangbantime"><br>
				下班打卡时间:<input type="text" id="xiabantime"><br>
				 是否缺勤:<input type="radio" name="queqin" id="shi " value="是">是
				 <input type="radio" name="queqin" id="fou" value="否">否<br>
				员工ID:<input type="text" id="empid"><br>
				 所属岗位:<select name="gangwei" id="gangweiselect">
					<option value="1">Java研发</option>
					<option value="2">前端开发</option>
					<option value="3">大数据开发</option>
					<option value="4">C++工程师</option>
					<option value="5">系统性能优化</option>
					<option value="6">UI体验交互</option>
					<option value="7">产品推广</option>
					<option value="8">Linux运维</option>
					<option value="9">自动化运维</option>
					<option value="10">产品评测</option>
					<option value="11">初级会计</option>
					<option value="12">审计</option>
					<option value="13">财务助理</option>
					<option value="14">法务经理</option>
					<option value="15">法务助理</option>
				</select>
			
			<button type="button" id="jilu">提交</button>
			<span id="callback"></span>
		</div>
	</div>
	
</body>
</html>