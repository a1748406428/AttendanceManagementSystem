$(document).ready(function(){
$("#userid").blur(function(){
    var Name = $("#userid").val();
    $.post("checkIsNULL.action",{name:Name},function(data,status){
//    	if(data==""){
//    		$("#usercheck").html("您输入的值为空");
//    	}
    	$("#usercheck").html(data);
    });
  });
});
function validate() {
	var pwd1 = $("#pwd").val();
	var pwd2 = $("#pwd2").val();
	if(pwd1 == pwd2){
		$("#pwd2check").html("正确").css("color","green");
	}else {
		$("#pwd2check").html("您两次输入的密码不一致请重新输入").css("color","red");
	}
}
function checkphone(){
  var regExp = new RegExp("^[0-9]{11}");
  var phonenumber = $("#phoneid").val();
  if(regExp.test(phonenumber)){
    $("#checkphone").html("正确").css("color","green");
  }else{
	  $("#checkphone").html("请输入11位的数字").css("color","red");
  }
}
$(document).ready(function(){
	//省市联动
	$("#province").change(function(){
	    var pid = $("#province").val();
	    $.post("shengshi.action",{pId:pid},
	    function(data,status){
	        //先清空
				$("#city").html("<option value='' >-请选择-");
				//再遍历，追加
	      //取数据
	      $(data).each(function(index,c){
	        $("#city").append("<option value="+c.cid+" >"+c.cname);
	      });
	    },"json");
	  });
});
$(document).ready(function(){
//市县联动
$("#city").change(function(){
    var cid = $("#city").val();
    $.post("shixian.action",{cId:cid},
    function(data,status){
        //先清空
			$("#town").html("<option value='' >-请选择-");
			//再遍历，追加
      //取数据
      $(data).each(function(index,t){
        $("#town").append("<option value="+t.id+" >"+t.townname);
      });
    },"json");
  });
});
//接收前台传来的值
