package com.chopin.springfilterinterceptor.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 15:57
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping(value = "/{id:\\d+}")
    public void users(@PathVariable String id) {
        System.out.println(id);
    }
}