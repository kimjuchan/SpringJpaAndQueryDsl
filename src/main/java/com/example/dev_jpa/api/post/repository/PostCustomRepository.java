package com.example.dev_jpa.api.post.repository;


import com.example.dev_jpa.api.post.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;


public interface PostCustomRepository {

    //custom method
    List<Post> findByTtileContains(String title);


}
