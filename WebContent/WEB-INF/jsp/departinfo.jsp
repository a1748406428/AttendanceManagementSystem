<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="f" uri="/WEB-INF/tld/commons.tld" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门信息</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</head>
<script type="text/javascript">
$(function() {
	$("#chaxun").click(function() {
		$("#tijiao").submit();
	});
})
	
</script>
<body>
<div class="container-fluid">
	<form action="selectdep.action" id="tijiao" class="form-inline">
		
		<label>部门名称：</label>
		<input class="form-control" type="text" name="name" value="${departPageBan.name}">
		<button type="button" id="chaxun" class="btn btn-primary">查询</button>
		<button type="button" data-toggle="modal"  data-target="#insertDep" class="btn btn-primary">添加部门</button>
	</form>
	<table class="table table-condensed table-hover table-bordered" id="tab">
		<thead>
			<tr>
				<th>ID</th>
				<th>部门名称</th>
				<th>办公地点</th>
				<th>绩效</th>
				<th>福利待遇</th>
				<th>操作一</th>
				<th>操作二</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.getRows()}" var="results">
			<tr>
				<td>${results.getId()}</td>
				<td>${results.getName()}</td>
				<td>${results.getOfficelocal()}</td>
				<td>${results.getPerformance()}</td>
				<td>${results.getFuli()}</td>
				<td><button class="btn btn-info btn-sm" data-toggle="modal"  data-target="#myModal" >修改</button></td>
				<td><button class="btn btn-danger btn-sm" data-toggle="modal"  data-target="#deletemodal">删除</button></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="col-md-12 text-right">
	<f:page url="${pageContext.request.contextPath}/selectdep.action"></f:page>
</div>
<div class="modal fade" id="myModal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">修改部门信息</h4>
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
			<div class="modal-body">
	<form class="bs-example bs-example-form" role="form">
      <div class="input-group input-group">
      <span class="input-group-addon"> 部门编号：</span>
        <input type="text" class="form-control" id="temp" readonly="readonly">
      </div>
      <br>
      <div class="input-group">
      	 <span class="input-group-addon">部门名称：</span>
         <input type="text" class="form-control" placeholder="部门名称">
      </div>
      <br>
      <div class="input-group">
         办公地点：<input type="text" class="form-control" placeholder="办公地点">
         <span class="input-group-addon"></span>
      </div>
      <br>
      <div class="input-group">
         绩效考核：<input type="text" class="form-control" placeholder="绩效考核">
         <span class="input-group-addon"></span>
      </div><br>
      <div class="input-group">
         部门福利：<input type="text" class="form-control" placeholder="部门福利">
         <span class="input-group-addon"></span>
      </div>
   </form>
			</div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button>
            <button type="button" id="changedep" class="btn btn-primary btn-sm">提交更改</button>
         </div>
			
		</div>
	</div>
</div>
<!-- 添加部门模态框 -->
<div class="modal fade" id="insertDep" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">添加部门</h4>
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
			<div class="modal-body">
	<form class="bs-example bs-example-form" role="form">
      <div class="input-group">
      	 <span class="input-group-addon">部门名称：</span>
         <input type="text" class="form-control" placeholder="部门名称">
      </div>
      <br>
      <div class="input-group">
         办公地点：<input type="text" class="form-control" placeholder="办公地点">
         <span class="input-group-addon"></span>
      </div>
      <br>
      <div class="input-group">
         绩效考核：<input type="text" class="form-control" placeholder="绩效考核">
         <span class="input-group-addon"></span>
      </div><br>
      <div class="input-group">
         部门福利：<input type="text" class="form-control" placeholder="部门福利">
         <span class="input-group-addon"></span>
      </div>
   </form>
			</div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button>
            <button type="button" id="insertbtn" class="btn btn-primary btn-sm">添加</button>
         </div>
			
		</div>
	</div>
</div>
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
                                            <p>您确认要删除该部门吗？</p>
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
	<!-- 公司部门表
		--部门id 部门名称 部门位置 考核情况 部门福利 
	功能：修改部门信息
			模态框修改
			修改办公位置 部门福利 考核情况 部门福利
		 成员信息，根据部门号查询员工的信息
		 -->
<script type="text/javascript">
	$(function() {
		$("#tab").on("click",":button",function(){
			var id = $(this).closest("tr").find("td").eq(0).text();
			$("#temp").val(id);
		})
		$("#changedep").click(function() {
			var id = $("#temp").val();
			var name = $("#depname").val();
			var officelocal = $("#deplocal").val();
			var performance = $("#jixiaokaohe").val();
			var fuli = $("#bumenfuli").val();
			$.ajax(
				{
				url:"deleteEmpById.action",
				type:"post",
				data:JSON.stringify({
					id:id,
					name:name,
					officelocal:officelocal,
					performance:performance,
					fuli:fuli
				}),
				contentType:"application/json;charset=UTF-8",
				success:function(data){
					if(data!=null){
						alert("修改成功")
					}
				}
			})
		})
	})
</script>
<!-- 删除按钮 -->
<script type="text/javascript">
	$(function(){
		$("#tab").on("click",":button",function(){
			var id = $(this).closest("tr").find("td").eq(0).text();
			$("#temp1").val(id);
		})
		$("#deletebtn").click(function() {
				var id = $("#temp1").val();
				window.location.href="deleteById.action?id="+id;
		})
	})
</script>
<!-- 添加部门信息 -->
<script type="text/javascript">
	$(function() {
		$("#insertbtn").click(function() {
			var name = $("#depname").val();
			var officelocal = $("#deplocal").val();
			var performance = $("#jixiaokaohe").val();
			var fuli = $("#bumenfuli").val();
			$.ajax(
				{
				url:"deleteEmpById.action",
				type:"post",
				data:JSON.stringify({
					name:name,
					officelocal:officelocal,
					performance:performance,
					fuli:fuli
				}),
				contentType:"application/json;charset=UTF-8",
				success:function(data){
					if(data!=null){
						alert("修改成功")
					}
				}
			})
		})
	})
</script>
<script>
   $(function () { 
	   $('#myModal').modal('hide')
	   });
   </script>
</html>