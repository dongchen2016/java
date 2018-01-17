package com.dongchen.java.dao.mapper.extend;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author: mdd
 * @date:2017/11/22
 */
public interface TpDealTimeMapper {

    /**
     * 查询已处理时间
     * @param
     * @return
     */
    Date queryDealTime();

    /**
     * 更新已处理时间
     * @param
     * @return
     */
    int addDealTime();

    /**
     * 更新已处理时间
     * @param
     * @return
     */
    int updateDealTime(@Param("dealTime") Date dealTime);
}
