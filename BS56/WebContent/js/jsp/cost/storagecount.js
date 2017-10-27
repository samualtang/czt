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
	var begdate=$('#begdate').val();	 
	var enddate=$('#enddate').val();
	var settlementflagval=$("#settlementflag").val();
	$('#dataTable').datagrid({
		title:'入库查询统计', //标题
		method:'post',
		iconCls:'icon-edit', //图标
		singleSelect:false, //多选		height:420, //高度
		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。		striped: true, //奇偶行颜色不同		collapsible:true,//可折叠		url:baseURL+"/cost/suppliesimp/getSuppliesImpPageList.json", //数据来源
		sortName: 'id', //排序的列
		sortOrder: 'desc', //倒序 desc
		remoteSort: true, //服务器端排序
		idField:'id', //主键字段
		pageNumber: 1, 
		pageSize : 500,
		pageList: [500,2000,5000],
		showFooter: true,
		queryParams:{
			begdate:begdate,
			enddate:enddate,
			settlementflag:settlementflagval
			}, //查询条件
		pagination:true, //显示分页
		//pageSize : 1,
		rownumbers:true, //显示行号
		columns:[[
			//{field:'id',checkbox:true,width:2}, //显示复选框
			{field:'typename',title:'物资类别',width:20,sortable:true,
				formatter:function(value,row,index){return row.typename;} //需要formatter一下才能显示正确的数据
			},
			{field:'code',title:'物品编号',width:15,sortable:true,
				formatter:function(value,row,index){return row.code;} //需要formatter一下才能显示正确的数据
			},
			{field:'splname',title:'物品名称',width:30,
				formatter:function(value,row,index){return row.splname;}
			},
			{field:'suppliername',title:'供应商',width:40,
				formatter:function(value,row,index){return row.suppliername;}
			},
			{field:'imptime',title:'入库时间',width:25,
				formatter:function(value,row,index){return row.imptime;}
			},
			{field:'price',title:'单价(元)',width:15,
				formatter:function(value,row,index){return row.price;}
			},
			{field:'unitid',title:'单位',width:10,
				formatter:function(value,row,index){return row.unitid;}
			},
			{field:'initqty',title:'入库数量',width:10,
				formatter:function(value,row,index){return row.initqty;}
			},
			{field:'totalamount',title:'总价(元)',width:20,
				formatter:function(value,row,index){return row.totalamount;}
			}
		]],
		toolbar:'#toolbar',
		onLoadSuccess:function(){
			$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			compute();//调用计算函数
			$('#tabdiv .panel-header').css('display','none');
			
		}
	});
});
function compute() {//计算函数
//	alert("--");
	var totalnum=0;
    var rows = $('#dataTable').datagrid('getRows')//获取当前的数据行
    var ptotalnum = 0;//计算totalamount的总和 
    for (var i = 0; i < rows.length; i++) {
    	totalnum=rows[i]['totalamount'];if(totalnum==null||totalnum=="")totalnum=0;//totalnum为空时赋值为0，否则会显示NaN。
    	ptotalnum += parseFloat(totalnum);
    }
    ptotalnum=Math.round(ptotalnum*10000)/10000;
    //新增一行显示统计信息
    //$('#dataTable').datagrid('appendRow', { typename:'',code:'', splname:'<b>打印日期：  </b><input id=printdate name=printdate class="easyui-datebox" style="width:100px;" value="'+getDateYMD()+'" >',suppliername:'',price:'',unitid:'',initqty: '<b>金额合计:</b>', totalamount:((ptotalnum*10000)/10000),imptime:'' });
    
    $('#dataTable').datagrid('reloadFooter',[{
    	splname: '<div id="printarea" ><B>打印时间：</B><input  id=printdate name=printdate class="easyui-datebox" editable="false" style="width:100px;" value="'+getDateYMD()+'" ></div>',
    	initqty: '<B>合计</B>',
		totalamount: '<B>' + ptotalnum + '</B>'
	}]);
    $.parser.parse($('#printarea'));
    $('#printdate').datebox({editable:false});
}
//导出excel表格
function exportxls(){
	 $.messager.confirm('提示','确定要导出到excel吗?',function(result){
	        if (result){ 
	        	 $('#queryForm').form('submit', {
	        		 url: baseURL+'/cost/suppliesimp/getStoragecountExcel.json'
	        		
	        	 });
	        	 }
	 });
	
}
	  
