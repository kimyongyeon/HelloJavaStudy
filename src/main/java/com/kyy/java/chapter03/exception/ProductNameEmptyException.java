package com.kyy.java.chapter03.exception;

public class ProductNameEmptyException extends IllegalArgumentException {
    public ProductNameEmptyException(String message) {
        super(message);
    }
}
