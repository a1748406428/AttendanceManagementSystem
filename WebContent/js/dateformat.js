$(function(){
    function formatDate(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        m = m<10? '0'+m:m;
        var d = date.getDate();
        d = d<10?('0'+d):d;
        return y+'/'+m+'/'+d;
    }
    var start = $("#start").val();
    	var end = $("#end").val();
    	var startTimeBefore = new Date(start);
    	var endtimeBefore = new Date(end);
    	var startTime = formatDate(startTimeBefore).toString();
    	var endTime = formatDate(endtimeBefore).toString();
})