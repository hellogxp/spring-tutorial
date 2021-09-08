package com.chopin.springvalidationaop.service;

import com.chopin.springvalidationaop.dto.UserParam;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 12:52
 */
public interface UserService {
    int createUser(UserParam userParam);
}