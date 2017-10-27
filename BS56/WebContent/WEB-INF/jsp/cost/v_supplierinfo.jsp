<%@ page language="java" contentType ="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>

<html>

<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/cost/supplierinfo.js"/>"></script>

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
		<table id="dataTable"></table>
	</div>
	
	<!-- 查询-->
	<div id="toolbar" style="padding:5px;height:auto;border-top:1px solid #95B8E7">
	<form id="queryForm" style="margin:10;">
		<div style="margin-bottom:5px">
			<a href="#" id="newBtn" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newadd()">增加</a>
			<a href="#" id="viewBtn" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="openView()">查看</a>
			<a href="#" id="editBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEdit()">修改</a>
			<a href="#" id="delBtn" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleterow()">删除</a>
			<select class="easyui-combobox" name="ctype" id="ctype" style="width:auto;" data-option='selected:true;'>
				<option value="" selected>请选择...</option>
				<option value="10" >生产商</option>
				<option value="20">流通商</option>
				<option value="30">代理商</option>
				<option value="40">其它</option>
                
			</select>
			<input class="easyui-textbox"  name="keywd" id="keywd"  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchSupplierInfo();},prompt:'请输供应商名称/联系人/电话...'," style="width:250px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>
		</form>
	</div>
	
	<!-- 新增对话框 -->
	<div id="add-dlg" class="easyui-dialog" style="width:550px;height:360px;padding:10px 20px;align:center;"
			 closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<div class="ftitle"></div>
		<form  id="add-fm" method="post" action="" novalidate  >
			<div class="fitem">
				<table width="100%" border="0" cellpadding="0" cellspacing="6">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
               <tr><td colspan="4"  class="style2"><font color="blue">新增供应商信息</font></td></tr>
               </table></td>
           </tr>          
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>供应商名称：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="supplier" id="supplier" class="easyui-textbox" data-options="required:true,validType:'length[0,40]'"><strong><font color="red" >*</font></strong>
            </td>
            <td width="5%" height="20" align="left" nowrap>类型：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <select name="ctype" id="ctype"  data-option="selected:true">
                         <option value="10" selected>生产商</option>
				         <option value="20">流通商</option>
				         <option value="30" >代理商</option>
				         <option value="40">其它</option>
                  </select>
              </td>
        </tr>
        <tr align="center" >
           <td width="5%" height="20" align="left" nowrap>地址：</td>
           <td width="14%" height="20" align="left" nowrap>
                <input name="addr" id="addr" class="easyui-textbox" data-options="validType:'length[0,40]'">
           </td>
           <td width="5%"  height="20" align="left" nowrap>联系人：</td>
           <td width="13%" height="20" align="left" nowrap>
               <input name="contacts" id="contacts"   class="easyui-textbox" data-options="validType:'length[0,10]'">
           </td>   
       </tr>
       
       <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>联系电话：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="phone" id="phone" class="easyui-numberbox" data-options="validType:'length[0,20]'">
           </td>
           <td width="5%" height="20" align="left" nowrap>供货范围：</td>
            <td width="14%" height="20" align="left" nowrap>
              <input name="range" id="range"   class="easyui-textbox" data-options="validType:'length[0,40]'">  
            </td>
       </tr><tr></tr>
       <tr align="center">
            <td width="5%"  height="20" align="left" nowrap>备注信息：</td>
           <td width="13%" height="20" align="left" colspan=3 >
           <input name="remarks" id="remarks" class="easyui-textbox" data-options="multiline:true,validType:'length[0,100]'"  style="width:392px" >
           </td>
       </tr>
    </table>
	</td>
  </tr>
  </table>
			<br>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAdd()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#add-dlg').dialog('close')">取消</a>
	</div>
	
		
	
		<!-- 修改对话框 -->
	<div id="edit-dlg" class="easyui-dialog" style="width:550px;height:360px;padding:10px 20px;align:center;"  data-options="modal:true,draggable:false"
			 closed="true" buttons="#edit-dlg-buttons">
		<div class="ftitle"></div>
		<form id="edit-fm" method="post" action="" novalidate  >
			<div class="fitem"><input type=hidden name=id id=id>
				<table width="100%" border="0" cellpadding="0" cellspacing="6">
            <tr>
              <td> <table width="100%" border="0" cellpadding="0" cellspacing="0"  class="">
               </table></td>
           </tr>          
     <tr>
    <td >
	  <table width="100%" border="0" cellpadding="2" cellspacing="2" class="">
              <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>供应商名称：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <input name="supplier"  id="supplier1"  class="easyui-textbox" data-options="required:true,validType:'length[0,40]'"><strong><font color="red" >*</font></strong>
            </td>
            <td width="5%" height="20" align="left" nowrap>类型：</td>
            <td width="14%" height="20" align="left" nowrap>
                   <select name="ctype" id="ctype1"  data-option="selected:true">
                         <option value="10" selected>生产商</option>
				         <option value="20">流通商</option>
				         <option value="30" >代理商</option>
				         <option value="40">其它</option>
                  </select>
              </td>
        </tr>
        <tr align="center" >
           <td width="5%" height="20" align="left" nowrap>地址：</td>
           <td width="14%" height="20" align="left" nowrap>
                <input name="addr"  id="addr1" class="easyui-textbox" data-options="validType:'length[0,40]'">
           </td>
           <td width="5%"  height="20" align="left" nowrap>联系人：</td>
           <td width="13%" height="20" align="left" nowrap>
               <input name="contacts"  id="contacts1"  class="easyui-textbox" data-options="validType:'length[0,10]'">
           </td>   
       </tr>
       
       <tr align="center" >
            <td width="5%" height="20" align="left" nowrap>联系电话：</td>
            <td width="14%" height="20" align="left" nowrap>
                <input name="phone" id="phone1" class="easyui-numberbox" data-options="validType:'length[0,20]'">
           </td>
           <td width="5%" height="20" align="left" nowrap>供货范围：</td>
            <td width="14%" height="20" align="left" nowrap>
              <input name="range"  id="range1"  class="easyui-textbox" data-options="validType:'length[0,40]'">  
            </td>
       </tr><tr></tr>
       <tr align="center">
            <td width="5%"  height="20" align="left" nowrap>备注信息：</td>
           <td width="13%" height="20"  align="left" nowrap colspan=3  >
           <input name="remarks" id="remarks1" class="easyui-textbox" data-options="multiline:true,validType:'length[0,100]'"  style="width:392px" >
           </td>
       </tr>
    </table>
	</td>
  </tr>
			</div>
			<br>
		</form>
	</div>
	<div id="edit-dlg-buttons">
		<a href="#" id=saveEditBtn class="easyui-linkbutton" iconCls="icon-ok" onclick="saveEdit()">保存</a>
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
	   <c:import url="/WEB-INF/jsp/pub/sessionPage.jsp?paramPage=SupplierInfo"></c:import>
   </body>
</html>
