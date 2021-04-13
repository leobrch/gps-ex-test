package com.gpx.exchange.utils;

import com.gpx.exchange.constant.status.AppStatus;
import org.springframework.http.ResponseEntity;

public class RequestUtils {
    public static ResponseEntity<Object> getResponse(AppStatus appStatus) {
        return ResponseEntity.status(appStatus.getStatus()).body(appStatus);
    }
}
