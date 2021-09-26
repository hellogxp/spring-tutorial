package com.chopin.springfilterinterceptor.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chopin
 * @version 1.0
 * @description: TODO
 * @date 2021/9/26 17:11
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        System.out.println("Pre interceptor");
        Enumeration<String> enumeration = request.getParameterNames();
        StringBuilder stringBuilder = new StringBuilder();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            stringBuilder.append("\"").append(key).append("\":").append(request.getParameter(key)).append(", ");
        }
        LOGGER.info("Request parameter:" + stringBuilder.toString());
        // Check if the session is valid
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        /**
         * The postHandle method, as the name implies, is executed after the current request is processed, that is,
         * after the Controller method is called, but it will be called before the DispatcherServlet performs the
         * view return rendering, so we can operate on the ModelAndView object after the Controller is processed in
         * this method
         */
        System.out.println("Post handle");
        System.out.println("Request URI [Post handle]:" + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        // afterCompletion() will be executed regardless of whether the Controller method throws an exception, the
        // parameter ex is the exception thrown by the Controller method
        System.out.println("After completion");
        System.out.println("Request URI [After completion]:" + request.getRequestURI());
    }
}