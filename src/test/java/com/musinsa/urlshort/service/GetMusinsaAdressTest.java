package com.musinsa.urlshort.service;

import com.musinsa.urlshort.domain.UrlShort;
import com.musinsa.urlshort.repository.UrlRepository;
import com.musinsa.urlshort.util.Base62;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

/**
 * @package : service
 * @name : pmpro
 * @description : service Unit Test
 **/

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class GetMusinsaAdressTest {

   @InjectMocks
   private GetMusinsaAdress getMusinsaAdress;

   @Mock
   private UrlRepository urlRepository;

    @Test
    public void getShortUrlAdressServiceTest(){

        //given
        UrlShort newUrl=createUrl();

        int fakeId = 7777777;
        ReflectionTestUtils.setField(newUrl,"id",fakeId);

        // mocking
        given(urlRepository.save(any())).willReturn(newUrl);
        given(urlRepository.findById(fakeId)).willReturn(Optional.ofNullable(newUrl));

        //when
        String getShortUrl = getMusinsaAdress.getShortUrlAdress(newUrl.getUrl());

        System.out.println("##### getShortUrl:"+getShortUrl);
        int  idfromdecoding =Base62.decoding(getShortUrl);
        //then
        Optional<UrlShort> getFromDb=urlRepository.findById(idfromdecoding);

        assertEquals(newUrl.getUrl(),getFromDb.get().getUrl());

    }

    @Test
    public void getOriUrlAdressTest(){

        //given
        UrlShort newUrl=createUrl();

        int fakeId = 7777777;
        ReflectionTestUtils.setField(newUrl,"id",fakeId);

        // mocking
        given(urlRepository.save(any())).willReturn(newUrl);
        given(urlRepository.findById(fakeId)).willReturn(Optional.ofNullable(newUrl));

        //when
        String getShortUrl = getMusinsaAdress.getShortUrlAdress(newUrl.getUrl());

        //then
        String getOriUrl=getMusinsaAdress.getOriUrlAdress(getShortUrl);
        assertEquals(newUrl.getUrl(),getOriUrl);
    }

    private UrlShort createUrl(){
        UrlShort urlShort = new UrlShort();
        urlShort.setUrl("https://www.musinsa.com");
        urlShort.setCnt(0L);

        return urlShort;
    }


}
