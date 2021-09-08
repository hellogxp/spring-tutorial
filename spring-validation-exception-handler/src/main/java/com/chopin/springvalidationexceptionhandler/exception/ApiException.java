package com.chopin.springvalidationexceptionhandler.exception;

import com.chopin.springvalidationexceptionhandler.api.ResultCode;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 16:37
 */
public class ApiException extends RuntimeException{
    private ResultCode resultCode;

    public ApiException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}