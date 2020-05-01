<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>人员调度</title>
	<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link rel="stylesheet" href="https://unpkg.zhimg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="js/messages_zh.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script src="https://unpkg.zhimg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="js/shoujianxiang.js"></script>
</head>

<script type="text/javascript">
	
</script>
<body>
	<div class="container-fluid">
	<nav class="nav nav-pills nav-fill navbar-expand-xs navbar-light bg-light btn-group" role="group">
	<!-- <div class="input-group mb-3 "> -->
	<!-- <div class="btn-group"> -->
	        <button type="button" id="shoujianxiangbtn" class="btn btn-secondary nav-item">岗位变动</button>
			<button type="button" id="resignappbtn" class="btn btn-secondary nav-item ">离职申请收件箱</button>
	       	<button type="button" id="tiaozhengbtn" class="btn btn-secondary nav-item">员工岗位调整</button>
			<button type="button" id="renwufenfabtn" class="btn btn-secondary nav-item">任务分发</button>
	<!-- </div> -->
	<!--  </div> -->
	</nav>
		<!-- 离职申请单 -->
		<div id="gangweixinxi" style="display:none" >
			<table id="resigntable" style="table-layout:fixed;" class="table table-condensed table-hover table-bordered">
				<thead style="table-layout:fixed">
				<tr>
					<th data-field="state" data-checkbox='ture'></th>
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
		<!-- 人员调度 -->
<div id="renyuandiaodu" style="display: none;">
<form action="updateGangWeiById.action" method="post" id="updatePostForm">
  <div class="form-row">
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="empid">员工ID</label>
      <input type="text" class="form-control" id="empid" name="id" readonly="readonly" placeholder="ID" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="validationDefault06">薪资：</label>
      <input type="text" class="form-control" id="validationDefault06" name="basesalary" placeholder="薪资" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="bumen">部门</label>
      <select id="bumen" class="custom-select" name="departid">
				<option value="">-请选择-</option>
				<option value="1">研发部</option>
				<option value="2">运营部</option>
				<option value="3">运维部</option>
				<option value="4">产品部</option>
				<option value="5">财务部</option>
				<option value="6">法务部</option>
			</select>
    </div>
    <div class="col-md-6 mb-3">
      <label for="gangwei">岗位</label>
      <select id="gangwei" class="custom-select" name="postid">
				<option value="">-选择岗位-</option>
			</select>
    </div>
  </div>
  <button class="btn btn-primary" id="updateDepPost" type="button">提交</button>
</form>
		</div>
		<!-- 查看收件箱 -->
		<div id="shoujianxiang">
<div id="toolbar">
 <form class="form-inline">
  <div class="input-group mb-2 mr-sm-2">
    <div class="input-group-prepend">
      <div class="input-group-text">选择时间：</div>
    </div>
    <div class="btn-group">
    <input type="date" id="time" class="form-control">
	<button id="chaxunmsg" type="button" class="btn btn-info "><span class="fa fa-search">查询</span></button>
	<button id="btn_edit" type="button" class="btn btn-info "><span class="fa fa-edit">批量修改</span></button>
	<button id="btn_delete" type="button" class="btn btn-danger "><span class="fa fa-trash">批量删除</span></button>
	</div>
  </div>
</form>
</div>
		<table id="table" style="table-layout:fixed;" class="table table-condensed table-hover table-bordered">
			<thead style="table-layout:fixed">
				<tr>
					<th data-field="state" data-checkbox='ture'></th>
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
		<!-- 任务分发 -->
		<div id="renwufenfa" style="display: none;">
				<div class="card border-danger">
					<div class="card-body">
					<form id="taskform" style="margin-left: 30%">
						<div class="form-row">
							<div class="col-md-6">
								<label for="departid">选择部门</label>
								<select id="departid" name="departid" class="form-control">
									<option value="">-请选择-</option>
									<option value="1">研发部</option>
									<option value="2">运营部</option>
									<option value="3">运维部</option>
									<option value="4">产品部</option>
									<option value="5">财务部</option>
									<option value="6">法务部</option>
								</select>
								
							</div>
							</div>
							<div class="form-row">
							<div class="col-md-6">
								<label for="content">任务内容</label>
								<textarea rows="5" cols="" id="content" name="content" class="form-control"></textarea>
							</div>
							</div>
							<div class="form-row">
								<div class="col-md-6">
									<label>截止时间</label>
									<input type="date" id="deadline" name="deadline" class="form-control">
								</div>
							</div><br>
							<input type="submit" class="btn btn-outline-success col-md-6">
					</form>
					</div>
				</div>
		</div>
			<!-- 模态框 -->
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
      <input id="linshieid" type="text" style="display: none;">
   </form>
			</div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default" id="butongyi" data-dismiss="modal">不同意 </button>
            <button type="button" id="tongyi" class="btn btn-primary btn-sm" data-dismiss="modal">同意</button>
         </div>
			
		</div>
	</div>
</div>
<!-- 离职申请模态框 -->
<div class="modal fade bs-example" id="lizhiModal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">详情信息</h4>
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
			<div class="modal-body">
	<form class="form-horizontal" role="form">
      <div class="form-group" id="lizhitemp">
      </div>
      <input id="lizhieid" type="text" style="display: none;">
   </form>
			</div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default" id="lizhibutongyi" data-dismiss="modal">不同意 </button>
            <button type="button" id="lizhitongyi" class="btn btn-primary btn-sm" data-dismiss="modal">同意</button>
         </div>
			
		</div>
	</div>
</div>
<!-- 是否删除模态框 -->
<div class="modal fade" id="lizhideletemodal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
</div>
</body>
<!-- 删除按钮 -->
<script type="text/javascript">
	$(function(){
		$("#table").on("click",":button",function(){
			var tempeid = $(this).closest("tr").find("td").eq(4).text();
			$("#temp1").val(id);
		})
		$("#deletebtn").click(function() {
				var eid = $("#temp1").val();
				window.location.href="deleteOneByeid.action?eid="+eid;
				$("#table").bootstrapTable('refresh')
		})
		//离职申请操作
		$("#resigntable").on("click",":button",function(){
			var tempeid = $(this).closest("tr").find("td").eq(5).text();
			$("#lizhieid").val(id);
		})
		$("#deletebtn").click(function() {
				var eid = $("#lizhieid").val();
				window.location.href="deleteMsgOneByeid.action?eid="+eid;
				$("#resigntable").bootstrapTable('refresh')
		})
	})
</script>
<script type="text/javascript">
	
</script>
</html>