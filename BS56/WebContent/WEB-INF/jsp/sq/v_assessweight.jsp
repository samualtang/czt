<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>

<html>

<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/sq/assessweight.js"/>"></script>
  </head>
  
  <body>
	<!-- datagrid页面列表数据 -->
	<div style="padding:10" id="tabdiv">
		<table id="dataTabel"></table>
		<div class="fitem" style="padding:5" align="center" >
	
			</div>
	</div>
		<div id="toolbar" style="width:auto;align:center;margin:100;border-top:1px solid #95B8E7">
			<a href="#" id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEdit()">修改</a>
	<!-- 查询
	<div id="table" style="width:auto;align:center;margin:100;border-top:1px solid #95B8E7">
	<form id="queryForm" style="margin:100;">
	<div class="fitem" >
				<tr style="width:auto;"  colspan=4>市场督察得分权重</tr>
				<input name="marketweight" id=marketweight class="easyui-numberbox" style="width:50px;align:center;"data-options="min:0,max:1,precision:1" >
		<div class="fitem" >
		<tr></tr><tr></tr><tr></tr>
				<tr style="width:auto;" >自动语音得分权重</tr>
				<input name="autoweight" id=autoweight class="easyui-numberbox" style="width:50px;align:center;"data-options="min:0,max:1,precision:1"  >			
		<div style="margin-bottom:5px">

			<!--  input class="easyui-textbox"  name="starname"  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchPara();},prompt:'请输入星级名称或分值...'" style="width:450px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>

		</form>
	</div-->
	
	<!-- 修改对话框 -->
	<div id="edit-dlg" class="easyui-dialog" style="width:550px;height:350px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#edit-dlg-buttons">
		<div class="ftitle"></div>
		<form id="edit-fm" method="post"  validate action="${baseURL}/sq/assessweight/deleteAssessweight.json" >
			<input type="hidden" id="id" name="id"/>
			<div class="fitem" >
			<table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
			   <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>市场督察得分权重:</td>
            <td width="14%" height="20" align="left" nowrap>
				<input name="marketweight" id="marketweight" class="easyui-numberbox" style="width:250px;"  data-options="min:0,max:1,precision:2,prompt:'请输入大于0小于1的2位小数...'">
            <tr align="center" >
           <td width="5%" height="20" align="left" nowrap>自动语音得分权重:</td>
           <td width="14%" height="20" align="left" nowrap>
			<input name="autoweight" id="autoweight" class="easyui-numberbox" style="width:250px;"  data-options="min:0,max:1,precision:2,prompt:'请输入大于0小于1的2位小数...'">  `
           </td>
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
	 </div>	  -->
  <c:import url="/WEB-INF/jsp/pub/sessionPage.jsp?paramPage=Assessweight"></c:import>
  </body>
</html>
