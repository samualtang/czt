/*
 * Copyright (c) 2017, All rights reserved.
 */
package com.ztel.app.service.cost;

import java.util.List;

import com.ztel.app.vo.cost.SPLTypeStockVo;

/**
 * @author NJ
 * @since 2017年6月29日
 */
public interface SPLTypeStockVoService {
	
    /**
     * 物资入库和退库操作更新总库存表
     * @param splTypeStockVo
     * @return
     */
    public int updateTypeStockByImpOrRefund(SPLTypeStockVo splTypeStockVo);
    
    public List<SPLTypeStockVo> getTypeStockList(SPLTypeStockVo splTypeStockVo);
    
    public List<SPLTypeStockVo> getTypeStockListForPrint(SPLTypeStockVo splTypeStockVo);
    
}
