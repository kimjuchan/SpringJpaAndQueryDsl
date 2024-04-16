package com.example.dev_jpa.api.post;


import com.example.dev_jpa.api.comment.Comment;
import com.example.dev_jpa.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<Comment> commentList = new ArrayList<>();

    public void addComment(Comment comment){
        this.commentList.add(comment);
        comment.setPost(this);
    }

}
