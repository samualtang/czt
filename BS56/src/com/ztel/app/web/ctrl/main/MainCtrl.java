/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.web.ctrl.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztel.app.service.sys.MenuinfoService;
import com.ztel.app.vo.sys.MenuInfoVo;
import com.ztel.framework.web.annotation.AuthorityPage;
import com.ztel.framework.web.annotation.PublicPage;
import com.ztel.framework.web.ctrl.BaseCtrl;

/**
 * @author Zeal
 * @since 2017年3月16日
 * 菜单控制
 */
@Controller
@RequestMapping("/main")
public class MainCtrl extends BaseCtrl {
	
	private static Logger logger = LogManager.getLogger(MainCtrl.class);
	
	@Autowired
	private MenuinfoService menuinfoService = null;
	
	@RequestMapping("toMain")
	@AuthorityPage("main")
	public String index(HttpServletRequest request) {
		String sysid= request.getParameter("sysid");
		if(sysid==null||sysid.equals(""))sysid="1";
		request.setAttribute("sysid", sysid);
		return "/index/main";
	}
	
	 /**
	  * 根据系统模块名称获取栏目信息
	  * @return
	  */
	 /**
	  * 根据系统模块名称获取栏目信息
	  * @return
	  */
	 @RequestMapping(value="getMainMenu")
	 @ResponseBody
	 @PublicPage
	 public  Map<String, Object> getSysMenuList(String sysid,String roleid)
	 {
		 if(sysid==null||sysid.equals(""))sysid="1";
		 System.out.println("roleid=="+roleid);
		 if(roleid==null||roleid.equals(""))roleid="0";
		 //if(id==null||id.equals(""))sysid="0";//菜单id，对应数据库表中的fid
		 Map<String, Object> map=new HashMap<String, Object>(); 
		 List<MenuInfoVo> menuList=menuinfoService.searchMenuinfoListforMain(sysid,roleid);
		 map.put("menus", menuList);
		 return map;
	 }
	
	
}
