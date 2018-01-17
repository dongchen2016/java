package com.dongchen.java.util.exception;

/**
 * Created by zrj on 2016/6/23.
 */
public abstract class BaseException extends RuntimeException {
    protected String returnCode;

    protected String returnMsg;

    public BaseException(String msg) {
        super(msg);
    }

    public abstract String getReturnCode();

    public abstract String getErrMessage();

}
