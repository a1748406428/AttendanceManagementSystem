$(function() {
    $("#gangweibtn").click(function(){
        $("#gangweixinxi").show();
        $("#renyuandiaodu").hide();
        $("#shoujianxiang").hide();
        $("#renwufenfa").hide();
    })
    $("#tiaozhengbtn").click(function(){
        $("#renyuandiaodu").show();
        $("#gangweixinxi").hide();
        $("#shoujianxiang").hide();
        $("#renwufenfa").hide();
    })
    $("#shoujianxiangbtn").click(function(){
        $("#shoujianxiang").show();
        $("#renyuandiaodu").hide();
        $("#gangweixinxi").hide();
        $("#renwufenfa").hide();
    })
    $("#renwufenfabtn").click(function(){
        $("#renwufenfa").show();
        $("#renyuandiaodu").hide();
        $("#gangweixinxi").hide();
        $("#shoujianxiang").hide();
    })
    $("#chaxunmsg").click(function () {
        function formatDate(date){
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            m = m<10? '0'+m:m;
            var d = date.getDate();
            d = d<10?('0'+d):d;
            return y+'/'+m+'/'+d;
        }
        var timeBefore = $("#time").val();
        var date = new Date(timeBefore);
        var time = formatDate(date).toString();
        $("#table").bootstrapTable('destroy').bootstrapTable(
                {	
                    url : "getmessage.action",//数据请求路径
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
                    uniqueId: "eid",
                    search:true,
                    toolbar:"#toolbar",
                    showColumns: true,                  //是否显示所有的列
                    showRefresh: true, 
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
                            {field : 'name',title : '发件人',align : 'center'},
                            {field : 'time',title : '时间',align : 'center'},
                            {field : 'content',title : '内容',align : 'center',cellStyle:{
                                css:{
                                    "overflow": "hidden",
                                    "text-overflow": "ellipsis",
                                    "white-space": "nowrap"
                                    }
                            }},
                            {field : 'status',title : '状态',align : 'center',
                            	formatter:function(value,row,index) {
                                var a = "";  
                                if(value == "未审核") {  
                                    a = "<span style='color:#fa9f00'>"+value+"</span>";  
                                }else if(value == "同意"){  
                                    a = "<span style='color:#3e8f3e'><i class='fa fa-times-circle-o' aria-hidden='true'></i>"+value+"</span>";  
                                }else if(value == "不同意") {  
                                    a = "<span style='color:#c12e2a'><i class='fa fa-check-circle-o' aria-hidden='true'></i>"+value+"</span>";  
                                } 
                                return a;  
                         }},
                            {field : 'eid',title : '员工编号',align : 'center'},
                            {title : '操作',field : 'eid',align : 'center',
                                formatter : function(value, row, index) {
                                    var a = "<button type='button' class = 'btn btn-info btn-sm' data-toggle='modal' data-target='#myModal' id='detail'><span class='fa fa-plus'>详情</span></button>"
                                    var b = "<button type='button' class = 'btn btn-danger btn-sm' data-toggle='modal' data-target='#deletemodal' id='delete'><span class='fa fa-trash'>删除</span></button>"
                                    return a + b;
                                }

                            } ],
                });
    })
    $("#table").on("click",":button",function(){
        var text = $(this).closest("tr").find("td").eq(4).text();
        var tempeid = $(this).closest("tr").find("td").eq(6).text();
        $("#linshieid").val(tempeid);
        $("#temp").text(text);
    })
    $("#tongyi").click(function() {
        var eid = $("#linshieid").val();
        $.post("tongyi.action",{eid:eid,status:"同意"},function(data,status){
            if(data!=null){
                $("#table").bootstrapTable('refresh');
                $("#renyuandiaodu").show();
                $("#gangweixinxi").hide();
                $("#shoujianxiang").hide();
                $("#renwufenfa").hide();
                $("#empid").val(eid);
            }
        })
    })
    $("#butongyi").click(function() {
        var eid = $("#linshieid").val();
        $.post("butongyi.action",{eid:eid,status:"不同意"},function(data,status){
            if(data!=null){
                $("#table").bootstrapTable('refresh')
            }
        })
    })
// 初始化部门岗位信息表

})