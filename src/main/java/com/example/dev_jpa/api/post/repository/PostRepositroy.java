package com.example.dev_jpa.api.post.repository;

import com.example.dev_jpa.api.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostRepositroy extends JpaRepository<Post, Long>, PostCustomRepository {

    // ?1 , ?2의 의미가 (파라미터 순서임)   각각 title, id에 매칭됨
    //clearAutomatically 속성 값을 통해서 persist context 싱크 맞출 수 있음.
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE POST p SET p.title = ?1 WHERE p.id = ?2",nativeQuery = true)
    int updateTitle(String title,Long id);


}
