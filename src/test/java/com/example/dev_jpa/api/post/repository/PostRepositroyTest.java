package com.example.dev_jpa.api.post.repository;

import com.example.dev_jpa.api.post.Post;
import com.example.dev_jpa.config.QueryDslConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
@Import(value = QueryDslConfig.class)
class PostRepositroyTest {

    @Autowired
    PostRepositroy postRepositroy;



    public void init_savePost(){
        //given
        for(int i=1; i<=10; i++){
            Post post = new Post();
            post.setTitle("test" + i);
            Post newPost = postRepositroy.save(post);
            System.out.println("=============created post :: ["+ newPost.getTitle() + "]==========================");
        }

    }
    @Test
    @Rollback(false)
    public void crudRepository(){
        Post post = new Post();
        post.setTitle("test11");
        Post newPost = postRepositroy.save(post);
        System.out.println("===result : " + newPost.getTitle() + "======");
    }

    @Test
    @Rollback(false)
    public void QueryDsl_Like_테스트(){
        //given
        init_savePost();

        //when
        List<Post> resultList = postRepositroy.findByTtileContains("test");
        resultList.forEach(x -> {
                        System.out.println("================insert data :: [" + x.getTitle() + "]===================");
        });

        //then
        Assertions.assertThat(resultList.size()).isEqualTo(10);

    }


    @Test
    public void transient_persistenct(){
        //entity @Id 기반으로 null -> transient 상태 판단
        //null 아닌 경우 Detached 상태로 판단.
        //사용 시 항상 return 객체 기준으로 상태 값 변경이라던지...다른 작업 행위를해라.

        Post post = new Post();
        post.setTitle("post1");
        Post savedPost = postRepositroy.save(post); //persist

        Post updatePost = new Post();
        updatePost.setTitle("update");

        Post updated = postRepositroy.save(updatePost);

        // X
        updatePost.setTitle("반영 x");
        // O
        updated.setTitle("반영 o");
    }

    @Test
    @Rollback(false)
    public void Query_test(){
        //given
        init_savePost();

        //when
        //Sort 사용시 해당 엔티티 컬럼 기준으로..   Alias가 엔티티에 없는경우... ex) LENGHT(title) 식으로 함수를 사용 시 불가능
        //-> 함수 기준으로 정렬을 진행하고 싶다면  JpaSort.unsafe("LENGTH(title)")  식으로 사용 가능.
        List<Post> result = postRepositroy.findByTitleAndSort("test1");

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void update_Modifying_test(){
        //given
        Post post  = new Post();
        post.setTitle("before update");
        Post update_post = postRepositroy.save(post);

        //만약 @Modifying clearAutomatically =true  속성 정의 안했다면.. 데이터 싱크 맞춤이 없음   기존 post title 값은 이전 persist context에 저장된 before update 값 가지고  있음.
        int updateCnt = postRepositroy.updateTitle("Second_update", post.getId());
        Optional<Post> reuslt = postRepositroy.findById(post.getId());

        System.out.println("[result post] -> " + reuslt.get().getTitle());

        //그래서 그냥 이렇게 작업하지말고 그냥  해당 객체에 setter를 통해서 수정하는 방식으로 작업해주는게 제일 편함.
        post.setTitle("Second_update");
        Optional<Post> after_result = postRepositroy.findById(post.getId());

    }


}