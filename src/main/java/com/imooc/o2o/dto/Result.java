package com.imooc.o2o.dto;

/**
 * @author itjunjun  2021/1/19 21:46
 * 封装json对象，多有的返回结果都用它
 */
public class Result<T> {
    private boolean success;//标志是否成功

    private T data;//成功时候返回的数据

    private String errorMsg;//错误信息

    private int errCode;//错误代码

    public Result() {

    }

    //成功时候的构造器
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    //错误时候的构造器
    public Result(boolean success,int errCode,String errorMsg){
        this.success = success;
        this.errCode=errCode;
        this.errorMsg=errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
