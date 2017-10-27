package com.ztel.app.service.cost.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztel.app.persist.mybatis.cost.SPLApplyListLineVoMapper;
import com.ztel.app.persist.mybatis.cost.SPLApplyListVoMapper;
import com.ztel.app.persist.mybatis.cost.SPLConsumeVoMapper;
import com.ztel.app.persist.mybatis.cost.SPLTypeStockVoMapper;
import com.ztel.app.persist.mybatis.cost.SuppliesImpVoMapper;
import com.ztel.app.service.cost.SPLApplyListService;
import com.ztel.app.vo.cost.SPLApplyListLineVo;
import com.ztel.app.vo.cost.SPLApplyListVo;
import com.ztel.app.vo.cost.SPLConsumeVo;
import com.ztel.app.vo.cost.SPLTypeStockVo;
import com.ztel.app.vo.cost.SuppliesImpVo;
import com.ztel.framework.vo.Pagination;

@Service
public class SPLApplyListServiceImpl implements SPLApplyListService {

	private static final String SuppliesImpVo  = null;
	@Autowired
	private SPLApplyListVoMapper SPLApplyListVoMapper = null;
	@Autowired
	SuppliesImpVoMapper suppliesImpVoMapper = null;//物资入库mapper
	@Autowired
	SPLApplyListLineVoMapper sPLApplyListLineVoMapper = null;//领料申请明细
	@Autowired
	SPLTypeStockVoMapper sPLTypeStockVoMapper = null;
	@Autowired
	SPLConsumeVoMapper sPLConsumeVoMapper = null;
	
	private Map<String, String> sortKeyMapping = new HashMap<>();
	
	public SPLApplyListServiceImpl(){
		sortKeyMapping.put("applydate", "applydate");
		sortKeyMapping.put("id", "id");
		sortKeyMapping.put("deptname", "deptname");
	}
	
	public List<SPLApplyListVo> getApplyListList(Pagination<?> page)
	{
		page.sortKeyToColumn(sortKeyMapping);
		return SPLApplyListVoMapper.selectApplyListPageList(page);
		
	}

	public SPLApplyListVo getSPLApplyListVoByPrimaryKey(String listid)
	{
		return SPLApplyListVoMapper.selectByPrimaryKey(new BigDecimal(listid));
	}
	/**
	 * 领料新增
	 */
	@Transactional(rollbackFor=Exception.class)
	public void doAddApplyList(SPLApplyListVo sPLApplyListVo,SPLApplyListLineVo sPLApplyListLineVo,String reqType)
	{
		if(reqType.equals("first")){
		//插入申请领料主表
		SPLApplyListVoMapper.insertSelective(sPLApplyListVo);
		}
		BigDecimal listid = sPLApplyListVo.getId();//物资申请id
		BigDecimal typeid = sPLApplyListLineVo.getTypeid();//物资类别id
		BigDecimal preapplyqty = sPLApplyListLineVo.getPreapplyqty();//申请前剩余库存量
		
		BigDecimal applyQty = sPLApplyListLineVo.getApplyqty();//申请数量
		BigDecimal   applyQtyTmp   =   new   BigDecimal("1");
		BigDecimal   preapplyqtyTmp   =   new   BigDecimal("1"); 
		applyQtyTmp = applyQty;
		preapplyqtyTmp = preapplyqty;
		//根据类型id获取物资列表，先进先出
		List<SuppliesImpVo> suppliesImpVoList = suppliesImpVoMapper.getSuppliesImpListByTypeid(typeid+"");
		if(suppliesImpVoList!=null&&suppliesImpVoList.size()>0){
			for(int i=0;i<suppliesImpVoList.size();i++)
			{
				SuppliesImpVo SuppliesImpVo = suppliesImpVoList.get(i);
				Integer splid = SuppliesImpVo.getId();
				BigDecimal quantity = SuppliesImpVo.getQuantity();//入库物资剩余数量
				BigDecimal lockqty = SuppliesImpVo.getLockqty();//锁定数量
				BigDecimal canuseqty = quantity.subtract(lockqty);//可用数量
				BigDecimal price = SuppliesImpVo.getPrice();//设备单价
				if(applyQtyTmp.compareTo(canuseqty)==1){//申请数量>可用数量(compareTo返回-1表示小于,0是等于,1是大于)
					//插入明细及更新库存的申请数量字段
					doInsertLineAndUpdateStock(listid,splid,typeid,preapplyqtyTmp,canuseqty,price);
					preapplyqtyTmp = preapplyqtyTmp.subtract(quantity);
					applyQtyTmp = applyQtyTmp.subtract(quantity);
				}
				else//申请数量<剩余数量，则直接入明细，跳出循环
				{
					//插入明细及更新库存的申请数量字段
					doInsertLineAndUpdateStock(listid,splid,typeid,preapplyqtyTmp,applyQtyTmp,price);
					break;
				}
			}
			
		}
	}
	
