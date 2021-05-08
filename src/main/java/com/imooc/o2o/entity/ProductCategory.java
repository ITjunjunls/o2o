package com.imooc.o2o.entity;

import java.util.Date;

public class ProductCategory {

    private Long productCategoryId;
    private Long shopId;
    private String productCategoryName;
    private Integer priority;
    private Date createTime;

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	
	/*create table tb_product_category(
		product_category_id int(11) not null auto_increment,
		product_category_name varchar(100) not null,
		priority int(2) default '0',
		create_time datetime default null,
		shop_id int(20) not null default '0',
		primary key(product_category_id),
		constraint fk_procate_shop foreign key(shop_id) references tb_shop(shop_id)
		)engine=INNODB Auto_Increment=1 DEFAULT charset=utf8 
*/

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", shopId=" + shopId +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", priority=" + priority +
                ", creatTime=" + createTime +
                '}';
    }
}
