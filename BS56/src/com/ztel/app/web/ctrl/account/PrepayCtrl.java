package com.ztel.app.web.ctrl.account;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztel.app.service.account.OperateVoService;
import com.ztel.app.service.account.TimebydmVoService;
import com.ztel.app.service.produce.OrderService;
import com.ztel.app.service.wms.ShipOrderService;
import com.ztel.app.vo.account.OperateVo;
import com.ztel.app.vo.wms.ShipOrderVo;
import com.ztel.framework.util.FileUtil;

/**
 * 预付款客户
 * @author lcf
 *
 */
@Controller
@RequestMapping("/account/prepay")
public class PrepayCtrl {
	
	@Autowired
	private ShipOrderService shipOrderService = null;
	
	@Autowired
	private OrderService orderService = null;
	
	@Autowired
	TimebydmVoService timebydmVoService = null;
	
	@Autowired
	OperateVoService operateVoService = null;
	
	/**
	 * 预付款车组
	 * @param request
	 * @return
	 */
	@RequestMapping("toPrepayvehicle")
	public String toPrepayvehicle(HttpServletRequest request) {
		return "/account/v_prepayvehicle";
		//return "/gis/v_truckseq";
	}
	
	/**
	 * 预付款车组统计
	 * @param request
	 * @return
	 */
	@RequestMapping("toPrepayvehiclecount")
	public String toPrepayvehiclecount(HttpServletRequest request) {
		return "/account/v_prepayvehiclecount";
		//return "/gis/v_truckseq";
	}
	
	/**
	 * 预付款车组
	 * @param request
	 * @return
	 */
	@RequestMapping("toPrepayorder")
	public String toPrepayorder(HttpServletRequest request) {
		return "/account/v_prepayorder";
		//return "/gis/v_truckseq";
	}
	
	/**
	 * 预付款退货
	 * @param request
	 * @return
	 */
	@RequestMapping("toPrepayreturn")
	public String toPrepayreturn(HttpServletRequest request) {
		return "/account/v_prepayreturn";
		//return "/gis/v_truckseq";
	}
	
	/**
	 * 预付款车组查看
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectShiporderPerpayList")
	 @ResponseBody
	 public List<ShipOrderVo> selectShiporderPerpayList(HttpServletRequest request) throws Exception{
		 List<ShipOrderVo> result=new ArrayList<ShipOrderVo>(); 
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 String nowTime = sdf.format(new Date());
		 
		 String type = request.getParameter("type");
			if(type==null||type.equals(""))type="0";
			
			String orderdateTmp = timebydmVoService.getTimebydm(nowTime, type);
			
		 String date = request.getParameter("orderdate");
		 if(date==null||date.equals(""))date =orderdateTmp;
	 
		    Date orderdate = sdf.parse(date);
		  String calcid = request.getParameter("calcid");
		  String deptid = request.getParameter("deptid");
		    
		 ShipOrderVo shipOrderVo = new ShipOrderVo();
		 shipOrderVo.setOrderdate(orderdate);
		 if(calcid!=null&&!calcid.equals("")){
			 shipOrderVo.setCalcid(new BigDecimal(calcid));
		 }
		 if(deptid!=null&&!deptid.equals("")){
			 shipOrderVo.setDeptid(new BigDecimal(deptid));
		 }
		 result = shipOrderService.selectShiporderPerpayList(shipOrderVo);
		return result;
	}

	/**
	 * 预付款车组查看导出到excel
	 * @param request
	 * @return
	 */
	@RequestMapping("doExportToExcel")
	@ResponseBody
	public void doExportToExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 String nowTime = sdf.format(new Date());
		 
		 String type = request.getParameter("type");
			if(type==null||type.equals(""))type="0";
		String date = request.getParameter("orderdate");
		String orderdateTmp = timebydmVoService.getTimebydm(nowTime, type);
		
		 if(date==null||date.equals(""))date =orderdateTmp;
		    Date orderdate = sdf.parse(date);
		    
		 //orderdateStr = "2017-09-07";
		  String calcid = request.getParameter("calcid");
		  String deptid = request.getParameter("deptid");
		    
