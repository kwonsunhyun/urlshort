package com.musinsa.urlshort.domain;

/**
 * @package : domain
 * @name : pmpro
 * @description : 사용자 정의 Exception 응답을 위한 Dto
 **/
public class ResponseDto {
    private String message;

    public ResponseDto(String message){
        this.message = message;
    }

    public static ResponseDto of(String message){
        return new ResponseDto(message);
    }

    public String getMessage(){
        return message;
    }
}
