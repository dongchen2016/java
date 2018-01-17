package com.dongchen.java.util.exception;

/**
 * Created by zrj on 2016/7/7.
 * 服务异常
 */
public class ServiceException extends BaseException {


    public ServiceException(String returnCode, String returnMsg){
        super(returnMsg);
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    @Override
    public String getReturnCode() {
        return returnCode;
    }

    @Override
    public String getErrMessage() {
        return returnMsg;
    }
}
