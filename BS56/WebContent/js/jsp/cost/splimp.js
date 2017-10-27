var url;
//alert("-====");
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

function initSettleDatagrid(){
	var begdate=$('#begdate').datebox('getValue')
	var enddate=$('#enddate').datebox('getValue')
	var settleflag=$('#settlementflag').val();
	var param=$('#param').val();
	//定义表头
	var columnarr=[[
		{field:'id',checkbox:true,width:2}, //显示复选框
		{field:'typename',title:'物资类别',width:20,sortable:true,
			formatter:function(value,row,index){return row.typename;} //需要formatter一下才能显示正确的数据
		},
		{field:'code',title:'物资编号',width:20,sortable:true,
			formatter:function(value,row,index){return row.code;} //需要formatter一下才能显示正确的数据
		},
		{field:'splname',title:'物资名称',width:20,sortable:true,
			formatter:function(value,row,index){return row.splname;} //需要formatter一下才能显示正确的数据
		},
		{field:'suppliername',title:'供应商',width:50,sortable:true,
			formatter:function(value,row,index){return row.suppliername;} //需要formatter一下才能显示正确的数据
		},
		{field:'price',title:'单价(元)',width:20,sortable:false,
			formatter:function(value,row,index){return row.price;}
		},
		{field:'unitid',title:'单位',width:20,
			formatter:function(value,row,index){return row.unitid;}
		},
		{field:'initqty',title:'入库数量',width:20,
			formatter:function(value,row,index){return row.initqty;}
		},
		{field:'totalamount',title:'入库金额(元)',width:20,
			formatter:function(value,row,index){return row.totalamount;}
		},
		{field:'imptime',title:'入库时间',width:30,sortable:true,
			formatter:function(value,row,index){return row.imptime;}
		},
		{field:'settleflagname',title:'结算状态',width:30,sortable:false,
			formatter:function(value,row,index){return row.settleflagname;}
		}
	]];
	//未结算界面
	if(settleflag=='0'){
		$("#settleBtn").linkbutton("enable");
	}else{
		$("#settleBtn").linkbutton("disable");
		columnarr=[[
			{field:'id',checkbox:true,width:2}, //显示复选框
			{field:'typename',title:'物资类别',width:20,sortable:true,
				formatter:function(value,row,index){return row.typename;} //需要formatter一下才能显示正确的数据
			},
			{field:'code',title:'物资编号',width:20,sortable:true,
				formatter:function(value,row,index){return row.code;} //需要formatter一下才能显示正确的数据
			},
			{field:'splname',title:'物资名称',width:20,sortable:true,
				formatter:function(value,row,index){return row.splname;} //需要formatter一下才能显示正确的数据
			},
			{field:'suppliername',title:'供应商',width:50,sortable:true,
				formatter:function(value,row,index){return row.suppliername;} //需要formatter一下才能显示正确的数据
			},
			{field:'price',title:'单价(元)',width:20,sortable:false,
				formatter:function(value,row,index){return row.price;}
			},
			{field:'unitid',title:'单位',width:20,
				formatter:function(value,row,index){return row.unitid;}
			},
			{field:'initqty',title:'入库数量',width:20,
				formatter:function(value,row,index){return row.initqty;}
			},
			{field:'totalamount',title:'入库金额(元)',width:20,
				formatter:function(value,row,index){return row.totalamount;}
			},
			{field:'imptime',title:'入库时间',width:30,sortable:true,
				formatter:function(value,row,index){return row.imptime;}
			},
			{field:'settleflagname',title:'结算状态',width:30,sortable:false,
				formatter:function(value,row,index){return row.settleflagname;}
			},
			{field:'settledate',title:'结算日期',width:30,sortable:true,
				formatter:function(value,row,index){return row.settledate;}
			}
		]];
	}
		$('#dataTable').datagrid({
			title:'物资结算', //标题
			method:'post',
			iconCls:'icon-edit', //图标
			singleSelect:false, //多选
			height:420, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:true,//可折叠
			url:baseURL+"/cost/suppliesimp/getSuppliesImpPageList.json", //数据来源
			sortName: 'id', //排序的列
			sortOrder: 'desc', //正序asc、倒序 desc
			remoteSort: true, //服务器端排序
			idField:'id', //主键字段
			pageNumber: 1, 
			pageSize : 100,
			pageList: [100,300,500],
			queryParams:{
				begdate:begdate,
				enddate:enddate,
				settlementflag:settleflag,
				param:param
				}, //查询条件
			pagination:true, //显示分页
			//pageSize : 1,
			rownumbers:true, //显示行号
			columns:columnarr,
			toolbar:'#toolbar',
			showFooter: true,
			onLoadSuccess:function(){
				$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				$('#tabdiv .panel-header').css('display','none');
				
				$('#dataTable').datagrid('reloadFooter',[{
					unitid: '<B>合计</B>',
					initqty: '<B>' + compute("initqty") + '</B>',
					totalamount: '<B>' + compute("totalamount") + '</B>'
				}]);
				
//				$('#dataTable').datagrid('appendRow', {
//	                 id:'',
//					 unitid: '<B>合计</B>',
//	                 initqty: '<B>' + compute("initqty") + '</B>',
//	                 totalamount: '<B>' + compute("totalamount") + '</B>'
//	             });
			}
		});
}