	/**
	 * 插入明细及更新库存的申请数量字段
	 * @param listid 申请单id
	 * @param splid  物资id
	 * @param typeid  物资类型id
	 * @param preapplyqty 申请前库存量
	 * @param applyQty 申请数量
	 * @param price 申请设备单价
	 */
	private void doInsertLineAndUpdateStock(BigDecimal listid,Integer splid,BigDecimal typeid,BigDecimal preapplyqty,BigDecimal applyQty,BigDecimal price){
		SPLApplyListLineVo sPLAPPLYLISTLINE = new SPLApplyListLineVo();
		sPLAPPLYLISTLINE.setListid(listid);
		sPLAPPLYLISTLINE.setTypeid(typeid);
		sPLAPPLYLISTLINE.setSplid(splid);
		sPLAPPLYLISTLINE.setPreapplyqty(preapplyqty);
		sPLAPPLYLISTLINE.setApplyqty(applyQty);
		sPLAPPLYLISTLINE.setPrice(price);
		BigDecimal amount =  applyQty.multiply(price);//总金额
		sPLAPPLYLISTLINE.setAmount(amount);
		sPLApplyListLineVoMapper.insertSelective(sPLAPPLYLISTLINE);
		
		//更新物资表中的锁定数量：
		SuppliesImpVo SuppliesImpVo = new SuppliesImpVo();
		SuppliesImpVo.setId(splid);
		SuppliesImpVo.setLockqty(applyQty);
		suppliesImpVoMapper.updateByPrimaryKeySelective(SuppliesImpVo);
		
		//更新库存
		SPLTypeStockVo  SPLTypeStockVo = new SPLTypeStockVo();
		SPLTypeStockVo.setTypeid(typeid.intValue());
		SPLTypeStockVo.setApplyqty(applyQty);
		sPLTypeStockVoMapper.updateSPLTYPESTOCKByTypeId(SPLTypeStockVo);
	}
	
	/**
	 * 审核、驳回、发料
	 */
	@Transactional(rollbackFor=Exception.class)
	public void doUpdateApplyList(SPLApplyListVo sPLApplyListVo){
		String auditflag = sPLApplyListVo.getAuditflag();
		BigDecimal listid = sPLApplyListVo.getId();
		if(auditflag.equals("40") ){//驳回，需要释放申请数量和锁定数量  
			doBack(sPLApplyListVo);
		}else if(auditflag.equals("50")){ //发料的同时需要插入物资耗用表
			doConsume(sPLApplyListVo);
		}
		this.SPLApplyListVoMapper.updateByPrimaryKeySelective(sPLApplyListVo);//更新申请单主表的折状态标志及审核人
	}
	
	/**
	 * 申请单驳回或删除，需要释放申请数量和锁定数量
	 * @param sPLApplyListVo
	 */
	private void doBack(SPLApplyListVo sPLApplyListVo){
		BigDecimal listid = sPLApplyListVo.getId();
		Integer deptid = sPLApplyListVo.getDeptid();
		Long applyuserid = sPLApplyListVo.getApplyid();
		String auditflag = sPLApplyListVo.getAuditflag();
		
		SPLApplyListLineVo sPLApplyListLineVo = new SPLApplyListLineVo();
		sPLApplyListLineVo.setListid(listid);
		List<SPLApplyListLineVo> sPLApplyListLineVoList = this.sPLApplyListLineVoMapper.selectApplyListLineList(sPLApplyListLineVo);
		if(sPLApplyListLineVoList!=null&&sPLApplyListLineVoList.size()>0){
			for(int i=0;i<sPLApplyListLineVoList.size();i++){
				SPLApplyListLineVo sPLApplyListLineVo2 = sPLApplyListLineVoList.get(i);
				BigDecimal typeid = sPLApplyListLineVo2.getTypeid();
				Integer splid = sPLApplyListLineVo2.getSplid();
				BigDecimal applyqty = sPLApplyListLineVo2.getApplyqty();//申请数量
				BigDecimal preapplyqty = sPLApplyListLineVo2.getPreapplyqty();//申请前库存量
				BigDecimal price = sPLApplyListLineVo2.getPrice();//单价
				//更新设备表
				SuppliesImpVo  suppliesImpVo = new SuppliesImpVo();
				suppliesImpVo.setId(splid);
				suppliesImpVo.setLockqty(applyqty.multiply(new BigDecimal(-1)));
				this.suppliesImpVoMapper.updateByPrimaryKeySelective(suppliesImpVo);
				
				//更新总库存表
				SPLTypeStockVo sPLTypeStockVo = new SPLTypeStockVo();
				sPLTypeStockVo.setTypeid(typeid.intValue());
				sPLTypeStockVo.setApplyqty(applyqty.multiply(new BigDecimal(-1)));
				this.sPLTypeStockVoMapper.updateSPLTYPESTOCKByTypeId(sPLTypeStockVo);
			}
		}
	}
	
