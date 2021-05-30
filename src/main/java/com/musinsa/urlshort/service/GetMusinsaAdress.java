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

@Slf4j
@Service
public class GetMusinsaAdress implements MusinsaService {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private Base62 base62;

    @Override
    public String getShortUrlAdress(String req_url) {

        Optional<UrlShort> urlShort = urlRepository.findByUrl(req_url);

        String GetFromEncoding = "";

        /*요청 주소가 존재하는 경우 ID를 인코딩하여 전달*/
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


    /* 유입된 주소를 디코딩하여 ID를 획득하여 원 주소를 획득 */
    @Override
    @ExceptionHandler(value = NotFoundUrlException.class)
    public String getOriUrlAdress(String req_url) {
        int GetIdFromDecoding=base62.decoding(req_url);
        UrlShort urlShort = urlRepository.findById(GetIdFromDecoding)
                .orElseThrow(() ->new NotFoundUrlException());
        return urlShort.getUrl();
    }
}
