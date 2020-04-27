<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>排班管理</title>
<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<!-- 	<script type="text/javascript" src="js/js.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-table-export.js"></script>
    <script type="text/javascript" src="js/tableExport.js"></script>
</head>
<body>
<div class="container-fluid">
<div id="tishi" style="background-color: rgb(57,56,54); border-radius: 2px;text-align: center;" >
<span style="color: white;">重要提示：</span><span style="color: white;">为了确保所有工资发放到位，计算工资前请前往奖惩管理中心，手动汇总各个员工的奖惩并审核!</span><a href="javascript:void(0)"><span style="color: white;float: right;" id="gb">关闭提示</span></a>
</div>
<form>
<div class="form-row">
<div class="col-md-2 form-control" style="background: rgb(222, 224, 226);">
选择月份浏览工资表:</div>
	<div class="col-md-2">
	<input type="month" class="form-control" id="selectmonth">
	</div>
	<div class="col-md-2">
	<button type="button" class="btn btn-outline-primary" id="browsesalary">浏览薪资表</button>	
	</div>
	<div class="col-md-2 form-control" style="background: rgb(222, 224, 226);">
	选择月份进行工资汇总:</div>
	<div class="col-md-2">
	<input type="month" class="form-control" id="sumsalary">
	</div>
	<div class="col-md-2">
	<button type="button" class="btn btn-outline-primary" id="sumsalarybtn">一键计算工资</button>
	<button type="button" class="btn btn-outline-danger" data-toggle="modal"  data-target="#deletemodal" >清空</button>
	</div>
	</div>
	</form>
	<hr>
	<span id="toolbar" style="display: inline-block">
                                 <select class="form-control">
                                     <option value="">导出当前页数据</option>
                                     <option value="all">导出全部数据</option>
                                   <option value="selected">导出选中数据</option>
                                 </select>
                                 </span>
	<table id="salaryscantable" style="table-layout:fixed;" class="table table-condensed table-hover table-bordered">
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
				</tr>
			</thead>	
		</table>
		<!-- 确认删除模态框 -->
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
                                            <p>您确定要清空工资详细表吗？</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default"
                                                data-dismiss="modal">取消</button>
                                            <button type="button" class="btn btn-primary"
                                              data-dismiss="modal" id="deletesalarybtn">确认</button>
                                        </div>
                                    </div>
                                </div>
		 </div>
	</div>
</body>
<script type="text/javascript">
	$(function () {
		today = new Date();
		month = today.getMonth()+1
		$("#month").html(month).css('color','green');
	})
</script>
<script type="text/javascript">
	$(function () {
		$("#sumsalarybtn").click(function() {
			var day = $("#sumsalary").val();
			tempday = new Date(day);
			var year = tempday.getFullYear();
			var month = tempday.getMonth()+1
			month = (tempday.getMonth()+1)<10?'0'+month:month;
			thedate = year+'/'+month;
			$.post('gzhz.action',{choosemonth:thedate},function(data,status){
				if(data=='200'){
					alert('提交成功')
				}
			})
		})
		$("#deletesalarybtn").click(function() {
			var day = $("#sumsalary").val();
			tempday = new Date(day);
			var year = tempday.getFullYear();
			var month = tempday.getMonth()+1
			month = (tempday.getMonth()+1)<10?'0'+month:month;
			thedate = year+'/'+month;
			$.post('deleteallsalary.action',{choosemonth:thedate},function(data,status){
				if(data=='200'){
					alert('删除成功')
				}
			})
		})
		$('#toolbar').find('select').change(function () {
			                 $.bootstrapTable("#salaryscantable").bootstrapTable('destroy').bootstrapTable({
			                     exportDataType: $(this).val()
			                 });
			            });
		$("#gb").click(function(){
			$("#tishi").hide();
		})
	})
</script>
<script type="text/javascript">
	$(function () {
		$("#browsesalary").click(function(){
			var date = $("#selectmonth").val();
			var tempdate = new Date(date);
			var year = tempdate.getFullYear();
			var month = (tempdate.getMonth()+1)<10?'0'+(tempdate.getMonth()+1):(tempdate.getMonth()+1);
			var time = year+'/'+month;
			$("#salaryscantable").bootstrapTable('destroy').bootstrapTable(
	                {	
	                    url : "scansalary.action",//数据请求路径
	                    clickToSelect : true,  //点击表格项即可选择
	                    dataType : "json",   //后端数据传递类型
	                    pageSize : 5,
	                    cache:"false",
	                    pageList : [5,10,20],
	                    contentType : "application/x-www-form-urlencoded",
	                    method : 'get',      //请求类型
	                    dataField : "data",  //很重要，这是后端返回的实体数据！ 
	                    sidePagination: "server",
	                    pagination: true,
	                    pageNumber:1,
	                    showToggle:true, 
	                    uniqueId: "id",
	                    search:true,
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
	                            time:time
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
	                            {field: 'postname',title : '岗位',align : 'center'},
	                            {field : 'month',title : '月份',align : 'center'},
	                            {field : 'totalsalary',title : '基本工资',align : 'center'},
	                            {field : 'jiabangongzi',title : '加班工资',align : 'center'},
	                            {field : 'tax',title : '应缴税收',align : 'center'},
	                            {title : '税后工资',field : 'endsalary',align : 'center'}],
	                });
		})
	})
</script>
</html>