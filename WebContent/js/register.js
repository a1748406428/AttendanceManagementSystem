/*$(function(){*/
$(function() {
	$("#registerButton").click(function(){
		if($("#town").click()){
			var option1 = $("#province option:checked");
			var option2 = $("#city option:checked");
			var option3 = $("#town option:checked");
			var pname = option1.text();
			var cname = option2.text();
			var tname = option3.text();
		}
		var name = document.getElementById("userid").value;
		var	password = $("#pwd").val();
		var	sex = $('input:radio:checked').val();
		var	phone = $("#phoneid").val();
		var detailedadd = $("#detailed").val();
		var	address = pname+cname+tname+detailedadd;
		$.post("register.action",{Name:name,Password:password,Sex:sex,Phone:phone,Address:address},function(data,status){
            if(data!=null){
            	var delay;
/*             	$("#tiaozhuan").html("注册成功！3秒后自动跳转"); //页面文本显示初始值 */
            	//定义页面延时跳转方法
            	function delayURL(delay){
            	setTimeout(function () {
            	if (delay > 0) {
            	delay--;
            	$("#tiaozhuan").html("注册成功！"+delay+"秒后自动跳转至登陆页面"); //页面文本赋值
            	delayURL(delay); //调用页面延时跳转方法
            	} else {
            	var url ='http://localhost:8080/BootMannager/index.jsp';
            	document.location.href = url;
            	} 
            	},1000); //setTimeout里面的方法1000毫秒执行一次
            	}
            	delayURL(3);
            }
        });

	})
})
	
/*});*/