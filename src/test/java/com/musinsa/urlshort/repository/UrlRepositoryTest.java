package com.musinsa.urlshort.repository;

import com.musinsa.urlshort.domain.UrlShort;
import groovy.transform.builder.Builder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;


/**
 * @package : repository
 * @name : pmpro
 * @description : repository Unit Test
 **/

@RunWith(SpringRunner.class)
@DataJpaTest
@Builder
public class UrlRepositoryTest {

    @Autowired
    private UrlRepository urlRepository;

    @Test
    public void UrlSaveAndFindTest(){
        UrlShort urlShort = new UrlShort();
        urlShort.setUrl("https://www.musinsa.com");
        urlShort.setCnt(0L);
        UrlShort newUrl =urlRepository.save(urlShort);
        assertThat(newUrl.getUrl(),is(notNullValue()));

        Optional<UrlShort> urlShort2 = urlRepository.findByUrl(newUrl.getUrl());
        Assert.assertTrue(urlShort2.isPresent());
    }

}
