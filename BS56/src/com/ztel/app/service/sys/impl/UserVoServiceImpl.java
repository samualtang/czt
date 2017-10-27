package com.ztel.app.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztel.app.persist.mybatis.sys.OperationrolerelativeVoMapper;
import com.ztel.app.persist.mybatis.sys.UserVoMapper;
import com.ztel.app.service.sys.UserVoService;
import com.ztel.app.vo.sys.OperationrolerelativeVo;
import com.ztel.app.vo.sys.UserVo;
import com.ztel.framework.vo.Pagination;

@Service
public class UserVoServiceImpl implements UserVoService{

	@Autowired
	private UserVoMapper userVoMapper = null;
	
	@Autowired
	private OperationrolerelativeVoMapper operationrolerelativeVoMapper = null;
	
    private Map<String, String> sortKeyMapping = new HashMap<>();
	
	public UserVoServiceImpl() {
		//TODO 请在这里填入排序的key转换为列名, 防止SQL注入;每个Service业务域用自己的mapping,在BaseCtrl容易重复
        //sortKeyMapping.put(key, value)
		sortKeyMapping.put("usercode", "usercode");
		sortKeyMapping.put("username", "username");
		sortKeyMapping.put("deptname", "deptname");
	}
	
	/**
	 * 用户登录判断
	 */
	public Map<String, Object> checkUser(String usercode,String userpsw)
	{
		Map<String, Object> result  =new HashMap<String, Object>();  
		//先根据code判断用户是否存在
		int usercodeRlt = userVoMapper.selectByCode(usercode);
		if(usercodeRlt==0)//用户不存在
		{
			result.put("resultCode", "0");
			result.put("msg", "用户不存在");
			return result;
		}
		else//用户存在，则检查用户密码是否输入正确
		{
			UserVo userVo = userVoMapper.selectByCodeAndPwd(usercode, userpsw);
			if(userVo!=null && userVo.getId()>0)//用户密码正确
			{
				result.put("resultCode", "1");
				result.put("msg", "用户密码正确");
				
				//取角色功能点权限
				String opStr=";";
				if(userVo.getRoleid()!=null){
					List<OperationrolerelativeVo> opList = operationrolerelativeVoMapper.selectListByRoleid(userVo.getRoleid()+"");
					if(opList!=null&&opList.size()>0){
						for(int i=0;i<opList.size();i++){
							opStr += opList.get(i).getOperationid()+";";
						}
					}
					userVo.setOpList(opStr);
					result.put("userVo", userVo);
				}
				
			}
			else
			{
				result.put("resultCode", "2");
				result.put("msg", "用户密码不正确");
			}
			 return result;
		}
		 
	}
	
	public List<UserVo> getUserListByDeptId(Integer deptid)
	{
		List<UserVo> userList = userVoMapper.getUserListByDeptId(deptid);
		return userList;
	}

	/**
	 * 取用户列表
	 */
	@Override
	public List<UserVo> getUserPageList(Pagination<?> page) {
		// TODO Auto-generated method stub
		page.sortKeyToColumn(sortKeyMapping);
		List<UserVo> userList = userVoMapper.getUserPageList(page);
		return userList;
	}

	/**
	 * 密码重置
	 */
	@Override
	public void resetPsw(List<Integer> ids) {
		// TODO Auto-generated method stub
		if(ids != null && ids.size() > 0) {
			for (Integer id : ids) {
				this.userVoMapper.updateUserPsw(id);
			}
		}
	}

	/**
	 * 新增用户
	 */
	@Override
	public void insertNewUser(UserVo userVo) {
		// TODO Auto-generated method stub
		if (userVo!=null&&!"".equals(userVo.getUsercode())) {
			userVoMapper.insertSelective(userVo);
		}
	}

	@Override
	public void updateUser(UserVo userVo) {
		// TODO Auto-generated method stub
		if (userVo!=null&&!"".equals(userVo.getUsercode())) {
			userVoMapper.updateByPrimaryKeySelective(userVo);
		}
	}

	@Override
	public List<UserVo> getUserListByRoleId(Integer roleid) {
		List<UserVo> userList = userVoMapper.getUserListByRoleId(roleid);
		return userList;
	}
	
	/**
	 * 角色重置，角色授权之前，把已经授权的角色id为roleid的用户重置为默认角色，以便下一步授权
	 * @param roleid
	 */
	public void resetRole(String roleid){
		
	}
	
	public List<UserVo> selectUserListByroleid(String roleid){
		List<UserVo> userVo = userVoMapper.selectUserListByroleid(roleid);
		return userVo;
	}
	
}
