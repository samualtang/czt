/**
 * 装卸效率
 */

	var nowTime = getDateYMD();
jQuery(function($){
	
		//$('#orderdate').datebox("setValue",nowTime);
		initTextbox();
	$('#dataTabel').datagrid({
		title:'车辆入园', //标题
		method:'post',
		iconCls:'icon-edit', //图标
		singleSelect:true, //单选
		height:490, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:true,//可折叠
		url:baseURL+"/account/prepay/selectShiporderPerpayOrderList.json", //数据来源
		sortName: 'id', //排序的列
		sortOrder: 'desc', //倒序
		remoteSort: true, //服务器端排序
		idField:'id', //主键字段
		//pageNumber: 1, 
		//pageSize : 20,
		//pageList: [20,30,50],
		queryParams:{
			}, //查询条件
		pagination:false, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号
		columns:[[
			
			
			{field:'customername',title:'客户名称',width:$(this).width()*0.2,
				formatter:function(value,row,index){return row.customername;}
			},
			{field:'customerId',title:'专卖证',width:$(this).width()*0.1,
				formatter:function(value,row,index){return row.customerId;}
			},
			{field:'realshipaddressphone',title:'电话',width:$(this).width()*0.1,
				formatter:function(value,row,index){return row.realshipaddressphone;}
			},
			{field:'routecode',title:'线路',width:$(this).width()*0.05,
				formatter:function(value,row,index){return row.routecode;}
			},
			{field:'totalamount',title:'消费金额',width:$(this).width()*0.05,
				formatter:function(value,row,index){return row.totalamount;}
			},
			{field:'totalqty',title:'条数',width:$(this).width()*0.05,
				formatter:function(value,row,index){return row.totalqty;}
			},
			{field:'orderdate',title:'订单日期',width:$(this).width()*0.1,
				formatter:formatDatebox
			}
		]],
		toolbar:'#toolbar',
		onLoadSuccess:function(){
			$('#dataTabel').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			$('#tabdiv .panel-header').css('display','none'); 
			
		}
	});
});

function formatOper(val,row,index){  
    return '<a href="#" onclick="viewD('+index+')">查看</a>';  
}  
  
function initTextbox(){
	//初始部门
	$('#deptid').combobox({
  		url:baseURL+"/sys/route/getRouteinfoCombobox.json", //数据来源
  	    valueField:'deptid',
  	    textField:'deptname'
  	});
	//初始核算员
	$('#calcid').combobox({
  		url:baseURL+"/sys/route/getRouteCalCombobox.json", //数据来源
  	    valueField:'calcid',
  	    textField:'calcname'
  	});
	//初始预付款客户
	$('#prepayid').combobox({
  		url:baseURL+"/wms/customer/getPrepaycustomerCombobox.json", //数据来源
  	    valueField:'id',
  	    textField:'name'
  	});
	//初始订单日期
	$.ajax({
		url:baseURL+"/account/timebydm/getTimebydm.json?type=0&date="+nowTime, //此处fid无用
		success : function(data) {
			$('#orderdate').datebox("setValue",data.timebydm);
			var orderdate = $("#orderdate").val();
			//initRow(orderdate,consignsor);
         },
         error: function(e) { 
        	 $('#orderdate').datebox("setValue",nowTime);
        	 var orderdate = $("#orderdate").val();
        	 //initRow(orderdate,consignsor);
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
	//$('#queryForm').form('clear');
    $('#deptid').textbox("setValue","");
	$('#deptid').textbox("setText","");
	$('#calcid').textbox("setValue","");
	$('#calcid').textbox("setText","");
	searchData();
}



function exportxls()
{
	var orderdate  =  $("#orderdate").val();
	var calcid  =  $("#calcid").val();
	var deptid  =  $("#deptid").val();
	var prepayid  =  $("#prepayid").val();
	 $.messager.confirm('提示','确定要导出到excel吗?',function(result){
	        if (result){
	        	 $('#queryForm').form('submit', {
	        		 url: baseURL+'/account/prepay/doExportOrderToExcel.json?orderdate='+orderdate+"&calcid="+calcid+"&deptid="+deptid+"&prepayid="+prepayid
	        		
	        	 });
	        }
	 });
	
}

/**
 * 查看窗口
 */
  function viewD(index){
	  $('#add-fm').form('clear');
	  $('#dataTabel').datagrid('selectRow', index);  
      var row = $('#dataTabel').datagrid('getSelected');
		if (row){
			$('#add-dlg').dialog('open').dialog('setTitle',"查看");
			$('#add-dlg').form('load',row);
		}
		
	}

