package com.kyy.java.mission.bankapp.common.exception;

public class CommonException extends RuntimeException {
    private final ErrorCode errorCode;

    public CommonException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode.getCode();
    }

    public String getErrorMessage() {
        return errorCode.getDescription();
    }
}
