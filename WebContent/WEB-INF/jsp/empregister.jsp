<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	$(function () {
		$("#changeshense").click(function () {
			$("#cardbody").attr('class','card-body bg-dark mb-3 text-white')
			$(".card-header").attr('class','card-header bg-dark mb-3 text-center text-white')
			$("#changeyuan").show();
			$("#changeshense").hide();
		})
		$("#changeyuan").click(function () {
			$("#changeshense").show();
			$("#changeyuan").hide();
			$("#cardbody").attr('class','card-body bg-light mb-3 text-info')
			$(".card-header").attr('class','card-header bg-info mb-3 text-center')
		})
	})
</script>
<body id="content">

<div class="container-fluid" >
<div class="card border-success" >
<div class="card-header bg-info mb-3 text-center">
	员工注册
	<button type="button" class="btn btn-dark btn-sm" id="changeshense" style="float: right;">切换深色模式</button>
	<button type="button" class="btn btn-info btn-sm" id="changeyuan" style="float: right; display: none;">切换至原模式</button>
</div>
<div class="card-body bg-light mb-3 text-info" id="cardbody">
<form id="registerForm" style="margin-left: 26%">
<div class="form-row">
	<div class="col-md-4">
	<label for="name">姓名</label>
    <input class="form-control" type="text" id="name" name="name" autofocus="autofocus">
    </div>
    <div class="col-md-4">
	<label for="age">年龄：</label>
    <input type="text" id="age" name="age" class="form-control">
    </div>
</div>
<br>
<div class="form-row">
 <div class="col-md-4">
      <label for="bumen">部门</label>
      <select id="bumen" name="departid" class="form-control">
				<option value="">-请选择-</option>
				<option value="1">研发部</option>
				<option value="2">运营部</option>
				<option value="3">运维部</option>
				<option value="4">产品部</option>
				<option value="5">财务部</option>
				<option value="6">法务部</option>
			</select>
</div>
    <div class="col-md-4">
      <label for="gangwei">岗位</label>
      <select id="gangwei" name="postid" class="form-control">
				<option value="">-选择岗位-</option>
			</select>
    </div>
</div>
  <br>
<div class="form-row">
	<div class="col-md-4">
    <label for="xueli">学历：</label>
    <select id="xueli" name="eduction" class="form-control">
    	<option value="">-请选择-</option>
    	<option value="MBA">MBA</option>
    	<option value="博士">博士</option>
    	<option value="硕士">硕士</option>
    	<option value="本科">本科</option>
    	<option value="专科">专科</option>
    	<option value="高中">高中</option>
    	<option value="其他">其他</option>
    </select>
    </div>
    <div class="col-md-4">
    <label for="gonghao">工号：</label>
    <input class="form-control" type="text" name="gonghao" id="gonghao" placeholder="选择部门自动填充">
    </div>
</div>
<br>
<div class="form-row">
<div class=" col-md-2 custom-control custom-control-inline">
	性别:</div>
  <div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="nan" value="男" name="sex" class="custom-control-input">
  <label class="custom-control-label" for="nan">男</label>
</div>
<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="nv" name="sex" value="女" class="custom-control-input">
  <label class="custom-control-label" for="nv">女</label>
</div>
</div>
<br>
<div class="form-row">
  <div class="col-md-3">
  <label>省份:</label>
  <select id="province" class="form-control">
			<option value="">-请选择-</option>
			<option value="1">江苏省</option>
			<option value="2">浙江省</option>
			<option value="3">安徽省</option>
			<option value="4">山东省</option>
		</select>
		</div>
		<div class="col-md-2">
		<label>市:</label>
		<select id="city" name="city" class="form-control">
			<option value="">-请选择-</option>
		</select>
		</div>
		<div class="col-md-3">
		<label>区/县:</label>
		<select id="town" name="town" class="form-control">
			<option value="">-请选择-</option>
		</select>
		</div>
</div>
<br>
  <div class="form-row">
  <div class="col-md-8">
  <label>详细住址</label>
  <textarea rows="5" cols="40" class="form-control" id="detailed"></textarea>
  </div>
