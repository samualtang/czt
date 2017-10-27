package com.ztel.app.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztel.app.persist.mybatis.sys.BlockcustomerVoMapper;
import com.ztel.app.service.sys.BlockcustomerService;
import com.ztel.app.vo.sys.BlockcustomerVo;
import com.ztel.framework.vo.Pagination;

@Service
public class BlockcustomerServiceImpl implements BlockcustomerService{

	@Autowired
	private BlockcustomerVoMapper blockcustomerVoMapper = null;
    private Map<String, String> sortKeyMapping = new HashMap<>();
	
	public BlockcustomerServiceImpl() {
		//TODO 请在这里填入排序的key转换为列名, 防止SQL注入;每个Service业务域用自己的mapping,在BaseCtrl容易重复
        //sortKeyMapping.put(key, value)
		sortKeyMapping.put("custmoercode", "custmoercode");
		sortKeyMapping.put("id", "id");
		sortKeyMapping.put("custmoerid", "custmoerid");
	}
	
	
	@Override
	public List<BlockcustomerVo> searchBlockcustomerPageList(Pagination<?> page) {
		// TODO Auto-generated method stub
		page.sortKeyToColumn(sortKeyMapping);
		return this.blockcustomerVoMapper.getBlockcustomerPageList(page);
	}

	public int delBlockcustomer(List<Integer> ids) {
		// TODO Auto-generated method stub
		if(ids != null && ids.size() > 0) {
			for (Integer id : ids) {
				this.blockcustomerVoMapper.deleteByPrimaryKey(id);
			}
			return ids.size();
		}
		return 0;
	}

	public int insertBlockcustomer(BlockcustomerVo blockcustomerVo) {
		// TODO Auto-generated method stub
		if (blockcustomerVo!=null&&!"".equals(blockcustomerVo.getId())) {
			return blockcustomerVoMapper.insertSelective(blockcustomerVo);
		}
		return 0;
	}

	public int updateBlockcustomer(BlockcustomerVo blockcustomerVo) {
		// TODO Auto-generated method stub
		if (blockcustomerVo!=null&&!"".equals(blockcustomerVo.getId())) {
			return blockcustomerVoMapper.updateByPrimaryKeySelective(blockcustomerVo);
		}
		return 0;
	}


	@Override
	public int BlockcustomerView(BlockcustomerVo blockcustomerVo) {
		// TODO 自动生成的方法存根

		return 0;
	}


	@Override
	public int handleBlockcustomer(BlockcustomerVo blockcustomerVo) {
		return this.blockcustomerVoMapper.updateByPrimaryKeySelective(blockcustomerVo);
	}


	
	




	

		 
	}
	
