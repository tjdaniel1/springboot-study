package com.example.demo.exception;

public class NotFoundException extends IllegalArgumentException{
    public NotFoundException(String s) {
        super(s);
    }
}
