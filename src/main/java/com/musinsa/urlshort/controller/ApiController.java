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

/**
* @package : urlshort
* @name : pmpro
* @description : Api 컨트롤러 구현
**/
@Slf4j
@RestController
public class ApiController {

    @Autowired
    private MusinsaService musinsaService;

    /**
     * Post 요청으로 들어온 URL주소를 축약된 형태로 응답합니다.
     * @param searchParam Json
     * @return 축약주소 String
     */
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


    /**
     * Get 요청으로 들어온 축약URL주소를 원 주소로 Redirect 합니다.
     * @param response
     * @param requrl String
     * @throws IOException
     */
    @GetMapping("/{requrl}")
    public void GoUrl(HttpServletResponse response, @PathVariable String requrl) throws IOException {
        String GetUrlAdress = musinsaService.getOriUrlAdress(requrl);
        response.sendRedirect(GetUrlAdress);
    }


}
