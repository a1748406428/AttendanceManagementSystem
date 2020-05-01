<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tasks</title>
</head>
<link rel="stylesheet" href="css/bootstrap.css">
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入-->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<body>
任务中心
<c:forEach items="${task}" var="result" begin="0" varStatus="status">
	<div class="card">
    <div class="card-header" id="headingOnecollapseOne${status.index}">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne${status.index}" aria-expanded="false" aria-controls="collapseOne${status.index}">
         	 通知时间：${result.getDaytime()}
        </button>
      </h5>
    </div>
    <div id="collapseOne${status.index}" class="collapse hide" aria-labelledby="headingOnecollapseOne${status.index}" data-parent="#accordion">
      <div class="card-body">
      	任务编号:${result.getId()}<br>
      	任务内容:${result.getContent()}<br>
     	截止日期:${result.getDeadline()}<br>
     	任务状态:${result.getProgress()}<br>
     	<input type="radio" name="progressd" value="100%">100%
     	<input type="radio" name="progressd" value="90%">90%
     	<input type="radio" name="progressd" value="80%">80%
     	<input type="radio" name="progressd" value="50%">50%
     	<a id="pro" href="#">更新任务状态</a>
      </div>
    </div>
  </div>
<script type="text/javascript">
	$(function(){
		$("#pro").click(function () {
			var temp = $("input[name='progressd']:checked").val();
			var id = '${result.getId()}'
			$.post('updateprogress.action',{id:id,progress:temp},function(data,status){
				alert('修改成功')
			})
		})
	})
</script>
	</c:forEach>
</body>
</html>