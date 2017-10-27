package com.ztel.app.persist.mybatis.wms;

import java.math.BigDecimal;
import java.util.List;

import com.ztel.app.vo.wms.CigarettedamagedVo;
import com.ztel.framework.vo.Pagination;

public interface CigarettedamagedVoMapper {
	
	List<CigarettedamagedVo> selectCigarettedamagedPageList(Pagination<?> page);
	
	List<CigarettedamagedVo> selectListByCond(CigarettedamagedVo cigarettedamagedVo);
    /**
     *
     * @mbggenerated 2017-08-02
     */
    int insert(CigarettedamagedVo record);

    /**
     *
     * @mbggenerated 2017-08-02
     */
    int insertSelective(CigarettedamagedVo record);
    
    int updateByInboundidSelective(CigarettedamagedVo record);
    
    int deleteByInboundid(BigDecimal inboundid);
    
}