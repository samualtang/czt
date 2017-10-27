/**
 * 页面列表datagrid初始化
 */
jQuery(function($){
	var nowTime01 = getDateYM01();
	var nowTime = getDateYMD();
	$('#searchtime').datebox("setValue",nowTime01);
	$('#searchtime2').datebox("setValue",nowTime);
	initdatetype();
	var obj = $("#consignsorsearch");
	initconsignsor(obj);

	$('#dataTabel').datagrid({
		title:'入库单', //标题
		method:'post',
		iconCls:'icon-edit', //图标
		singleSelect:true, //单选
		height:490, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:true,//可折叠
		//货主默认为长沙11430101
		url:baseURL+"/wms/outbound/getOutBoundPageList.json?outboundtype="+outboundtype, //数据来源
		sortName: 'outboundid', //排序的列
		sortOrder: 'desc', //倒序
		remoteSort: true, //服务器端排序
		idField:'outboundid', //主键字段
		pageNumber: 1, 
		pageSize : 20,
		pageList: [20,30,50],
		queryParams:{
			}, //查询条件
		pagination:true, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号
		columns:[[
			{field:'outboundid',checkbox:true,width:2}, //显示复选框
			{field:'qty',title:'数量',width:$(this).width()*0.1,
				formatter:function(value,row,index){return row.qty;} //需要formatter一下才能显示正确的数据
			},
			{field:'outtime',title:'出库日期',width:$(this).width()*0.1,formatter: formatDatebox,sortable:true},
			{field:'consignsor',title:'货主',width:$(this).width()*0.1,sortable:true,
				formatter:function(value,row,index){return row.consignsor;}
			},
			{field:'createtime',title:'记录时间',width:$(this).width()*0.1,sortable:true,
				formatter:function(value,row,index){return row.createtime;}
			}
		]],
		toolbar:'#toolbar',
		onLoadSuccess:function(){
			$('#dataTabel').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			$('#tabdiv .panel-header').css('display','none'); 
			
		}
	});
	

});



//初始化日期类型
function initdatetype(){
	$("#datetype").combobox({
        valueField:'id',
        textField:'value',
        data:[
        	{
        		id:10,
        		value:"出库日期"
        	},{
        		id:20,
        		value:"订单日期"
        	}],
	onLoadSuccess: function () {
		 var val = $(this).combobox("getData");
		 for (var item in val[0]) {
             if (item == "id") {
                 $(this).combobox("select", val[0][item]);
             }
         }
	}
    });
}

//初始货主
function initconsignsor(obj){
	obj.combobox({
        valueField:'code',
        textField:'company',
        url:baseURL+"/wms/consignor/getConsignorListForComb.json", //数据来源
	onLoadSuccess: function () {
		 var val = $(this).combobox("getData");
		 for (var item in val[1]) {
             if (item == "code") {
                 $(this).combobox("select", val[1][item]);
             }
         }
	}
    });
}

function initOrderDatebox(){
    $('#orderdate_new').datebox({
    	onSelect: function(date){
    		var orderdate = $("#orderdate_new").val();
    		var consignsor = $("#consignsor_new").val();
    		initRow(orderdate,consignsor);
    	}
    });
}

//查询
function searchData(){
	var params = $('#dataTabel').datagrid('options').queryParams; //先取得 datagrid 的查询参数
	var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
	$.each( fields, function(i, field){
		params[field.name] = field.value; //设置查询参数
	}); 
	$('#dataTabel').datagrid('reload'); //设置好查询参数 reload 一下就可以了
}
//清空查询条件
function clearForm(){
	$('#queryForm').form('clear');
	searchData();
}


/**
 * 打开新增窗口
 */
