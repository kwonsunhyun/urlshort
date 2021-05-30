package com.musinsa.urlshort.controller;

import com.musinsa.urlshort.service.MusinsaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(ViewController.class)
public class ViewControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MusinsaService musinsaService;

    @Test
    public void TestMain() throws Exception {

        MultiValueMap<String,String> requestParam = new LinkedMultiValueMap<>();
        requestParam.set("requrl","https://www.musinsa.com");

        mockMvc.perform(post("/home")
                .content("https://www.musisa.com")
                .params(requestParam)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }
}
