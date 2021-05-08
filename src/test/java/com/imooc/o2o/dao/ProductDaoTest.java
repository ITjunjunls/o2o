package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Product;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.entity.ProductImg;
import com.imooc.o2o.entity.Shop;
import javafx.scene.effect.Effect;
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
 * @author itjunjun  2021/1/26 21:20
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductImgDao productImgDao;

    @Test
    @Ignore
    public void testAInsertProduct() throws Exception {
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(1L);

        Product product = new Product();
        product.setPriority(100);
        product.setEnableStatus(1);
        product.setLastEditTime(new Date());
        product.setCreateTime(new Date());
        product.setProductName("asd");
        product.setShop(shop);
        product.setProductCategory(productCategory);


        int effectNum = productDao.insertProduct(product);
        assertEquals(1, effectNum);
    }

    @Test
    @Ignore
    public void testCQueryProductByProductId() throws Exception {
        long productId = 1L;
        ProductImg productImg = new ProductImg();
        productImg.setImgAddr("adfas");
        productImg.setCreateTime(new Date());
        productImg.setImgDesc("adas");
        productImg.setPriority(10);
        productImg.setProductId(1L);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("adfas");
        productImg2.setCreateTime(new Date());
        productImg2.setImgDesc("adas");
        productImg2.setPriority(10);
        productImg2.setProductId(1L);
        List<ProductImg> list = new ArrayList<ProductImg>();
        list.add(productImg2);
        list.add(productImg);
        int effectNum = productImgDao.batchInsertProductImg(list);
        assertEquals(2, effectNum);
        Product product = productDao.queryProductById(productId);
        assertEquals(2, product.getProductImgList().size());
        effectNum = productImgDao.deleteProductImgByProductId(productId);
        assertEquals(2, effectNum);
    }

    @Test
    @Ignore
    public void testDUpdateProduct() throws Exception {
        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(1L);
        Product product = new Product();
        product.setProductId(1L);
        product.setEnableStatus(0);
        product.setLastEditTime(new Date());
        product.setPriority(15);
        product.setPromotionPrice("29");
        product.setProductCategory(pc);
        product.setShop(shop);
        int effectNum = productDao.updateProduct(product);
        assertEquals(1, effectNum);
    }

    @Test
    @Ignore
    public void testQueryProductList() throws Exception {
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(29L);
        product.setShop(shop);
        List<Product> productList=productDao.queryProductList(product, 0, 5);
        assertEquals(5,productList.size());
    }

    @Test
    public void testUpdateCategoryToNull() throws Exception {
        int effectNum = productDao.updateProductCategoryToNull(6L);
        assertEquals(2,effectNum);
    }
}
