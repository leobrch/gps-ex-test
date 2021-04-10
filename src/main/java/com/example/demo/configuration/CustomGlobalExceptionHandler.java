package com.example.demo.configuration;

import com.example.demo.constant.status.StatusFactory;
import com.example.demo.exception.CustomException;
import com.example.demo.utils.RequestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        return RequestUtils.getResponse(StatusFactory.ofBadRequest(ex.getMessage()));
    }
}
