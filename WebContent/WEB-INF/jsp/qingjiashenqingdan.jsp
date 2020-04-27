<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请假申请单</title>
<link rel="stylesheet" type="text/css" href="css/style3.css">
	<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<!-- 	<script type="text/javascript" src="js/js.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="js/qingjiadan.js"></script>
    <script type="text/javascript" src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/xlsx/0.14.2/xlsx.core.min.js"></script>
    
</head>
<body>
		<!-- 浏览请假申请单 -->
<div class="container-fluid">
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
<div id="toolbar">
<form class="form-inline">
  <div class="input-group mb-2 mr-sm-2">
    <div class="input-group-prepend">
      <div class="input-group-text">选择时间：</div>
    </div>
    <div class="btn-group">
    <input type="date" id="time" class="form-control">
	<select class="custom-select" id="classifyjiatiao">
			<option>-请选择-</option>
			<option value="person">个人假条</option>
			<option value="jiti">集体假条</option>
		</select>
	<button id="chaxunjiatiao" type="button" class="btn btn-info form-control"><span class="fa fa-search">浏览假条</span></button>
	</div>
  </div>
</form>
</div>		
		<!-- 假条需要实现哪些功能？
			   申请是否批准
			   	不予批准则回复内容，
			   	批准后也回复内容，但是根据请假情况
			   		考虑的问题：请假和考勤有什么关联呢？
				是否记入考勤管理中
					如：普通事假需要计入个人考勤管理中，病假公司会带薪休假
					如何计算在考勤管理中？直接跳转到手动记录到考勤管理中，算是正常上班
					普通假则需要按照缺勤计算，同样是手动记录
				集体事假则不记录缺勤所有员工手机上进行远程打卡
					开放一键打卡功能
					如何写一键打卡功能呢？设计思路如下：
					当部门写请假申请单的时候，后台会默认将请假单中的权限字段值写成“否”
					然后给部门请假表中的部门请假打卡权限改成“是”，默认是“否”
					部门请假单后台传来的值是部门的请假信息，部门表提交的数据是“否”，传到管理员端的时候，管理员点击同意后将请假权限
					改成“是”这样 “每个员工一键打卡功能则需要根据所在部门的ID和时间”查询部门请假单的权限，如果是请假权限变成是则可以一键打卡
					把本人的个人信息自动记录到考勤表上，如果否则直接Ajax提示打卡失败无权限
					但是权限是不可能一直开通的，根据请假天数关闭权限，
					根据请假天数管理员自己手动关闭，自动关闭还未想好
		 -->
		<div id="persondiv" style="display: none;">
		<table id="qingjiatable" style="table-layout:fixed;" class="table table-condensed table-hover table-bordered">
			<thead >
				<tr>
					<th data-field="state" data-checkbox='ture'></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>	
		</table>
		</div>
		<!-- 集体假条接口 -->
		<div id="jititable" style="display: none;">
		<table id="jitijiatable" style="table-layout:fixed;" class="table table-condensed table-hover table-bordered">
			<thead>
				<tr>
					<th data-field="state" data-checkbox='ture'></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>	
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td><!-- 可以进行修改 -->
				<td>同意</td>
				<td>不同意</td>
			</tr>
		</table>
		</div>
<!-- 		集体假条点击同意后则会开通对应部门的员工一键打卡权限
			-->
			<!-- 请假统计将记录到个人考勤中 
				点击同意后将每个人的考勤记录
			
			-->
	<!-- 个人假条模态框 -->
	<div class="modal fade bs-example" id="myModal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">详情信息</h4>
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
			<div class="modal-body">
	<form class="form-horizontal" role="form">
      <div class="form-group" id="temp">
      </div>
      <input id="linshiid" type="text" style="display: none;">
   </form>
			</div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default" id="butongyi" data-dismiss="modal">不同意 </button>
            <button type="button" id="tongyi" class="btn btn-primary btn-sm" data-dismiss="modal">同意</button>
         </div>
			
		</div>
	</div>
</div>
<!-- 是否删除模态框 -->
<div class="modal fade" id="deletemodal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content message_align">
                                        <div class="modal-header">
                                        <h6 class="modal-title">系统提示</h6>
                                            <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                                <span aria-hidden="true">×</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <!-- 隐藏需要删除的id -->
                                          <input type="text" id="temp1"style="display: none;">
                                            <p>是否删除该信息？</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default"
                                                data-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary"
                                                id="deletebtn">确认</button>
                                        </div>
                                    </div>
                                </div>
		 </div>
		 <!-- 集体假条模态框 -->
	<div class="modal fade bs-example" id="jitimodal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">详情信息</h4>
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
			<div class="modal-body">
	<form class="form-horizontal" role="form">
      <div class="form-group" id="jititemp">
      </div>
      <input id="jitilinshiid" type="text" style="display: none;">
   </form>
			</div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default" id="jitibutongyi" data-dismiss="modal">不同意 </button>
            <button type="button" id="jititongyi" class="btn btn-primary btn-sm" data-dismiss="modal">同意</button>
         </div>
			
		</div>
	</div>
</div>
<!-- 是否删除模态框 -->
<div class="modal fade" id="jitideletemodal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content message_align">
                                        <div class="modal-header">
                                        <h6 class="modal-title">系统提示</h6>
                                            <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                                <span aria-hidden="true">×</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <!-- 隐藏需要删除的id -->
                                          <input type="text" id="jititempdelete"style="display: none;">
                                            <p>是否删除该信息？</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default"
                                                data-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary"
                                                id="jitideletebtn">确认</button>
                                        </div>
                                    </div>
                                </div>
		 </div>
		 </div>
</body>
<!-- 删除按钮 -->
<script type="text/javascript">
	$(function(){
		$("#qingjiatable").on("click",":button",function(){
			var tempeid = $(this).closest("tr").find("td").eq(2).text();
			$("#temp1").val(id);
		})
		$("#deletebtn").click(function() {
				var eid = $("#temp1").val();
				window.location.href="deleteOneByeid.action?id="+id;
				$("#qingjiatable").bootstrapTable('refresh')
		})
		//集体假条删除按钮
		$("#jitijiatable").on("click",":button",function(){
			var tempid = $(this).closest("tr").find("td").eq(2).text();
			$("#jititempdelete").val(tempid);
		})
		$("#jitideletebtn").click(function() {
				var id = $("#jititempdelete").val();
				window.location.href="deleteOneByeid.action?id="+id;
				$("#jitijiatable").bootstrapTable('refresh')
		})
		document.onreadystatechange = function () {//即在加载的过程中执行下面的代码
			if(document.readyState=="complete"){//complete加载完成
				$(".loading").fadeOut();
			}
		}
	})
</script>
</html>