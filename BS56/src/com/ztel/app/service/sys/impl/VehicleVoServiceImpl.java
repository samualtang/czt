package com.ztel.app.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztel.app.persist.mybatis.sys.VehicleVoMapper;
import com.ztel.app.service.sys.VehicleVoService;
import com.ztel.app.vo.sys.BasetypeInfoVo;
import com.ztel.app.vo.sys.VehicleVo;
import com.ztel.app.vo.wms.CustomerVo;
import com.ztel.framework.vo.Pagination;

@Service
public class VehicleVoServiceImpl implements VehicleVoService{

@Autowired
    private VehicleVoMapper VehicleVoMapper =null;
	
	private Map<String, String> sortKeyMapping = new HashMap<>();
	
	public VehicleVoServiceImpl() {
		//TODO 请在这里填入排序的key转换为列名, 防止SQL注入;每个Service业务域用自己的mapping,在BaseCtrl容易重复
        //sortKeyMapping.put(key, value)
		sortKeyMapping.put("id", "id");
		sortKeyMapping.put("vehicles", "vehicles");
		sortKeyMapping.put("vehicleno", "vehicleno");
		sortKeyMapping.put("buydate", "buydate");
		sortKeyMapping.put("delstatus", "delstatus");
	}
	


	@Override
	public int delVehicleVo(List<Integer> ids) {
		// TODO Auto-generated method stub
		if(ids != null && ids.size() > 0) {
			for (Integer id : ids) {
				this.VehicleVoMapper.deleteByPrimaryKey(id);
			}
			return ids.size();
		}
		return 0;
	}

	@Override
	public int insertVehicleVo(VehicleVo VehicleVo) {
		// TODO Auto-generated method stub
		if (VehicleVo!=null&&!"".equals(VehicleVo.getId())) {
			return VehicleVoMapper.insertSelective(VehicleVo);
		}
		return 0;
	}

	@Override
	public int updateVehicleVo(VehicleVo VehicleVo) {
		// TODO Auto-generated method stub
		if (VehicleVo!=null&&!"".equals(VehicleVo.getId())) {
			return VehicleVoMapper.updateByPrimaryKeySelective(VehicleVo);
		}
		return 0;
	}

	@Override
	public List<VehicleVo> getVehicleVoList(VehicleVo vo) {
		// TODO 自动生成的方法存根
	//	System.out.println("2vehicleno=="+vo.getVehicleno()+"----------vehicles="+vo.getVehicles());
		return this.VehicleVoMapper.getVehicleVoList(vo);
	}

	@Override
	public List<VehicleVo> getVehicleVoPageList(Pagination<?> page) {
		// TODO 自动生成的方法存根
		List<VehicleVo> vehicleList = VehicleVoMapper.getVehicleVoPageList(page);
		return vehicleList;
	}


	@Override
	public int viewVehicleVo(VehicleVo vehicleVo) {
		// TODO 自动生成的方法存根
		return 0;
	}


    /**
     *配送车辆下拉列表
     */
	@Override
	public List<HashMap<String, String>> getVehiclesCombobox() {
		 // TODO Auto-generated method stub
		VehicleVo vehicleVo=new VehicleVo();
		vehicleVo.setVehicles("10");		 
		List<VehicleVo> treeList=getVehicleVoList(vehicleVo);
		 List<HashMap<String, String>> boxList=new ArrayList<>();
		 if (treeList!=null&&treeList.size()>0) {
			 for(int i=0;i<treeList.size();i++){
				 VehicleVo vo=treeList.get(i);
				 HashMap<String, String> map=new HashMap<String, String>();
				 map.put("id", vo.getId().toString());
				 map.put("vehicleno", vo.getVehicleno());
				 //System.out.println(vo.getId().toString()+"-------------");
				 //System.out.println(vo.getText()+"-------------");
				 boxList.add(map);
			 }
		}
		 
		 return boxList;
	}

	}
	
