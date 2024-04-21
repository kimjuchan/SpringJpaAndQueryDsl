package com.example.dev_jpa.api.post.controller;

import com.example.dev_jpa.api.post.dto.PostDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostRestControllerTest {

    @InjectMocks
    private PostRestController postRestController;
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        //mockMvc  초기화
        mockMvc = MockMvcBuilders.standaloneSetup(postRestController).build();
    }


    @Test
    @DisplayName("post tile 정보 조회 테스트 ")
    public void getPostByTitle(){
        //given
        PostDto request = PostDto.builder()
                .title("mvc test")
                .build();
      /*
        //when
        ResultActions resultActions = mockMvc.perform(get("/api/post/1"))

        //then
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("statusCode", response.getStatusCode()).exists())
                .andExpect(jsonPath("msg", response.getMsg()).exists());*/

    }



}