/**
 * 页面列表datagrid初始化 */
jQuery(function($){
	var begdate=getDateYM01();
	var enddate=getDateYMD();
	$('#begdate').datebox('setValue', begdate);
	$('#enddate').datebox('setValue', enddate);
    //alert(showFlag);
	//退货界面
	if(showFlag=='refund'){
		$('#dataTable').datagrid({
			title:'已退库物资', //标题
			method:'post',
			iconCls:'icon-edit', //图标
			singleSelect:false, //多选	
			height:420, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。	
			striped: true, //奇偶行颜色不同	
			collapsible:true,//可折叠	
			url:baseURL+"/cost/suppliesimp/getSuppliesRefundPageList.json", //数据来源
			sortName: 'id', //排序的列
			sortOrder: 'desc', //正序asc、倒序 desc
			remoteSort: true, //服务器端排序
			idField:'id', //主键字段
			pageNumber: 1, 
			pageSize : 10,
			pageList: [10,30,50],
			queryParams:{
				begdate:begdate,
				enddate:enddate
				}, //查询条件
			pagination:true, //显示分页
			//pageSize : 1,
			rownumbers:true, //显示行号
			columns:[[
				//{field:'id',checkbox:true,width:2}, //显示复选框
				{field:'typename',title:'物资类别',width:20,sortable:true,
					formatter:function(value,row,index){return row.typename;} //需要formatter一下才能显示正确的数据
				},
				{field:'splname',title:'物资名称',width:20,sortable:true,
					formatter:function(value,row,index){return row.splname;} //需要formatter一下才能显示正确的数据
				},
				{field:'suppliername',title:'供应商',width:50,sortable:true,
					formatter:function(value,row,index){return row.suppliername;} //需要formatter一下才能显示正确的数据
				},
				{field:'price',title:'单价(元)',width:20,sortable:false,
					formatter:function(value,row,index){return row.price;}
				},
				{field:'unitid',title:'单位',width:20,
					formatter:function(value,row,index){return row.unitid;}
				},
				{field:'refundqty',title:'退库数量',width:20,
					formatter:function(value,row,index){return row.refundqty;}
				},
				{field:'totalamount',title:'退库金额(元)',width:20,
					formatter:function(value,row,index){return row.totalamount;}
				},
				{field:'refunddate',title:'退库时间',width:30,sortable:true,
					formatter:function(value,row,index){return row.refunddate.substring(0,10);}
				},
				{field:'refundname',title:'记录人',width:30,sortable:true,
					formatter:function(value,row,index){return row.refundname;}
				}
			]],
			toolbar:'#toolbar',
			onLoadSuccess:function(){
				$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题				$('#tabdiv .panel-header').css('display','none');
			}
		});
	}
	//结算界面
	else if(showFlag=='settle'){
		initSettleDatagrid();
	}else if(showFlag=='summary'){
		$('#dataTable').datagrid({
			title:'入库清单', //标题
			method:'post',
			iconCls:'icon-edit', //图标
			singleSelect:true, //多选
			height:420, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
			striped: true, //奇偶行颜色不同
			collapsible:false,//可折叠
			url:baseURL+"/cost/suppliesimp/getSuppliesImpList.json", //数据来源
			//sortName: 'id', //排序的列
			//sortOrder: 'desc', //正序asc、倒序 desc
			//remoteSort: true, //服务器端排序
             collapsible:true,
             //data:data,
             view:groupview,
             groupField:'maintypename',
             groupFormatter:function(value,rows){
                 //return value + ' - ' + rows.length + ' Item(s)';
                 return value;
             },
			idField:'id', //主键字段
			pageNumber: 1, 
			pageSize : 10000,
			pageList: [10000,30,50],
			queryParams:{
				begdate:begdate,
				enddate:enddate
				}, //查询条件
			pagination:false, //显示分页
			showFooter: true,
			rownumbers:true, //显示行号
			columns:[[
				//{field:'id',checkbox:true,width:2}, //显示复选框
				{field:'typename',title:'物资类别',width:20,sortable:true,
					formatter:function(value,row,index){return row.typename;} //需要formatter一下才能显示正确的数据
				},
				{field:'splname',title:'物资名称',width:20,sortable:true,
					formatter:function(value,row,index){return row.splname;} //需要formatter一下才能显示正确的数据
				},
				{field:'suppliername',title:'供应商',width:50,sortable:true,
					formatter:function(value,row,index){return row.suppliername;} //需要formatter一下才能显示正确的数据
				},
				{field:'price',title:'单价(元)',width:20,sortable:false,
					formatter:function(value,row,index){return row.price;}
				},
				{field:'unitid',title:'单位',width:20,
					formatter:function(value,row,index){return row.unitid;}
				},
				{field:'initqty',title:'入库数量',width:20,
					formatter:function(value,row,index){return row.initqty;}
				},
				{field:'totalamount',title:'入库金额(元)',width:20,
					formatter:function(value,row,index){return row.totalamount;}
				},
				{field:'imptime',title:'入库时间',width:30,sortable:true,
					formatter:function(value,row,index){
//						var date=row.imptime;
//						date=date.substring(0,10);
						return row.imptime;
					}
				},
				{field:'settleflagname',title:'结算状态',width:30,sortable:true,
					formatter:function(value,row,index){return row.settleflagname;}
				}
			]],
			toolbar:'#toolbar',
			onLoadSuccess:function(){
				$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				$('#tabdiv .panel-header').css('display','none');
				$('#dataTable').datagrid('reloadFooter',[{
					unitid: '<B>合计</B>',
					initqty: '<B>'+compute("initqty")+'</B>',
					totalamount: '<B>'+compute("totalamount")+'</B>'
				}]);
//				$('#dataTable').datagrid('appendRow', {
//	                 id:'',
//					 unitid: '<B>合计</B>',	
//	                 initqty: '<B>' + compute("initqty") + '</B>',
//	                 totalamount: '<B>' + compute("totalamount") + '</B>'
//	             });
			}
		});
	}else{//物资管理界面
		$('#dataTable').datagrid({
			title:'物资管理', //标题
			method:'post',
			iconCls:'icon-edit', //图标
			singleSelect:false, //多选
	
			height:420, //高度
			fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
	
			striped: true, //奇偶行颜色不同
	
			collapsible:true,//可折叠
	
			url:baseURL+"/cost/suppliesimp/getSuppliesImpPageList.json", //数据来源
			sortName: 'id', //排序的列
			sortOrder: 'desc', //正序asc、倒序 desc
			remoteSort: true, //服务器端排序
			idField:'id', //主键字段
			pageNumber: 1, 
			pageSize : 10,
			pageList: [10,30,50],
			queryParams:{
				begdate:begdate,
				enddate:enddate
				}, //查询条件
			pagination:true, //显示分页
			//pageSize : 1,
			rownumbers:true, //显示行号
			columns:[[
				{field:'id',checkbox:true,width:2}, //显示复选框
				{field:'typename',title:'物资类别',width:20,sortable:true,
					formatter:function(value,row,index){return row.typename;} //需要formatter一下才能显示正确的数据
				},
				{field:'splname',title:'物资名称',width:20,sortable:false,
					formatter:function(value,row,index){return row.splname;} //需要formatter一下才能显示正确的数据
				},
				{field:'suppliername',title:'供应商',width:50,sortable:true,
					formatter:function(value,row,index){return row.suppliername;} //需要formatter一下才能显示正确的数据
				},
				{field:'price',title:'单价(元)',width:20,sortable:false,
					formatter:function(value,row,index){return row.price;}
				},
				{field:'unitid',title:'单位',width:20,
					formatter:function(value,row,index){return row.unitid;}
				},
				{field:'initqty',title:'入库数量',width:20,
					formatter:function(value,row,index){return row.initqty;}
				},
				{field:'totalamount',title:'入库金额(元)',width:20,
					formatter:function(value,row,index){return row.totalamount;}
				},
				{field:'imptime',title:'入库时间',width:30,sortable:true,
					formatter:function(value,row,index){return row.imptime;}
				}
			]],
			toolbar:'#toolbar',
			onLoadSuccess:function(){
				$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				$('#tabdiv .panel-header').css('display','none');
			}
		});
	}
});

