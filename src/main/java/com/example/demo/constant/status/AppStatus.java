package com.example.demo.constant.status;

public class AppStatus<T> {
    private String code;
    private String message;
    private T data;
    private Long timestamp;

    public AppStatus(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }
}
