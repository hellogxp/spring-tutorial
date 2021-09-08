package com.chopin.springvalidationexceptionhandler.controller;

import com.chopin.springvalidationexceptionhandler.api.CommonResult;
import com.chopin.springvalidationexceptionhandler.dto.UserParam;
import com.chopin.springvalidationexceptionhandler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 17:05
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@PathVariable String userId) {
        userService.add(userId);
        return CommonResult.success(null, "Add user successfully");
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@Validated @RequestBody UserParam userParam) {
        String id = userService.update(userParam);
        return CommonResult.success(id, "Update user successfully"); }

}