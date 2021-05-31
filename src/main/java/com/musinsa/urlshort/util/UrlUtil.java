package com.musinsa.urlshort.util;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlUtil {

    /**
     *  URI 유효성 검증
     * @param url
     * @return boolean
     */
    public boolean isValidURL(String url){
        try{
            new URL(url).toURI();
        }catch(MalformedURLException | URISyntaxException e){
            return false;
        }

        return true;
    }
}
