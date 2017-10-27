/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.web.ctrl.wms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ztel.app.service.wms.ConsignorService;
import com.ztel.app.service.wms.ItemService;
import com.ztel.app.vo.sq.StarinfoVo;
import com.ztel.app.vo.sys.VehicleVo;
import com.ztel.app.vo.wms.ConsignorVo;
import com.ztel.app.vo.wms.ItemVo;
import com.ztel.app.vo.wms.LanewayVo;
import com.ztel.framework.vo.Pagination;
import com.ztel.framework.web.ctrl.BaseCtrl;

/**
 * @author yy
 * @since 2017年9月11日
 */
@Controller
@RequestMapping("/wms/item")
public class ItemCtrl extends BaseCtrl {
	
	private static Logger logger = LogManager.getLogger(ItemCtrl.class);
	
	@Autowired
	private ItemService itemService = null;
	@RequestMapping("toBrandinfo")
	public String index(HttpServletRequest request) {
		
		return "/wms/v_brandinfo";
	}
	
	
	/**
	  * 获取商品信息
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("getBrandinfoList")
	 @ResponseBody
	 public Map<String, Object> getBrandinfoList(ItemVo itemVo, HttpServletRequest request) throws Exception{
		 Map<String, Object> result=new HashMap<String, Object>();  
		 
		Pagination<?> page = this.getPagination(request);
		if (itemVo!=null) {
			 page.setParam(itemVo);
		}
		List<ItemVo> itemVoList = new ArrayList<ItemVo>();
		itemVoList = itemService.getBrandinfoList(page);
		
		 result.put("rows",itemVoList);  
		 result.put("total",page.getTotalCount());  
		 
		return result;
	 }
	 
	 /**
	  * 修改品牌信息
	  * @return
	  */
	 @RequestMapping(value="doEditBrandinfo",method=RequestMethod.POST)
	 @ResponseBody
	 public   Map<String, Object> doEditBrandinfo(ItemVo itemVo,HttpServletResponse response) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
        
		 try {
			 itemService.updateBrandinfo(itemVo);
			 map.put("msg", "成功");
			 total=1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			map.put("msg", "失败");
		}
		 map.put("total", total);
		// String result = JSON.toJSONString(map);
		 //response.setContentType("text/html;charset=UTF-8");
		 //response.getWriter().write(result);
		 return map;
	 }
	 
	 

	 	
	

}
	
    
