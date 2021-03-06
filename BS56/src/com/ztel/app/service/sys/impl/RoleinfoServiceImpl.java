/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.service.sys.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztel.app.persist.mybatis.sys.MenuinfoVoMapper;
import com.ztel.app.persist.mybatis.sys.MenurolerelativeVoMapper;
import com.ztel.app.persist.mybatis.sys.OperationrolerelativeVoMapper;
import com.ztel.app.persist.mybatis.sys.RoleinfoVoMapper;
import com.ztel.app.persist.mybatis.sys.UserVoMapper;
import com.ztel.app.persist.mybatis.sys.UserrolerelativeVoMapper;
import com.ztel.app.service.sys.RoleinfoService;
import com.ztel.app.vo.sys.MenuInfoVo;
import com.ztel.app.vo.sys.MenurolerelativeVo;
import com.ztel.app.vo.sys.OperationrolerelativeVo;
import com.ztel.app.vo.sys.RoleInfoVo;
import com.ztel.app.vo.sys.UserVo;
import com.ztel.app.vo.sys.UserrolerelativeVo;
import com.ztel.framework.util.PubUtils;
import com.ztel.framework.vo.Pagination;

/**
 * @author Administrator
 * @since 2017年2月27日
 */
@Service
public class RoleinfoServiceImpl implements RoleinfoService {
	
	@Autowired
	private RoleinfoVoMapper roleinfoMapper = null;
	
	@Autowired
	private UserVoMapper userVoMapper = null;
	
	@Autowired
	private MenurolerelativeVoMapper menurolerelativeVoMapper = null;
	
	@Autowired
	private MenuinfoVoMapper menuinfoVoMapper = null;
	
	@Autowired
	private UserrolerelativeVoMapper userrolerelativeVoMapper = null;
	
	@Autowired
	private OperationrolerelativeVoMapper operationrolerelativeVoMapper = null;
	
	
	private Map<String, String> sortKeyMapping = new HashMap<>();
	
	public RoleinfoServiceImpl() {
		//TODO 请在这里填入排序的key转换为列名, 防止SQL注入;每个Service业务域用自己的mapping,在BaseCtrl容易重复
//		sortKeyMapping.put(key, value)
		sortKeyMapping.put("rolename", "rolename");
		sortKeyMapping.put("id", "id");
		sortKeyMapping.put("updatetime", "updatetime");
	}
	
	public List<RoleInfoVo> searchRoleinfoList(Pagination<?> page) {
		
		page.sortKeyToColumn(sortKeyMapping);
		return this.roleinfoMapper.getRoleinfoPageList(page);
	}
	
	/**
	 * 根据id删除角色
	 */
	public void deleteRoleById(List<Integer> ids)
	{
		if(ids != null && ids.size() > 0) {
			for (Integer id : ids) {
				this.roleinfoMapper.doDeleteById(id);
			}
		}
	}
	
	/**
	 * 新增角色
	 */
	public void newRole(RoleInfoVo roleinfo)
	{
		if(roleinfo != null && !roleinfo.getRolename().equals("") ) {
				this.roleinfoMapper.doNewRole(roleinfo);
		}
	}
	/**
	 * 修改角色
	 */
	public void updateRole(RoleInfoVo roleinfo)
	{
		if(roleinfo != null && !roleinfo.getRolename().equals("") ) {
				this.roleinfoMapper.doUpdateRole(roleinfo);
		}
	}

	/**
	 * 提交角色菜单权限设置，idList格式:1，2，3，4，...
	 */
	public void doRoleSetting(String idList,String roleid){
		String[] idListArr = idList.split(",");
		if(idListArr!=null&&idListArr.length>0){//判断idList非空
			for(int i=0;i<idListArr.length;i++){
				String id=idListArr[i];
				if(id!=null&&id.trim().length()>0){//判断id非空
					System.out.println("id-----------"+id);
					MenurolerelativeVo menurolerelativeVo = new MenurolerelativeVo();
					menurolerelativeVo.setMenuid(Integer.parseInt(id));
					menurolerelativeVo.setSysroleid(Integer.parseInt(roleid));
					//检查roleid的角色 是否已经对id的菜单授权，没有授权则授权，否则跳过
					if(!checkSetting(id,roleid))
					{
						menurolerelativeVoMapper.insertSelective(menurolerelativeVo);
						//检查其父级是否授权，如果没有，则其父级也需要授权，否则导航中无法正常显示角色授权的菜单
						//1.根据id在t_sys_menuinfo中查找菜单的级次和父级菜单id(需要考虑3级的父级有2个)
						BigDecimal bd=new BigDecimal(id);
						MenuInfoVo menuInfoVo = menuinfoVoMapper.selectByPrimaryKey(bd);
						if(menuInfoVo!=null){
							BigDecimal  fid = menuInfoVo.getFid();
							String menulevel = menuInfoVo.getMenulevel();
							//如果是3级菜单，需要对父级及祖父级进行授权判断
							if(menulevel!=null&&menulevel.trim().equals("3"))
							{
								//2.根据父级菜单id和角色id，检查挂接表中是否已经授权，没有授权则授权，否则跳过
								//父级授权
								if(!checkSetting(fid+"",roleid)){//父级未授权
									MenurolerelativeVo menurolerelativeVo_f = new MenurolerelativeVo();
									menurolerelativeVo_f.setMenuid(fid.intValue());
									menurolerelativeVo_f.setSysroleid(Integer.parseInt(roleid));
									menurolerelativeVoMapper.insertSelective(menurolerelativeVo_f);
									
									//祖父级授权
									MenuInfoVo menuInfoVo_f = menuinfoVoMapper.selectByPrimaryKey(fid);
									if(menuInfoVo_f!=null){
										BigDecimal  fid_f = menuInfoVo_f.getFid();
										String menulevel_F = menuInfoVo_f.getMenulevel();
										//判断祖父级是否授权
										if(!checkSetting(fid_f+"",roleid)){//祖父级未授权
											MenurolerelativeVo menurolerelativeVo_gf = new MenurolerelativeVo();
											menurolerelativeVo_gf.setMenuid(fid_f.intValue());
											menurolerelativeVo_gf.setSysroleid(Integer.parseInt(roleid));
											menurolerelativeVoMapper.insertSelective(menurolerelativeVo_gf);
										}
									}
								}
								
							}else if(menulevel!=null&&menulevel.trim().equals("2")){
								//父级授权
								if(!checkSetting(fid+"",roleid)){//父级未授权
									MenurolerelativeVo menurolerelativeVo_f = new MenurolerelativeVo();
									menurolerelativeVo_f.setMenuid(fid.intValue());
									menurolerelativeVo_f.setSysroleid(Integer.parseInt(roleid));
									menurolerelativeVoMapper.insertSelective(menurolerelativeVo_f);
								}
							}
						}
						
					}
					
				}
			}
		}
		
	}
	
