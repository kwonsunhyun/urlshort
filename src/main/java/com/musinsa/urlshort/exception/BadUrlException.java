package com.musinsa.urlshort.exception;

public class BadUrlException extends RuntimeException{

    public BadUrlException(String message){
        super(message);
    }
}
