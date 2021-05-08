package com.imooc.o2o.exception;

/**
 * @author itjunjun  2021/1/20 21:18
 */
public class ProductCategoryOperationException extends RuntimeException{


    private static final long serialVersionUID = 7648773768674561721L;

    public ProductCategoryOperationException(String msg){
        super(msg);
    }
}
