<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="f" uri="/WEB-INF/tld/commons.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>人员调度</title>
	<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.js"></script>
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
	        <button type="button" id="shoujianxiangbtn" class="btn btn-secondary nav-item">收件箱</button>
			<button type="button" id="gangweibtn" class="btn btn-secondary nav-item ">部门岗位信息</button>
	       	<button type="button" id="tiaozhengbtn" class="btn btn-secondary nav-item">员工岗位调整</button>
			<button type="button" id="renwufenfabtn" class="btn btn-secondary nav-item">任务分发</button>
	<!-- </div> -->
	<!--  </div> -->
	</nav>
		<!-- 如果点击同意后将会弹出模态框，在模态框中进行修改，修改完成后，将状态改成已处理 -->
		<!-- 部门岗位信息 -->
		<div id="gangweixinxi" style="display:none" >
			岗位信息
			<select>
				<option value="">所属部门</option>
				<option value="1">研发部</option>
				<option value="2">运营部</option>
				<option value="3">运维部</option>
				<option value="4">产品部</option>
				<option value="5">财务部</option>
				<option value="6">法务部</option>
			</select>
			<select>
				<option>按人数大小排序</option>
				<option>升序</option>
				<option>降序</option>
			</select>
			<button type="button">提交</button>
			<table id="depinfotable" style="table-layout:fixed;" class="table table-condensed table-hover table-bordered"></table>
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
		<!-- 产看收件箱 -->
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
			选择部门
			截止时间
			任务内容
			
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
</div>
</body>
<!-- 部门联动效果 -->
<script type="text/javascript">
	$(function(){
		$("#bumen").change(function(){
		    var did = $("#bumen").val();
		    $.ajax({
		    	url:"bumenliandong.action",
				type:"post",
				dataType:"json",
				data:JSON.stringify({did:did}),
				contentType:"application/json;charset=UTF-8",
				success:function(data){
					$("#gangwei").html("<option value='' >-请选择-");
					 $(data).each(function(index,c){
					        $("#gangwei").append("<option value="+c.id+" >"+c.name);
					      });
				}
		    })
		  });
		$("#updateDepPost").click(function() {
			$("#updatePostForm").submit();
		})
	})
</script>
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
	})
</script>
</html>