package com.ztel.app.service.cost.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztel.app.persist.mybatis.cost.SPLTypeStockVoMapper;
import com.ztel.app.service.cost.SPLTypeStockVoService;
import com.ztel.app.vo.cost.SPLTypeStockVo;

@Service
public class SPLTypeStockVoServiceImpl implements SPLTypeStockVoService{

	@Autowired
    private SPLTypeStockVoMapper splTypeStockVoMapper =null;

	@Override
	public int updateTypeStockByImpOrRefund(SPLTypeStockVo splTypeStockVo) {
		// TODO Auto-generated method stub
		return this.splTypeStockVoMapper.updateSplTypeStockByImpOrRefund(splTypeStockVo);
	}

	@Override
	public List<SPLTypeStockVo> getTypeStockList(SPLTypeStockVo splTypeStockVo) {
		// TODO Auto-generated method stub
		return this.splTypeStockVoMapper.getTypeStockList(splTypeStockVo);
	}

	@Override
	public List<SPLTypeStockVo> getTypeStockListForPrint(SPLTypeStockVo splTypeStockVo) {
		// TODO Auto-generated method stub
		return this.splTypeStockVoMapper.getTypeStockListForPrint(splTypeStockVo);
	}
	
}
	
