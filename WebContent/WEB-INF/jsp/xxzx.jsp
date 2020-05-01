<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>消息中心</title>
		<link rel="stylesheet" href="css/bootstrap.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="js/mousescroll.js"></script>
	</head>
	<body>
	<div class="container">
	<div>
		<ul>
			<li><a href="xxzx.action">广播通知</a></li>
			<li><a href="privatenotice.action?gonghao=${GONG_HAO}">私信消息</a></li>
		</ul>
		<hr>
		
	<div id="scrolllayout">
		<c:forEach items="${personNotice}" var="result" begin="0" varStatus="status">
	<div class="card">
    <div class="card-header" id="headingOnecollapseOne${status.index}">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne${status.index}" aria-expanded="false" aria-controls="collapseOne${status.index}">
         	 通知时间：${result.getDaytime()}
        </button>
        	<span id="setweidu${status.index}" style="color: green;display: none;"><font size="2.5" >已读</font></span>
        	<span id="statu${status.index}" ><font size="2.5">${result.getStatus()}</font></span>
         	<span style="float: right"><button class="btn btn-outline-success" id="yidubtn${status.index}">标记为已读</button></span>
         	<span style="float: right"><button class="btn btn-danger" id="deletebtn${status.index}">删除</button></span>
      </h5>
    </div>
    <div id="collapseOne${status.index}" class="collapse hide" aria-labelledby="headingOnecollapseOne${status.index}" data-parent="#accordion">
      <div class="card-body">
      	内容:${result.getContent()}<br>
     	 编号:${result.getId()}
      </div>
    </div>
  </div>
  <script type="text/javascript">
		$(function(){
			$("#yidubtn${status.index}").click(function(){
				var id = "${result.getId()}";
				$.post("updatemsgStatus.action",{status:"已读",id:id},function (data,status){
					if(data!=null){
						$("#setweidu${status.index}").show()
						$("#statu${status.index}").hide();
						}
				})
				
			})
			$("#deletebtn${status.index}").click(function(){
				$("#headingOnecollapseOne${status.index}").hide();
			})
		})
	</script>
	</c:forEach>
	</div>
	</div>
	</div>
	</body>
	
</html>
