package com.dio.santander.bankline.api.exception;

public class CorrentistaNotFound extends RuntimeException{
    public CorrentistaNotFound(String message) {
        super(message);
    }
}