function openNew(){
	$('#add-dlg').dialog('open').dialog('setTitle','物资管理--新增');
	$('#add-fm').form('clear');
	$('#servicelife').val("12");
	$('#depreciationyear').val("12");
	$('#splstatus').val("2");
	$('#ctype').val("17");
	$('#warehouseid').val("61");
	$('#stockstatus').val("1");
	$('#settlementflag').val("0");
	$('#printnum').val("0");
	//物资供应商下拉列表
	$("#supplierid").combobox({
    	url : baseURL+"/cost/suppliesimp/getSuppliersCombobox.json?ctype=",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "supplier", //这个text和你返回json里面的text对应
    	required:true,
    })
    //物资类别一级
    $("#lvl1").combobox({
    	url : baseURL+"/cost/suppliesimp/getSPLTypesCombobox.json?clevel=2&fid=2",//返回json数据的url
    	valueField : "id",//这个id和你返回json里面的id对应
    	textField : "typename", //这个text和你返回json里面的text对应
    	required:true,
    	onSelect: function (row1) {  
            if (row1 != null) {  
            	//物资类别二级
                $('#lvl2').combobox({  
                	url : baseURL+"/cost/suppliesimp/getSPLTypesCombobox.json?clevel=3&fid="+row1.id,//返回json数据的url
                    valueField : "id",//这个id和你返回json里面的id对应
                	textField : "typename", //这个text和你返回json里面的text对应
                	required:true,
                	onSelect: function (row2) {  
                        if (row2 != null) {  
                        	//物资类别三级
                            $('#typeid').combobox({  
                            	url : baseURL+"/cost/suppliesimp/getSPLTypesCombobox.json?clevel=4&fid="+row2.id,//返回json数据的url
                            	valueField : "id",//这个id和你返回json里面的id对应
                            	textField : "typename", //这个text和你返回json里面的text对应
                            	required:true,
                            	onSelect: function (row3) {
                            		$('#unitid').val(row3.unit);
                            	}
                            });  
                        }  
                    }  
                });  
            }  
        }  
    })
    //$('#add-fm').form('reset');
}
	
