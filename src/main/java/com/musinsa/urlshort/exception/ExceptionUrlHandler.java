package com.musinsa.urlshort.exception;

import com.musinsa.urlshort.domain.ResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionUrlHandler {

    @ExceptionHandler(NotFoundUrlException.class)
    public ResponseDto NotFoundUrlException(NotFoundUrlException ex){
        return ResponseDto.of(ex.getMessage());
    }

    @ExceptionHandler(BadUrlException.class)
    public ResponseDto badUrlException(BadUrlException ex){
        return ResponseDto.of(ex.getMessage());
    }
}
