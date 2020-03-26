<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>人员调度</title>
</head>

<body>
	<div class="container">
	<button type="button">查看收件箱</button>
		<table>
			<thead>
				<tr>
					<th>发件人</th>
					<th>时间</th>
					<th>内容</th>
					<th>操作1</th>
					<th>操作2</th>
					<th>状态</th>
					<th>id</th>
				</tr>
			</thead>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>同意</td>
				<td>不同意</td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<!-- 如果点击同意后将会弹出模态框，在模态框中进行修改，修改完成后，将状态改成已处理 -->
	</div>
</body>

</html>