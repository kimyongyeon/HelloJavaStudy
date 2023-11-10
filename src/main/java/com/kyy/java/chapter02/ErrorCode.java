package com.kyy.java.chapter02;

public enum ErrorCode {

    USER_NOT_FOUND(100, "사용자를 찾을 수 없습니다."),
    USER_NOT_FOUND2(101, "사용자를 찾을 수 없습니다."),
    USER_NOT_FOUND3(102, "사용자를 찾을 수 없습니다.");

    private int code;
    private String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
