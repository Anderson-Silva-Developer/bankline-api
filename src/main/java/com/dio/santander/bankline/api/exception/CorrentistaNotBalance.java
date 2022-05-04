package com.dio.santander.bankline.api.exception;

public class CorrentistaNotBalance extends RuntimeException{
    public CorrentistaNotBalance(String message) {
        super(message);
    }
}