function ReplaceAll(str, sptr, sptr1){
    while (str.indexOf(sptr) >= 0){
       str = str.replace(sptr, sptr1);
    }
    return str;
}
		/**
		 * 打开打印窗口
		 */
		  function printpage(sprnstr,eprnstr){
			   
			    var printdate=$('#printdate').val().replace("-","").replace("-","");
			    var begdate=$('#begdate').val().replace("-","").replace("-","");
			    var enddate=$('#enddate').val().replace("-","").replace("-","");
			    $(".formtd").each(function(){
				 	   $(this).html("");
				 	 });
				var rows = $('#dataTable').datagrid('getRows');
				if(rows.length==0){
					$.messager.alert('提示',"请先查询要打印的入库信息",'info');
					return;
				}
				//验证打印时间不得小于查询时间
				if(printdate!=null&&printdate!=""&&parseInt(printdate)<parseInt(enddate)){
					$.messager.alert('提示',"打印时间不能小于结束时间",'info');
					return;
				}
				var contentstr='<table width="100%" border="0" cellpadding="0" cellspacing="0">';
				contentstr+='<h3  style="text-align:center;">'+begdate+'-'+enddate+'&nbsp;入库单汇总</h3>';
				contentstr+='<tr><td align=left>&nbsp&nbsp打印时间:&nbsp&nbsp'+printdate+'</td><td align=right>单位(元)&nbsp&nbsp&nbsp&nbsp</td></tr></table>';
				contentstr +='<table width="100%" border="1" cellpadding="0" cellspacing="0"<tr><td align="center">物资类别</td><td align="center">编号</td> <td align="center">物品名称</td><td align="center">供应商</td><td align="center">入库时间</td><td align="center">单价</td><td align="center">单位</td><td align="center">实收数量</td><td align="center">总价 </td> </tr>';
				var totalamount=0;
				$.each(rows,function(i,n){
	        		contentstr +="<tr><td align='center'>"+n.typename+"</td><td align='center'>"+n.code+"</td><td align='center'>"+n.splname+"</td><td align='center'>"+n.suppliername+"</td><td align='center'>&nbsp&nbsp"+n.imptime.substr(0, 10)+"&nbsp&nbsp</td><td align='center'>&nbsp&nbsp"+n.price+"&nbsp&nbsp</td><td align='center'>"+n.unitid+"</td><td align='center'>"+n.initqty+"</td><td align='center'>&nbsp&nbsp"+n.totalamount+"&nbsp&nbsp</td></tr>";
	        		totalamount=(totalamount+parseFloat(n.totalamount.toFixed(2)));
	        	});
			   
				contentstr +='<tr><td colspan="9" align="right" > <strong style="margin-right:10px">金额合计：'+Math.round(totalamount*10000)/10000+'</strong></td> </tr>'; 
				contentstr +="</table>";
//				contentstr +="<div style='text-align:center; margin:auto;padding:15px'>";
//				contentstr +="<input type='button'  value='关闭'  onclick='window.location.reload();'></div>"
				//alert(contentstr);
				$("#printTable").html(contentstr);
				$('#print-dlg').dialog('open').dialog('setTitle','入库查询汇总打印');
//				 var bdhtml=window.document.body.innerHTML;  
//			  		var prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);  
//			  		prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));  
//			  		window.document.body.innerHTML=$("#print-dlg").html();
//			  		window.print();  	
			}
	//查询
		function searchStoragecount(){
			var params = $('#dataTable').datagrid('options').queryParams; //先取得 datagrid 的查询参数
			var fields =$('#queryForm').serializeArray(); //自动序列化表单元素为JSON对象
		    //将时间格式由字符串转换成date型
			var begdate=$('#begdate').val().replace("-","").replace("-","");
		    var enddate=$('#enddate').val().replace("-","").replace("-","");  
			//验证查询时开始时间不得小于结束时间
		    if(begdate!=null&&begdate!=""&&enddate!=null&&enddate!=""&&begdate>enddate){
				$.messager.alert('提示',"开始时间不能大于结束时间",'info');
				return;
			}
			
			$.each( fields, function(i, field){
				params[field.name] = field.value; //设置查询参数
			}); 
			$('#dataTable').datagrid('reload'); //设置好查询参数 reload 一下就可以了

		}
		
	  
	//清空查询条件
	function clearForm(){
		$('#queryForm').form('clear');
		$('#queryForm').form('reset');
		$('#begdate').datebox("setValue",getDateYM01());
		$('#enddate').datebox("setValue",getDateYMD());
		searchStoragecount();
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
        
//       function printpage(sprnstr,eprnstr){
//    		
//    		var bdhtml=window.document.body.innerHTML;  
//    		var sprnstr="<!--startprint-->";  
//    		var eprnstr="<!--endprint-->";  
//    		var prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);  
//    		prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));  
//    		window.document.body.innerHTML=prnhtml;  
//    		window.print();  
//       }
       
    }