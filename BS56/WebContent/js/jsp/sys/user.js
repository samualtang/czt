var url;
var grantRow;	

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
	$('#dataTable').datagrid({
		title:'员工信息', //标题
		method:'post',
		iconCls:'icon-edit', //图标
		singleSelect:false, //多选
		height:420, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:true,//可折叠
		url:baseURL+"/sys/user/getUsers.json", //数据来源
		sortName: 'usercode', //排序的列
		sortOrder: 'asc', //倒序 desc
		remoteSort: true, //服务器端排序
		idField:'id', //主键字段
		pageNumber: 1, 
		pageSize : 10,
		pageList: [10,30,50],
		queryParams:{
			}, //查询条件
		pagination:true, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号  
		columns:[[
			{field:'id',checkbox:true,width:2}, //显示复选框
			{field:'usercode',title:'用户CODE',width:20,sortable:true,
				formatter:function(value,row,index){return row.usercode;} //需要formatter一下才能显示正确的数据
			},
			{field:'username',title:'用户姓名',width:20,sortable:true,
				formatter:function(value,row,index){return row.username;}
			},
			{field:'deptname',title:'所属部门',width:30,sortable:true,
				formatter:function(value,row,index){return row.deptname;}
			},
			{field:'phonenum',title:'手机号码',width:30,
				formatter:function(value,row,index){return row.phonenum;}
			},
			{field:'idnum',title:'身份证号',width:30,
				formatter:function(value,row,index){return row.idnum;}
			},
			{field:'rolename',title:'所属角色',width:30,
				formatter:function(value,row,index){return row.rolename;}
			},
			{field:'postname',title:'岗位',width:30,
				formatter:function(value,row,index){return row.postname;}
			}
		]],
		toolbar:'#toolbar',
		onLoadSuccess:function(){
			$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			$('#tabdiv .panel-header').css('display','none');
		}
	});
	//var mydate = new Date();
	//var date=mydate.getFullYear()+"-"+((mydate.getMonth()+1)<10?"0":"")+(mydate.getMonth()+1)+"-"+(mydate.getDate()<10?"0":"")+mydate.getDate();
	//$("#birthdate").val(date+"");
});

/**
 * 打开新增用户信息窗口
 */
function newAddUser(){
	//岗位下拉列表
	$("#userpostid").combobox({
        url : baseURL+"/sys/user/getPostCombobox.json",//返回json数据的url
        valueField : "id",//这个id和你返回json里面的id对应
        textField : "postname", //这个text和你返回json里面的text对应
        //panelHeight: 'auto'
    })
    //部门下拉列表
    $("#deptid").combobox({
    	url : baseURL+"/sys/user/getDeptCombobox.json",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "deptname", //这个text和你返回json里面的text对应
    	//panelHeight: 'auto'
    })
    //银行下拉列表
    $("#bankid").combobox({
    	url : baseURL+"/sys/user/getBanksCombobox.json",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "contentlist", //这个text和你返回json里面的text对应
    	//panelHeight: 'auto'
    })
    //民族下拉列表
    $("#nation").combobox({
    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=NATION",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "contentlist", //这个text和你返回json里面的text对应
    	//panelHeight: 'auto'
    })
    //政治面貌下拉列表
    $("#politicalstatus").combobox({
    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=POLITICAL",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "contentlist", //这个text和你返回json里面的text对应
    	//panelHeight: 'auto'
    })
    //语种下拉列表
    $("#foreignlanguage").combobox({
    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=LANGUAGE",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "contentlist", //这个text和你返回json里面的text对应
    	//panelHeight: 'auto'
    })
    //外来派遣下拉列表
    $("#worksource").combobox({
    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=WORKSOURCE",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "contentlist", //这个text和你返回json里面的text对应
    	//panelHeight: 'auto'
    })
    //学历下拉列表
    $("#education").combobox({
    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=EDU",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "contentlist", //这个text和你返回json里面的text对应
    	//panelHeight: 'auto'
    })
    //角色下拉列表
    $("#roleid").combobox({
    	url : baseURL+"/sys/user/getRolesCombobox.json",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "rolename", //这个text和你返回json里面的text对应
    	//panelHeight: 'auto'
    })
	$('#add-dlg').dialog('open').dialog('setTitle','增加用户信息');
	$('#add-fm').form('reset');
}

