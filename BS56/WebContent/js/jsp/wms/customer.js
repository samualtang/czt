var url;

//信息上传进度条初始化
$(function(){
	  $('#loading').window({
			title:'系统提示',
			closable:false,
			collapsible:false,
			minimizable:false,
			maximizable:false,
			resizable:false,
			width:355,
			height:120,
			closed:true,
		    modal:true   
		});
	  
});

/**
 * 页面列表datagrid初始化
 */
jQuery(function(def){
	$("#routecode").combobox({
	    url : baseURL+"/comm/combobox/getRoutesComboboxByDeptid.json?deptid=",//返回json数据的url
	    valueField : "routecode",//这个id和你返回json里面的id对应
	    textField : "routename", //这个text和你返回json里面的text对应
	    loadFilter : function (data) {
	        if (data && data instanceof Array) {
	            data.splice(0, 0, {routecode: '', routename: '请选择车组'});　// 此处空格用全角
	        }
	        return data;
	    }   	
	})
	//alert(baseURL+"/sq/starinfo/getStarinfo.json");
	$('#dataTable').datagrid({
		title:'零售户信息', //标题
		method:'post',
		iconCls:'icon-edit', //图标
		singleSelect:true, //多选,当true时只允许当前选择一行。		height:420, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。		striped: true, //奇偶行颜色不同
		collapsible:true,//可折叠		url:baseURL+"/wms/customer/getCustomerList.json", //数据来源
		sortName: 'id', //排序的列
		sortOrder: 'desc', //正序asc、倒序 desc
		remoteSort: false, //服务器端排序
		idField:'id', //主键字段
		pageNumber: 1, 
		pageSize : 30,
		pageList: [10,30,50],
		queryParams:{
			}, //查询条件
		pagination:true, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号
		columns:[[
			{field:'id',checkbox:true,width:2}, //显示复选框
			{field:'id2',title:'专卖证号',width:20,sortable:false,
				formatter:function(value,row,index){return row.id;} //需要formatter一下才能显示正确的数据
			},
			{field:'contact',title:'联系人',width:20,sortable:false,
				formatter:function(value,row,index){return row.contact;}
			},
//			{field:'code',title:'零售户CODE',width:15,sortable:false,
//				formatter:function(value,row,index){return row.code;} 
//			},
			{field:'contactphone',title:'联系电话',width:20,
				formatter:function(value,row,index){return row.contactphone;}
			},
			{field:'name',title:'店名',width:30,
				formatter:function(value,row,index){return row.name;}
			},
			{field:'routecode',title:'送货车组',width:10,
				formatter:function(value,row,index){return row.routecode;}
			}
		]],
		
		toolbar:'#toolbar',
		onLoadSuccess:function(){
			$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题			$('#tabdiv .panel-header').css('display','none');
		}
	});
});



/**
 * 打开查看窗口
 */
function openView(){
	$(".formtd").each(function(){
	 	   $(this).html("");
	 	 });
		var rows = $('#dataTable').datagrid('getSelections');
		
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要查看的零售户信息",'info');
			return;
		}
		
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一条自零售户信息进行查看",'info');
			return;
		}
 	//$(".formtd");
	viewRow = $('#dataTable').datagrid('getSelected');
	//alert(viewRow);
	if (viewRow!=null){
		$('#view-dlg').dialog('open').dialog('setTitle','零售户信息');
		//$("#id").attr("value",viewRow.id);
		$("#v-id").html(viewRow.id);
		//$("#v-code").html(viewRow.code);
		$("#v-contact").html(viewRow.contact);
		$("#v-contactphone").html(viewRow.contactphone);
		$("#v-name").html(viewRow.name);
		$("#v-contactaddress").html(viewRow.contactaddress);
		$("#v-routecode").html(viewRow.routecode);
		$("#v-remarks").html(viewRow.remarks);
		$('#view-fm').form('clear');
		//alert("----="+viewRow.remarks);
		//return;
	}

	}
	
	  //查询
	function searchCustomer(){
		var params = $('#dataTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		//alert(params.length);
		//alert(fields.length);
		$.each( fields, function(i, field){
			//alert(field.name);
			//alert(field.value);
			params[field.name] = field.value; //设置查询参数
		}); 
		$('#dataTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了
	}
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('reset');
		searchCustomer();
	}
	
	function openTopWindow(url, title, width, height) {
        title = title == undefined ? '&nbsp;' : title;
        width = width == undefined ? 800 : width;
        height = height == undefined ? 300 : height;
        if (url != undefined) {
            var content = '<iframe name="eui-open-page" scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:100%;"></iframe>';
            parent.$('#openWindow').window({
                title: title,
                width: width,
                height: height,
                content: content,
                modal: true,
                animate: true,
                minimizable: false
            });
        }
    }