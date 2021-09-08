package com.chopin.springvalidationaop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 12:54
 */
@Data
public class UserParam {
    @NotEmpty(message = "Name is required")
    private String name;
    @Min(value = 0, message = "Minimum value of sort is zero")
    private Integer sort;
    @Min(value = 0, message = "Minimum value of status is zero")
    private Integer status;
    @NotEmpty(message = "Logo is required")
    private String logo;
}