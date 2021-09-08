package com.chopin.springvalidationexceptionhandler.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 22:08
 */
@Data
public class UserParam {
    @NotEmpty(message = "Name is required")
    private String name;
    @Min(value = 0, message = "Sot value must > 0")
    private Integer sort;
    @NotEmpty(message = "Logo is required")
    private String logo;
    @NotEmpty(message = "Status is required")
    private String status;
}