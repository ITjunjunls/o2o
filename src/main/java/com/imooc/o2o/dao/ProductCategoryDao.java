package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author itjunjun  2021/1/18 22:00
 */
public interface ProductCategoryDao {

    /**
     * 返回一个店铺所拥有的商品类别
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);

    /**
     * 批量添加商品类别，返回的为修改的行数
     *
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 删除指定商品类别
     * @param productCategory
     * @param shopId 两个参数，要用@Param
     * @return
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategory, @Param("shopId") long shopId);
}
