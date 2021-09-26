package com.chopin.springfilterinterceptor.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 16:17
 */
@Component
//@WebFilter(urlPatterns = {"/*"})
public class FilterOne implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterOne init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        System.out.println("FilterOne start");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        System.out.println("Request URI: " + httpServletRequest.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterOne end");
    }

    @Override
    public void destroy() {
        System.out.println("FilterOne destroy");
    }
}