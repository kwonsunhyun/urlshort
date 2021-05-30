package com.musinsa.urlshort.controller;

import com.musinsa.urlshort.domain.SearchParam;
import com.musinsa.urlshort.service.MusinsaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class ApiController {

    @Autowired
    private MusinsaService musinsaService;

    @PostMapping(value = "/getUrl")
    public String GetShortUrl(@RequestBody SearchParam searchParam){
        String GetFromBodyUrl=searchParam.getReq_url();
        String getUrl = musinsaService.getShortUrlAdress(GetFromBodyUrl);
        return getUrl;
    }


    @GetMapping("/{requrl}")
    public void GoUrl(HttpServletResponse response, @PathVariable String requrl) throws IOException {
        String GetUrlAdress = musinsaService.getOriUrlAdress(requrl);
        response.sendRedirect(GetUrlAdress);
    }


}
