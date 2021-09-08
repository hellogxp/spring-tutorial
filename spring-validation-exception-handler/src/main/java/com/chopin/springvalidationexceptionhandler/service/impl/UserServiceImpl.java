package com.chopin.springvalidationexceptionhandler.service.impl;

import com.chopin.springvalidationexceptionhandler.dto.UserParam;
import com.chopin.springvalidationexceptionhandler.exception.Asserts;
import com.chopin.springvalidationexceptionhandler.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 17:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void add(String userId) {
        if ("x".equals(userId)) {
            Asserts.fail("User do not exist");
        }
        // db.save();
    }

    @Override
    public String update(UserParam userParam) {
        if ("hello".equals(userParam.getName())) {
            Asserts.fail("User do not exist");
        }
        return "x";
        // db.save();
    }
}