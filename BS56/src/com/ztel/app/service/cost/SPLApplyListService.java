package com.ztel.app.service.cost;

import java.util.List;

import com.ztel.app.vo.cost.SPLApplyListLineVo;
import com.ztel.app.vo.cost.SPLApplyListVo;
import com.ztel.framework.vo.Pagination;

public interface SPLApplyListService {
	public List<SPLApplyListVo> getApplyListList(Pagination<?> page);
	
	public void doAddApplyList(SPLApplyListVo sPLApplyListVo,SPLApplyListLineVo sPLApplyListLineVo,String reqType);
	
	public void doUpdateApplyList(SPLApplyListVo sPLApplyListVo);
	
	public void doDelApplyList(SPLApplyListVo sPLApplyListVo);
	
	public SPLApplyListVo getSPLApplyListVoByPrimaryKey(String listid);
	
	/**
	 * 修改发料的某物资申请数量
	 * @param sPLApplyListLineVo
	 */
	public void doEditSPLApplyListLineVo(SPLApplyListLineVo sPLApplyListLineVo);
	
	/**
	 * 发料时，由仓管员选择发料物资，新增一条物资申请单明细、该类型的库存申请数量做修改、物资锁定数量修改
	 * @param sPLApplyListLineVo
	 */
	public void doAddSPLApplyListLineVo(SPLApplyListLineVo sPLApplyListLineVo);

}
