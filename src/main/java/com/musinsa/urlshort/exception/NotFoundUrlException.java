package com.musinsa.urlshort.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotFoundUrlException extends RuntimeException {
    private static final String MESSAGE = "존재하지 않는 축약 URL 입니다.";

    public NotFoundUrlException(){
        super(MESSAGE);
    }


}