</div>
<br>
<div class="form-row">
<div class="col-md-3">
    <label>电话号码</label>
    <input type="text" id="phone" name="phone" class="form-control">
</div>
<div class="col-md-2">
    <label>基础工资</label>
    <input type="text" id="basesalary" name="basesalary" class="form-control">
</div>
<div class="col-md-3">
   <label>入职时间</label>
    <input type="date" id="entrytime" name="entrytime" class="form-control">
</div>
</div>
 <br>
 
  <div class="form-row">
  <div class="col-md-2">
  <label for="selectguanliorjishu">职位类型</label>
 <select id="selectguanliorjishu" class="form-control">
 	<option value="1">技术层</option>
 	<option value="2">管理层</option>
 </select>
 </div>
 <div class="col-md-2">
 <label>等级</label>
 <select id="jishu" class="form-control">
 	<option>-请选择-</option>
 	<option value="P1">P1</option>
 	<option value="P2">P2</option>
 	<option value="P3">P3</option>
 	<option value="P4">P4</option>
 	<option value="P5">P5</option>
 	<option value="P6">P6</option>
 	<option value="P7">P7</option>
 	<option value="P8">P8</option>
 	<option value="P9">P9</option>
 </select>
  <select id="guanli" class="form-control" style="display: none;">
  	<option>-请选择-</option>
 	<option value="M1">M1</option>
 	<option value="M2">M2</option>
 	<option value="M3">M3</option>
 	<option value="M4">M4</option>
 	<option value="M5">M5</option>
 	<option value="M6">M6</option>
 	<option value="M7">M7</option>
 	<option value="M8">M8</option>
 	<option value="M9">M9</option>
 	<option value="M10">M10</option>
 </select>
 </div>
 <div class="col-md-4">
 <label for="zhengzhimianmao">政治面貌</label>
 <select id="zhengzhimianmao" class="form-control">
 	<option>-请选择-</option>
 	<option value="普通民众">普通民众</option>
 	<option value="团员">团员</option>
 	<option value="党员">党员</option>
 </select>
 </div>
 </div>
 <br>
<input type="submit" id="registerbtn" class="btn btn-outline-success col-md-8" value="提交">
</form>
</div>
</div>
</div>
<script type="text/javascript" src="js/jquery.nicescroll.js"></script>
<script type="text/javascript">
		$(function () {
			$("body").niceScroll({
			    cursorcolor: "rgb(110, 110, 109)", //滚动条的颜色   
			    cursoropacitymax: 1, //滚动条的透明度，从0-1   
			    touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备   
			    cursorwidth: "8px", //滚动条的宽度   
			    cursorborder: "0", // 游标边框css定义    
			    cursorborderradius: "5px", //以像素为光标边界半径  圆角   
			    autohidemode: true, //是否隐藏滚动条  true的时候默认不显示滚动条，当鼠标经过的时候显示滚动条   
			    zindex: "auto", //给滚动条设置z-index值    
			    railpadding: {
			        top: 0,
			        right: -4,
			        left: 0,
			        bottom: 0
			    }, //滚动条的位置
			});
		})
</script>
</body>
<script type="text/javascript">
	$(function () {
		$("#selectguanliorjishu").change(function () {
			var id = $("#selectguanliorjishu").val();
			if(id==1){
				$("#jishu").show();
				$("#guanli").hide();
			}else if(id==2){
				$("#guanli").show();
				$("#jishu").hide();
			}
		})
		$("#province").change(function(){
		    var pid = $("#province").val();
		    $.post("shengshi.action",{pId:pid},
		    function(data,status){
		        //先清空
					$("#city").html("<option value='' >-请选择-</option>");
					//再遍历，追加
		      //取数据
		      $(data).each(function(index,c){
		        $("#city").append("<option value="+c.cid+" >"+c.cname);
		      });
		    },"json");
		  });
		//市县联动
		$("#city").change(function(){
		    var cid = $("#city").val();
		    $.post("shixian.action",{cId:cid},
		    function(data,status){
		        //先清空
					$("#town").html("<option value='' >-请选择-</option>");
					//再遍历，追加
		      //取数据
		      $(data).each(function(index,t){
		        $("#town").append("<option value="+t.id+" >"+t.townname);
		      });
		    },"json");
		  });
		$("#bumen").change(function(){
		    var did = $("#bumen").val();
		    $.ajax({
		    	url:"bumenliandong.action",
				type:"post",
				dataType:"json",
				data:JSON.stringify({did:did}),
				contentType:"application/json;charset=UTF-8",
				success:function(data){
					$("#gangwei").html("<option value='' >-请选择-</option>");
					 $(data).each(function(index,c){
					        $("#gangwei").append("<option value="+c.id+" >"+c.name);
					      });
				}
		    })
		  });
	});
