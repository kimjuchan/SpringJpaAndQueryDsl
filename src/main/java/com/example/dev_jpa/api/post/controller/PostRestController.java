package com.example.dev_jpa.api.post.controller;

import com.example.dev_jpa.api.post.Post;
import com.example.dev_jpa.api.post.dto.PostDto;
import com.example.dev_jpa.api.post.repository.PostRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostRestController {

    private final PostRepositroy postRepositroy;


    @GetMapping("/{id}")
    public String getList(@PathVariable("id") Long id){
        Optional<PostDto> post = Optional.ofNullable(postRepositroy.findById(id).map(Post::toDto).orElseThrow(() -> new NullPointerException("해당 id 정보가 없습니다.")));
        return post.get().getTitle();
    }


}