	/**
	 * 角色授权给用户
	 * @param userstr 用户串 格式为姓名[工号];姓名[工号];姓名[工号]...  如：谢静[0502];殷兴强[0061];...
	 * @param roleid
	 */
	public void doRoleGrant(String userstr,String roleid){
		String codestr = PubUtils.userstrExtract(userstr);//codestr格式为0502;006;
		String[] codestrArr = codestr.split(";");
		UserrolerelativeVo userrolerelativeVo = new UserrolerelativeVo();
		//授权之前删除该角色下已授权用户,前版本为用户和角色挂接表，后修改为直接对用户表授权角色
		//userrolerelativeVoMapper.deleteByRoleid(roleid);
		//授权之前删除该角色下已授权用户
		userVoMapper.resetRole(roleid);
		
		if(codestrArr!=null&&codestrArr.length>0){
			for(int i=0;i<codestrArr.length;i++){
				UserVo userVo = userVoMapper.selectByCodeAndPwd(codestrArr[i], "");
				Long userid = userVo.getId();
				if(!checkGrant(userid+"",roleid)){//检查角色下该用户是否已经授权，已经授权则跳过，没有则执行授权
					UserVo user = new UserVo();
					user.setId(userid);
					user.setRoleid(Integer.parseInt(roleid));
					userVoMapper.updateByPrimaryKeySelective(user);
//					 userrolerelativeVo = new UserrolerelativeVo();
//					 userrolerelativeVo.setRoleid(Integer.parseInt(roleid));
//					 userrolerelativeVo.setUserid(Integer.parseInt(userid));
//					 userrolerelativeVoMapper.insertSelective(userrolerelativeVo);
				}
			}
		}
		
	}
	
	/**
	 * 角色功能点授权提交
	 * @param opid 功能点id串
	 * @param roleid 角色id
	 * @param belongsys 所属系统
	 */
	public void doRoleOperation(List<String> opid,String roleid,String belongsys ){
		//先删除角色在所属系统下的功能点授权.然后再新增
		operationrolerelativeVoMapper.deleteByRoleid(roleid, belongsys);
		if(opid!=null&&opid.size()>0){
			for(int i=0;i<opid.size();i++){
				String id = opid.get(i);
				BigDecimal bgid = new BigDecimal(id);
				OperationrolerelativeVo operationrolerelativeVo = new OperationrolerelativeVo();
				operationrolerelativeVo.setOperationid(bgid);
				operationrolerelativeVo.setRoleid(Integer.parseInt(roleid));
				operationrolerelativeVo.setBelongsys(belongsys);
				operationrolerelativeVoMapper.insertSelective(operationrolerelativeVo);
			}
		}
	}
	
	private boolean checkSetting(String menuid,String roleid)//返回true则表示已经授权
	{
		boolean hasSetting = false;
		int rlt = menurolerelativeVoMapper.checkSetting(menuid, roleid);
		if(rlt!=0)hasSetting = true;
		
		return hasSetting;
	}

	private boolean checkGrant(String userid,String roleid)//返回true则表示已经授权
	{
		boolean hasSetting = false;
		int rlt = userVoMapper.checkGrant(userid, roleid);
		if(rlt!=0)hasSetting = true;
		
		return hasSetting;
	}

	@Override
	public List<HashMap<String, String>> getRoleinfoCombobox() {
		// TODO Auto-generated method stub
		List<RoleInfoVo> treeList=getRoleinfoList();
		 List<HashMap<String, String>> boxList=new ArrayList<>();
		 if (treeList!=null&&treeList.size()>0) {
			 for(int i=0;i<treeList.size();i++){
				 RoleInfoVo vo=treeList.get(i);
				 HashMap<String, String> map=new HashMap<String, String>();
				 map.put("id", vo.getId().toString());
				 map.put("rolename", vo.getRolename());
				 //System.out.println(vo.getId().toString()+"-------------");
				 //System.out.println(vo.getText()+"-------------");
				 boxList.add(map);
			 }
		}
		 
		 return boxList;
	}

	@Override
	public List<RoleInfoVo> getRoleinfoList() {
		// TODO Auto-generated method stub
		List<RoleInfoVo> roleInfoVos=roleinfoMapper.getRoleinfoList();
		return roleInfoVos;
	}
	
}
