package com.simon.springbootmocktest.zimug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@WebMvcTest
@WebMvcTest(ArticleController.class)
@AutoConfigureMockMvc
class ArticleControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ArticleService articleService;
    @Test
    public void test_save_article() throws Exception {
        when(articleService.saveArticle("ababa")).thenReturn("ok");
        mockMvc.perform(MockMvcRequestBuilders
                .get("/article/save/ababa")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("ok")));
    }
    @Test
    public void test_save_article_json() throws Exception {
        when(articleService.saveArticle("baba")).thenReturn("ok");
        String articleJson = "{ \"content\":\"baba\"}";
        ResultActions ok = mockMvc.perform(MockMvcRequestBuilders
                        .post("/article/foo")
                        .contentType("application/json")
                        .content(articleJson))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("ok")));
    }
}