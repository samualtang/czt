package com.ztel.app.service.wms.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztel.app.persist.mybatis.wms.ItemVoMapper;
import com.ztel.app.service.wms.ItemService;
import com.ztel.app.vo.sys.SysparameterVo;
import com.ztel.app.vo.wms.ConsignorVo;
import com.ztel.app.vo.wms.ItemVo;
import com.ztel.framework.vo.Pagination;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemVoMapper itemVoMapper = null;
	
	@Override
	public List<ItemVo> selectListByCond(ItemVo itemVo) {
		// TODO Auto-generated method stub
		return itemVoMapper.selectListByCond(itemVo);
	}
	/**
	 * 获取品牌信息
	 */
	@Override
	public List<ItemVo> getBrandinfoList(Pagination<?> page) {
		// TODO Auto-generated method stub
		return itemVoMapper.selectBrandinfoPageList(page);
	}
	
	@Override
	public int updateBrandinfo(ItemVo itemVo) {
		// TODO Auto-generated method stub
		if (itemVo!=null&&!"".equals(itemVo.getId())) {
			return itemVoMapper.updateByPrimaryKeySelective(itemVo);
		}
		return 0;
	}
}
