package com.example.dev_jpa.api.comment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.stream.Stream;


@DataJpaTest
@EnableJpaRepositories
class CommentRepositroyTest {


    @Autowired
    CommentRepository commentRepositroy;


    @Test
    public void 특정키워드_존재여부_확인(){
        //given
        Comment comment = new Comment();
        comment.setContent("Summer is comming");

        Comment comment2 = new Comment();
        comment.setContent("Winter is comming");

        Comment comment3 = new Comment();
        comment.setContent("Spring is comming");

        Comment comment4 = new Comment();
        comment.setContent("Summer is comming2");

        //when
        commentRepositroy.save(comment);
        commentRepositroy.save(comment2);
        commentRepositroy.save(comment3);
        commentRepositroy.save(comment4);

        //then
        //try with resource 사용해봄 (자원 반납을 잘해보자..)
        try(Stream<Comment> comments = commentRepositroy.findByContentContains("Summer")){
            Comment firstComment = comments.findFirst().get();
            System.out.println("Keyword is :: " + firstComment);
        }

    }
}