package com.ztel.app.service.wms.Impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztel.app.persist.mybatis.wms.InBoundVoMapper;
import com.ztel.app.service.wms.InBoundLineService;
import com.ztel.app.service.wms.InBoundService;
import com.ztel.app.service.wms.StorageAreaInOutService;
import com.ztel.app.util.Constant;
import com.ztel.app.vo.wms.InBoundLineVo;
import com.ztel.app.vo.wms.InBoundVo;
import com.ztel.app.vo.wms.StorageAreaInOutVo;
import com.ztel.framework.vo.Pagination;
@Service
public class InBoundServiceImpl implements InBoundService {

	@Autowired
	private InBoundVoMapper inBoundVoMapper = null;
	
	@Autowired
	private InBoundLineService inBoundLineService = null;
	
	@Autowired
	private StorageAreaInOutService storageAreaInOutService = null;
	
	 @Autowired 
	 DataSource ds = null;
	 JdbcTemplate template;
	 
	 private Map<String, String> sortKeyMapping = new HashMap<>();
		
		public InBoundServiceImpl() {
			//TODO 请在这里填入排序的key转换为列名, 防止SQL注入;每个Service业务域用自己的mapping,在BaseCtrl容易重复
//			sortKeyMapping.put(key, value)
			sortKeyMapping.put("createtime", "createtime");
			sortKeyMapping.put("consignsor", "consignsor");
		}
		
	@Override
	public void InsertInBound(InBoundVo vo) {
		initJdbcTemplate();
		// TODO Auto-generated method stub
		BigDecimal id =  template.execute("select S_WMS_INOUTBOUND.nextval from dual",new PreparedStatementCallback() {  
			   public BigDecimal doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {  
				       pstmt.execute();  
			        ResultSet rs = pstmt.getResultSet();  
			        rs.next();  
			        return rs.getBigDecimal(1);  
				    }  
				});  
		vo.setInboundid(id);
		inBoundVoMapper.insertSelective(vo);
	}
	public void initJdbcTemplate()
	{
		template=new JdbcTemplate(ds);
	}
	
	public List<InBoundVo> selectInBoundPageList(Pagination<?> page) {
			page.sortKeyToColumn(sortKeyMapping);
			return this.inBoundVoMapper.selectInBoundPageList(page);
	}

	public List<InBoundVo> selectInBoundList(InBoundVo inBoundVo){
		return this.inBoundVoMapper.selectInBoundList(inBoundVo);
	}

//	@Override
//	public int getIdFromSequence() {
//		// TODO Auto-generated method stub
//		return inBoundVoMapper.getIdFromSequence();
//	}

	@Override
	public void doInsertInBound(InBoundVo vo) {
		// TODO Auto-generated method stub
		inBoundVoMapper.insertSelective(vo);
	}

	@Override
	public void doUpdateInBound(InBoundVo vo) {
		// TODO Auto-generated method stub
		inBoundVoMapper.updateByPrimaryKeySelective(vo);
	}
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void doConfiscationImp(List<Integer> inBoundIdList) {
		//更新入库单状态
		int inBoundlen=inBoundIdList.size();
		for(int i=0;i<inBoundlen;i++){
			//更新入库单状态
			InBoundVo inBoundVo=new InBoundVo();
			int inBoundId=inBoundIdList.get(i);
			inBoundVo.setInboundid(new BigDecimal(inBoundId));
			inBoundVo.setStatus("30");
			doUpdateInBound(inBoundVo);
			
			//更新入库单明细信息------------------------------------------------------
			//取入库单明细
			InBoundLineVo inBoundLineVo=new InBoundLineVo();
			inBoundLineVo.setInboundid(new BigDecimal(inBoundId));
			List<InBoundLineVo> lineList=inBoundLineService.selectListByCond(inBoundLineVo);
			//遍历入库单明细
			int lineLen=lineList.size();
			for(int j=0;j<lineLen;j++){
				//更新入库单明细的状态和数量
				InBoundLineVo lineVo=new InBoundLineVo();
				lineVo=lineList.get(j);
				lineVo.setStatus("30");
				lineVo.setOtherqty(lineVo.getBoxqty());
				inBoundLineService.updateInBoundLine(lineVo);
				
				//插入一条入散烟区的调拨数据
				StorageAreaInOutVo storageAreaInOutVo=new StorageAreaInOutVo();
				storageAreaInOutVo.setAreaid(new BigDecimal(Constant.storagearea_sy));
				storageAreaInOutVo.setQty(lineVo.getBoxqty());
				storageAreaInOutVo.setInouttype(new BigDecimal(20));
				storageAreaInOutVo.setCigarettecode(lineVo.getCigarettecode());
				storageAreaInOutVo.setCigarettename(lineVo.getCigarettename());
				storageAreaInOutVo.setStatus(new BigDecimal(20));
				storageAreaInOutVo.setCigarattetype(new BigDecimal(40));
				storageAreaInOutVo.setBarcode(lineVo.getBarcode());
				storageAreaInOutService.doInsert(storageAreaInOutVo);
			}
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void doAddInboundAndLine(InBoundVo inBoundVo, InBoundLineVo inBoundLineVo, String addType) {
		// TODO Auto-generated method stub
		String status=inBoundVo.getStatus();
		//第一次保存,需要保存入库单
		if("1".equals(addType)){
			//inBoundVo.setQty(inBoundLineVo.getBoxqty());
			this.doInsertInBound(inBoundVo);
		}else{
			this.doUpdateInBound(inBoundVo);
		}
		
		//当状态是完成的时候插入调拨表
		if("30".equals(status)){
			//设置入散烟区数量
			inBoundLineVo.setOtherqty(inBoundLineVo.getBoxqty());
			//插入调拨表
			StorageAreaInOutVo storageAreaInOutVo=new StorageAreaInOutVo();
			storageAreaInOutVo.setAreaid(new BigDecimal(Constant.storagearea_sy));
			storageAreaInOutVo.setQty(inBoundLineVo.getBoxqty());
			storageAreaInOutVo.setInouttype(new BigDecimal(20));
			storageAreaInOutVo.setCigarettecode(inBoundLineVo.getCigarettecode());
			storageAreaInOutVo.setCigarettename(inBoundLineVo.getCigarettename());
			storageAreaInOutVo.setStatus(new BigDecimal(20));
			storageAreaInOutVo.setBarcode(inBoundLineVo.getBarcode());
			storageAreaInOutVo.setCigarattetype(new BigDecimal(40));
			storageAreaInOutService.doInsert(storageAreaInOutVo);
		}
		
		inBoundLineService.InsertInBoundLine(inBoundLineVo);
	}
}
