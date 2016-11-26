package com.crm.base.exception;

import com.shsxt.constant.Constant;

@SuppressWarnings("serial")
public class ParamException extends RuntimeException {

    private int errorCode;

    public  ParamException() {
    }
    public ParamException(String message) {
        super(message);
        this.errorCode = Constant.RESULT_ERROR;
    }
    public ParamException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
