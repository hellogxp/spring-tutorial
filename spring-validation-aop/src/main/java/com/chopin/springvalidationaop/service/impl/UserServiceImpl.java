package com.chopin.springvalidationaop.service.impl;

import com.chopin.springvalidationaop.dto.UserParam;
import com.chopin.springvalidationaop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 13:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public int createUser(UserParam userParam) {
        return 0;
    }
}