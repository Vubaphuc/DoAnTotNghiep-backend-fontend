package com.example.doanbackend.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException (String message) {
        super(message);
    }
}
