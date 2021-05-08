package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author itjunjun  2021/1/18 22:11
 */
/*@FixMethodOrder(MethodSorters.JVM)按照JVM运行方法的顺序运行方法
@FixMethodOrder(MethodSorters.NAME_ASCENDING)按照方法名字顺序执行
@FixMethodOrder(MethodSorters.DEFAULT)不可预期顺序执行*/
public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    @Ignore
    public void testQueryByShopId() {
        long shopId = 1L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println(productCategoryList.size());
    }

    @Test
    @Ignore
    public void testBatchInsertProductCategory() {
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryName("one");
        productCategory1.setPriority(10);
        productCategory1.setCreateTime(new Date());
        productCategory1.setShopId(44L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("two");
        productCategory2.setPriority(20);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(44L);
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory2);
        productCategoryList.add(productCategory1);
        int effectNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        assertEquals(2, effectNum);
    }

    @Test
    @Ignore
    public void testDeleteProductCategory() {
        productCategoryDao.deleteProductCategory(7, 44);
    }

}
