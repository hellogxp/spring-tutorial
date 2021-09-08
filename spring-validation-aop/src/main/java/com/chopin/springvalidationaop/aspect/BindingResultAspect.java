package com.chopin.springvalidationaop.aspect;

import com.chopin.springvalidationaop.api.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Aspect
@Component
public class BindingResultAspect {
    @Pointcut("execution(public * com.chopin.springvalidationaop.controller.*.*(..))")
    public void bindingResult() {

    }

    @Around("bindingResult()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    FieldError fieldError = bindingResult.getFieldError();
                    if (fieldError != null) {
                        return CommonResult.validateFailed(fieldError.getDefaultMessage());
                    } else {
                        return CommonResult.validateFailed();
                    }
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
