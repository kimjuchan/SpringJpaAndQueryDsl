package com.example.dev_jpa.api.comment;

import com.example.dev_jpa.api.post.controller.PostRestController;
import com.example.dev_jpa.config.QueryDslConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
//이거 당연히  test에서는 디폴트로 안읽어오는거라 상관없을줄 알았는데...
@Import(value = QueryDslConfig.class)
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void 테스트(){
        System.out.println("===================================start");
        commentRepository.findAll();
        System.out.println("===================================end");
    }
}