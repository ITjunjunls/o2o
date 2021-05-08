package com.imooc.o2o.dao;

import com.imooc.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author itjunjun  2021/2/7 20:31
 */
public interface HeadLineDao {

    /**
     * 根据条件查询头条
     * @param headLineCondition
     * @return
     */
    List<HeadLine> queryHeadLine(@Param("headLineCondition")HeadLine headLineCondition);
}
