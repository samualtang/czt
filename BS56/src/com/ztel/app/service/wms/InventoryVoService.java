package com.ztel.app.service.wms;

import java.util.List;

import com.ztel.app.vo.wms.InventoryVo;
import com.ztel.framework.vo.Pagination;

public interface InventoryVoService {

	public List<InventoryVo> selectInventoryPageList(Pagination<?> page);
	
	public int doInventoryAdd(InventoryVo inventoryVo);
	
	public int doInventoryUpdate(InventoryVo inventoryVo);
	
}
