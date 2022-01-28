package com.jk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理模块
 */
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<String> exceptionHandler (Exception e){
        return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
