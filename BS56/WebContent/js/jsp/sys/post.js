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
jQuery(function($){
	$('#dataTabel').datagrid({
		title:'岗位信息维护', //标题
		method:'post',
		iconCls:'icon-edit', //图标
		singleSelect:false, //多选
		height:420, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:true,//可折叠
		url:baseURL+"/sys/post/getPostList.json", //数据来源
		sortName: 'id', //排序的列
		sortOrder: 'desc', //倒序 desc
		remoteSort: true, //服务器端排序
		idField:'id', //主键字段
		pageNumber: 1, 
		pageSize : 10,
		pageList: [10,30,50],
		queryParams:{
			}, //查询条件
		pagination:false, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号
		columns:[[
			{field:'id',checkbox:true,width:2}, //显示复选框
			{field:'postcode',title:'岗位代码',width:20,sortable:false,
				formatter:function(value,row,index){return row.postcode;} //需要formatter一下才能显示正确的数据
			},
			{field:'postname',title:'岗位名称',width:20,sortable:false,
				formatter:function(value,row,index){
					if(row.lvl=='10')return row.postname;
					if(row.lvl=='20')return '&nbsp;&nbsp;'+row.postname;
					if(row.lvl=='30')return '&nbsp;&nbsp;&nbsp;&nbsp;'+row.postname;
					if(row.lvl=='40')return '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+row.postname;
					if(row.lvl=='50')return '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+row.postname;
					
				}
			},
			{field:'lvl',title:'岗位级次',width:30,
				formatter:function(value,row,index){return row.lvl;}
			},
			{field:'deptname',title:'所属部门',width:30,
				formatter:function(value,row,index){return row.deptname;}
			},
			{field:'remarks',title:'备注信息',width:30,
				formatter:function(value,row,index){
					return row.remarks;  
				}
			}
		]],
		toolbar:'#toolbar',
		onLoadSuccess:function(){
			$('#dataTabel').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			$('#tabdiv .panel-header').css('display','none');
		}
	});
});

/**
 * 打开新增岗位信息窗口
 */
function newaddPost(){
	$('#add-fm').form('clear');
	var rows = $('#dataTabel').datagrid('getSelections');
	if(rows.length==0){
		$.messager.alert('提示',"请选择一个上级岗位",'info');
		return;
	}
	if(rows.length > 1){
		$.messager.alert('提示',"只能选择一个上级岗位",'info');
		return;
	}
	var row = $('#dataTabel').datagrid('getSelected');
	if(row.lvl=='50'){
		$.messager.alert('提示',"第五级岗位已是最小岗位单位，无法新增子岗位，请重新选择！",'info');
		return;
	}else{
		//$('#superiorsid').textbox("setValue",row.id);
		//$('#lvl').textbox("setValue",(parseInt(row.lvl)+10));
		$('#superiorsid').val(row.id);
		$('#lvl').val((parseInt(row.lvl)+10));
		//alert($('#superiorsid').val());
		//alert($('#lvl').val());
	}
	$('#add-dlg').dialog('open').dialog('setTitle','增加岗位信息');
	$("#deptid").combobox({
        url : baseURL+"/sys/post/getDeptTreeList.json",//返回json数据的url

        valueField : "id",//这个id和你返回json里面的id对应

        textField : "deptname", //这个text和你返回json里面的text对应
        
        //panelHeight: 'auto'

    })
	
}

/**
 * 保存岗位信息
 */
function saveAdd(){
	//alert($("#add-fm").serializeArray());
	$('#add-fm').form('submit',{
		onSubmit: function(){
			var isValidate = $(this).form('validate');
			if(isValidate){
				//$('#loading').window('open');
			}
			return isValidate;
		},
		url:baseURL+"/sys/post/doPostNew.json",
		data:$("#add-fm").serializeArray(),
		beforeSend : function () {
			$.messager.progress({
				text : '正在新增中...',
			});
		},
		success: function(data){
			//$('#loading').window('close');
			data = eval('('+data+')');
			$('#add-dlg').dialog('close');
			$('#dataTabel').datagrid('reload'); 
    		$.messager.show({
				title : '提示',
				msg :  data.total+'个岗位信息新增'+data.msg+'！',
			});
			//$('#loading').window('close');
		}
	});
}


/**
 * 打开修改窗口
 */
  function openEdit(){
	  $("#deptid2").combobox({
	        url : baseURL+"/sys/post/getDeptTreeList.json",//返回json数据的url

	        valueField : "id",//这个id和你返回json里面的id对应

	        textField : "deptname", //这个text和你返回json里面的text对应
	        
	        //panelHeight: 'auto'

	    })
		var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要更新的岗位信息",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一条岗位信息进行更新",'info');
			return;
		}
		var row = $('#dataTabel').datagrid('getSelected');
		if (row){
			$('#edit-dlg').dialog('open').dialog('setTitle','修改岗位信息');
			$('#edit-fm').form('load',row);
			//url = '/BS56/sys/roleNew.json';
		}

	}
  
  /**
   * 保存修改的岗位信息
   */
  function saveEdit(){
  	$('#edit-fm').form('submit',{
  		onSubmit: function(){
  			var isValidate = $(this).form('validate');
  			if(isValidate){
  				//$('#loading').window('open');
  			}
  			return isValidate;
  		},
  		success: function(data){
			//$('#loading').window('close');
			data = eval('('+data+')');
			$('#edit-dlg').dialog('close');
			$('#dataTabel').datagrid('reload'); 
    		$.messager.show({
				title : '提示',
				msg :  data.total+'个岗位信息修改'+data.msg+'！',
			});
			//$('#loading').window('close');
		}
  	});
  }
  
  function deleterow(){
		var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
		$.messager.alert('提示',"请选择你要删除的岗位信息",'info');
		return;
	}
		$.messager.confirm('提示','确定要删除岗位信息吗?',function(result){
      if (result){
      	var ps = "";
      	$.each(rows,function(i,n){
      		if(i==0) 
      			ps += "?id="+n.id;
      		else
      			ps += "&id="+n.id;
      	});
      	$.post('/BS56/sys/post/doPostDel.json'+ps,function(data){
	        	$('#dataTabel').datagrid('reload'); 
	        	//console.log("del--"+data);
      		$.messager.show({
					title : '提示',
					msg :  data.total+'个系统岗位信息被删除'+data.msg+'！',
				});
      	});
      }
  });
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