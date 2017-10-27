package com.ztel.app.service.account;

import java.util.List;

import com.ztel.app.vo.account.OperateVo;
import com.ztel.framework.vo.Pagination;

public interface OperateVoService {

	public List<OperateVo> getOperatePageList(Pagination<?> page);
	
	/**
	 * 预付款退货列表
	 * @param operateVo
	 * @return
	 */
	public List<OperateVo> selectPrepayreturn(OperateVo operateVo);
	
	public void doOperateUpdate(OperateVo operateVo);
	
	public void doOperateDelete(List<Integer> ids);
	
	public void doOperateImp(List<Integer> ids,String status);
	
	public void doOperateAdd(OperateVo operateVo);
	
}