	/**
	 * 物资发料
	 * @param sPLApplyListVo
	 */
	private void doConsume(SPLApplyListVo sPLApplyListVo){
		BigDecimal listid = sPLApplyListVo.getId();
		Integer deptid = sPLApplyListVo.getDeptid();
		Long applyuserid = sPLApplyListVo.getApplyid();
		String auditflag = sPLApplyListVo.getAuditflag();
		
		SPLApplyListLineVo sPLApplyListLineVo = new SPLApplyListLineVo();
		sPLApplyListLineVo.setListid(listid);
		List<SPLApplyListLineVo> sPLApplyListLineVoList = this.sPLApplyListLineVoMapper.selectApplyListLineList(sPLApplyListLineVo);
		if(sPLApplyListLineVoList!=null&&sPLApplyListLineVoList.size()>0){
			for(int i=0;i<sPLApplyListLineVoList.size();i++){
				SPLApplyListLineVo sPLApplyListLineVo2 = sPLApplyListLineVoList.get(i);
				BigDecimal typeid = sPLApplyListLineVo2.getTypeid();
				Integer splid = sPLApplyListLineVo2.getSplid();
				BigDecimal applyqty = sPLApplyListLineVo2.getApplyqty();//申请数量
				BigDecimal preapplyqty = sPLApplyListLineVo2.getPreapplyqty();//申请前库存量
				BigDecimal price = sPLApplyListLineVo2.getPrice();//单价
				//更新设备表：减去锁定数量，改变剩余数量
				SuppliesImpVo  suppliesImpVo = new SuppliesImpVo();
				suppliesImpVo.setId(splid);
				suppliesImpVo.setLockqty(applyqty.multiply(new BigDecimal(-1)));
				suppliesImpVo.setQuantity(applyqty.multiply(new BigDecimal(-1))); 
				this.suppliesImpVoMapper.updateByPrimaryKeySelective(suppliesImpVo);
				
				//更新总库存表：减去申请数量，改变剩余数量
				SPLTypeStockVo sPLTypeStockVo = new SPLTypeStockVo();
				sPLTypeStockVo.setTypeid(typeid.intValue());
				sPLTypeStockVo.setApplyqty(applyqty.multiply(new BigDecimal(-1)));
				sPLTypeStockVo.setSurplusqty(applyqty.multiply(new BigDecimal(-1)));
				this.sPLTypeStockVoMapper.updateSPLTYPESTOCKByTypeId(sPLTypeStockVo);
				
				//如果为发料 记录物资耗用表
					SPLConsumeVo sPLConsumeVo= new SPLConsumeVo();
					sPLConsumeVo.setSplid(splid);
					sPLConsumeVo.setTypeid(typeid);
					sPLConsumeVo.setQuantity(applyqty);
					sPLConsumeVo.setSurplusqty(preapplyqty);
					sPLConsumeVo.setDeptid(deptid);
					sPLConsumeVo.setApplyid(listid);
					sPLConsumeVo.setIssuedate(new Date());
					sPLConsumeVo.setApplyuserid(applyuserid);
					sPLConsumeVo.setPrice(price);
					sPLConsumeVoMapper.insertSelective(sPLConsumeVo);
			}
		}
	}
	
	
	public void doDelApplyList(SPLApplyListVo sPLApplyListVo){
		this.SPLApplyListVoMapper.updateByPrimaryKeySelective(sPLApplyListVo);//更新申请单主表的折状态标志
		String auditflag = sPLApplyListVo.getAuditflag();
		if(auditflag.equals("0")||auditflag.equals("30")){//未审核或审核通过的需要释放申请数量和锁定数量
			doBack(sPLApplyListVo);
		}
	}
	
