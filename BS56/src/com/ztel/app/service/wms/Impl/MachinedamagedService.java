package com.ztel.app.service.wms.Impl;

import java.math.BigDecimal;
import java.util.List;

import com.ztel.app.vo.produce.SortTroughVo;
import com.ztel.app.vo.wms.MachinedamagedVo;
import com.ztel.framework.vo.Pagination;

public interface MachinedamagedService {

	public List<MachinedamagedVo> selectCigarettedamagedPageList(Pagination<?> page);
	
	public void insertMachinedamaged(SortTroughVo sortTroughVo,BigDecimal qty,BigDecimal id,Long userid,String mdid);
	
	public void doAudit(MachinedamagedVo machinedamagedVo);
	
	public void doUpdate(MachinedamagedVo machinedamagedVo);
}
