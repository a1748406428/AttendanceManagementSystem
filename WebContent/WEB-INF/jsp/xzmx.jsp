<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>xzck</title>
	<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	</head>
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<body>
	<div class="container">
	<c:forEach items="${empsalary}" var="result" begin="0" varStatus="status">
	<div class="card">
    <div class="card-header" id="headingOnecollapseOne${status.index}">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne${status.index}" aria-expanded="false" aria-controls="collapseOne${status.index}">
         	 通知时间：${result.getMonth()}
        </button>
      </h5>
    </div>
    <div id="collapseOne${status.index}" class="collapse hide" aria-labelledby="headingOnecollapseOne${status.index}">
      <div class="card-body">
      			姓名:${result.getName()}<br>
				月份:${result.getMonth()}<br>
				基础工资:${result.getTotalsalary()}<br>
				加班工资:${result.getJiabangongzi()}<br>
				个人所得税:${result.getTax()}<br>
				最终工资:${result.getEndsalary()}
      </div>
    </div>
  </div>
  </c:forEach>
</div>
</body>
</html>