function openCreate(){
	$('#add-fm').form('clear');
	$('#add-dlg').dialog('open').dialog('setTitle','出库单');
	
	//初始化订单日期
	$('#username_new').textbox("setValue",username);
	$('#username_new').textbox("setText",username);
		//初始化货主
		var obj = $('#consignsor_new');
		initconsignsor(obj);
 
	var nowTime = getDateYMD();
	//初始化订单日期从系统订单任务表中取订单日期
	var consignsor = $("#consignsor_new").val();
	
	$('#outtime_new').datebox("setValue",nowTime);
	
	//卷烟列表
	var keyword = $("#keyword").val();
	initItemList(keyword);
	//出库明细列表
	obid = 0;
	var obj = $('#outboundlinelist');
	getoutboundlinelist(obj,obid,150);
}

function searchType(){
	var keyword = $("#keyword").val();
	initItemList(keyword);
}

//清空查询条件
function clearForm(){
	$('#add-fm').form('clear');
	searchType();
}
//待续............
function initItemList(keyword){
	$('#itemlist').datagrid({
		title:'入库单明细', //标题
		method:'post',
		iconCls:'icon-view', //图标
		singleSelect:false, //多选
		height:140, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:false,//可折叠
		url:baseURL+"/wms/outbound/getItemList.json?keyword="+keyword, 
		sortName: 'id', //排序的列
		sortOrder: 'desc', //倒序
		remoteSort: true, //服务器端排序
		idField:'id', //主键字段
		singleSelect: true,
		pagination:false, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号
		columns:[[
			{field:'itemno',title:'卷烟编码',width:$(this).width()*0.05,sortable:true,
				formatter:function(value,row,index){return row.itemno;} //需要formatter一下才能显示正确的数据
			},
			{field:'itemname',title:'卷烟名称',width:$(this).width()*0.1,
				formatter:function(value,row,index){return row.itemname;}
			},
			{field:'shiptypename',title:'卷烟类别',width:$(this).width()*0.1,sortable:true,
				formatter:function(value,row,index){return row.shiptypename;} //需要formatter一下才能显示正确的数据
			},
			{field:'jtSize',title:'件条比例',width:$(this).width()*0.1,sortable:true,
				formatter:function(value,row,index){return row.jtSize;}
			},
			{field:'_operate',title:'操作',width:$(this).width()*0.05,
				formatter:function(value,row,index){return '<input name="isShow" type="radio" onclick="radClick('+index+')"/>';}
			}
		]],
		onLoadSuccess:function(){
			//$('#inboundlinediv .panel-header').css('display','none'); 
			
		}
	});
}

function radClick(index){ 
	 $('#itemlist').datagrid('selectRow',index);// 关键在这里  
	    var row = $('#itemlist').datagrid('getSelected');  
	    if (row){  
	    	$('#cigarettecode').textbox("setValue",row.itemno);
	    	$('#cigarettecode').textbox("setText",row.itemno);
	    	$('#cigarettename').textbox("setValue",row.itemname);
	    	$('#cigarettename').textbox("setText",row.itemname);
	    	$('#jtsize').textbox("setValue",row.jtSize);
	    	$('#jtsize').textbox("setText",row.jtSize);
	    }
}

/**
 * 生成出库单
 * @returns
 */
function toCKD()
{
	var outtime = $("#outtime_new").val();
	var consignsor = $("#consignsor_new").val();
	var cigarettename = $("#cigarettename").val();
	var cigarettecode = $("#cigarettecode").val();
	var jtsize = $("#jtsize").val();
	  var qty = $("#qtynew").val();
	  if(cigarettecode==""){
		  $.messager.alert('提示',"请选择出库卷烟！",'info');
			return;
	  }
	  if(qty==""){
		  $.messager.alert('提示',"请输入出库数量！",'info');
			return;
	  }
	  $.ajax({
			url:baseURL+"/wms/outbound/doSavedb.json?qty="+qty+"&obid="+obid+"&outtime="+outtime+"&consignsor="+consignsor+"&cigarettename="+cigarettename+"&cigarettecode="+cigarettecode+"&jtsize="+jtsize, 
			success : function(data) {
				//data = eval('('+data+')');
				console.log(data);
				//$('#add-dlg').dialog('close');
				$('#dataTabel').datagrid('reload'); 
				obid=data.obid;
				//获取出库单明细列表
				var obj = $('#outboundlinelist');
				getoutboundlinelist(obj,obid,150);
				$.messager.show({
					title : '提示',
					msg :  '出库单'+data.msg+'！',
				});
	         },
	         error: function(e) { 
	        	 $.messager.show({
	 				title : '提示',
	 				msg :  '新增出错，请联系管理员!',
	 			});
	          	} 
		});
	  
	}

