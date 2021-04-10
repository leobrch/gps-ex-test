package com.example.demo.utils;

import com.example.demo.constant.status.AppStatus;
import org.springframework.http.ResponseEntity;

public class RequestUtils {
    public static ResponseEntity<Object> getResponse(AppStatus appStatus) {
        return ResponseEntity.status(appStatus.getStatus()).body(appStatus);
    }
}
