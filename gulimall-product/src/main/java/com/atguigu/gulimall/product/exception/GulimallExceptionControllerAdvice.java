package com.atguigu.gulimall.product.exception;

import com.atguigu.common.exception.BizCodeEnume;
import com.atguigu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dch on 2021/2/22.
 */

@Slf4j
//统一处理异常,//指定处理异常的controller
//@ResponseBody
//@ControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
@RestControllerAdvice
public class GulimallExceptionControllerAdvice {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)//指定可以处理的异常
    public R handleValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach(item->{
            String field = item.getField();
            String message = item.getDefaultMessage();
            map.put(field,message);
        });
        //log.error("数据校验出现问题：{}，异常类型：{}",e.getMessage(),e.getClass());
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(),BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data",map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Exception e){
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }

}
