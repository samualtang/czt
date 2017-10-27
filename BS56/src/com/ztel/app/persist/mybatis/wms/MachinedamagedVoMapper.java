package com.ztel.app.persist.mybatis.wms;

import com.ztel.app.vo.wms.MachinedamagedVo;
import com.ztel.framework.vo.Pagination;

import java.math.BigDecimal;
import java.util.List;

public interface MachinedamagedVoMapper {
	
	List<MachinedamagedVo> selectCigarettedamagedPageList(Pagination<?> page);
	
    /**
     *
     * @mbggenerated 2017-08-08
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     *
     * @mbggenerated 2017-08-08
     */
    int insert(MachinedamagedVo record);

    /**
     *
     * @mbggenerated 2017-08-08
     */
    int insertSelective(MachinedamagedVo record);

    /**
     *
     * @mbggenerated 2017-08-08
     */
    MachinedamagedVo selectByPrimaryKey(BigDecimal id);

    /**
     *
     * @mbggenerated 2017-08-08
     */
    int updateByPrimaryKeySelective(MachinedamagedVo record);

    /**
     *
     * @mbggenerated 2017-08-08
     */
    int updateByPrimaryKey(MachinedamagedVo record);
}