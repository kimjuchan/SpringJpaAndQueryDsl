package com.example.dev_jpa.api.post.repository;

import com.example.dev_jpa.api.post.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository{

    @PersistenceContext
    final EntityManager em;

    @Override
    public List<Post> findByTtileContains(String title) {

        String sql = "SELECT post FROM POST post where post.title like CONCAT('%',:title,'%')";
        List<Post> result =  em.createQuery(sql,Post.class).setParameter("title",title).getResultList();
        return result;
    }


}
