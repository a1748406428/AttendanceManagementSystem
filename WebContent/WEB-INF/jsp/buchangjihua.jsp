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
    <script type="text/javascript" src="js/buchangjihua.js"></script>
</head>
<script type="text/javascript">
	
</script>
<body>
<div class="container-fluid">
<div id="toolbar">
	<form class="form-inline">
  <div class="input-group mb-2 mr-sm-2">
    <div class="input-group-prepend">
      <div class="input-group-text">选择时间:</div>
    </div>
    <div class="btn-group">
    <input type="date" id="monthstart">--
	<input type="date" id="monthend">
	<button id="chaxunmsg" type="button" id="hzbtn" class="btn btn-info form-control"><span class="fa ">汇总奖惩</span></button>
	<select id="month" class="custom-select">
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
	<button  type="button" class="btn btn-info form-control" id="jcbtn"><span class="fa fa-search">查询奖惩情况</span></button>
	</div>
  </div>
</form>
</div>
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
<!-- 	<form class="form-horizontal" role="form">
      <div class="form-group" id="jianglitemp">
      		个人平均日薪:<input type="text" id="pingjunrixin" placeholder="单击获取值"><br>
      		加班天数:<input type="text" id="jiabantianshu"><br>
          	应得奖励:<input type="text" id="yingdejiangli">
          	
      </div>
   </form> -->
   	<form class="bs-example bs-example-form" role="form">
      <div class="input-group input-group">
      <span class="input-group-addon">平均日薪:</span>
        <input type="text" class="form-control" id="pingjunrixin" readonly="readonly">
      </div>
      <br>
      <div class="input-group">
      	 <span class="input-group-addon">加班天数:</span>
         <input type="text" class="form-control" id="jiabantianshu"  placeholder="加班天数">
      </div>
      <br>
      <div class="input-group">
         应得奖励:<input type="text" class="form-control" id="yingdejiangli" placeholder="应得奖励">
         <span class="input-group-addon"></span>
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
</html>