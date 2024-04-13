package com.example.dev_jpa.api.team.domain;


import com.example.dev_jpa.api.member.domain.Member;
import com.example.dev_jpa.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<Member> memList = new ArrayList<>();

}




