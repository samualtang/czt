<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<%@ page import="com.ztel.framework.util.DateUtil" %>
<!DOCTYPE html >
<html>

<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/sys/businessrole.js"/>"></script>
  <head>
  </head>
  
  <body>
	
	<!-- datagrid页面列表数据 -->
	<div style="padding:10" id="tabdiv">
		<table id="dataTabel"></table>
	</div>
	
	<!-- 查询-->
	<div id="toolbar" style="padding:5px;height:auto;border-top:1px solid #95B8E7">
	<form id="queryForm" style="margin:10;">
		<div style="margin-bottom:5px">
		<a href="#" id="newBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newrow()">增加</a>
		<a href="#" id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEdit()">修改</a>
		<a href="#" id="grantBtn" class="easyui-linkbutton" iconCls="icon-mygroup" plain="true" onclick="openGrant()">授权</a>
		<a href="#" id="delBtn" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleterow()">删除</a>
			<input class="easyui-textbox"  name="rolename"  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchData();},prompt:'请输入角色名称...'" style="width:450px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>
		</form>
	</div>
    
    <!-- 新增对话框 -->
	<div id="add-dlg" class="easyui-dialog" style="width:680px;height:300px;padding:10px 20px;align:center;"
			 closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<div class="ftitle"></div>
		<form  id="add-fm" method="post" action="" novalidate  >
			<div class="fitem">
				<label>角色名称</label>
				<input name="rolename" class="easyui-validatebox" style="width:360px;" data-options="validType:'length[1,25]'"  required="true">
			</div>
			<br>
			<div id="text2" class="fitem">
				<label >备注信息</label>
				<input name="remarks" id="remarks" class="easyui-textbox" data-options="multiline:true,validType:'length[1,100]'"  value="0"  style="width:360px" >
			</div>
			<br>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saverow()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#add-dlg').dialog('close')">取消</a>
	</div>
    
    <!-- 修改对话框 -->
	<div id="edit-dlg" class="easyui-dialog" style="width:680px;height:300px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#edit-dlg-buttons">
		<div class="ftitle"></div>
		<form id="edit-fm" method="post" novalidate action="${contextPath}/sys/businessrole/roleUpdate.json" >
			<input type="hidden" id="id" name="id"/>
			<div class="fitem">
				<label>角色名称</label>
				<input name="rolename" class="easyui-validatebox" style="width:360px;" data-options="validType:'length[1,25]'"  required="true">
				
			</div>
			<br>
			<div id="text2" class="fitem">
				<label >备注信息</label>
				<input name="remarks" id="remarks" class="easyui-textbox" data-options="multiline:true,validType:'length[1,100]'"  value="0"  style="width:360px" >
			</div>
			<br>
		</form>
	</div>
	<div id="edit-dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEdit()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#edit-dlg').dialog('close')">取消</a>
	</div>
    
    <script>
    /**
     * 页面列表datagrid初始化
     */
    jQuery(function($){
    	$('#dataTabel').datagrid({
    		title:'操作日志', //标题
    		method:'post',
    		iconCls:'icon-edit', //图标
    		singleSelect:false, //多选
    		height:490, //高度
    		fitColumns: true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
    		striped: true, //奇偶行颜色不同
    		collapsible:true,//可折叠
    		url:baseURL+"/sys/businessrole/getBusinessroleList.json", //数据来源
    		sortName: 'id', //排序的列
    		sortOrder: 'desc', //倒序
    		remoteSort: true, //服务器端排序
    		idField:'id', //主键字段
    		pageNumber: 1, 
    		pageSize : 20,
    		pageList: [20,30,50],
    		queryParams:{
    			}, //查询条件
    		pagination:true, //显示分页
    		//pageSize : 1,
    		rownumbers:true, //显示行号
    		columns:[[
    			{field:'id',checkbox:true,width:2}, //显示复选框
    			{field:'id2',title:'id',width:10,
    				formatter:function(value,row,index){return row.id;} //需要formatter一下才能显示正确的数据
    			},
    			{field:'rolename',title:'角色名称',width:30,sortable:true,
    				formatter:function(value,row,index){return row.rolename;}
    			},
    			{field:'remarks',title:'人员',width:130,
    				formatter:function(value,row,index){
    					//return row.deptName;  //该列的值是deptId，显示的是deptName
    					return row.usernames;  
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
		searchData();
	}
    </script>
    
  </body>
</html>
