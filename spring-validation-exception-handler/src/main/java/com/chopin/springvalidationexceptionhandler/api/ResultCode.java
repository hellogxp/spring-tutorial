package com.chopin.springvalidationexceptionhandler.api;

import lombok.AllArgsConstructor;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 16:42
 */
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200, "Operate successfully"),
    VALIDATE_FAILED(404, "Paramter validate failed"),
    FAILED(500, "Operate failed");
    private long code;
    private String message;

    public long getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}