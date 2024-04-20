package com.example.dev_jpa.api.comment;

import com.example.dev_jpa.common.repository.MyRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Comment, Long> {

/*
    @Query(value = "SELECT C FROM Comment AS c", nativeQuery = true)
    List<Comment> findByTitleContains(String title);

*/
    Stream<Comment> findByContentContains(String keyword);

}
