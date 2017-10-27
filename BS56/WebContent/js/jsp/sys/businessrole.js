var url;

/**
 * 打开新增角色窗口
 */
function newrow(){
	$('#add-dlg').dialog('open').dialog('setTitle','增加业务角色');
	$('#add-fm').form('clear');
	//url = '/BS56/sys/roleNew.json';
	//$('#add-dlg').dialog('colse');
}


/**
 * 新建角色
 */
function saverow(){
	$('#add-fm').form('submit',{
		onSubmit: function(){
			var isValidate = $(this).form('validate');
			if(isValidate){
				//$('#loading').window('open');
			}
			return isValidate;
		},
		url:baseURL+"/sys/businessrole/roleNew.json",
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
				msg :  data.total+'个角色新增'+data.msg+'！',
			});
			//$('#loading').window('close');
		}
	});
}



/**
 * 打开更新窗口
 */
  function openEdit(){
		var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要更新的用户",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一位用户进行更新",'info');
			return;
		}
		var row = $('#dataTabel').datagrid('getSelected');
		if (row){
			$('#edit-dlg').dialog('open').dialog('setTitle','修改业务角色');
			$('#edit-fm').form('load',row);
		}

	}
  
  /**
   * 保存修改的预案
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
				msg :  data.total+'个角色修改'+data.msg+'！',
			});
			//$('#loading').window('close');
		}
  	});
  }
  
//删除
	function deleterow(){
		var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
		$.messager.alert('提示',"请选择你要删除的业务角色",'info');
		return;
	}
		$.messager.confirm('提示','确定要删除吗?',function(result){
        if (result){
        	var ps = "";
        	$.each(rows,function(i,n){
        		if(i==0) 
        			ps += "?id="+n.id;
        		else
        			ps += "&id="+n.id;
        	});
        	$.post(baseURL+'/sys/businessrole/roledelete.json'+ps,function(data){
	        	$('#dataTabel').datagrid('reload'); 
	        	//console.log("del--"+data);
        		$.messager.show({
					title : '提示',
					msg :  data.total+'个业务角色被删除'+data.msg+'！',
				});
        	});
        }
    });
	}
	
	  //查询
	function searchUser(){
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
		searchUser();
	}
	
	function openSetting(){
		var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要授权的角色",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"一次只能选择一个角色授权",'info');
			return;
		}
		var row = $('#dataTabel').datagrid('getSelected');
		//console.log(row.id);
		var roleid=row.id;
		$.ajax({ 
		    url: baseURL+'/sys/menu/getSysMenu.json', 
		    type: 'POST', 
		    success: function(data){
				//console.log(data);
				//var result = eval('('+data.rows+')');
		    	var url;
				$(data.rows).each(function(i,val) {
					//console.log(val.id+"--"+val.name+",roleid="+roleid);
				  url = baseURL+"/sys/role/toRoleSetting?sysid="+val.id+"&roleid="+roleid;
				  addTab(val.id,val.name,url);
				}); 
			}
		   }); 
		$('#rolewin').window('open');
	  // $('.panel window').addClass("easyui-fluid");
		//$('.panel-tool-max').addClass("panel-tool-restore");
	}
	
	function openGrant(){
		
		var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要授权的业务角色",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"一次只能选择一个业务角色授权",'info');
			return;
		}
		var row = $('#dataTabel').datagrid('getSelected');
		//console.log(row.id);
		var roleid=row.id;
		parent.addTab('角色授权',baseURL+"/chooseUser?roleid="+roleid+"&optype=businessrolegrant",'icon-mygroup');
		
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
	
	var url;

	//添加选项卡  
	function addTab(id,title, url){                  
	        content = '<iframe scrolling="no" frameborder="0"  src="' + url+ '" style="width:100%;height:100%;"></iframe>';  
	        if(!$("#tabs-box").tabs('exists', title)){  
	            $("#tabs-box").tabs("add", { 
	         id : id,
	         title : title,  
	         closable :  false,  
	         collapsible : true,
	         content : content,  
	         width: 600 ,  
	         height: 400,  
	         selected : true,
	         iconCls : 'icon-add',
	         border:true
	        } );                   
	    }else{  
	         $('#tabs-box').tabs('select', title);  
	    }            
	} 
	
	function openOperation(){
		var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要授权的角色",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"一次只能选择一个角色授权",'info');
			return;
		}
		var row = $('#dataTabel').datagrid('getSelected');
		//console.log(row.id);
		var roleid=row.id;
		parent.addTab('功能点授权',baseURL+'/sys/role/toRoleoperation.json?roleid='+roleid,'icon-mygroup');
	}