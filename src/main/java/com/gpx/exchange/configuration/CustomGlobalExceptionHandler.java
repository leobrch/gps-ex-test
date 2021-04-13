package com.gpx.exchange.configuration;

import com.gpx.exchange.constant.status.StatusFactory;
import com.gpx.exchange.exception.CustomException;
import com.gpx.exchange.utils.RequestUtils;
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
