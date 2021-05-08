package com.imooc.o2o.exception;

//序列化ID是干什么的？？？学习一下
public class ShopOperationException extends RuntimeException {

    private static final long serialVersionUID = 3882011364906825791L;

    public ShopOperationException(String msg) {
        super(msg);
    }

}