/**
 * 保存新建用户信息
 */
function saveAdd(){
	$('#add-fm').form('submit',{
		onSubmit: function(){
			//var isValidate = $(this).form('validate');
			//if(isValidate){
				//$('#loading').window('open');
			//}
			//return isValidate;
		},
		//sys/user/user/
		url:baseURL+"/sys/user/doUserNew.json",
		//data:$("#add-fm").serializeArray(),
		beforeSend : function () {
			$.messager.progress({
				text : '正在新增中...',
			});
		},
		success: function(data){
			//$('#loading').window('close');
			data = eval('('+data+')');
			$('#add-dlg').dialog('close');
			$('#dataTable').datagrid('reload'); 
    		$.messager.show({
				title : '提示',
				msg :  data.total+'个用户信息新增'+data.msg+'！',
			});
			//$('#loading').window('close');
		}
	});
}


/**
 * 打开修改窗口
 */
  function openEdit(){
		var rows = $('#dataTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要修改的用户信息",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一个用户进行修改操作",'info');
			return;
		}
		var row = $('#dataTable').datagrid('getSelected');
		if (row){
			//岗位下拉列表
			$("#userpostid1").combobox({
		        url : baseURL+"/sys/user/getPostCombobox.json",//返回json数据的url
		        valueField : "id",//这个id和你返回json里面的id对应
		        textField : "postname", //这个text和你返回json里面的text对应
		        //panelHeight: 'auto'
		    })
		    //部门下拉列表
		    $("#deptid1").combobox({
		    	url : baseURL+"/sys/user/getDeptCombobox.json",//返回json数据的url
		    	valueField : "id",//这个id和你返回json里面的id对应
		    	textField : "deptname", //这个text和你返回json里面的text对应
		    	//panelHeight: 'auto'
		    })
		    //银行下拉列表
		    $("#bankid1").combobox({
		    	url : baseURL+"/sys/user/getBanksCombobox.json",//返回json数据的url
		    	valueField : "id",//这个id和你返回json里面的id对应
		    	textField : "contentlist", //这个text和你返回json里面的text对应
		    	//panelHeight: 'auto'
		    })
		    //民族下拉列表
		    $("#nation1").combobox({
		    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=NATION",//返回json数据的url
		    	valueField : "id",//这个id和你返回json里面的id对应
		    	textField : "contentlist", //这个text和你返回json里面的text对应
		    	//panelHeight: 'auto'
		    })
		    //政治面貌下拉列表
		    $("#politicalstatus1").combobox({
		    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=POLITICAL",//返回json数据的url
		    	valueField : "id",//这个id和你返回json里面的id对应
		    	textField : "contentlist", //这个text和你返回json里面的text对应
		    	//panelHeight: 'auto'
		    })
		    //语种下拉列表
		    $("#foreignlanguage1").combobox({
		    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=LANGUAGE",//返回json数据的url
		    	valueField : "id",//这个id和你返回json里面的id对应
		    	textField : "contentlist", //这个text和你返回json里面的text对应
		    	//panelHeight: 'auto'
		    })
		    //外来派遣下拉列表
		    $("#worksource1").combobox({
		    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=WORKSOURCE",//返回json数据的url
		    	valueField : "id",//这个id和你返回json里面的id对应
		    	textField : "contentlist", //这个text和你返回json里面的text对应
		    	//panelHeight: 'auto'
		    })
		    //学历下拉列表
		    $("#education1").combobox({
		    	url : baseURL+"/sys/user/getComboboxByTypeCode.json?typeCode=EDU",//返回json数据的url
		    	valueField : "id",//这个id和你返回json里面的id对应
		    	textField : "contentlist", //这个text和你返回json里面的text对应
		    	//panelHeight: 'auto'
		    })
		    //角色下拉列表
		    $("#roleid1").combobox({
		    	url : baseURL+"/sys/user/getRolesCombobox.json",//返回json数据的url
		    	valueField : "id",//这个id和你返回json里面的id对应
		    	textField : "rolename", //这个text和你返回json里面的text对应
		    	//panelHeight: 'auto'
		    })
		    var webroot=document.location.href;
			var pathName=window.document.location.pathname;  
			var pos=webroot.indexOf(pathName);  
		    //获取主机地址，如： http://localhost:8083  
		    var localhostPath=webroot.substring(0,pos);  
			//alert(pathName);
			var cname=row.photoname;
			//http://localhost:8080/BS56/user/201705/20170502152635_526.jpg
			if(cname!=null&&cname!="")cname=localhostPath+baseURL+"/"+cname;
			else cname="";
			//alert(cname);
			//cname=cname.replace('\\','/');
			//row.photoname=cname;
			$('#edit-dlg').dialog('open').dialog('setTitle','修改用户信息');
			$('#edit-fm').form('load',row);
			$("#photoname").attr('src',cname); 
			$("#photoname").attr('width',"65%"); 
			//url = baseURL+'/sys/user/roleNew.json';
		}
  }
		
  /**
   * 保存修改的用戶信息
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
  		url:baseURL+"/sys/user/doUpdateUser.json",
  		success: function(data){
			//$('#loading').window('close');
			data = eval('('+data+')');
			$('#edit-dlg').dialog('close');
			$('#dataTable').datagrid('reload'); 
    		$.messager.show({
				title : '提示',
				msg :  data.total+'个用戶信息修改'+data.msg+'！',
			});
			//$('#loading').window('close');
		}
  	});
  }
  
		/**
		 * 打开授权窗口
		 */
		function openGrant(){
			var rows = $('#dataTable').datagrid('getSelections');
			if(rows.length==0){
				$.messager.alert('提示',"请选择你要授权的用户",'info');
				return;
			}
			if(rows.length > 1){
				$.messager.alert('提示',"只能选择一个用户进行授权",'info');
				return;
			}
			grantRow = $('#dataTable').datagrid('getSelected');
			if (grantRow){
				$('#grant-dlg').dialog('open').dialog('setTitle','用户授权操作');
				$("#userid").attr("value",grantRow.id);
				$("#grantusercode").html(grantRow.usercode);
				$("#grantusername").html(grantRow.username);
				$("#deptname").html(grantRow.deptname);
				$("#postname").html(grantRow.postname);
				//角色下拉列表
			    $("#roleid2").combobox({
			    	url : baseURL+"/sys/user/getRolesCombobox.json",//返回json数据的url
			    	valueField : "id",//这个id和你返回json里面的id对应
			    	textField : "rolename", //这个text和你返回json里面的text对应
			    	//panelHeight: 'auto'
			    })
			}

	}
		
		//授权
		function saveGrant(){
			$('#grant-fm').form('submit',{
				onSubmit: function(){
					var isValidate = $(this).form('validate');
					if(isValidate){
						//$('#loading').window('open');
					}
					return isValidate;
				},
				//sys/user/user/
				url:baseURL+"/sys/user/doUserGrant.json",
				data:$("#grant-fm").serializeArray(),
				success: function(data){
					//$('#loading').window('close');
					data = eval('('+data+')');
					$('#grant-dlg').dialog('close');
					$('#dataTable').datagrid('reload'); 
		    		$.messager.show({
						title : '提示',
						msg :  data.total+'个用户信息授权'+data.msg+'！',
					});
					//$('#loading').window('close');
				}
			});
		}
	
//密码重置
	function resetPsw(){
		var rows = $('#dataTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要重置密码的用户",'info');
			return;
		}
		$.messager.confirm('提示','确定要重置密码吗?',function(result){
			if (result){
				var ps = "";
				$.each(rows,function(i,n){
					if(i==0) 
						ps += "?id="+n.id;
					else
						ps += "&id="+n.id;
				});
				$.post(baseURL+'/sys/user/resetPsw.json'+ps,function(data){
					$('#dataTable').datagrid('reload'); 
					//console.log("del--"+data);
					$.messager.show({
						title : '提示',
						msg :  data.total+'个用户密码重置'+data.msg+'！',
					});
				});
			}
		});
	}
	
	  //查询
	function searchUser(){
		var params = $('#dataTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
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
		//$('#queryForm').form('clear');
		$('#usercode').textbox("setValue","");
		$('#usercode').textbox("setText","");
		searchUser();
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