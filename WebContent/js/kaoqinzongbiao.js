$(function () {
    $("#selectkaoqin").click(function () {
        var depart = $("#departselect").val();
        var post = $("#postselect").val();
        var date = $("#time").val();
        var tempdate = new Date(date);
        var year = tempdate.getFullYear();
        var month = (tempdate.getMonth()+1)<10?'0'+(tempdate.getMonth()+1):(tempdate.getMonth()+1);
        var time = year+'/'+month;
        var departid = $("#departselect").val();
        var postid = $("#postselect").val();
        $("#kaoqintable").bootstrapTable("destroy").bootstrapTable(
                {	
                    url : "scankaoqinzongbiao.action",//数据请求路径
                    clickToSelect : true,  //点击表格项即可选择
                    dataType : "json",   //后端数据传递类型
                    pageSize : 10,
                    cache:"false",
                    pageList : [5,10,20],
                    contentType : "application/x-www-form-urlencoded",
                    method : 'get',      //请求类型
                    dataField : "data",  //很重要，这是后端返回的实体数据！ 
                    sidePagination: "server",
                    pagination: true,
                    fixedColumns: true, 
                    fixedNumber: 1, //固定列数
                    pageNumber:1,
                    showToggle:true, 
                    uniqueId: "id",
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
                            time:time,           //时间
                            departid:departid,  //部门id
                            postid:postid      //岗位id
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
                            {field: 'checktime',title : '打卡日期',align : 'center'},
                            {field : 'startcheck',title : '上班打卡时间',align : 'center'},
                            {field : 'endcheck',title : '下班打卡时间',align : 'center'},
                            {field : 'absence',title : '是否缺勤',align : 'center'},
                            {field : 'departname',title : '部门',align : 'center'},
                            {field : 'postname',title : '岗位',align : 'center'}]
                });
        $("#content").niceScroll({
            cursorcolor: "rgb(110, 110, 109)", //滚动条的颜色   
            cursoropacitymax: 1, //滚动条的透明度，从0-1   
            touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备   
            cursorwidth: "8px", //滚动条的宽度   
            cursorborder: "0", // 游标边框css定义    
            cursorborderradius: "5px", //以像素为光标边界半径  圆角   
            autohidemode: false, //是否隐藏滚动条  true的时候默认不显示滚动条，当鼠标经过的时候显示滚动条   
            zindex: "auto", //给滚动条设置z-index值    
            railpadding: {
                top: 0,
                right: -4,
                left: 0,
                bottom: 0
            }, //滚动条的位置
        });
    });
    
})