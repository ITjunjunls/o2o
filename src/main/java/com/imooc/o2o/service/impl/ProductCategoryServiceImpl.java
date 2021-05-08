package com.imooc.o2o.service.impl;

import com.imooc.o2o.dao.ProductCategoryDao;
import com.imooc.o2o.dao.ProductDao;
import com.imooc.o2o.dto.ProductCategoryExecution;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.enums.ProductCategoryStateEnum;
import com.imooc.o2o.exception.ProductCategoryOperationException;
import com.imooc.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author itjunjun  2021/1/18 22:25
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }

    @Override
    public ProductCategoryExecution batchInsertProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException {
        if(productCategoryList!=null && productCategoryList.size()>0){
            try{
                int effectEnum=productCategoryDao.batchInsertProductCategory(productCategoryList);
                if(effectEnum<=0){
                    throw new ProductCategoryOperationException("店铺创建失败");
                }else {
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }
            }catch (Exception e){
                throw new ProductCategoryOperationException("batchInsertProductCategory error :"+e.getMessage());
            }
        }else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    @Override
    @Transactional
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException {
        //将商品类别下的商品ID设置为空
        try{
            int effectNum = productDao.updateProductCategoryToNull(productCategoryId);
            if(effectNum<0){
                throw new ProductCategoryOperationException("商品的类别更新为null失败");
            }
        }catch (Exception e){
            throw new ProductCategoryOperationException("deleteProductCategory error"+e.getMessage());
        }
        //删除商品类别
        try{
            int effectNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
            if(effectNum<=0){
                throw new ProductCategoryOperationException("店铺类别删除失败");
            }else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        }catch (Exception e){
            throw new ProductCategoryOperationException("商品类别删除失败"+e.getMessage());
        }
    }
}
