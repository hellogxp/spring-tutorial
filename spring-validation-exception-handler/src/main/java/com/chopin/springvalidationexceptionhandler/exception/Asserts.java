package com.chopin.springvalidationexceptionhandler.exception;

import com.chopin.springvalidationexceptionhandler.api.ResultCode;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 16:46
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(ResultCode resultCode) {
        throw new ApiException(resultCode);
    }
}