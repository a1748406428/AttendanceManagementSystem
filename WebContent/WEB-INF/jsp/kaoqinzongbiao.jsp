<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考勤总表</title>
<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"><!--  integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous" -->
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.css">
	<script type="text/javascript" src= "https://code.jquery.com/jquery-3.3.1.min.js"></script> <!--  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous" -->
<!-- 	<script type="text/javascript" src="js/js.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" ></script> <!-- integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous" -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" ></script> <!-- integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous" -->
    <script src="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-table-export.js"></script>
    <script type="text/javascript" src="js/tableExport.js"></script>
</head>
<script type="text/javascript" src="js/jquery.nicescroll.js"></script>
<body id="content">
<div class="container-fluid">
	<span id="toolbar">
	<form class="form-inline">
		<div class="form-control" style="background: rgb(222, 224, 226);">选择时间:</div>
		<input type="month" class="form-control" id="time"><span class="form-control" style="color: red">岗位、部门条件请选其一</span>
		<div class="form-control" style="background: rgb(222, 224, 226);">选择部门:</div>
		<select id="departselect" class="custom-select">
				<option value="">所属部门</option>
				<option value="1">研发部</option>
				<option value="2">运营部</option>
				<option value="3">运维部</option>
				<option value="4">产品部</option>
				<option value="5">财务部</option>
				<option value="6">法务部</option>
			</select>&nbsp;&nbsp;&nbsp;
		<div class="form-control" style="background: rgb(222, 224, 226);">选择岗位:</div>
		<select id="postselect" class="custom-select">
			<option value="">-请选择-</option>
			<option value="1">Java研发</option>
			<option value="2">前端开发</option>
			<option value="3">大数据开发</option>
			<option value="4">C++开发</option>
			<option value="5">系统性能优化</option>
			<option value="6">UI交互</option>
			<option value="7">产品推广</option>
			<option value="8">Linux运维</option>
			<option value="9">自动化运维</option>
			<option value="10">产品评测</option>
			<option value="11">初级会计</option>
			<option value="12">审计</option>
			<option value="13">财务助理</option>
			<option value="14">法务助理</option>
			<option value="15">法务经理</option>
		</select>&nbsp;&nbsp;&nbsp;
		<button type="button" class="btn btn-outline-primary" id="selectkaoqin">查询</button>
		</form>
	</span>
	<table id="kaoqintable" style="table-layout:fixed;" class="table table-condensed table-hover table-bordered">
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
				</tr>
			</thead>	
		</table>
</div>

</body>
<script type="text/javascript">
	$(function () {
		$("#selectkaoqin").click(function () {
			var depart = $("#departselect").val();
			var post = $("#postselect").val();
			var date = $("#time").val();
			var tempdate = new Date(date);
			var year = tempdate.getFullYear();
			var month = (tempdate.getMonth()+1)<10?'0'+(tempdate.getMonth()+1):(tempdate.getMonth()+1);
			var time = year+'/'+month;
			var departid = $("#departselect").val();
			var postid = $("#postselect").val();
			$("#kaoqintable").bootstrapTable("destroy").bootstrapTable(
	                {	
	                    url : "scankaoqinzongbiao.action",//数据请求路径
	                    clickToSelect : true,  //点击表格项即可选择
	                    dataType : "json",   //后端数据传递类型
	                    pageSize : 10,
	                    cache:"false",
	                    pageList : [5,10,20],
	                    contentType : "application/x-www-form-urlencoded",
	                    method : 'get',      //请求类型
	                    dataField : "data",  //很重要，这是后端返回的实体数据！ 
	                    sidePagination: "server",
	                    pagination: true,
	                    fixedColumns: true, 
	                    fixedNumber: 1, //固定列数
	                    pageNumber:1,
	                    showToggle:true, 
	                    uniqueId: "id",
	                    toolbar:"#toolbar",
	                    showColumns: true,                  //是否显示所有的列
	                    showRefresh: true,
	                    showExport: true,
	                    exportDataType: "basic",
	                    showPrint:true,
	                    clickToSelect: true, 
	                    queryParamsType:'limit',
	                    //是否显示详细视图和列表视图的切换按钮
	                     queryParams : function(params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的  
	                        return {//这里的params是table提供的  
	                            offset : params.offset,//从数据库第几条记录开始  
	                            limit : params.limit, //找多少条 
	                            time:time,           //时间
	                            departid:departid,  //部门id
	                            postid:postid      //岗位id
	                        };
	                    },  
	                     responseHandler : function(res) {
	                        //在ajax获取到数据，渲染表格之前，修改数据源
	                        return res;
	                    }, 
	                    columns : [
	                            {field : 'state'},
	                            {field:'id',title:'序号', align:'center'},
	                            {field : 'name',title : '姓名',align : 'center'},
	                            {field: 'checktime',title : '打卡日期',align : 'center'},
	                            {field : 'startcheck',title : '上班打卡时间',align : 'center'},
	                            {field : 'endcheck',title : '下班打卡时间',align : 'center'},
	                            {field : 'absence',title : '是否缺勤',align : 'center'},
	                            {field : 'departname',title : '部门',align : 'center'},
	                            {field : 'postname',title : '岗位',align : 'center'}]
	                });
			$("#content").niceScroll({
			    cursorcolor: "rgb(110, 110, 109)", //滚动条的颜色   
			    cursoropacitymax: 1, //滚动条的透明度，从0-1   
			    touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备   
			    cursorwidth: "8px", //滚动条的宽度   
			    cursorborder: "0", // 游标边框css定义    
			    cursorborderradius: "5px", //以像素为光标边界半径  圆角   
			    autohidemode: false, //是否隐藏滚动条  true的时候默认不显示滚动条，当鼠标经过的时候显示滚动条   
			    zindex: "auto", //给滚动条设置z-index值    
			    railpadding: {
			        top: 0,
			        right: -4,
			        left: 0,
			        bottom: 0
			    }, //滚动条的位置
			});
		});
		
	})
</script>

</html>