/**
 * 根据税率和含税总价计算不含税的单价和总价
 * @returns
 */
	function calcPrice(){
		var amount=$('#amount').val();
		var tax=$('#tax').val();
		var initqty=$('#initqty').val();
		if(amount==null||amount==""){
			alert("请输入含税总金额进行计算！");
			return false;
		}
		if(tax==null||tax==""){
			alert("请输入税率进行计算！");
			return false;
		}
		if(initqty==null||initqty==""){
			alert("请输入入库数量进行计算！");
			return false;
		}
	  	var totalamount=0,price=0;
	  	//alert(amount+"=="+initqty+"=="+tax);
	  	if (!isNaN(parseFloat(amount)) && !isNaN(parseInt(initqty)) && !isNaN(parseFloat(tax))){
	  		totalamount=Math.round((parseFloat(amount)/parseFloat(tax))*10000000000)/10000000000;
	  		$('#totalamount').numberbox('setValue', totalamount);
	  	  	price=Math.round((parseFloat(amount)/parseFloat(initqty)/parseFloat(tax))*10000000000)/10000000000;
	  	    $('#price').numberbox('setValue', price);
	  	    
	  	    //alert($('#totalamount')+"---"+$('#price'));
	  	    //alert(totalamount+"---"+price);  reset change clear
	  	}
	}
	/**
	 * 保存新增信息
	 */
	function saveAdd(){
		$('#add-fm').form('submit',{
			onSubmit: function(){
				var isValidate = $(this).form('validate');
				if(isValidate){
				}
				return isValidate;
			},
			url:baseURL+"/cost/suppliesimp/doInsertSuppliesImp.json",
			beforeSend : function () {
				$.messager.progress({
					text : '正在新增中...',
				});
			},
			success: function(data){
				data = eval('('+data+')');
				//$('#add-dlg').dialog('close');
				$('#dataTable').datagrid('reload'); 
				$('#price').numberbox('setValue', '');
				$('#totalamount').numberbox('setValue', '');
	    		$.messager.show({
					title : '提示',
					msg :  data.total+'个物资新增'+data.msg+'！',
				});
			}
		});
	}
	
	function openPagePrint(){
		var rows = $('#dataTable').datagrid('getRows');
		if(rows.length==0){
			$.messager.alert('提示',"请先查询要打印的入库信息",'info');
			return;
		}
	    var contentstr='<table width="100%" border="0" cellpadding="0" cellspacing="0">';
		contentstr+='<h2  style="text-align:center;">入库结算总表</h2>';
		//contentstr+='<tr><td align=left>&nbsp&nbsp'+getDateYMD()+'</td></tr></table>';
		contentstr +='<table width="100%" border="1" cellpadding="0" cellspacing="0"<tr><td align="center">物资类别</td><td align="center">物品名称</td><td align="center">供应商</td><td align="center">单价</td><td align="center">单位</td><td align="center">入库数量</td><td align="center">入库金额</td> <td align="center">入库时间</td><td align="center">结算状态</td>  </tr>';
		var totalamount=0,totalqty=0;
		var maintypeid="",tmpid="";
		$.each(rows,function(i,n){
    		//alert(n.code+'---'+n.splname);
			maintypeid=n.maintypeid;
			if(tmpid!=maintypeid)contentstr +="<tr><td align='left' colspan='9'>&nbsp;<strong><b>"+n.maintypename+"</b></strong></td>";
    		contentstr +="<tr><td align='center'>"+n.typename+"</td><td align='center'>"+n.splname+"</td><td align='center'>"+n.suppliername+"</td><td align='center'>"+n.price+"</td><td align='center'>"+n.unitid+"</td><td align='center'>"+n.initqty+"</td><td align='center'>"+n.totalamount+"</td><td align='center'>"+n.imptime+"</td><td align='center'>"+n.settleflagname+"</td></tr>";
    		totalamount=totalamount+parseFloat(n.totalamount);
    		totalqty=totalqty+parseFloat(n.initqty);
    		tmpid=maintypeid;
    	});
		//alert(totalamount);
		totalamount=Math.round(totalamount*1000)/1000;
	   //alert(totalamount);
		//contentstr +='<tr><td colspan="2"><strong>备注：</strong></td> <td colspan="4" ><strong>验收人签章：</strong></td><td align="center"><strong >合计：</strong></td><td align="center" colspan="1"><strong >'+totalamount.toFixed(2)+'</strong ></td> </tr>'; 
		contentstr +="<tr><td align='center'>&nbsp;</td><td align='center'>&nbsp;</td><td align='center'>&nbsp;</td><td align='center'>&nbsp;</td><td align='center'><b>合计</b></td><td align='center'><b>"+totalqty+"</b></td><td align='center'><b>"+totalamount+"</b></td><td align='center'>&nbsp;</td><td align='center'>&nbsp;</td></tr>";
		contentstr +="</table>";
		//alert(contentstr);
		$("#printTable").html(contentstr);
		//$("#printTable").attr("style","display:none;");
		//alert($("printTable"))
		$('#print-dlg').dialog('open').dialog('setTitle','入库结算总表打印');
//		 var bdhtml=window.document.body.innerHTML;  
//	  		var sprnstr="<!--startprint-->";  
//	  		var eprnstr="<!--endprint-->";  
//	  		var prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);  
//	  		prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));  
//	  		window.document.body.innerHTML=$("#print-dlg").html();
//	  		window.print();  	
//	  		alert(location.href.substring(0,location.href.length-1)+"3");
	}

	/**
	 * 打开退库窗口
	 * @returns
	 */
	function openRefund(){
		var rows = $('#dataTable').datagrid('getSelections');
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要退库的物资信息",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一个物资进行退库操作",'info');
			return;
		}
		var row = $('#dataTable').datagrid('getSelected');
		if (row){
			$('#refund-dlg').dialog('open').dialog('setTitle','物资退库');
			$('#refund-fm').form('load',row);
			$('#refunddate').datebox('setValue', getDateYMD());
			$('#refundqty').numberbox('setValue', '');
		}
  }
		
  /**
   * 保存退库信息
   */
  function saveRefund(){
	 var price=$('#price_refund').val();
	 var refundqty=$('#refundqty').val();
	 var amount=Math.round((parseFloat(refundqty)*parseFloat(price))*10000000000)/10000000000;
	 //alert(price+"=="+refundqty+"=="+amount);
	 $('#refundamount').val(amount);
  	 $('#refund-fm').form('submit',{
  		onSubmit: function(){
  			var isValidate = $(this).form('validate');
  			if(isValidate){
  				var quantity=$('#quantity').val();
  				if(parseFloat(refundqty)>parseFloat(quantity)){
  					alert("退库数量大于当前库存数量，请调整后再保存！");
  					return false;
  				}
  			}
  			return isValidate;
  		},
  		url:baseURL+"/cost/suppliesimp/doRefundSupplies.json",
  		success: function(data){
			//$('#loading').window('close');
			data = eval('('+data+')');
			$('#edit-dlg').dialog('close');
			$('#edit-fm').form('clear');
			$('#dataTable').datagrid('reload'); 
    		$.messager.show({
				title : '提示',
				msg :  data.total+'个物资信息退库'+data.msg+'！',
			});
			//$('#loading').window('close');
    		$('#refund-dlg').dialog('close');
		}
  	});
  }
	
	  //查询
	function searchSPL(){
		var params = $('#dataTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数		var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		$.each( fields, function(i, field){
			//alert(field.value);
			params[field.name] = field.value; //设置查询参数
		}); 
		if(showFlag=='settle')initSettleDatagrid();
		else $('#dataTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了		//initSettleDatagrid();
	}
	//清空查询条件
	function clearForm(){
		//$('#keywd').val('');
		$('#param').textbox("setValue","");
		$('#param').textbox("setText","");
		$('#begdate').datebox('setValue', getDateYM01());
		$('#enddate').datebox('setValue', getDateYMD());
		if(showFlag=='settle'){
			$('#settlementflag').combobox('setValue','0');
		}
		searchSPL();
	}
	
	/**
	 * 结算操作
	 * @returns
	 */
	  function SPLSettle(){
		  //alert("==");
			var rows = $('#dataTable').datagrid('getSelections');
			if(rows.length==0){
				$.messager.alert('提示',"请选择你要结算的入库物资信息",'info');
				return;
			}
			$.messager.confirm('提示','确定要结算所选的入库物资信息吗?',function(result){
		      if (result){
		      	var ps = "";
		      	$.each(rows,function(i,n){
		      		if(i==0) 
		      			ps += "?id="+n.id;
		      		else
		      			ps += "&id="+n.id;
		      	});
		      	$.post(baseURL+'/cost/suppliesimp/doSettleSupplies.json'+ps,function(data){
			        	$('#dataTable').datagrid('reload'); 
			        	//console.log("del--"+data);
			        	data = eval('('+data+')');
			      		$.messager.show({
								title : '提示',
								msg :  data.total+'个入库物资信息结算'+data.msg+'！',
						});
		      	});
	      }
	  });
	  }
	  
	  /**
	   * 导出Excel
	   * @returns
	   */
	  function toExcel(){
		  //alert("==");
		  var rows = $('#dataTable').datagrid('getSelections');
		  if(rows.length==0){
			  $.messager.alert('提示',"请选择你要导出的入库物资信息",'info');
			  return;
		  }
		  $.messager.confirm('提示','确定要导出所选入库信息到Excel吗?',function(result){
		        if (result){
		        	var ps = "";
			      	$.each(rows,function(i,n){
			      		if(i==0) 
			      			ps += n.id;
			      		else
			      			ps += ","+n.id;
			        });
			      	 $('#ids').val(ps);
			      	 var settlementflag=$('#settlementflag').val();
			      	 //alert(settlementflag);
			      	 $('#settlementflag1').val(settlementflag);
		        	 $('#excelForm').form('submit', {
		        		 url: baseURL+'/cost/suppliesimp/doExportSuppliesSettleExcel.json' 
		        	 });
		        }
		  });
	  }
	  
	//指定列求和
      function compute(colName) {
           var rows = $('#dataTable').datagrid('getRows');
           var total = 0;
           for (var i = 0; i < rows.length; i++) {
               total = (total+parseFloat(rows[i][colName]))*10000/10000;
           }
           return total;
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