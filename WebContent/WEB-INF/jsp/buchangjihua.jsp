<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>补偿计划</title>
	<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-table-zh-CN.min.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		function formatDate(date) {
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			m = m < 10 ? '0' + m : m;
			var d = date.getDate();
			d = d < 10 ? ('0' + d) : d;
			return y + '/' + m + '/' + d;
		}
		$("#hzbtn").click(function () {
			var monthstartbefore = $("#monthstart").val();
			var monthendbefore = $("#monthend").val();
			var monthstart = formatDate(new Date(monthstartbefore)).toString();
			var monthend = formatDate(new Date(monthendbefore)).toString();
			$.post("huizong.action",{monthstart:monthstart,monthend:monthend},function(data,status){
				if(data!=null){
					alert("汇总成功")
				}
			})
			}		
		)
		$("#jcbtn").click(function () {
			var month = parseInt($("#month").val());
			$("#jiangchengtable")
			.bootstrapTable('destroy')
			.bootstrapTable(
					{
						url : "selectjiangcheng.action",// 数据请求路径
						clickToSelect : true, // 点击表格项即可选择
						dataType : "json", // 后端数据传递类型
						pageSize : 5,
						cache : "false",
						pageList : [ 5, 10, 20 ],
						contentType : "application/x-www-form-urlencoded",
						method : 'get', // 请求类型
						dataField : "data", // 很重要，这是后端返回的实体数据！
						sidePagination : "server",
						pagination : true,
						pageNumber : 1,
						showToggle : true,
						uniqueId : "id",
						search : true,
						toolbar : "#toolbar",
						showColumns : true, // 是否显示所有的列
						showRefresh : true,
						clickToSelect : true,
						queryParamsType : 'limit',
						// 是否显示详细视图和列表视图的切换按钮
						queryParams : function(params) {// 自定义参数，这里的参数是传给后台的，我这是是分页用的
							return {// 这里的params是table提供的
								offset : params.offset,// 从数据库第几条记录开始
								limit : params.limit, // 找多少条
								month : month
							};
						},
						responseHandler : function(res) {
							// 在ajax获取到数据，渲染表格之前，修改数据源
							return res;
						},
						columns : [
								{
									field : 'state'
								},
								{
									field : 'id',
									title : '序号',
									align : 'center'
								},
								{
									field : 'ename',
									title : '姓名',
									align : 'center'
								},
								{
									field : 'reason',
									title : '请假原因',
									align : 'center'
								},
								{
									field : 'totalday',
									title : '加班天数',
									align : 'center'
								},
								{
									field : 'jiangli',
									title : '应得奖励',
									align : 'center'
								},
								{
									field : 'status',
									title : '状态',
									align : 'center',
									formatter : function(
											value, row,
											index) {
										var a = "";
										if (value == "未审核") {
											a = "<span style='color:#fa9f00'>"
													+ value
													+ "</span>";
										} else if (value == "已审核") {
											a = "<span style='color:#3e8f3e'><i class='fa fa-times-circle-o' aria-hidden='true'></i>"
													+ value
													+ "</span>";
										} 
										return a;
									}
								},
								{
									field : 'month',
									title : '月份',
									align : 'center'
								},
								{
									field : 'eid',
									title : '员工编号',
									align : 'center'
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(
											value, row,
											index) {
										var a = "<button type='button' class = 'btn btn-info btn-sm' data-toggle='modal' data-target='#jianglimodal' id='detail'><span class='fa fa-plus'>详情</span></button>"
										return a;
									}
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(
											value, row,
											index) {
										var b = "<button type='button' class = 'btn btn-danger btn-sm' data-toggle='modal' data-target='#jianglideletemodal' id='delete'><span class='fa fa-trash'>删除</span></button>"
										return b;
									}
								},

						]
					});
		}) 
	})
</script>
<body>
<div class="container-fluid">
	员工编号<input>
	<form action="">
	请选择时间段：<input type="date" id="monthstart">to
	<input type="date" id="monthend">
	<button type="button" id="hzbtn">一键汇总员工奖惩</button>
	<select id="month">
		<option value="">-选择月份-</option>
		<option value="1">一月</option>
		<option value="2">二月</option>
		<option value="3">三月</option>
		<option value="4">四月</option>
		<option value="5">五月</option>
		<option value="6">六月</option>
		<option value="7">七月</option>
		<option value="8">八月</option>
		<option value="9">九月</option>
		<option value="10">十月</option>
		<option value="11">十一月</option>
		<option value="12">十二月</option>
	</select>
	<button type="button" id="jcbtn">查看员工奖惩情况</button>
	</form>
	<table id="jiangchengtable">
		<thead>
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
	<div class="modal fade bs-example" id="jianglimodal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">详情信息</h4>
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button></div>
			<div class="modal-body">
	<form class="form-horizontal" role="form">
      <div class="form-group" id="jianglitemp">
      		个人平均日薪:<input type="text" id="pingjunrixin" placeholder="单击获取值"><br>
      		加班天数:<input type="text" id="jiabantianshu"><br>
          	应得奖励:<input type="text" id="yingdejiangli">
      </div>
      <input id="jianglilinshiid" type="text" style="display: none;">
      <input id="jianglirowid" type="text" style="display: none;">
   </form>
			</div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default" id="jianglibutongyi" data-dismiss="modal">取消 </button>
            <button type="button" id="jianglitongyi" class="btn btn-primary btn-sm" data-dismiss="modal">提交</button>
         </div>
			
		</div>
	</div>
</div>
<!-- 是否删除模态框 -->
<div class="modal fade" id="jianglideletemodal" tabindex = "-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
<script type="text/javascript">
//模态框操作
$("#jiangchengtable").on("click", ":button", function() {
	var tempeid = $(this).closest("tr").find("td").eq(8).text();
	var jiabantianshu = $(this).closest("tr").find("td").eq(4).text();
	var rowid = $(this).closest("tr").find("td").eq(1).text();
	$("#jianglilinshiid").val(tempeid);
	$("#jiabantianshu").val(jiabantianshu);
	$("#jianglirowid").val(rowid);
})
$("#pingjunrixin").mousedown(function () {
	var id = $("#jianglilinshiid").val();
	var jiabantianshu = $("#jiabantianshu").val();

	$.post("caculatormoney.action",{id:id,jiabantianshu:jiabantianshu},function(data,status){
		if(data!=null){
			$("#pingjunrixin").val(data.avgDailySal);
			$("#yingdejiangli").val(data.jiangli);
		}
	})
})
$("#jianglitongyi").click(function() {
	var id = $("#jianglirowid").val();
	var yingdejiangli = $("#yingdejiangli").val();
	$.post("jianglishenhe.action", {id:id,status:"已审核",yingdejiangli:yingdejiangli},function(data, status) {
		if(data=="200") {
			$("#jiangchengtable").bootstrapTable('refresh');
			$("#pingjunrixin").val("");
			$("#yingdejiangli").val("");
		}
	})
})

$("#jianglibutongyi").click(function() {
	$("#pingjunrixin").val("");
	$("#yingdejiangli").val("");
})
</script>
</html>