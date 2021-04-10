package com.example.demo.constant.status;

import org.springframework.http.HttpStatus;

public class StatusFactory {

    public static <T> AppStatus getAppStatus(String code, String message, T data) {
        return new AppStatus(code, message, data);
    }

    public static <T> AppStatus ofOk() {
        return new AppStatus(HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.getReasonPhrase(), null);
    }

    public static <T> AppStatus ofFound(T data) {
        return new AppStatus(HttpStatus.FOUND.getReasonPhrase(),
                HttpStatus.FOUND.getReasonPhrase(), data);
    }

    public static <T> AppStatus ofNotFound() {
        return new AppStatus(HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND.getReasonPhrase(), null);
    }

    public static <T> AppStatus ofBadRequest(String badRequestInstruction) {
        return new AppStatus(HttpStatus.BAD_REQUEST.getReasonPhrase(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), badRequestInstruction);
    }

    public static <T> AppStatus ofInternalError(T data) {
        return new AppStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), data);
    }
}
