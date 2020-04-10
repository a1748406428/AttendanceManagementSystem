$(function(){
    function formatDate(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        m = m<10? '0'+m:m;
        var d = date.getDate();
        d = d<10?('0'+d):d;
        return y+'/'+m+'/'+d;
    }
    $("#chaxunjiatiao").click(function () {
        var selectval = $("#classifyjiatiao").val();
        if(selectval=="person"){
            $("#persondiv").show();
            $("#jititable").hide();           
            var timeBefore = $("#time").val();
            var date = new Date(timeBefore);
            var time = formatDate(date).toString();
            $("#qingjiatable").bootstrapTable('destroy').bootstrapTable(
                    {	
                        url : "jiatiao.action",//数据请求路径
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
                                {field : 'totalday',title : '请假天数',align : 'center'},
                                {field : 'reason',title : '原因',align : 'center'},
                                {field : 'daytime',title : '日期',align : 'center'},
                                {field : 'togo',title : '去向',align : 'center',cellStyle:{
                                    css:{
                                        "overflow": "hidden",
                                        "text-overflow": "ellipsis",
                                        "white-space": "nowrap"
                                        }
                                }},
                                {field : 'phone',title : '电话',align : 'center'},
                                {field : 'eid',title : '员工编号',align : 'center'},
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
                                {title : '操作',field : 'id',align : 'center',
                                    formatter : function(value, row, index) {
                                        var a = "<button type='button' class = 'btn btn-info btn-sm' data-toggle='modal' data-target='#myModal' id='detail'><span class='fa fa-plus'>详情</span></button>"
                                        return a;
                                    }
                                }, 
                                {title : '操作',field : 'id',align : 'center',
                                    formatter : function(value, row, index) {
                                        var b = "<button type='button' class = 'btn btn-danger btn-sm' data-toggle='modal' data-target='#deletemodal' id='delete'><span class='fa fa-trash'>删除</span></button>"
                                        return b;
                                    }
                                },
                            
                            ]
                    });
        }else if(selectval=="jiti"){
            $("#jititable").show();  
            $("#persondiv").hide();
            var timeBefore = $("#time").val();
            var date = new Date(timeBefore);
            var time = formatDate(date).toString();
            $("#jitijiatable").bootstrapTable('destroy').bootstrapTable(
                    {	
                        url : "jitijiatiao.action",//数据请求路径
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
                        showExport: true,//工具栏上显示导出按钮
                        exportDataType: $(this).val(),//显示导出范围
                        exportTypes: ['json', 'xml', 'png', 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf'],//导出格式
                        exportOptions: {//导出设置
                            fileName: 'test'//下载文件名称
                        },
                        columns : [
                                {field : 'state'},
                                {field:'id',title:'序号', align:'center'},
                                {field : 'departname',title : '部门名称',align : 'center'},
                                {field : 'totalday',title : '请假天数',align : 'center'},
                                {field : 'reason',title : '原因',align : 'center'},
                                {field : 'daytime',title : '日期',align : 'center'},
                                {field : 'togo',title : '去向',align : 'center',cellStyle:{
                                    css:{
                                        "overflow": "hidden",
                                        "text-overflow": "ellipsis",
                                        "white-space": "nowrap"
                                        }
                                }},
                                {field : 'phone',title : '电话',align : 'center'},
                                {field : 'leadername',title : '领导',align : 'center'},
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
                                {title : '操作',field : 'id',align : 'center',
                                    formatter : function(value, row, index) {
                                        var a = "<button type='button' class = 'btn btn-info btn-sm' data-toggle='modal' data-target='#jitimodal' id='detail'><span class='fa fa-plus'>详情</span></button>"
                                        return a;
                                    }
                                }, 
                                {title : '操作',field : 'id',align : 'center',
                                    formatter : function(value, row, index) {
                                        var b = "<button type='button' class = 'btn btn-danger btn-sm' data-toggle='modal' data-target='#jitideletemodal' id='delete'><span class='fa fa-trash'>删除</span></button>"
                                        return b;
                                    }
                                },
                            
                            ]
                    });
        }
        
    })
    //模态框操作
    $("#qingjiatable").on("click",":button",function(){
        var text = $(this).closest("tr").find("td").eq(6).text();
        var tempid = $(this).closest("tr").find("td").eq(1).text();
        $("#linshiid").val(tempid);
        $("#temp").text(text);
    })

    $("#tongyi").click(function() {
        var id = $("#linshiid").val();
        $.post("pizhun.action",{id:id,status:"同意"},function(data,status){
                $("#qingjiatable").bootstrapTable('refresh');
        })
    })

    $("#butongyi").click(function() {
        var id = $("#linshieid").val();
        $.post("pizhun.action",{id:id,status:"不同意"},function(data,status){
                $("#qingjiatable").bootstrapTable('refresh')
        })
    })

    //集体假条表格操作
    $("#jitijiatable").on("click",":button",function(){
        var text = $(this).closest("tr").find("td").eq(4).text();
        var tempid = $(this).closest("tr").find("td").eq(1).text();
        $("#jitilinshiid").val(tempid);
        $("#jititemp").text(text);
    })

    $("#jititongyi").click(function() {
        var id = $("#jitilinshiid").val();
        $.post("istongyi.action",{id:id,status:"同意"},function(data,status){
                $("#qingjiatable").bootstrapTable('jitijiatable');
        })
    })

    $("#jitibutongyi").click(function() {
        var id = $("#jitilinshiid").val();
        $.post("istongyi.action",{id:id,status:"不同意"},function(data,status){
                $("#jitijiatable").bootstrapTable('refresh')
        })
    })

})