/**
 * 查看窗口
 */
  function viewD(){
	  $('#view-fm').form('clear');
	  var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要查看的信息",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一条信息进行查看",'info');
			return;
		}
		
		var row = $('#dataTabel').datagrid('getSelected');
		var outboundid = row.outboundid;
		row.orderdate=formatDatebox(row.orderdate);
		row.outtime=formatDatebox(row.outtime);
		if (row){
			$('#view-dlg').dialog('open').dialog('setTitle',"查看");
			$('#view-dlg').form('load',row);
		}
		var obj = $('#outboundlinelist1');
		getoutboundlinelist(obj,outboundid,270);
	}
  
	//出库单明细列表
	  function getoutboundlinelist(obj,outboundid,dgheight)
	  {
	  		//获取领料新增分配的物资明细列表
	  	obj.datagrid({
	  		title:'出库单明细列表', //标题
	  		method:'post',
	  		iconCls:'icon-view', //图标
	  		singleSelect:false, //多选
	  		height:dgheight, //高度
	  		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	  		striped: true, //奇偶行颜色不同
	  		collapsible:false,//可折叠
	  		url:baseURL+"/wms/outbound/getOutboundLineList.json?outboundid="+outboundid, 
	  		sortName: 'id', //排序的列
	  		sortOrder: 'desc', //倒序
	  		remoteSort: true, //服务器端排序
	  		idField:'id', //主键字段
	  		singleSelect: true,
	  		pagination:false, //显示分页
	  		//pageSize : 1,
	  		rownumbers:true, //显示行号
	  		columns:[[
	  			{field:'cigarettename',title:'卷烟名称',width:$(this).width()*0.1,
	  				formatter:function(value,row,index){return row.cigarettename;}
	  			},
	  			{field:'cigarettecode',title:'卷烟编码',width:$(this).width()*0.1,sortable:true,
	  				formatter:function(value,row,index){return row.cigarettecode;} //需要formatter一下才能显示正确的数据
	  			},
	  			{field:'itemqty',title:'条烟数量',width:$(this).width()*0.1,sortable:true,
	  				formatter:function(value,row,index){return row.itemqty;} //需要formatter一下才能显示正确的数据
	  			},
	  			{field:'boxqty',title:'件烟数量',width:$(this).width()*0.1,sortable:true,
	  				formatter:function(value,row,index){return row.boxqty;}
	  			}
	  		]],
	  		onLoadSuccess:function(){
	  			//$('#inboundlinediv .panel-header').css('display','none'); 
	  			
	  		}
	  	});
	  	}
	  
	  
	//删除
		function deleterow(){
			var rows = $('#dataTabel').datagrid('getSelections');
			if(rows.length==0){
			$.messager.alert('提示',"请选择你要删除的信息",'info');
			return;
		}
			$.messager.confirm('提示','确定要删除吗?',function(result){
	        if (result){
	        	var ps = "";
	        	$.each(rows,function(i,n){
	        		if(i==0) 
	        			ps += "?id="+n.outboundid;
	        		else
	        			ps += "&id="+n.outboundid;
	        	});
	        	$.post(baseURL+'/wms/outbound/dodelete.json'+ps,function(data){
		        	$('#dataTabel').datagrid('reload'); 
		        	//console.log("del--"+data);
	        		$.messager.show({
						title : '提示',
						msg :  data.total+'个信息被删除'+data.msg+'！',
					});
	        	});
	        }
	    });
		}
