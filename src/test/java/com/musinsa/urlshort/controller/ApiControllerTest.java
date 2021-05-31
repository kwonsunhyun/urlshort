package com.musinsa.urlshort.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musinsa.urlshort.domain.SearchParam;
import com.musinsa.urlshort.repository.UrlRepository;
import com.musinsa.urlshort.service.MusinsaService;
import org.json.JSONObject;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @package : controller
 * @name : pmpro
 * @description : controller Unit Test
 **/

@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SearchParam searchParam;

    @MockBean
    private MusinsaService musinsaService;

    @MockBean
    private UrlRepository urlRepository;

    @Test
    public void TestPostGetUrl() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("req_url","aaaaaaam");

        mockMvc.perform(post("/getUrl")
                .content(String.valueOf(jsonObject))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }


}