	/**
	 * 修改发料的某物资申请数量
	 * 1、需要更改T_COST_SUPPLIESIMP--物资入库信息表的锁定数量LOCKQTY
	 * 2、需要更改T_COST_SPLTYPESTOCK--物资类别总库存信息表的申请数量APPLYQTY
	 * 3、修改T_COST_SPLAPPLYLISTLINE--设备申请信息明细表的申请数量APPLYQTY和申请总金额AMOUNT
	 * @param sPLApplyListLineVo
	 */
	@Transactional(rollbackFor=Exception.class)
	public void doEditSPLApplyListLineVo(SPLApplyListLineVo sPLApplyListLineVo){
		Integer splid = sPLApplyListLineVo.getSplid();
		BigDecimal typeid = sPLApplyListLineVo.getTypeid();
		BigDecimal applyqty = sPLApplyListLineVo.getApplyqty();//申请数量
		BigDecimal editapplyqty =  sPLApplyListLineVo.getEditapplyqty();//修改数量
		BigDecimal price = sPLApplyListLineVo.getPrice();//物资单价
		BigDecimal quantity = sPLApplyListLineVo.getQuantity();//设备剩余数量
		
		//更改T_COST_SUPPLIESIMP--物资入库信息表的锁定数量LOCKQTY
		SuppliesImpVo  suppliesImpVo = new SuppliesImpVo();
		suppliesImpVo.setId(splid);
		suppliesImpVo.setLockqty(editapplyqty.subtract(applyqty));
		suppliesImpVoMapper.updateByPrimaryKeySelective(suppliesImpVo);
		//applyQtyTmp.subtract(quantity)
		
		//更改T_COST_SPLTYPESTOCK--物资类别总库存信息表的申请数量APPLYQTY
		SPLTypeStockVo sPLTypeStockVo = new SPLTypeStockVo();
		sPLTypeStockVo.setTypeid(typeid.intValue());
		sPLTypeStockVo.setApplyqty(editapplyqty.subtract(applyqty));
		sPLTypeStockVoMapper.updateSPLTYPESTOCKByTypeId(sPLTypeStockVo);
		
		//修改T_COST_SPLAPPLYLISTLINE--设备申请信息明细表的申请数量APPLYQTY和申请总金额AMOUNT
		SPLApplyListLineVo sPLApplyListLineVo2 = new SPLApplyListLineVo();
		sPLApplyListLineVo2.setId(sPLApplyListLineVo.getId());
		sPLApplyListLineVo2.setApplyqty(editapplyqty);
		sPLApplyListLineVo2.setAmount(editapplyqty.multiply(price));
		sPLApplyListLineVo2.setPreapplyqty(quantity);//设备剩余数量
		sPLApplyListLineVoMapper.updateSPLApplyListLineVoByIdSelective(sPLApplyListLineVo2);
	}
	
	/**
	 * 发料时，由仓管员选择发料物资，新增一条物资申请单明细、该类型的库存申请数量做修改、物资锁定数量修改
	 * @param sPLApplyListLineVo
	 */
	@Transactional(rollbackFor=Exception.class)
	public void doAddSPLApplyListLineVo(SPLApplyListLineVo sPLApplyListLineVo){
		//1、插入明细
		sPLApplyListLineVoMapper.insertSelective(sPLApplyListLineVo);
		
		//2、更新物资表中的锁定数量：
				SuppliesImpVo SuppliesImpVo = new SuppliesImpVo();
				SuppliesImpVo.setId(sPLApplyListLineVo.getSplid());
				SuppliesImpVo.setLockqty(sPLApplyListLineVo.getApplyqty());
				suppliesImpVoMapper.updateByPrimaryKeySelective(SuppliesImpVo);
				
				//3、更新库存
				SPLTypeStockVo  SPLTypeStockVo = new SPLTypeStockVo();
				SPLTypeStockVo.setTypeid(sPLApplyListLineVo.getTypeid().intValue());
				SPLTypeStockVo.setApplyqty(sPLApplyListLineVo.getApplyqty());
				sPLTypeStockVoMapper.updateSPLTYPESTOCKByTypeId(SPLTypeStockVo);
	}
}
