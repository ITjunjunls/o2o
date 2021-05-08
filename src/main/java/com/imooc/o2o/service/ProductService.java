package com.imooc.o2o.service;

import com.imooc.o2o.dto.ImageHolder;
import com.imooc.o2o.dto.ProductExecution;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.exception.ProductOperationException;

import java.io.InputStream;
import java.util.List;

/**
 * @author itjunjun  2021/1/28 19:39
 */
public interface ProductService {


    /**
     * 添加商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException;

    /**
     * 根据商品ID获取商品信息
     * @param productId
     * @return
     */
    Product getProductById(long productId);

    /**
     * 修改商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgHolderList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product,ImageHolder thumbnail, List<ImageHolder> productImgHolderList)throws ProductOperationException;

    /**
     * 查詢商品列表并分页
     * @param productCondition 查询条件
     * @param pageIndex 从第几个起
     * @param pagesize 每页几个
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex,int pagesize);
}
