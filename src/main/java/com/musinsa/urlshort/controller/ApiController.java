package com.musinsa.urlshort.controller;

import com.musinsa.urlshort.domain.SearchParam;
import com.musinsa.urlshort.exception.BadUrlException;
import com.musinsa.urlshort.service.MusinsaService;
import com.musinsa.urlshort.util.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class ApiController {

    @Autowired
    private MusinsaService musinsaService;

    @PostMapping(value = "/getUrl")
    public String GetShortUrl(@RequestBody SearchParam searchParam){
        String GetFromBodyUrl=searchParam.getReq_url();
        UrlUtil urlUtil = new UrlUtil();
        if(!urlUtil.isValidURL(GetFromBodyUrl)){
            throw new BadUrlException("유효하지 않은 URL형식 입니다.");
        }
        String getUrl = musinsaService.getShortUrlAdress(GetFromBodyUrl);
        return getUrl;
    }


    @GetMapping("/{requrl}")
    public void GoUrl(HttpServletResponse response, @PathVariable String requrl) throws IOException {
        String GetUrlAdress = musinsaService.getOriUrlAdress(requrl);
        response.sendRedirect(GetUrlAdress);
    }


}
