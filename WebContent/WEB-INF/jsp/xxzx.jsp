<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>消息中心</title>
		<link rel="stylesheet" href="css/bootstrap.css">
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入-->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	</head>
	<link rel="stylesheet" href="css/sys.css"/>
	<body>
	<div class="container-fluid">
	<div>
		<ul>
			<li><a href="xxzx.action">广播通知</a></li>
			<li><a href="privatenotice.action?gonghao=${GONG_HAO}">私信消息</a></li>
		</ul>
		<hr>
	</div>
	<c:forEach items="${personNotice}" var="result" begin="0" varStatus="status">
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
      ${result.getContent()}
      </div>
    </div>
  </div>
	</c:forEach>
	</div>
	</body>
	
</html>
