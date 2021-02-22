package com.atguigu.gulimall.product.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by dch on 2021/2/22.
 */

@Slf4j
//统一处理异常,//指定处理异常的controller
@ControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = Exception.class)//指定可以处理的异常
    public void handleValidException(Exception e){
        log.error("数据校验出现问题：{}，异常类型：{}",e.getMessage(),e.getClass());
    }
}