</script>
<script type="text/javascript">
	$(function () {
		function formatDate(date){
	        var y = date.getFullYear();
	        var m = date.getMonth()+1;
	        m = m<10? '0'+m:m;
	        var d = date.getDate();
	        d = d<10?('0'+d):d;
	        return y+'/'+m+'/'+d;
	    }
		$("#registerForm").validate({
			rules:{
				name:"required",
				gonghao:"required",
				xueli:"required",
				sex:"required",
				age:"required",
				province:"required",
				city:"required",
				town:"required",
				detailed:"required",
				phone:"required",
				basesalary:"required",
				entrytime:"required",
				bumen:"required",
				gangwei:"required",
				jishu:"required",
				guanli:"required",
				zhengzhimianmao:"required"
			},
			messages:{
				name:"请输入姓名",
				gonghao:"请输入工号",
				xueli:"请输入学历",
				sex:"必填",
				age:"请填写年龄",
				province:"必填",
				city:"必填",
				town:"必填",
				detailed:"必填",
				phone:"请输入手机号",
				basesalary:"请填写工资",
				entrytime:"必填",
				bumen:"必填",
				gangwei:"必填",
				jishu:"必填",
				guanli:"必填",
				zhengzhimianmao:"必填"
			},
            //验证成功后提交参数
            submitHandler : function(form) {
            	/* $("#registerbtn").click(function() { */
        			var name = $("#name").val();
        			var gonghao = $("#gonghao").val();
        			var education = $("#xueli").val();
        			var sex = $('input[name="sex"]:checked').val();
        			var age = $("#age").val();
        			var province = $("#province").find("option:selected").text();
        			var city = $("#city").find("option:selected").text();
        			var town = $("#town").find("option:selected").text();
        			var detailed = $("#detailed").val();
        			var phone = $("#phone").val();
        			var basesalary = $("#basesalary").val();
        			var tempentrytime = $("#entrytime").val();
        			var daydate = new Date(tempentrytime);
        			var entrytime = formatDate(daydate);
        			var bumen = $("#bumen").val();
        			var gangwei = $("#gangwei").val();
        			var jishu = $("#jishu").val();
        			var guanli = $("#guanli").val();
        			var zhengzhimianmao = $("#zhengzhimianmao").val();
        			var address = province+city+town+detailed;
        			var level = '';
        			if(jishu != null || jishu != '' || jishu != undefined){
        				level = jishu;
        			}if (guanli != null || guanli != '' || guanli != undefined) {
        				level = guanli;
        			};
        	      $.ajax({
        	    	   url : "registerEmp.action",
	        			type : "post",
	        			data:JSON.stringify({
	        				name:name,
	        				gonghao:gonghao,
	        				education:education,
	        				sex:sex,
	            			age:age,
	            			address:address,
	            			phone:phone,
	            			basesalary:basesalary,
	            			entrytime:entrytime,
	            			departid:bumen,
	            			postid:gangwei,
	            			level:level,
	            			politicalstatus:zhengzhimianmao
	            		  }),
	            		 contentType:"application/json;charset=UTF-8",
	            		 success:function(data){
	            			alert('提交成功')
	           		  },
	        		error : function(e){
	                    alert('提交失败')
	                }
        	       })
        	/* }); */
            }
		})	
		//自动计算工号
		$("#bumen").change(function () {
			var did = $(this).val();
			$.post('calcaugonghao.action',{did:did},function(data,status){
				if(data!=null){
					$("#gonghao").val(data);
				}
			})
		})
	});
</script>
</html>