		 ShipOrderVo shipOrderVo = new ShipOrderVo();
		 shipOrderVo.setOrderdate(orderdate);
		 if(calcid!=null&&!calcid.equals("")){
			 shipOrderVo.setCalcid(new BigDecimal(calcid));
		 }
		 if(deptid!=null&&!deptid.equals("")){
			 shipOrderVo.setDeptid(new BigDecimal(deptid));
		 }
		ArrayList<ShipOrderVo> resultList = ( ArrayList<ShipOrderVo>)shipOrderService.selectShiporderPerpayList(shipOrderVo);

		List<String> needPrintFields=new ArrayList<String>();
	     needPrintFields.add("routecode");
	     needPrintFields.add("customername");
	     needPrintFields.add("totalamount");
	     needPrintFields.add("totalqty");
	     needPrintFields.add("orderdatestr");
	     
		 List<String> ColumnTitle=new ArrayList<String>();
		 ColumnTitle.add("线路");
		 ColumnTitle.add("客户名称");
		 ColumnTitle.add("消费金额");
		 ColumnTitle.add("条数");
		 ColumnTitle.add("订单日期");
		 
		 String sheetname="预付款车组";
		 String title="预付款车组";
			 
		 FileUtil.ExportToExcel(resultList,sheetname,title, needPrintFields, ColumnTitle,  response);
		

	}
	
	/**
	 * 预付款车组统计
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectShiporderPerpayCountList")
	 @ResponseBody
	 public List<ShipOrderVo> selectShiporderPerpayCountList(HttpServletRequest request) throws Exception{
		 List<ShipOrderVo> result=new ArrayList<ShipOrderVo>(); 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 String nowTime = sdf.format(new Date());
		 String type = request.getParameter("type");
			if(type==null||type.equals(""))type="0";
			String orderdateTmp = timebydmVoService.getTimebydm(nowTime, type);
			
		 String date = request.getParameter("orderdate");
			if(date==null||date.equals(""))date =orderdateTmp;
			
			
			 
		 //orderdateStr = "2017-09-07";
		 
		    Date orderdate = sdf.parse(date);
		  String calcid = request.getParameter("calcid");
		  String deptid = request.getParameter("deptid");
		    
		 ShipOrderVo shipOrderVo = new ShipOrderVo();
		 shipOrderVo.setOrderdate(orderdate);
		 if(calcid!=null&&!calcid.equals("")){
			 shipOrderVo.setCalcid(new BigDecimal(calcid));
		 }
		 if(deptid!=null&&!deptid.equals("")){
			 shipOrderVo.setDeptid(new BigDecimal(deptid));
		 }
		 result = shipOrderService.selectShiporderPerpayCountList(shipOrderVo);
		return result;
	}
	
	/**
	 * 预付款订单查看
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectShiporderPerpayOrderList")
	 @ResponseBody
	 public List<ShipOrderVo> selectShiporderPerpayOrderList(HttpServletRequest request) throws Exception{
		 List<ShipOrderVo> result=new ArrayList<ShipOrderVo>(); 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 String nowTime = sdf.format(new Date());
		 String type = request.getParameter("type");
			if(type==null||type.equals(""))type="0";
			String orderdateTmp = timebydmVoService.getTimebydm(nowTime, type);
			
			
		 String date = request.getParameter("orderdate");
			if(date==null||date.equals(""))date =orderdateTmp;

			
			// String dateresult = timebydmVoService.getTimebydm(date, type);
			 
		 //orderdateStr = "2017-09-07";
		 
		    Date orderdate = sdf.parse(date);
		  String calcid = request.getParameter("calcid");
		  String deptid = request.getParameter("deptid");
		  String prepayid = request.getParameter("prepayid");
		    
		 ShipOrderVo shipOrderVo = new ShipOrderVo();
		 shipOrderVo.setOrderdate(orderdate);
		 if(calcid!=null&&!calcid.equals("")){
			 shipOrderVo.setCalcid(new BigDecimal(calcid));
		 }
		 if(deptid!=null&&!deptid.equals("")){
			 shipOrderVo.setDeptid(new BigDecimal(deptid));
		 }
		 if(prepayid!=null&&!prepayid.equals("")){
			 shipOrderVo.setParentcustid(prepayid);
		 }
		 result = shipOrderService.selectShiporderPerpayOrderList(shipOrderVo);
		return result;
	}
	
	/**
	 * 预付款订单导出到excel
	 * @param request
	 * @return
	 */
	@RequestMapping("doExportOrderToExcel")
	@ResponseBody
	public void doExportOrderToExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		 List<ShipOrderVo> result=new ArrayList<ShipOrderVo>(); 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 
		 String nowTime = sdf.format(new Date());
		 String type = request.getParameter("type");
			if(type==null||type.equals(""))type="0";
			String orderdateTmp = timebydmVoService.getTimebydm(nowTime, type);
			
		 String date = request.getParameter("orderdate");
			if(date==null||date.equals(""))date =orderdateTmp;
			
			 //String dateresult = timebydmVoService.getTimebydm(date, type);
			 
		 //orderdateStr = "2017-09-07";
		 
		    Date orderdate = sdf.parse(date);
		  String calcid = request.getParameter("calcid");
		  String deptid = request.getParameter("deptid");
		  String prepayid = request.getParameter("prepayid");
		    
		 ShipOrderVo shipOrderVo = new ShipOrderVo();
		 shipOrderVo.setOrderdate(orderdate);
		 if(calcid!=null&&!calcid.equals("")){
			 shipOrderVo.setCalcid(new BigDecimal(calcid));
		 }
		 if(deptid!=null&&!deptid.equals("")){
			 shipOrderVo.setDeptid(new BigDecimal(deptid));
		 }
		 if(prepayid!=null&&!prepayid.equals("")){
			 shipOrderVo.setParentcustid(prepayid);
		 }
		 ArrayList<ShipOrderVo> resultList = ( ArrayList<ShipOrderVo>)shipOrderService.selectShiporderPerpayOrderList(shipOrderVo);
		 
		List<String> needPrintFields=new ArrayList<String>();
		needPrintFields.add("customername");
		needPrintFields.add("customerId");
		needPrintFields.add("realshipaddressphone");
	     needPrintFields.add("routecode");
	     needPrintFields.add("totalamount");
	     needPrintFields.add("totalqty");
	     needPrintFields.add("orderdatestr");
	     
		 List<String> ColumnTitle=new ArrayList<String>();
		 ColumnTitle.add("客户名称");
		 ColumnTitle.add("专卖证");
		 ColumnTitle.add("电话");
		 ColumnTitle.add("线路");
		 ColumnTitle.add("消费金额");
		 ColumnTitle.add("条数");
		 ColumnTitle.add("订单日期");
		 
		 String sheetname="预付款订单";
		 String title="预付款订单";
			 
		 FileUtil.ExportToExcel(resultList,sheetname,title, needPrintFields, ColumnTitle,  response);
		

	}
	
	/**
	 * 预付款退货
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getPrepayreturn")
	 @ResponseBody
	 public List<OperateVo> getPrepayreturn(HttpServletRequest request) throws Exception{
		 List<OperateVo> result=new ArrayList<OperateVo>(); 
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 String nowTime = sdf.format(new Date());
		 
		 String type = request.getParameter("type");
			if(type==null||type.equals(""))type="0";
		
			String orderdateTmp = timebydmVoService.getTimebydm(nowTime, type);
		 String begdate = request.getParameter("orderdateStart");
		 if(begdate==null||begdate.equals(""))begdate =orderdateTmp;
	 
		 String enddate = request.getParameter("orderdateEnd");
		 if(enddate==null||enddate.equals(""))enddate = begdate;
		 
		  String keywd = request.getParameter("keywd");
		  
		  
		    

		 OperateVo  operateVo = new OperateVo();
		 operateVo.setBegdate(begdate);
		 operateVo.setEnddate(enddate);
		 if(keywd!=null&&!keywd.equals(""))
		 {
			 operateVo.setKeywd(keywd);
		 }
		 result = operateVoService.selectPrepayreturn(operateVo);
		return result;
	}
	
}
