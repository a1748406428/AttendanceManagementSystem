<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="f" uri="/WEB-INF/tld/commons.tld" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="https://www.jq22.com/jquery/font-awesome.4.7.0.css">
<link rel="stylesheet" href="css/fontastic.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function selectall() {
		var sub = document.getElementById("selectAll")
		sub.submit();
	}
</script>
<body>
<div class="container-fluid">
	<nav class="navbar navbar-default" role="navigation">
	<form action="selectbycon.action" id="selectAll" role="form" class="form-inline">
		<div class="form-group">
		<label for="inputid">ID</label>
		<input type="text" name="id" id="inputid" class="form-control">
		<label for="inputname">姓名</label><input type="text" id="inputname" name="name" value="${employeeBean.name }" class="form-control">
		<label for="inputgonghao">工号</label><input type="text" id="inputgonghao" name="gonghao" class="form-control">
		<label for="inputbumen">部门号</label><input type="text" id="inputbumen" name="departid" class="form-control">&nbsp;&nbsp;
	<button type="button" class="btn btn-primary form-control" onclick="selectall()">条件查询</button>&nbsp;&nbsp;
	<button type="button" class="btn btn-primary form-control" onclick="selectall()">查询所有</button>
	</div>
	</form>
	</nav>
	<hr>
 <table class="table table-condensed table-hover table-bordered" id="tab">
  <thead>
  	<tr>
    <th>ID</th>
    <th>姓名</th>
    <th>工号</th>
    <th>学历</th>
    <th>性别</th>
    <th>年龄</th>
    <th>地址</th>
    <th>电话号码</th>
    <th>基础工资</th>
    <th>入职时间</th>
    <th>部门</th>
    <th>修改</th>
    <th>删除</th>
    </tr>
  </thead>
  <c:forEach items="${page.getRows()}" var="result">
  <tbody>
  <tr>
    <td >${result.getId() }</td>
    <td>${result.getName() }</td>
    <td>${result.gonghao }</td>
    <td>${result.education }</td>
    <td>${result.sex }</td>
    <td>${result.age }</td>
    <td>${result.address }</td>
    <td>${result.phone }</td>
    <td>${result.basesalary }</td>
    <td>${result.entrytime }</td>
    <td>${result.depname }</td>
    <td><button class="btn btn-info btn-sm" data-toggle="modal"  data-target="#myModal" >修改</button></td>
    <td><button class="btn btn-danger btn-sm" data-toggle="modal"  data-target="#deletemodal">删除</button></td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<div class="col-md-12 text-right" style="align-content: right: ;">
	<f:page url="${pageContext.request.contextPath}/selectbycon.action"></f:page>
</div>
<div class="modal fade bs-example-modal-lg" id="myModal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">修改员工基本信息</h4>
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
			<div class="modal-body">
	<form class="form-horizontal" role="form">
      <div class="form-group">
        <label for="temp" class="col-sm-2 control-label">员工编号：</label>
        <div class="col-sm-10">
        <input type="text" class="form-control" id="temp" disabled>
        </div>
      </div>
      <div class="form-group">
      	 <label for="empname" class="col-sm-2 control-label">员工姓名：</label>
      	 <div class="col-sm-10">
         <input type="text" class="form-control" id="empname" placeholder="姓名">
         </div>
      </div>
      <div class="form-group">
        <label for="empaddress" class="col-sm-2 control-label">住&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
        <div class="col-sm-10">
        <input type="text" class="form-control" placeholder="家庭住址" id="empaddress">
        </div>
      </div>
      <div class="form-group">
      <label for="empphone" class="col-sm-2 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</label>
      <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="联系电话" id="empphone">
      </div>
      </div>
      <div class="form-group">
      	 <label for="empbasesalary" class="col-sm-2 control-label">基础工资：</label>
      	 <div class="col-sm-10">
         <input type="text" class="form-control" placeholder="基础工资" id="empbasesalary">
         </div>
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
                                            <p>您确认要删除该员工吗？</p>
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
<script type="text/javascript">
	$(function() {
		$("#tab").on("click",":button",function(){
			var id = $(this).closest("tr").find("td").eq(0).text();
			$("#temp").val(id);
		})
		$("#changedep").click(function() {
			var id = $("#temp").val();
			var name = $("#empname").val();
			var address = $("#empaddress").val();
			var phone = $("#empphone").val();
			var basesalary = $("#empbasesalary").val();
			$.ajax(
				{
				url:"updateEmpById.action",
				type:"post",
				data:JSON.stringify({
					id:id,
					name:name,
					address:address,
					phone:phone,
					basesalary:basesalary
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
				window.location.href="deleteempById.action?id="+id;
		})
	})
</script>
<script>
   $(function () { 
	   $('#myModal').modal('hide')
	   });
   </script>
</html>