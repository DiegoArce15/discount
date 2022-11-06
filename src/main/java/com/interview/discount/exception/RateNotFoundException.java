package com.interview.discount.exception;

public class RateNotFoundException extends RuntimeException {


    public RateNotFoundException(String message) {
        super(message);
    }
}
