<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<!-- 来烟接口数据：车辆信息 -->
<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/gis/currlocation.js"/>"></script>
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
		车辆状态：<input name="status" id="status" class="easyui-textbox" style="width:120px" >
			<input class="easyui-textbox"  name="keyword" id="keyword" data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchData();},prompt:'请输入车牌号、批次号...'" style="width:220px;height:24px;">
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
		  		 	<td width="5%" height="20" align="left" nowrap>本地编号：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="id" id="id" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>批次id：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="batchId" id="batchId" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>承运车牌：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="truckNum" id="truckNum" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>发货时间：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="outDate" id="outDate" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>行驶时间：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="onlineTime" id="onlineTime" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>行驶里程：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="onlineDistance" id="onlineDistance" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
				<tr>
		           	<td width="5%"  height="20" align="left" nowrap>到货仓库代码：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="longitude" id="longitude" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
		           <td width="5%" height="20" align="left" nowrap>票号：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="orderId" id="orderId" class="easyui-textbox" style="width:180px"  readonly>
		           	</td>
		            <td width="5%" height="20" align="left" nowrap>到货仓库名称：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="latitude" id="latitude" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>物流单状态：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="statusname" id="statusname" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>车载设备号：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="lockNo" id="lockNo" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%"  height="20" align="left" nowrap>到货日期：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="arrivedDate" id="arrivedDate" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>当前位置：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="currentPos" id="currentPos" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>经度：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="longitude" id="longitude" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>纬度：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="latitude" id="latitude" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap colspan="6" style="color:blue">运输车辆信息</td>
	           </tr>
	           
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>运输单位代码：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="tranOrgCode" id="tranOrgCode" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>运输单位名称：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="tranOrgName" id="tranOrgName" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>运输方式 ：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="transMode" id="transMode" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>发货单位代码：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="orgOrgCode" id="orgOrgCode" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>发货单位名称：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="orgOrgName" id="orgOrgName" class="easyui-textbox" style="width:180px" colspan="3" readonly/>
		           </td>  
		            
	           </tr>
	           <tr>
	           <td width="5%" height="20" align="left" nowrap>司机姓名：</td>
		           	<td width="5%" height="20" align="left" nowrap >
		                <input name="driverName" id="driverName" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
		  		 	<td width="5%" height="20" align="left" nowrap>司机手机号：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="mobileTel" id="mobileTel" class="easyui-textbox" style="width:180px" colspan="3" readonly>
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
	
	</div>
	
	
  </body>
</html>
