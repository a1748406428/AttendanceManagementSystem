$(function(){
	function formatDate(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        m = m<10? '0'+m:m;
        var d = date.getDate();
        d = d<10?('0'+d):d;
        return y+'/'+m+'/'+d;
    }
    $("#jilu").click(function() {
        var start = $("#start").val();
        var startTime = null;
        if(start != null || start != '' || start != undefined){
        	var startTimeBefore = new Date(start);
        	startTime = formatDate(startTimeBefore);
        }else{
        	startTime = '';
        }
        var shangba = $("#shangbantime").val();
        var xiaban = $("#xiabantime").val();
        var isabsence = $('input[name = "queqin"]:checked').val();
        var checkVal = $("#gangweiselect").val();
        var eid = $("#empid").val();
        $.ajax(
        		{
        			url:"sdjl.action",
        			type:"post",
        			data:JSON.stringify({
            			checktime:startTime,
            			startcheck:shangba,
            			endcheck:xiaban,
            			absence:isabsence,
            			eid:eid,
            			postid:checkVal
            		  }),
            		 contentType:"application/json;charset=UTF-8",
            		 success:function(data){
            			if(data!=null){
            				alert(data)
            			}else{
            				alert("返回值为空")
            			}
           		  }
        		});
});
    $("#gengxin").click(function () {

        var start = $("#start").val();
        var startTimeBefore = new Date(start);
        var startTime = formatDate(startTimeBefore).toString();
        var shangba = $("#shangbantime").val();
        var xiaban = $("#xiabantime").val();
        var isabsence = $('input[name = "queqin"]:checked').val();
        var checkVal = $("#gangweiselect").val();
        var eid = $("#empid").val();
        $.ajax(
        		{
        			url:"gengxin.action",
        			type:"post",
        			data:JSON.stringify({
            			checktime:startTime,
            			startcheck:shangba,
            			endcheck:xiaban,
            			absence:isabsence,
            			eid:eid,
            			postid:checkVal
            		  }),
            		 contentType:"application/json;charset=UTF-8",
            		 success:function(data){
            			if(data!=null){
            				alert(data)
            			}else{
            				alert("返回值为空")
            			}
           		  }
        		});
	})
});