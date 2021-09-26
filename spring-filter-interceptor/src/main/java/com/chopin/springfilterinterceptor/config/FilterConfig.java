package com.chopin.springfilterinterceptor.config;

import java.util.ArrayList;
import java.util.Arrays;

import com.chopin.springfilterinterceptor.filter.FilterOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 16:46
 */
@Configuration
public class FilterConfig {
    @Autowired
    private FilterOne filterOne;

    public FilterRegistrationBean<FilterOne> registerFilterOne() {
        FilterRegistrationBean<FilterOne> filterOneFilterRegistrationBean = new FilterRegistrationBean<>();
        filterOneFilterRegistrationBean.setOrder(1);
        filterOneFilterRegistrationBean.setFilter(filterOne);
        filterOneFilterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/*")));
        return filterOneFilterRegistrationBean;
    }
}