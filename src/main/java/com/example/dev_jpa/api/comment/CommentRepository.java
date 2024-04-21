package com.example.dev_jpa.api.comment;

import com.example.dev_jpa.common.repository.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
