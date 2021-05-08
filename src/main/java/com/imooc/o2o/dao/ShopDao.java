package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {

    /**
     * 分页查询店铺，可输入的条件有：店铺名（模糊） 店铺状态 店铺类别 区域ID owner
     *
     * @param shopCondition 条件
     * @param rowIndex      第几行开始取，如果这个为1 pagesize为5，就是从第一行开始取，取五行
     * @param pageSize      取几行数据
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /**
     * 返回queryshoplist总数
     *
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);

    /**
     * 新增店铺
     *
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     *
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 通过shopId查询店铺
     *
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

}
