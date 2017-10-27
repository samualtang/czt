<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/wms/inbound.js"/>"></script>
  <head>
  <script type="text/javascript">
</script>
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
		<a href="#" id="newBtn" class="easyui-linkbutton" iconCls="icon-view" plain="true" onclick="viewD()">查看</a>
			<input class="easyui-textbox"  name="keyword"  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchData();},prompt:'请输入准运证、货主、合同号...'" style="width:220px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
		</div>
		</form>
	</div>
	
	
	
    <!-- 1、明细查看--------------------------------------------------------------------------------------->
	<div id="add-dlg" class="easyui-dialog" style="width:800px;height:420px;padding:5px 10px;align:center;"
			 closed="true" buttons="#dlg-buttons"  data-options="modal:true,draggable:false">
		<form  id="add-fm" method="post" action="" novalidate  >
			<div >
			<tr>
			<td>
			<table>
			<tr>
		  		 	<td width="5%" height="20" align="left" nowrap>入库编号：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="inboundid" id="inboundid" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>准运证：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="navicert" id="navicert" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>合同号：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="contractno" id="contractno" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>记录时间：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="createtime" id="createtime" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>供应商：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="supplier" id="supplier" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>数量：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="qty" id="qty" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	            <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>货主：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="consignsor" id="consignsor" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>入库类型：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="intypename" id="intypename" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>入库状态：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="statusname" id="statusname" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
				<tr>
		            <td width="5%" height="20" align="left" nowrap>备注：</td>
		           	<td width="20%" height="20" align="left" nowrap colspan="7">
		               <input name="remarks" id="remarks" class="easyui-textbox" data-options="multiline:true"   style="width:460px" readonly>
		           	</td>
	           </tr>
			</table>
			</td>
			</tr>
			</div>
		</form>
	 <div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" id="btn-done" iconCls="icon-ok" onclick="javascript:$('#add-dlg').dialog('close')">关闭</a>
	</div>
	
	<div id="listtabdiv" style="border-top:1px solid #95B8E7">
		<table id="listdataTabel"></table>
	</div>
	</div>
	
	
  </body>
</html>
