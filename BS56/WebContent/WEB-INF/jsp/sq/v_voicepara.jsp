<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>

<html>
<title><c:out value="${titleInfo}"/></title>
<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/sq/voicepara.js"/>"></script>
  <head>
  </head>
  
  <body>
  <!-- 查询
  <div id="searchDiv">
    <form id="queryForm" style="margin:10;text-align: center;">
		<table width="100%">
			<tr>
			<td>角色名称：<input class="easyui-textbox"  name="rolename"  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchUser();},prompt:'请输入角色名称...'" style="width:450px;height:26px;">
            &nbsp;&nbsp;
            <a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search">清空</a></td>
			<td align="center"><a href="#" onclick="searchUser();" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			</tr>
		</table>
	</form>
	</div>
   -->
	
	
	<!-- datagrid页面列表数据 -->
	<div style="padding:10" id="tabdiv">
		<table id="dataTabel"></table>
	</div>
	
	<!-- 查询-->
	<div id="toolbar" style="padding:5px;height:auto;border-top:1px solid #95B8E7">
	<form id="queryForm" style="margin:10;">
		<div style="margin-bottom:5px">
			<a href="#" id="newBtn"class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newVoicepara()">增加</a>
			<a href="#"id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEdit()">修改</a>
			<input class="easyui-textbox"  name="paraname"  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchVoicepara();},prompt:'请输入参数名称...'" style="width:450px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>
		</form>
	</div>
	
	<!-- 新增对话框 -->
	<div id="add-dlg" class="easyui-dialog" style="width:550px;height:300px;padding:10px 20px;align:center;"
			 closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<div class="ftitle"></div>
		<form  id="add-fm" method="post" action="" novalidate  >
			<div class="fitem">
				<label>参数名称</label>
				<input name="paraname" class="easyui-validatebox" style="width:373px;"  required="true">
			</div>
			<br>
			<div class="fitem">
				<label>参数内容</label>
				<input name="paracontent" class="easyui-validatebox" style="width:373px;"  required="true">
			</div>
		
			<br>
			<div id="text2" class="fitem">
				<label >参数说明</label>
				<textarea id="pararemarks"  rows="3" cols="43" name="pararemarks" data-options="multiline:true,validType:'length[0,200]'"></textarea>
			</div>
			<br>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAdd()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#add-dlg').dialog('close')">取消</a>
	</div>
	
	<!-- 修改对话框 -->
	<div id="edit-dlg" class="easyui-dialog" style="width:550px;height:300px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#edit-dlg-buttons">
		<div class="ftitle"></div>
		<form id="edit-fm" method="post"  validate action="${contextPath}/sq/VoiceparaUpdate.json" >
			<input type="hidden" id="id" name="id"/>
			<div class="fitem">
				<label>参数名称</label>
				<input name="paraname" class="easyui-validatebox" style="width:373px;"  required="true">
			</div>
			<br>
			<div class="fitem">
				<label>参数内容</label>
				<input name="paracontent" class="easyui-validatebox" style="width:373px;"  required="true">
			</div>
			
			<br>
			<div id="text2" class="fitem">
				<label >参数说明</label>
				<textarea id="pararemarks"  rows="3" cols="43" name="pararemarks" data-options="multiline:true,validType:'length[0,200]'"></textarea>
			</div>
			<br>
		</form>
	</div>
	<div id="edit-dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEdit()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#edit-dlg').dialog('close')">取消</a>
	</div>
	
	<!-- 进度条，建议对于耗时长的操作才启用
	<div id="loading">
		<div class="inputdiv" >
			<img  src="/BS56/img/loading.gif" style="padding-top: 20px; padding-left:72px;"/><br>
			<h3 style="padding-left: 35px;">&nbsp;&nbsp;&nbsp;&nbsp;数据上传中,请稍候......</h3>
		</div>
	 </div>
	 -->
	  <c:import url="/WEB-INF/jsp/pub/sessionPage.jsp?paramPage=voicepara"></c:import> 
  </body>
</html>
