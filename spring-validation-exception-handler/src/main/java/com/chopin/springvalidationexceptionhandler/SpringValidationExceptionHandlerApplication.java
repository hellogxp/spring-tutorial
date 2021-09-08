package com.chopin.springvalidationexceptionhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SpringValidationExceptionHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringValidationExceptionHandlerApplication.class, args);
    }

}
