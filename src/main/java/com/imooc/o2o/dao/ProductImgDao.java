package com.imooc.o2o.dao;

import com.imooc.o2o.entity.ProductImg;

import java.util.List;

/**
 * @author itjunjun  2021/1/26 21:07
 */
public interface ProductImgDao {

    /**
     * 批量添加商品图片
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * 删除指定商品ID下的所有详情图
     * @param productId
     * @return
     */
    int deleteProductImgByProductId(long productId);

    /**
     * 列出某个商品的详情图列表
     * @param productId
     * @return
     */
    List<ProductImg> queryProductImgList(long productId);
}
