package com.example.exception;

public class CustomerException extends Exception{
    private String code;
    private String message;

    public CustomerException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
