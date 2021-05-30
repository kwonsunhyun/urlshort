package com.musinsa.urlshort.controller;

import com.musinsa.urlshort.service.MusinsaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @Autowired
    private MusinsaService musinsaService;

    @PostMapping("/home")
    public String main(@RequestParam String requrl, Model model){
        model.addAttribute("geturl",musinsaService.getShortUrlAdress(requrl));
        return "index";
    }
}
