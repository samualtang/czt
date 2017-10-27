package com.ztel.app.service.wms;

import java.util.List;

import com.ztel.app.vo.wms.ItemVo;
import com.ztel.framework.vo.Pagination;

public interface ItemService {
	List<ItemVo> selectListByCond(ItemVo itemVo);
	public List<ItemVo> getBrandinfoList(Pagination<?> page);
	public int updateBrandinfo(ItemVo itemVo);
}
