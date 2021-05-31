package com.musinsa.urlshort.service;

import com.musinsa.urlshort.domain.UrlShort;
import com.musinsa.urlshort.exception.NotFoundUrlException;
import com.musinsa.urlshort.repository.UrlRepository;
import com.musinsa.urlshort.util.Base62;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Optional;

/**
 * @package : service
 * @name : pmpro
 * @description : service
 **/
@Slf4j
@Service
public class GetMusinsaAdress implements MusinsaService {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private Base62 base62;

    /**
     * 사용자로부터 입력받은 URL주소를 DB에 저장 후
     * 해당 ID 값을 Base62 인코딩
     * @param req_url 요청주소
     * @return String 축약된 URL주소
     */
    @Override
    public String getShortUrlAdress(String req_url) {

        Optional<UrlShort> urlShort = urlRepository.findByUrl(req_url);

        String GetFromEncoding = "";

        if(urlShort.isPresent()){
            urlShort.get().setCnt(urlShort.get().getCnt()+1);
            urlRepository.save(urlShort.get());
            GetFromEncoding=base62.encoding(urlShort.get().getId());
        }else{
            UrlShort urlShort1 = new UrlShort();
            urlShort1.setUrl(req_url);
            urlShort1.setCnt(0L);
            UrlShort newUrl=urlRepository.save(urlShort1);
            GetFromEncoding=base62.encoding(newUrl.getId());
        }
        return GetFromEncoding;
    }


    /**
     * 사용자에게 입력받은 축약주소를 이용하여 원 주소를 획득
     * @param  req_url  축약된 주소 String
     * @return 원 주소 String
     */
    @Override
    @ExceptionHandler(value = NotFoundUrlException.class)
    public String getOriUrlAdress(String req_url) {
        int GetIdFromDecoding=base62.decoding(req_url);
        UrlShort urlShort = urlRepository.findById(GetIdFromDecoding)
                .orElseThrow(() ->new NotFoundUrlException());
        return urlShort.getUrl();
    }
}
