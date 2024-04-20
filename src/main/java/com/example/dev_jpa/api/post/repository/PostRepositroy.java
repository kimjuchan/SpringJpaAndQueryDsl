package com.example.dev_jpa.api.post.repository;

import com.example.dev_jpa.api.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositroy extends JpaRepository<Post, Long>, PostCustomRepository {




}
