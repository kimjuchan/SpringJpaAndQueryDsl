package com.example.dev_jpa.api.post.repository;

import com.example.dev_jpa.api.post.Post;
import com.example.dev_jpa.api.post.QPost;
import com.example.dev_jpa.common.util.GlobalUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.apache.tika.utils.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> findByTtileContains(String title) {
        QPost post = QPost.post;
        //우선 공백 체크만
        BooleanExpression likeByTitle = StringUtils.isBlank(title) ? null : post.title.containsIgnoreCase(title);
        List<Post> postList = jpaQueryFactory.select(post).from(post).where(likeByTitle).fetch();
        return postList;
    }

    @Override
    public List<Post> findByTitleAndSort(String title) {
        QPost post = QPost.post;
        //우선 공백 체크만
        BooleanExpression likeByTitle = StringUtils.isBlank(title) ? null : post.title.containsIgnoreCase(title);
        List<Post> postList = jpaQueryFactory.select(post).from(post).where(likeByTitle).orderBy(post.title.desc()).fetch();
        return postList;
    }


}
