var url;


/**
 * 页面列表datagrid初始化
 */
jQuery(function($){
	$('#dataTabel').datagrid({
		title:'角色维护', //标题
		method:'post',
		iconCls:'icon-edit', //图标
		singleSelect:false, //多选
		height:490, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:true,//可折叠
		url:baseURL+"/cost/SPLApplyList/getSPLApplyList.json", //数据来源
		sortName: 'id', //排序的列
		sortOrder: 'desc', //倒序
		remoteSort: true, //服务器端排序
		idField:'id', //主键字段
		pageNumber: 1, 
		pageSize : 20,
		pageList: [20,30,50],
		queryParams:{
			listtype:listtype
			}, //查询条件
		pagination:true, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号
		columns:[[
			{field:'id',checkbox:true,width:2}, //显示复选框
			{field:'id2',title:'id',width:10,sortable:true,
				formatter:function(value,row,index){return row.id;} //需要formatter一下才能显示正确的数据
			},
			{field:'deptname',title:'部门',width:10,
				formatter:function(value,row,index){return row.deptname;}
			},
			{field:'applyusername',title:'申请人',width:10,sortable:true,
				formatter:function(value,row,index){return row.applyusername;} //需要formatter一下才能显示正确的数据
			},
			{field:'applydate',title:'申请时间',width:10,sortable:true,
				formatter:function(value,row,index){return row.applydate;}
			},
			{field:'mngusername',title:'审核人',width:10,sortable:true,
				formatter:function(value,row,index){return row.mngusername;}
			},
			{field:'auditflagname',title:'审核状态',width:10,sortable:true,
				formatter:function(value,row,index){return row.auditflagname;}
			},
			{field:'remarks',title:'备注信息',width:30,
				formatter:function(value,row,index){
					//return row.deptName;  //该列的值是deptId，显示的是deptName
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
	searchUser();
}

/**
 * 打开新增窗口
 */
function openCreate(){
	$('#add-fm').form('clear');
	$('#add-dlg').dialog('open').dialog('setTitle','领料申请');
	// $('#applyusername').textbox('setText', username);
	$("#splchoose-div" ).css("display", "block"); //类型显示
	initSplType();
	initDept();
	var nowTime = getDateYMD();
	 $('#applydate').textbox('setText', nowTime);
	 $("#audit-div" ).css("display", "none"); //审核不显示
	 $("#listtabdiv" ).css("display", "none"); //列表不显示
	 $("#purpose").textbox('textbox').attr('readonly',false);//移除只读，在审核窗口设置过为只读
	 $('#btn-audit').linkbutton('disable'); 
	 $('#btn-back').linkbutton('disable'); 
	 $('#applyusername').textbox('setText', username);
	 
}

function initDept(){
	//部门下拉列表
    $("#deptid").combobox({
    	url : baseURL+"/cost/SPLApplyList/getDeptComboboxByCond.json",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "deptname", //这个text和你返回json里面的text对应
    	onLoadSuccess: function () { //加载完成后,设置选中用户所属部门
                    //$(this).combobox("select", deptid);  
    		var typecode=$("#deptid").val();
    		var choosebz = 0;
	    	if(typecode==null||typecode==""){
	            var val = $(this).combobox("getData");
	          //如果登陆用户部门在二级部门里面，则默认选中用户部门，否则默认选中第一个
	            for (var i = 0; i < val.length; i++){
	            	for (var item in val[i]) {
	            		if (item == "id") {
		                	if(deptid==val[i][item]){
		                		choosebz=1;
		 	                   typecode=deptid;
		 	                    $(this).combobox("select", typecode);
		                	}
		                }
	            	}
	            }
	            if(choosebz==0){//没有选中用户所在部门,则默认选中第一个
	            	for (var item in val[0]) {
		                if (item == "id") {
		                   typecode=val[0][item];
		                    $(this).combobox("select", typecode);
		                }
		            }
	            }
	            
	    	}
        }
    	//panelHeight: 'auto'
    })
}
function initSplType()
{
	//物资类别一级
	$("#lvl1").combobox({
		url : baseURL+"/cost/SPLTypeInfo/getSPLTypesCombobox.json?clevel=2&fid=2&reqType=forComb",//返回json数据的url
		valueField : "id",//这个id和你返回json里面的id对应
		textField : "typename", //这个text和你返回json里面的text对应
		//required:true,
		onSelect: function (row1) {  
	        if (row1 != null) {  
	        	//物资类别二级
	            $('#lvl2').combobox({  
	            	url : baseURL+"/cost/SPLTypeInfo/getSPLTypesCombobox.json?clevel=3&fid="+row1.id+"&reqType=forComb",//返回json数据的url
	                valueField : "id",//这个id和你返回json里面的id对应
	            	textField : "typename", //这个text和你返回json里面的text对应
	            	//required:true,
	            	onSelect: function (row2) {  
	                    if (row2 != null) {  
	                    	//物资类别三级
	                       // $('#typeid').combobox({  
	                    	$.ajax({
	                        	url : baseURL+"/cost/SPLTypeInfo/getSPLTypesCombobox.json?clevel=4&fid="+row2.id+"&reqType=forComb&listtype="+listtype,//返回json数据的url
	                        	//valueField : "id",//这个id和你返回json里面的id对应
	                        	//textField : "typename", //这个text和你返回json里面的text对应
	                        	//required:true,
	                        	success : function(data) {
	               				 $(".gridtable tr").remove(".dynamic-tr");
	               				var listTmp = "";
	               	             $.each(data, function(i, cust) {
	               	            	listTmp = listTmp +"<tr class='dynamic-tr' ><td>"+cust.id+"</td><td>"+cust.typename+"</td><td>"+cust.canUseQty+"</td><td>"+cust.unit+"</td>"+
	               	            	"<td><input name='rad' id=rad"+i+" type='radio' onClick=radClick('"+cust.id+"','"+cust.typename+"','"+cust.canUseQty+"','"+cust.unit+"') value="+cust.id+"></td></tr>";
	               	             });
	               	           $(".gridtable tbody").append (listTmp);
	               	           if(listTmp==""){
	               	        	$.messager.alert('系统提示', '该物资库存为零或请输入正确的物资类型查询！', 'warning');
	               	           }
	               	         },
	               	         error: function(e) { 
	               	        	$.messager.alert('系统提示', '该物资库存为零或请输入正确的物资类型查询！', 'warning');
	               	          	} 
	                    	});
	                        	//onSelect: function (row3) {
	                        	//	$('#unitid').val(row3.unit);
	                        	//}
	                     //   });  
	                    }  
	                }  
	            });  
	        }  
	    }  
	})
	}

function radClick(id,typename,canUseQty,unit){
	$('#typeid').val(id);
	$('#typename').textbox("setValue",typename);
	$('#typename').textbox("setText",typename);
	$('#surplusqty').textbox("setValue",canUseQty);
	$('#surplusqty').textbox("setText",canUseQty);
	$('#unit').textbox("setValue",canUseQty);
	$('#unit').textbox("setText",unit);
}

//查找类别
function searchType(){
	//先选择车组
	//var routecode= $("#croutecode").val(); 
	var condname= $("#condname").val(); 
		if(condname==null||condname=="")
			{
			$.messager.alert('系统提示', '请输入查询信息！', 'warning');
			return;
			}
		//根据车组返回零售户信息getCustListByRouteCode
		$.ajax({
			url:baseURL+"/cost/SPLTypeInfo/getSPLTypesCombobox.json?typename="+condname+"&clevel=4&fid=1&reqType=forSearch&listtype="+listtype, //此处fid无用
			success : function(data) {
				 $(".gridtable tr").remove(".dynamic-tr");
				var listTmp = "";
	             $.each(data, function(i, cust) {
	            	 listTmp = listTmp +"<tr class='dynamic-tr' ><td>"+cust.id+"</td><td>"+cust.typename+"</td><td>"+cust.canUseQty+"</td><td>"+cust.unit+"</td>"+
    	            	"<td><input name='rad' id=rad"+i+" type='radio' onClick=radClick('"+cust.id+"','"+cust.typename+"','"+cust.canUseQty+"','"+cust.unit+"') value="+cust.id+"></td></tr>";
	             });
	           $(".gridtable tbody").append (listTmp);
	           if(listTmp==""){
      	        	$.messager.alert('系统提示', '该物资库存为零或请输入正确的物资类型查询！', 'warning');
      	           }
	         },
	         error: function(e) { 
	          	} 
		})
}

function saveNew(){
	var url = "";
	if(listid==0){
		url=baseURL+"/cost/SPLApplyList/doSave.json?reqType=first&listid="+listid;
		
	}
	else{//继续领用
		//获取领用单信息 填充备注
		//清空物资类别等信息
		url= baseURL+"/cost/SPLApplyList/doSave.json?reqType=second&listid="+listid;
	}
	saveNewStart(url);
}
/**
 * 提交新增
 */
function saveNewStart(url){
	var deptid= $("#deptid").val(); 
	var typename= $("#typename").val(); 
	var surplusqty= $('#surplusqty').val();
	var applyqty= $("#applyqty").val(); 
	$('#applyid').val(userid);
	if(deptid==null||deptid==""){
		$.messager.alert('系统提示', '请选择耗用部门！', 'warning');
		return;
	}
	if(typename==null||typename==""){
		$.messager.alert('系统提示', '请选择物资类别！', 'warning');
		return;
	}
	if(applyqty==null||applyqty==""){
		$.messager.alert('系统提示', '请输入申请数量！', 'warning');
		return;
	}
	if((parseInt(surplusqty)-parseInt(applyqty))<0){
		$.messager.alert('系统提示', '您的申请数量超过了库存数量！', 'warning');
		return;
	}
	$('#add-fm').form('submit',{
		onSubmit: function(){
			var isValidate = $(this).form('validate');
			if(isValidate){
			}
			return isValidate;

		},
		url:url,
		data:$("#add-fm").serializeArray(),
		beforeSend : function () {
			$.messager.progress({
				text : '正在新增中...',
			});
		},
		success: function(data){
			
			data = eval('('+data+')');
			listid = data.listid;
			//$('#add-dlg').dialog('close');
			$('#dataTabel').datagrid('reload'); 
    		$.messager.show({
				title : '提示',
				msg :  data.total+'个领料申请'+data.msg+'！',
			});
    		$("#listtabdiv" ).css("display", "block");
    		getsplapplylistline();
		}
	});
}

function getsplapplylistline()
{
		//获取领料新增分配的物资明细列表
	$('#listdataTabel').datagrid({
		title:'事情物品列表', //标题
		method:'post',
		iconCls:'icon-view', //图标
		singleSelect:false, //多选
		height:200, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
		striped: true, //奇偶行颜色不同
		collapsible:false,//可折叠
		url:baseURL+"/cost/SPLApplyList/getSPLApplyListLine.json?listid="+listid, 
		sortName: 'id', //排序的列
		sortOrder: 'desc', //倒序
		remoteSort: true, //服务器端排序
		idField:'id', //主键字段
		pagination:false, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号
		columns:[[
			{field:'id',title:'id',width:10,sortable:true,
				formatter:function(value,row,index){return row.id;} //需要formatter一下才能显示正确的数据
			},
			{field:'typename',title:'类型',width:10,
				formatter:function(value,row,index){return row.typename;}
			},
			{field:'splname',title:'物品',width:10,sortable:true,
				formatter:function(value,row,index){return row.splname;} //需要formatter一下才能显示正确的数据
			},
			{field:'applyqty',title:'申请数量',width:10,sortable:true,
				formatter:function(value,row,index){return row.applyqty;}
			},
			{field:'price',title:'单价',width:10,sortable:true,
				formatter:function(value,row,index){return row.price;}
			},
			{field:'amount',title:'总金额',width:10,sortable:true,
				formatter:function(value,row,index){return row.amount;}
			},
		]],
		onLoadSuccess:function(){
			$('#listtabdiv .panel-header').css('display','none'); 
			
		}
	});
	
	//移除本次新增的数据
	$(".gridtable tr").remove(".dynamic-tr");
	$('#typename').textbox("setValue","");
	$('#typename').textbox("setText","");
	$('#surplusqty').textbox("setValue","");
	$('#surplusqty').textbox("setText","");
	$('#unit').textbox("setValue","");
	$('#unit').textbox("setText","");
	}


/**
 * 查看窗口
 */
  function viewD(){
	  $('#add-fm').form('clear');
	  var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要查看的领料信息",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一条领料信息进行查看",'info');
			return;
		}
		
		var row = $('#dataTabel').datagrid('getSelected');
		var auditflag = row.auditflag;//审核状态
		//未审核时不现实审核div
		if(auditflag=="0"){
			$("#audit-div" ).css("display", "none"); 
		}
		else{
			$("#audit-div" ).css("display", "block"); //审核显示
		}
		
		listid = row.id;
		if (row){
			$('#add-dlg').dialog('open').dialog('setTitle',"查看");
			$('#add-dlg').form('load',row);
			$("#splchoose-div" ).css("display", "none"); 
			$("#listtabdiv" ).css("display", "block"); //列表显示
			$('#btn-save').linkbutton('disable'); 
			 $('#btn-audit').linkbutton('disable'); 
			 $('#btn-back').linkbutton('disable'); 
		}
		getsplapplylistline();
	}

  /**
   * 审核
   */
  /**
   * 查看窗口
   */
    function openAudit(){
    	$('#add-fm').form('clear');
    	$("#audit-div" ).css("display", "block"); //审核显示
    	$("#listtabdiv" ).css("display", "block"); //列表显示
    	var nowTime = getDateYMD();
   	 $('#mngauditdate').textbox('setText', nowTime);
   	$('#mngusername').textbox('setText', username);
   	$('#mngid').val(userid);
   	$("#purpose").textbox('textbox').attr('readonly',true);
  	  var rows = $('#dataTabel').datagrid('getSelections');
  		if(rows.length==0){
  			$.messager.alert('提示',"请选择你要查看的领料信息",'info');
  			return;
  		}
  		if(rows.length > 1){
  			$.messager.alert('提示',"只能选择一条领料信息进行查看",'info');
  			return;
  		}
  		
  		var row = $('#dataTabel').datagrid('getSelected');
  		listid = row.id;
  		var auditflag = row.auditflag;
  		if(auditflag!="0"){
  			$.messager.alert('提示',"对不起，本条申请信息已经审核或发料，不能再次审核！",'info');
  			return;
  		}
  		if (row){
  			$('#add-dlg').dialog('open').dialog('setTitle',"查看");
  			$('#add-dlg').form('load',row);
  			$("#splchoose-div" ).css("display", "none"); 
  			$('#btn-save').linkbutton('disable'); 
  			$('#btn-audit').linkbutton('enable'); 
  			$('#btn-back').linkbutton('enable'); 
  			$('#btn-done').linkbutton('enable'); 
  		}
  		getsplapplylistline();
  	}
    
    function doAudit(auditflag){
    	var alertMsg = "确定通过吗？";
    	var mngid= $("#mngid").val(); 
    	if(auditflag=="40"){alertMsg = "确定驳回吗？";}
    	$.messager.confirm('提示',alertMsg,function(result){
    		if(result){
    			$('#add-fm').form('submit',{
        			url:baseURL+"/cost/SPLApplyList/doAudit.json?listid="+listid+"&auditflag="+auditflag+"&mngid="+mngid, 
            		data:$("#add-fm").serializeArray(),
            		beforeSend : function () {
            			$.messager.progress({
            				text : '正在新增中...',
            			});
            		},
            		success: function(data){
            			data = eval('('+data+')');
            			$('#add-dlg').dialog('close');
            			$('#dataTabel').datagrid('reload'); 
                		$.messager.show({
            				title : '提示',
            				msg :  data.msg,
            			});
                		
                		//$("#listtabdiv" ).css("display", "block");
                		//getsplapplylistline();
            		}
            	});
    		}
    		
    	});
    }
    
  //删除
	function deleterow(){
		var rows = $('#dataTabel').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要删除的领料申请信息",'info');
			return;
		}
		if(rows.length > 1){
  			$.messager.alert('提示',"只能选择一条领料信息进行删除",'info');
  			return;
  		}
		var row = $('#dataTabel').datagrid('getSelected');
  		listid = row.id;
  		var applyid = row.applyid;
  		var auditflag = row.auditflag;//审核状态
  		if(auditflag=="50"||auditflag=="60")//发料完成或退库完成的，不再允许删除
  			{
	  			$.messager.alert('提示',"对不起，该领料信息不允许删除！",'info');
	  			return;
  			}
  		if(applyid!=userid){
  			$.messager.alert('提示',"对不起，您无权删除别人的领料申请信息！",'info');
  			return;
  		}
		$.messager.confirm('提示','确定要删除吗?',function(result){
        if (result){
        	$.post(baseURL+'/cost/SPLApplyList/doDel.json?listid='+listid+"&auditflag="+auditflag,function(data){
	        	$('#dataTabel').datagrid('reload'); 
	        	//console.log("del--"+data);
        		$.messager.show({
					title : '提示',
					msg :  data.total+'个领料信息'+data.msg+'！',
				});
        	});
        }
    });
	}