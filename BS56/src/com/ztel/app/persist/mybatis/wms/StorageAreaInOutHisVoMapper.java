package com.ztel.app.persist.mybatis.wms;

import com.ztel.app.vo.wms.StorageAreaInOutHisVo;
import java.math.BigDecimal;

public interface StorageAreaInOutHisVoMapper {
    /**
     *
     * @mbggenerated 2017-08-01
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     *
     * @mbggenerated 2017-08-01
     */
    int insert(StorageAreaInOutHisVo record);

    /**
     *
     * @mbggenerated 2017-08-01
     */
    int insertSelective(StorageAreaInOutHisVo record);

    /**
     *
     * @mbggenerated 2017-08-01
     */
    StorageAreaInOutHisVo selectByPrimaryKey(BigDecimal id);

    /**
     *
     * @mbggenerated 2017-08-01
     */
    int updateByPrimaryKeySelective(StorageAreaInOutHisVo record);

    /**
     *
     * @mbggenerated 2017-08-01
     */
    int updateByPrimaryKey(StorageAreaInOutHisVo record);
}