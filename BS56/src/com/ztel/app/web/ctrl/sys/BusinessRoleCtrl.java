/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.web.ctrl.sys;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ztel.app.service.sys.BusinessRoleRelativeService;
import com.ztel.app.service.sys.BusinessRoleService;
import com.ztel.app.service.sys.OperationlogService;
import com.ztel.app.vo.sys.BusinessRoleRelativeVo;
import com.ztel.app.vo.sys.BusinessRoleVo;
import com.ztel.app.vo.sys.UserVo;
import com.ztel.framework.vo.Pagination;
import com.ztel.framework.web.ctrl.BaseCtrl;

/**
 * @author lcf
 * @since 2017年6月16日
 * 操作日志
 */
@Controller
@RequestMapping("/sys/businessrole")
public class BusinessRoleCtrl extends BaseCtrl {
	
	private static Logger logger = LogManager.getLogger(OperationlogCtrl.class);
	
	@Autowired
	private BusinessRoleService businessRoleService = null;
	
	@Autowired
	private OperationlogService operationlogService = null;
	
	@Autowired
	private BusinessRoleRelativeService businessRoleRelativeService = null;
	
	
	@RequestMapping("toBusinessrole")
	public String toOperation(HttpServletRequest request) {
		return "/sys/v_businessrole";
	}
	
	@RequestMapping("getBusinessroleList")
	 @ResponseBody
	 public  Map<String, Object> getOperationlogList(BusinessRoleVo businessRoleVo,HttpServletRequest request) throws Exception {

		Pagination<?> page = this.getPagination(request);
		 Map<String, Object> result=new HashMap<String, Object>();  
		
		 if (businessRoleVo!=null) {
			 page.setParam(businessRoleVo);
		}
		 
		 String rolename = request.getParameter("rolename");
		 List<BusinessRoleVo> ones = businessRoleService.getBusinessRolePageList(page);
		 
		 result.put("rows",ones);  
		 result.put("total",page.getTotalCount());  

		 return result;
	 }
	
 	
	 /**
	  * 删除角色
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="roledelete",method=RequestMethod.POST)
	 @ResponseBody
	 public   Map<String, Object> deleteRole(@RequestParam("id") List<Integer> id,HttpServletRequest request) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
		 if (id!=null&&id.size()>0) {
			 total = id.size();
		}
		 try {
			 businessRoleService.deleteRoleById(id);
			 UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
			 operationlogService.insertLog(userVo, "/sys/businessrole/roledelete", "业务角色", "删除", "");
			 map.put("msg", "成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			map.put("msg", "失败");
		}
		 map.put("total", total);
		 
		 return map;
	 }
	 
	 /**
	  * 新增角色
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="roleNew",method=RequestMethod.POST)
	// @ResponseBody
	 public   void roleNew(BusinessRoleVo businessRoleVo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
        
		 try {
			 System.out.println(businessRoleVo.getRolename()+"-------"+businessRoleVo.getRemarks());
			int result = businessRoleService.doAddRole(businessRoleVo);
			 UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
			 operationlogService.insertLog(userVo, "/sys/businessrole/roleNebusinessRoleVow", "业务角色", "新增", "");
			 map.put("msg", "成功");
			 total=1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			map.put("msg", "失败");
		}
		 map.put("total", total);
		 
		 //直接使用注解@ResponseBody，框架自动返回json串，但是form形式提交的返回json在IE在会出现下载json的提示，所以修改成设置response的形式
		 String result = JSON.toJSONString(map);
		 response.setContentType("text/html;charset=UTF-8");
		 response.getWriter().write(result);  

		 //return result;
	 }
	 
	 /**
	  * 修改角色
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="roleUpdate",method=RequestMethod.POST)
	 //@ResponseBody
	 public   void roleUpdate(BusinessRoleVo businessRoleVo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 int total=0;
        
		 try {
			 businessRoleService.doUpdateRole(businessRoleVo);
			 UserVo userVo = (UserVo)request.getSession().getAttribute("userVo");
			 operationlogService.insertLog(userVo, "/sys/businessrole/roleUpdate", "业务角色", "修改", "");
			 map.put("msg", "成功");
			 total=1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
			map.put("msg", "失败");
		}
		 map.put("total", total);
		 String result = JSON.toJSONString(map);
		 response.setContentType("text/html;charset=UTF-8");
		 response.getWriter().write(result);
		 //return map;
	 }
	 
	 /**
	  * 提交角色对用户授权
	  * @param request
	  * @return
	  */
	 @RequestMapping(value="/doRoleGrant",method=RequestMethod.GET)
	 @ResponseBody
		public  Map<String, Object> doRoleGrant(HttpServletRequest request) {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 String userstr= request.getParameter("userstr");
		 String roleid= request.getParameter("roleid");
		 //System.out.println("roleinfoCtr------------userstr="+userstr+",roleid="+roleid);
		 businessRoleService.doRoleGrant(userstr,roleid);
			return map;
			//return "/sys/v_roleSetting";
		}
	 
	 /**
	  * 根据角色获取已经授权的用户列表
	  * @param request
	  * @return
	  */
	 @RequestMapping(value="/getRoleGrantUserList",method=RequestMethod.GET)
	 @ResponseBody
		public  List<BusinessRoleRelativeVo> getRoleGrantUserList(HttpServletRequest request) {
		 Map<String, Object> map=new HashMap<String, Object>();  
		 String roleid= request.getParameter("roleid");
		 //System.out.println("roleinfoCtr------------userstr="+userstr+",roleid="+roleid);
		 List<BusinessRoleRelativeVo> userList = businessRoleRelativeService.getBusinessRoleRelativeGrantList(roleid);
			//return userList;
			return userList;
		}
}
