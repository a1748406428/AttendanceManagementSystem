$(function() {
	function formatDate(date){
	      var y = date.getFullYear();
	      var m = date.getMonth()+1;
	      m = m<10? '0'+m:m;
	      var d = date.getDate();
	      d = d<10?('0'+d):d;
	      return y+'/'+m+'/'+d;
	  }
    $("#bumenchart").click(function() {
    	var start = $("#start").val();
    	var end = $("#end").val();
    	var startTimeBefore = new Date(start);
    	var endtimeBefore = new Date(end);
    	var startTime = '';
    	var endTime = '';
    	if((start != null && start.length>0) && (end != null && end.length >0)){
    		startTime = formatDate(startTimeBefore);
    		endTime = formatDate(endtimeBefore);
    	}else{
    		var today = new Date();
    		startTime = formatDate(today);
    		endTime = formatDate(today);
    	}
    	$("#main1,#main2,#main3,#main4,#main5,#main6").show();
    	$("#main7").hide();
        // 基于准备好的dom，初始化echarts实例
           var myChart1 = echarts.init(document.getElementById('main1'));
           var myChart2 = echarts.init(document.getElementById('main2'));
           var myChart3 = echarts.init(document.getElementById('main3'));
           var myChart4 = echarts.init(document.getElementById('main4'));
           var myChart5 = echarts.init(document.getElementById('main5'));
           var myChart6 = echarts.init(document.getElementById('main6'));
        //预先设置，柱形图
        myChart1.setOption({
            title: {
                text: '各部门情况表'
            },
            tooltip: {
            	show:true,
            	trigger:'axis'
            },
            toolbox:{
			show:true,
			orient:'horizontal',
			feature:{
				saveAsImage:{
					show:true,
					type:'jpeg',
					name:'title.text'
				},
			magicType:{
			show:true,
			type:['line'],
			title:{
				line:"切换为折线图"
			},
		},
		restore:{
			show:true,
			title:'还原',
			
		}
			}
		},
            legend: {
                data:['研发部']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '研发部',
                type: 'bar',
                data: []
            }]
        });
        //部门2
        myChart2.setOption({
            tooltip: {
            	show:true,
            	trigger:'axis'
            },
            toolbox:{
    			show:true,
    			orient:'horizontal',
    			feature:{
    				saveAsImage:{
    					show:true,
    					type:'jpeg',
    					name:'title.text'
    				},
    			magicType:{
    			show:true,
    			type:['line'],
    			title:{
    				line:"切换为折线图"
    			},
    		},
    		restore:{
    			show:true,
    			title:'还原',
    			
    		}
    			}
    		},
            legend: {
                data:['运营部']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '运营部',
                type: 'bar',
                data: []
            }]
        });
        //部门3
        myChart3.setOption({
            tooltip: {
            	show:true,
            	trigger:'axis'
            },
            toolbox:{
    			show:true,
    			orient:'horizontal',
    			feature:{
    				saveAsImage:{
    					show:true,
    					type:'jpeg',
    					name:'title.text'
    				},
    			magicType:{
    			show:true,
    			type:['line'],
    			title:{
    				line:"切换为折线图"
    			},
    		},
    		restore:{
    			show:true,
    			title:'还原',
    			
    		}
    			}
    		},
            legend: {
                data:['运维部']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '运维部',
                type: 'bar',
                data: []
            }]
        });
        //部门4
        myChart4.setOption({
            tooltip: {
            	show:true,
            	trigger:'axis'
            },
            toolbox:{
    			show:true,
    			orient:'horizontal',
    			feature:{
    				saveAsImage:{
    					show:true,
    					type:'jpeg',
    					name:'title.text'
    				},
    			magicType:{
    			show:true,
    			type:['line'],
    			title:{
    				line:"切换为折线图"
    			},
    		},
    		restore:{
    			show:true,
    			title:'还原',
    			
    		}
    			}
    		},
            legend: {
                data:['产品部']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '产品部',
                type: 'bar',
                data: []
            }]
        });
        //部门5
        myChart5.setOption({
            tooltip: {
            	show:true,
            	trigger:'axis'
            },
            toolbox:{
    			show:true,
    			orient:'horizontal',
    			feature:{
    				saveAsImage:{
    					show:true,
    					type:'jpeg',
    					name:'title.text'
    				},
    			magicType:{
    			show:true,
    			type:['line'],
    			title:{
    				line:"切换为折线图"
    			},
    		},
    		restore:{
    			show:true,
    			title:'还原',
    			
    		}
    			}
    		},
            legend: {
                data:['财务部']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '财务部',
                type: 'bar',
                data: []
            }]
        });
        //部门6
        myChart6.setOption({
            tooltip: {
            	show:true,
            	trigger:'axis'
            },
            toolbox:{
    			show:true,
    			orient:'horizontal',
    			feature:{
    				saveAsImage:{
    					show:true,
    					type:'jpeg',
    					name:'title.text'
    				},
    			magicType:{
    			show:true,
    			type:['line'],
    			title:{
    				line:"切换为折线图"
    			},
    		},
    		restore:{
    			show:true,
    			title:'还原',
    			
    		}
    			}
    		},
            legend: {
                data:['法务部']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '法务部',
                type: 'bar',
                data: []
            }]
        });
        myChart1.showLoading();
    	myChart2.showLoading();
    	myChart3.showLoading();
    	myChart4.showLoading();
    	myChart5.showLoading();
    	myChart6.showLoading();
        $.post("bumen.action",{did1:1,did2:2,did3:3,did4:4,did5:5,
        	did6:6,startTime:startTime,
        	endTime:endTime},function(data,status){
        	myChart1.hideLoading();
        	myChart2.hideLoading();
        	myChart3.hideLoading();
        	myChart4.hideLoading();
        	myChart5.hideLoading();
        	myChart6.hideLoading();
            // 填入数据
            myChart1.setOption({
                xAxis: {
                    data: data.categories
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '研发部',
                    data: data.data[0].d1
                }]
            });
            //2号部门填数据
            myChart2.setOption({
                xAxis: {
                    data: data.categories
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '运营部',
                    data: data.data[0].d2
                }]
            });
          //3号部门填数据
            myChart3.setOption({
                xAxis: {
                    data: data.categories
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '运维部',
                    data: data.data[0].d3
                }]
            });
          //4号部门填数据
            myChart4.setOption({
                xAxis: {
                    data: data.categories
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '产品部',
                    data: data.data[0].d4
                }]
            });
          //52号部门填数据
            myChart5.setOption({
                xAxis: {
                    data: data.categories
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '财务部',
                    data: data.data[0].d5
                }]
            });
          //6号部门填数据
            myChart6.setOption({
                xAxis: {
                    data: data.categories
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '法务部',
                    data: data.data[0].d6
                }]
            });
        },"json")
        
    });
    $("#totalchart").click(function(){
    	var start = $("#start").val();
    	var end = $("#end").val();
    	var startTimeBefore = new Date(start);
    	var endtimeBefore = new Date(end);
    	var startTime = formatDate(startTimeBefore).toString();
    	var endTime = formatDate(endtimeBefore).toString();
    	$("#main7").show();
    	$("#main1,#main2,#main3,#main4,#main5,#main6").hide();
    	var myChart7 = echarts.init(document.getElementById('main7'));
        var option = {
        		series:[{
        			type:'pie',
        			data:[]
        		}]
        }
        myChart7.setOption(option)
        myChart7.showLoading();
        $.post("total.action",{startTime:startTime,
        	endTime:endTime},function(data,status){
        	myChart7.hideLoading();
        	myChart7.setOption({
        		name:'公司总体考勤表',
        		tooltip:{
        			show:true,
        			trigger:'item'
        		},
        		toolbox:{
        			show:true,
        			orient:'horizontal',
        			feature:{
        				saveAsImage:{
        					show:true,
        					type:'jpeg',
        					name:'title.text'
        				},
        			magicType:{
					show:true,
					type:['line','bar'],
					title:{
						line:"切换为折线图",
						bar:"切换为柱状图"
					},
				},
				restore:{
					show:true,
					title:'还原',
					
				}
        			}
        		},
        		series:[{
        			data:[
            			{name:"正常",value:data.zhengchang},
            			{name:"缺勤",value:data.queqin},
            			{name:"迟到",value:data.chidao}
            		]
        		}]
        		
        	})
        },'json')
    })
});    