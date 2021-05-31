package com.musinsa.urlshort.exception;

/**
 * @package : exception
 * @name : pmpro
 * @description : 유효하지 않은 URL 사용자 정의 Exception
 **/
public class BadUrlException extends RuntimeException{

    public BadUrlException(String message){
        super(message);
    }
}
