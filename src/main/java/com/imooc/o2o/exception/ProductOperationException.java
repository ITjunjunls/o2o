package com.imooc.o2o.exception;

/**
 * @author itjunjun  2021/1/28 20:02
 */


public class ProductOperationException extends RuntimeException{
    private static final long serialVersionUID = 8770405275510724149L;

    public ProductOperationException(String msg){
        super(msg);
    }
}
