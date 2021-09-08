package com.chopin.springvalidationaop.controller;

import com.chopin.springvalidationaop.api.CommonResult;
import com.chopin.springvalidationaop.dto.UserParam;
import com.chopin.springvalidationaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 12:52
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated UserParam userParam, BindingResult bindingResult) {
        CommonResult commonResult;
        int count = userService.createUser(userParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
}