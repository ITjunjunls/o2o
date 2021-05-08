package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductImg;
import org.junit.Assert;
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
 * @author itjunjun  2021/1/26 21:41
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {

    @Autowired
    ProductImgDao productImgDao;

    @Test
    public void testABatchInsertProductImg() throws Exception {
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
        Assert.assertEquals(2, effectNum);
    }

    @Test
    public void testCDeleteProductImgByProductId() throws Exception {
        long productId = 1L;
        int effectNum = productImgDao.deleteProductImgByProductId(productId);
        Assert.assertEquals(2,effectNum);
    }

}
