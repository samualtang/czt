/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.service.cost;

import java.util.List;
import java.util.Map;

import com.ztel.app.vo.cost.SuppliesImpVo;
import com.ztel.framework.vo.Pagination;

/**
 * @author NJ
 * @since 2017年6月26日
 */
public interface SuppliesImpVoService {
	/**
	 * 入库信息列表
	 * @param page
	 * @return
	 */
    List<SuppliesImpVo> getSuppliesImpPageList(Pagination<?> page);
    
    /**
     * 退库信息列表
     * @param page
     * @return
     */
    List<SuppliesImpVo> getSuppliesRefundPageList(Pagination<?> page);
    
    /**
     * 退库信息列表
     * @param page
     * @return
     */
    List<SuppliesImpVo> getSuppliesSettleList(Map<String,Object> paraMap);
    
    /**
     * 用于生产物资编号
     * @param dateStr
     * @return
     */
    public String getMaxSuppliesCode(String dateStr);
    
    /**
     * 退库
     * @param suppliesImpVo
     * @return
     */
	public void doRefundSupplies(SuppliesImpVo suppliesImpVo);
	
	/**
	 * 结算
	 * @param suppliesImpVo
	 * @return
	 */
	public void doSuppliesSettle(List<Integer> idLst);

	/**
	 * 入库
	 * @param suppliesImpVo
	 */
    public void doInsertSuppliesImp(SuppliesImpVo suppliesImpVo);
    /**
     * 入库单
     * @param suppliesImpVo
     * @return
     */
    public List<SuppliesImpVo> searchSuppliesImpList(Pagination<?> page);
    
    /**
     * 根据typeid取物资剩余数量不为0的物资类别列表
     * @param typeid
     * @return
     */
    public List<SuppliesImpVo> getSuppliesImpListByTypeidForStock(String typeid);
    
    /**
     * 根据条件获取物资列表
     * @param suppliesImpVo
     * @return
     */
    public List<SuppliesImpVo> getSuppliesImpListByCond(SuppliesImpVo suppliesImpVo);


}
