<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.ztel.app.vo.sys.UserVo"%>
<%
UserVo userVoSession = (UserVo)request.getSession().getAttribute("userVo");
System.out.println(userVoSession.getUsercode());
String opList = userVoSession.getOpList();//功能按钮
if(opList==null)opList="";
String paramPage = request.getParameter("paramPage");//页面参数，用于标识来自于哪个页面
if(paramPage==null)paramPage="";
System.out.println("paramPage=============="+paramPage);
%>
<script>
//功能按钮
var opList = '<%=opList%>';
var paramPage = '<%=paramPage%>';
$(function(){
	//角色页面
	if(paramPage=="RoleInfo"){
		if(!checkOp("202")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("206")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("208")){
			$("#settingBtn").linkbutton("disable");
		}
		if(!checkOp("209")){
			$("#grantBtn").linkbutton("disable");
		}
		if(!checkOp("207")){
			$("#delBtn").linkbutton("disable");
		}
		if(!checkOp("202")){
			//$("#opBtn").linkbutton("disable");
		}
	}
	//菜单页面
	else if(paramPage=="MenuInfo"){
		if(!checkOp("221")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("222")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("241")){
			$("#saveBtn").linkbutton("disable");
		}
		if(!checkOp("242")){
			$("#candelBtn").linkbutton("disable");
		}
		if(!checkOp("243")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//工业司机页面
	else if(paramPage=="industrialdriver"){
		if(!checkOp("290")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("291")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("292")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//系统参数配置页面
	else if(paramPage=="sysparameter"){
		if(!checkOp("299")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("300")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("301")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//部门信息配置页面
	else if(paramPage=="Dept"){
		if(!checkOp("279")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("280")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("281")){
			$("#delBtn").linkbutton("disable");
		}
	}	
	//星级参数配置页面
	else if(paramPage=="Starinfo"){
		if(!checkOp("282")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("283")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("284")){
			$("#delBtn").linkbutton("disable");
		}
	}	
	//车辆信息配置页面
	else if(paramPage=="Vehicle"){
		if(!checkOp("275")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("278")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("277")){
			$("#delBtn").linkbutton("disable");
		}
		if(!checkOp("276")){
			$("#viewBtn").linkbutton("disable");
		}
	}
	//语音参数配置页面
	else if(paramPage=="voicepara"){
		if(!checkOp("333")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("334")){
			$("#editBtn").linkbutton("disable");
		}
	}
	//自动语音页面
	else if(paramPage=="Routescore"){
		if(!checkOp("381")){
			$("#viewBtn").linkbutton("disable");
		}
		if(!checkOp("382")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//零售户信息页面
	else if(paramPage=="Customer"){
		if(!checkOp("402")){
			$("#viewBtn").linkbutton("disable");
		}
	}
	
		//零售户异动
	else if(paramPage=="Blockcustomer"){
		if(!checkOp("421")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("422")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("423")){
			$("#delBtn").linkbutton("disable");
		}
		if(!checkOp("424")){
			$("#viewBtn").linkbutton("disable");
		}
		if(!checkOp("425")){
			$("#grantBtn").linkbutton("disable");
		}
	}
	//车组信息
	else if(paramPage=="Route"){
		if(!checkOp("462")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("463")){
			$("#editBtn").linkbutton("disable");
		}
	}
	//车组信息
	else if(paramPage=="RoutescoreMarket"){
		if(!checkOp("501")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("502")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//基础类别信息
	else if(paramPage=="BaseTypeInfo"){
		if(!checkOp("504")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("505")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("506")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//人员信息
	else if(paramPage=="User"){
		if(!checkOp("507")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("508")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("509")){
			$("#grantBtn").linkbutton("disable");
		}
		if(!checkOp("510")){
			$("#resetBtn").linkbutton("disable");
		}
	}
	//岗位信息
	else if(paramPage=="PostInfo"){
		if(!checkOp("511")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("512")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("513")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//自动语音考核项信息
	else if(paramPage=="autoItem"){
		if(!checkOp("527")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("528")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("529")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//考核权重设置
	else if(paramPage=="Assessweight"){
		if(!checkOp("521")){
			$("#editBtn").linkbutton("disable");
		}
	}
	//星级信息查看
	else if(paramPage=="Routemonthstar"){
		if(!checkOp("681")){
			$("#toexcelBtn").linkbutton("disable");
		}
	}
	//供应商信息
	else if(paramPage=="SupplierInfo"){
		if(!checkOp("703")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("704")){
			$("#viewBtn").linkbutton("disable");
		}
		if(!checkOp("705")){
			$("#editBtn").linkbutton("disable");
		}
		if(!checkOp("706")){
			$("#delBtn").linkbutton("disable");
		}
	}
	//物资管理
	else if(paramPage=="SPLImp"){
		if(!checkOp("721")){
			$("#newBtn").linkbutton("disable");
		}
		if(!checkOp("722")){
			$("#refundBtn").linkbutton("disable");
		}
	}
	//物资结算
	else if(paramPage=="SPLSettle"){
		if(!checkOp("763")){
			$("#settleBtn").linkbutton("disable");
		}
	}
	//入库单
	else if(paramPage=="StorageList"){
		if(!checkOp("782")){
			$("#toexcelBtn").linkbutton("disable");
		}
		if(!checkOp("781")){
			$("#printBtn").linkbutton("disable");
		}
	}
	
		//入库查询统计
		else if(paramPage=="Storagecount"){
			if(!checkOp("783")){
				$("#printBtn").linkbutton("disable");
			if(!checkOp("784")){
				$("#toexcelBtn").linkbutton("disable");
				}
			}
	}
	//出库汇总
		else if(paramPage=="SPLConsummary"){
			if(!checkOp("801")){
				$("#printBtn").linkbutton("disable");
			}
	}
	//品牌信息
		else if(paramPage=="Brandinfo"){
			if(!checkOp("1182")){
				$("#editBtn").linkbutton("disable");
			}
	}
})
//检查功能点是否有权限
function checkOp(opid){
	var result = false;
	if(opList==""||trim(opList).length==0){
		return;
	}
	else{
		return opList.indexOf(";"+opid+";") >= 0;
	}
}
</script>															