package com.imooc.o2o.service;

import com.imooc.o2o.dto.ProductCategoryExecution;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.exception.ProductCategoryOperationException;

import java.util.List;

/**
 * @author itjunjun  2021/1/18 22:23
 */
public interface ProductCategoryService {

    /**
     * 查询某店铺下的商品类别
     *
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);


    ProductCategoryExecution batchInsertProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    /**
     * 将此类别下的商品id置为空，并删除该商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}
