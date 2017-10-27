package com.ztel.app.service.cost.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztel.app.persist.mybatis.cost.SPLTypeInfoVoMapper;
import com.ztel.app.persist.mybatis.cost.SPLTypeStockVoMapper;
import com.ztel.app.service.PubService;
import com.ztel.app.service.cost.SPLTypeServcie;
import com.ztel.app.vo.cost.SPLTypeInfoVo;
import com.ztel.app.vo.cost.SPLTypeStockVo;
@Service
public class SPLTypeServiceImpl implements SPLTypeServcie {

	@Autowired
	private SPLTypeInfoVoMapper sPLTypeInfoVoMapper = null;
	@Autowired
	private SPLTypeStockVoMapper sPLTypeStockVoMapper = null;
	
	@Autowired 
	private PubService pubService = null;
	
	
	@Override
	public List<SPLTypeInfoVo> getSPLTypeList(String id) {
		// TODO Auto-generated method stub
		List<SPLTypeInfoVo> resultList = new ArrayList<SPLTypeInfoVo>();
		
		List<SPLTypeInfoVo> oneMenuList = this.sPLTypeInfoVoMapper.getSPLTypeInfoList(id);
		  //判断一级栏目是否有值
		  if (oneMenuList!=null&&oneMenuList.size()>0) {
			  for (int i = 0; i < oneMenuList.size(); i++) {
				  SPLTypeInfoVo oneMenuinfo =oneMenuList.get(i);
				  oneMenuinfo.setState("closed");
				  Integer oneparentId = oneMenuinfo.getId();
				  //根据一级id获取二级子栏目信息
				  List<SPLTypeInfoVo> TwoMenuList = this.sPLTypeInfoVoMapper.getSPLTypeInfoList(oneparentId+"");
				  if(TwoMenuList!=null&&TwoMenuList.size()>0){
					  for(int j=0;j<TwoMenuList.size();j++){
						  SPLTypeInfoVo TwoMenuInfoVo = TwoMenuList.get(j);
							  TwoMenuInfoVo.setState("closed");
					  }
				  }
				  else
				  {
					  oneMenuinfo.setState("open");
				  }
			}
			  resultList=oneMenuList;
		}
		
		return resultList;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void doAddSPLTypeInfo(SPLTypeInfoVo sPLTypeInfoVo){
		
		//菜单级次需要设置，传过来的参数是父菜单的级次，需要在父菜单的基础上加1
		if(sPLTypeInfoVo!=null && sPLTypeInfoVo.getClevel()!=null){
			Integer id = sPLTypeInfoVo.getClevel();
			sPLTypeInfoVo.setClevel(id+1);
		}
		else
		{
			Integer id = 1;
			sPLTypeInfoVo.setFid(0);
			sPLTypeInfoVo.setClevel(id);
		} 
		//取序列：
		Long typeid = pubService.getSequence("S_COST_SPLTYPEINFO");
		sPLTypeInfoVo.setId(typeid.intValue());
		//插入总库存
		SPLTypeStockVo sPLTypeStockVo = new SPLTypeStockVo();
		sPLTypeStockVo.setTypeid(typeid.intValue());
		sPLTypeStockVo.setUnit(sPLTypeInfoVo.getUnit());
		sPLTypeStockVo.setApplyqty(new BigDecimal("0"));
		sPLTypeStockVo.setPrice(new BigDecimal("0"));
		sPLTypeStockVo.setQuantity(new BigDecimal("0"));
		sPLTypeStockVo.setSurplusqty(new BigDecimal("0"));
		sPLTypeStockVo.setTotalamount(new BigDecimal("0"));
		
		int typeResult = this.sPLTypeInfoVoMapper.insertSelective(sPLTypeInfoVo);
		int stockResult = sPLTypeStockVoMapper.insertSelective(sPLTypeStockVo);
	}
	

	public int doEditSPLTypeInfo(SPLTypeInfoVo sPLTypeInfoVo){
		if(sPLTypeInfoVo!=null&&sPLTypeInfoVo.getIsproducename()!=null&&sPLTypeInfoVo.getIsproducename().equals("是"))
			{
			sPLTypeInfoVo.setIsproduce("10");
			}
		else{
			sPLTypeInfoVo.setIsproduce("0");
		}
		return this.sPLTypeInfoVoMapper.updateByPrimaryKeySelective(sPLTypeInfoVo);
	}
	
	public int doDelSPLTypeInfo(Integer typeid)
	{
		int result=0;
		//删除前需先判断商品是否还有库存，否则不允许删除
		SPLTypeStockVo sPLTypeStockVo = sPLTypeStockVoMapper.selectSPLTYPESTOCKByTypeId(typeid);
		
	if(sPLTypeStockVo!=null){
		BigDecimal surplusQty = sPLTypeStockVo.getSurplusqty();//设备剩余数量
			
			BigDecimal bd0=BigDecimal.valueOf(0);
			if(surplusQty.compareTo(bd0)==0){//剩余数量为0
				result  = deDel(typeid);
			}
			else{
				result= 0;
			}
			
		}
		else//没有进库存，可删除
		{
			result  = deDel(typeid);
		}
	return result;
	}
	
	private int deDel(Integer typeid)
	{
		SPLTypeInfoVo sPLTypeInfoVo1 = new SPLTypeInfoVo();
		sPLTypeInfoVo1.setId(typeid);
		sPLTypeInfoVo1.setDelstatus("0");
		return this.sPLTypeInfoVoMapper.updateByPrimaryKeySelective(sPLTypeInfoVo1);
	}

	@Override
	public List<SPLTypeInfoVo> getSPLTypeInfoListByCondition(SPLTypeInfoVo splTypeInfoVo) {
		// TODO Auto-generated method stub
		return this.sPLTypeInfoVoMapper.getSPLTypeInfoListByCondition(splTypeInfoVo);
	}

	@Override
	public List<HashMap<String, String>> getSPLTypeInfoCombobox(SPLTypeInfoVo splTypeInfoVo) {
		 // TODO Auto-generated method stub
		 List<SPLTypeInfoVo> treeList=getSPLTypeInfoListByCondition(splTypeInfoVo);
	   	 List<HashMap<String, String>> boxList=new ArrayList<>();
	   	 if (treeList!=null&&treeList.size()>0) {
	   		 for(int i=0;i<treeList.size();i++){
	   			SPLTypeInfoVo vo=treeList.get(i);
	   			 HashMap<String, String> map=new HashMap<String, String>();
	   			 map.put("id", vo.getId()+"");
	   			 map.put("typename", vo.getTypename());
	   			 map.put("unit", vo.getUnit());
	   			 boxList.add(map);
	   		 }
	   	 }
	   	 return boxList;
	}

	
	/**
	 * 领料申请时获取类别，库存为0的类别不再显示
	 */
	@Override
	public List<HashMap<String, String>> getSPLTypeInfoComboboxnForApply(SPLTypeInfoVo splTypeInfoVo) {
		List<SPLTypeInfoVo> treeList=getSPLTypeInfoListByCondition(splTypeInfoVo);
		List<HashMap<String, String>> boxList=new ArrayList<>();
		if (treeList!=null&&treeList.size()>0) {
	   		 for(int i=0;i<treeList.size();i++){
	   			SPLTypeInfoVo vo=treeList.get(i);
	   			Integer typeid = vo.getId();
	   			//根据id获取库存信息
	   			SPLTypeStockVo sPLTypeStockVo = sPLTypeStockVoMapper.selectSPLTYPESTOCKByTypeId(typeid);
	   			if(sPLTypeStockVo!=null){
	   				BigDecimal surplusQty = sPLTypeStockVo.getSurplusqty();//设备剩余数量
	   				BigDecimal applyQty = sPLTypeStockVo.getApplyqty();//申请数量
	   				BigDecimal canUseQty = surplusQty.subtract(applyQty);//可用数量=剩余数量-申请数量
	   				BigDecimal bd0=BigDecimal.valueOf(0);
	   				if(canUseQty.compareTo(bd0)==1){//可用数量>0(compareTo返回-1表示小于,0是等于,1是大于)
	   					HashMap<String, String> map=new HashMap<String, String>();
	   	   			 map.put("id", vo.getId()+"");
	   	   			 map.put("typename", vo.getTypename());
	   	   			 map.put("unit", vo.getUnit());
	   	   			 map.put("canUseQty", canUseQty+"");
	   	   			 boxList.add(map);
	   				}
	   			}
	   		 }
		}
		return boxList;
	}
		
}
