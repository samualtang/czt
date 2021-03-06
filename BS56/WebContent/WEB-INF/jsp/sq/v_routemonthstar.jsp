<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/taglib.jsp" %><!doctype html>

<html>
<title><c:out value="${titleInfo}"/></title>
<%@include file="/WEB-INF/jsp/pub/commonJsCss.jsp" %>
<script type="text/javascript" src="<spring:url value="/js/jsp/sq/routemonthstar.js"/>"></script>
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
		<tr align="center">
            <td width="5%"  height="20" align="left"  nowrap>统计时间:</td>
            <input type="text" name="assesstime" id="assesstime" />
			<select class="easyui-combobox" name="ctype" id="ctype" style="width:auto;">
				<option value="10" >驾驶员星级</option>
				<option value="20" >收款员星级</option>
				<option value="30" selected >全部</option>
			</select>
			<input class="easyui-textbox"  name=drivername id=drivername  data-options="buttonText:'查询',buttonIcon:'icon-search',onClickButton:function(){searchRouteMonthstar();},prompt:'请输入驾驶员姓名/收款员姓名/车组编号...'," style="width:300px;height:24px;">
			<a href="#" onclick="clearForm();" class="easyui-linkbutton" iconCls="icon-search" style="height:24px;">清空</a>
			<a href="#" id="toexcelBtn" onclick="exportxls();" class="easyui-linkbutton" iconCls="icon-myto_excel" style="width:84px;height:24px;">导出excel</a>
		</div>
		</form>
	</div>
	 <c:import url="/WEB-INF/jsp/pub/sessionPage.jsp?paramPage=Routemonthstar"></c:import>	
  </body>
</html>