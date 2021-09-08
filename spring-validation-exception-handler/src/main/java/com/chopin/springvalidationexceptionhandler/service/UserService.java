package com.chopin.springvalidationexceptionhandler.service;

import com.chopin.springvalidationexceptionhandler.dto.UserParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 16:56
 */
public interface UserService {
    @Transactional
    void add(String userId);

    @Transactional
    String update(UserParam userParam);
}
