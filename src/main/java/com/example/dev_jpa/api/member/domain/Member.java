package com.example.dev_jpa.api.member.domain;


import com.example.dev_jpa.api.member.dto.MemberDto;
import com.example.dev_jpa.api.member.enums.Address;
import com.example.dev_jpa.api.team.domain.Team;
import com.example.dev_jpa.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String loginId;

    private String password;

    private String userName;

    private String email;

    private String phoneNumber;

    @Embedded
    @Setter
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="team_id")
    private Team team;

    public void addTeam(Team team1){
        this.team = team1;
        team1.getMemList().add(this);
    }

   /* @Getter
    @Setter
    @Embeddable
    public static class Address {
        private String city;
        private String gun;
        private String dong;

        public Address(String city, String gun, String dong){
            this.city = city;
            this.gun = gun;
            this.dong = dong;
        }

        public Address() {

        }
    }*/

    public static MemberDto of(Member member){
        return MemberDto.builder()
                .loginId(member.loginId)
                .password(member.password)
                .userName(member.userName)
                .phoneNumber(member.phoneNumber)
                .address(member.address)
                .email(member.email)
                .team(member.team)
                .build();
    }
}
