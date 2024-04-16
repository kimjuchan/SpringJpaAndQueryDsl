package com.example.dev_jpa.api.post.repository;

import com.example.dev_jpa.api.post.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest

class PostRepositroyTest {

    @Autowired
    PostRepositroy postRepositroy;

    @Test
    @Rollback(false)
    public void crudRepository(){
        Post post = new Post();
        post.setTitle("test1");
        Post newPost = postRepositroy.save(post);
        System.out.println("===result : " + newPost.getTitle() + "======");
    }


}