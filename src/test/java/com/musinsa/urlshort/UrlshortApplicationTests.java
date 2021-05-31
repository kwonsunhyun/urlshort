package com.musinsa.urlshort;

import groovy.util.logging.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


/**
 * @package : urlshort
 * @name : pmpro
 * @description : 통합테스트
 **/

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class UrlshortApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void AllTest() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("req_url","https://www.naver.com");

        mockMvc.perform(post("/getUrl")
                .content(String.valueOf(jsonObject))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andDo(
                MockMvcResultHandlers.print()
        );

        mockMvc.perform(
                MockMvcRequestBuilders.get("/PjkvG")
        )
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andDo(MockMvcResultHandlers.print());

    }

}
