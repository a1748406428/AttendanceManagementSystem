$(function() {
    function formatDate(date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? '0' + m : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        return y + '/' + m + '/' + d;
    }

	$("#hzform").validate({
		rules:{
			monthstart:"required",
			monthend:"required",
			
		},
		messages:{
			monthstart:"必选",
			monthend:"必选",
		},
        //验证成功后提交参数
        submitHandler : function(form) {
        	var monthstartbefore = $("#monthstart").val();
            var monthendbefore = $("#monthend").val();
            var monthstart = formatDate(new Date(monthstartbefore)).toString();
            var monthend = formatDate(new Date(monthendbefore)).toString();
            $.post("huizong.action",{monthstart:monthstart,monthend:monthend},function(data,status){
                if(data!=null){
                    alert("汇总成功")
                }
            })
        }
	})	
   /* $("#hzbtn").click(function () {
        var monthstartbefore = $("#monthstart").val();
        var monthendbefore = $("#monthend").val();
        var monthstart = formatDate(new Date(monthstartbefore)).toString();
        var monthend = formatDate(new Date(monthendbefore)).toString();
        $.post("huizong.action",{monthstart:monthstart,monthend:monthend},function(data,status){
            if(data!=null){
                alert("汇总成功")
            }
        })
        })*/
    $("#jcbtn").click(function () {
    	var day = new Date($("#month").val());
    	var year = day.getFullYear();
    	var tempmonth = (day.getMonth()+1)<10?'0'+(day.getMonth()+1):day.getMonth()+1;
    	var month = year+'/'+tempmonth;
        $("#jiangchengtable")
        .bootstrapTable('destroy')
        .bootstrapTable(
                {
                    url : "selectjiangcheng.action",// 数据请求路径
                    clickToSelect : true, // 点击表格项即可选择
                    dataType : "json", // 后端数据传递类型
                    pageSize : 5,
                    cache : "false",
                    pageList : [ 5, 10, 20 ],
                    contentType : "application/x-www-form-urlencoded",
                    method : 'get', // 请求类型
                    dataField : "data", // 很重要，这是后端返回的实体数据！
                    sidePagination : "server",
                    pagination : true,
                    pageNumber : 1,
                    showToggle : true,
                    uniqueId : "id",
                    search : true,
                    toolbar : "#toolbar",
                    showColumns : true, // 是否显示所有的列
                    showRefresh : true,
                    clickToSelect : true,
                    queryParamsType : 'limit',
                    // 是否显示详细视图和列表视图的切换按钮
                    queryParams : function(params) {// 自定义参数，这里的参数是传给后台的，我这是是分页用的
                        return {// 这里的params是table提供的
                            offset : params.offset,// 从数据库第几条记录开始
                            limit : params.limit, // 找多少条
                            month : month
                        };
                    },
                    responseHandler : function(res) {
                        // 在ajax获取到数据，渲染表格之前，修改数据源
                        return res;
                    },
                    columns : [
                            {
                                field : 'state'
                            },
                            {
                                field : 'id',
                                title : '序号',
                                align : 'center'
                            },
                            {
                                field : 'ename',
                                title : '姓名',
                                align : 'center'
                            },
                            {
                                field : 'reason',
                                title : '请假原因',
                                align : 'center'
                            },
                            {
                                field : 'totalday',
                                title : '加班天数',
                                align : 'center'
                            },
                            {
                                field : 'jiangli',
                                title : '应得奖励',
                                align : 'center'
                            },
                            {
                                field : 'status',
                                title : '状态',
                                align : 'center',
                                formatter : function(
                                        value, row,
                                        index) {
                                    var a = "";
                                    if (value == "未审核") {
                                        a = "<span style='color:#fa9f00'>"
                                                + value
                                                + "</span>";
                                    } else if (value == "已审核") {
                                        a = "<span style='color:#3e8f3e'><i class='fa fa-times-circle-o' aria-hidden='true'></i>"
                                                + value
                                                + "</span>";
                                    } 
                                    return a;
                                }
                            },
                            {
                                field : 'month',
                                title : '月份',
                                align : 'center'
                            },
                            {
                                field : 'eid',
                                title : '员工编号',
                                align : 'center'
                            },
                            {
                                title : '操作',
                                field : 'id',
                                align : 'center',
                                formatter : function(
                                        value, row,
                                        index) {
                                    var a = "<button type='button' class = 'btn btn-info btn-sm' data-toggle='modal' data-target='#jianglimodal' id='detail'><span class='fa fa-plus'>详情</span></button>"
                                    return a;
                                }
                            },
                            {
                                title : '操作',
                                field : 'id',
                                align : 'center',
                                formatter : function(
                                        value, row,
                                        index) {
                                    var b = "<button type='button' class = 'btn btn-danger btn-sm' data-toggle='modal' data-target='#jianglideletemodal' id='delete'><span class='fa fa-trash'>删除</span></button>"
                                    return b;
                                }
                            },

                    ]
                });
    }) 
    //模态框操作
$("#jiangchengtable").on("click", ":button", function() {
	var tempeid = $(this).closest("tr").find("td").eq(8).text();
	var jiabantianshu = $(this).closest("tr").find("td").eq(4).text();
	var rowid = $(this).closest("tr").find("td").eq(1).text();
	$("#jianglilinshiid").val(tempeid);
	$("#jiabantianshu").val(jiabantianshu);
	$("#jianglirowid").val(rowid);
})
$("#pingjunrixin").mousedown(function () {
	var id = $("#jianglilinshiid").val();
	var jiabantianshu = $("#jiabantianshu").val();

	$.post("caculatormoney.action",{id:id,jiabantianshu:jiabantianshu},function(data,status){
		if(data!=null){
			$("#pingjunrixin").val(data.avgDailySal);
			$("#yingdejiangli").val(data.jiangli);
		}
	})
})
$("#jianglitongyi").click(function() {
	var id = $("#jianglirowid").val();
	var yingdejiangli = $("#yingdejiangli").val();
	$.post("jianglishenhe.action", {id:id,status:"已审核",yingdejiangli:yingdejiangli},function(data, status) {
		if(data=="200") {
			$("#jiangchengtable").bootstrapTable('refresh');
			$("#pingjunrixin").val("");
			$("#yingdejiangli").val("");
		}
	})
})

$("#jianglibutongyi").click(function() {
	$("#pingjunrixin").val("");
	$("#yingdejiangli").val("");
})
})