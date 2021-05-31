package com.musinsa.urlshort.controller;

import com.musinsa.urlshort.exception.BadUrlException;
import com.musinsa.urlshort.service.MusinsaService;
import com.musinsa.urlshort.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @package : urlshort
 * @name : pmpro
 * @description : View 컨트롤러 구현
 **/
@Controller
public class ViewController {
    @Autowired
    private MusinsaService musinsaService;

    /**
     * Post 요청시 index.html 로 응답합니다.
     * @param requrl
     * @param model
     * @return
     */
    @PostMapping("/home")
    public String main(@RequestParam String requrl, Model model){
        UrlUtil urlUtil = new UrlUtil();
        if(!urlUtil.isValidURL(requrl)){
            throw new BadUrlException("유효하지 않은 URL형식 입니다.");
        }
        model.addAttribute("geturl",musinsaService.getShortUrlAdress(requrl));
        return "index";
    }
}
