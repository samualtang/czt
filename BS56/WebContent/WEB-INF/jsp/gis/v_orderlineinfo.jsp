<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<!-- 来烟接口数据：来烟信息 -->
<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/gis/orderlineinfo.js"/>"></script>
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
					<td width="5%" height="20" align="left" nowrap>票号：</td>
		           	<td width="5%" height="20" align="left" nowrap >
		                <input name="orderId" id="orderId" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>批次id：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="batchId" id="batchId" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
	           		<td width="5%" height="20" align="left" nowrap>发货日期：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="outDate" id="outDate" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>	
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>承运车号：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="truckNum" id="truckNum" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>随车合同号：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="cgtContNum" id="cgtContNum" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		  		 	<td width="5%" height="20" align="left" nowrap>随车准运证号：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="cgtMpNum" id="cgtMpNum" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>	
	           </tr>
				<tr>
		           	<td width="5%"  height="20" align="left" nowrap>发货单位代码：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="orgOrgCode" id="orgOrgCode" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
		           <td width="5%" height="20" align="left" nowrap>发货单位名称：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="orgOrgName" id="orgOrgName" class="easyui-textbox" style="width:180px"  readonly>
		           	</td>
		            <td width="5%" height="20" align="left" nowrap>发货仓库代码：</td>
		           	<td width="5%" height="20" align="left" nowrap >
		                <input name="orgStoCode" id="orgStoCode" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>发货仓库名称：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="orgStoName" id="orgStoName" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>到货单位代码：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="destOrgCode" id="destOrgCode" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%"  height="20" align="left" nowrap>到货单位名称：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="destOrgName" id="destOrgName" class="easyui-textbox" style="width:120px" readonly/>
		           </td>  
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>到货仓库代码：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="destStoCode" id="destStoCode" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>到货仓库名称：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="destStoName" id="destStoName" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>发货地联系人：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="orgLinkman" id="orgLinkman" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>发货地联系电话：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="orgLinkmanTel" id="orgLinkmanTel" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>到货地联系人：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="destLinkman" id="destLinkman" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>到货地联系电话：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="destLinkmanTel" id="destLinkmanTel" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	            <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>运输单位名称：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="tranOrgName" id="tranOrgName" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>品牌（规格）：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="tradeName" id="tradeName" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>数量（件）：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="cgtPurQty1" id="cgtPurQty1" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
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
		                <input name="transModename" id="transModename" class="easyui-textbox" style="width:120px" readonly>
		           	</td>
	           </tr>
	           <tr>
		  		 	<td width="5%" height="20" align="left" nowrap>状态：</td>
		           	<td width="14%" height="20" align="left" nowrap>
		                <input name="isArrivedname" id="isArrivedname" class="easyui-textbox" style="width:120px"  readonly>
		           	</td>
		           	<td width="5%"  height="20" align="left" nowrap>创建时间：</td>
		           	<td width="23%" height="20" align="left" nowrap>
		               <input name="itime" id="itime" class="easyui-textbox" style="width:180px" readonly/>
		           </td>  
		            <td width="5%" height="20" align="left" nowrap>更新时间 ：</td>
		           	<td width="5%" height="20" align="left" nowrap colspan="3">
		                <input name="updatetime" id="updatetime" class="easyui-textbox" style="width:120px" readonly>
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
