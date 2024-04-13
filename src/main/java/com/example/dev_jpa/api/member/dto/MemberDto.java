package com.example.dev_jpa.api.member.dto;




import com.example.dev_jpa.api.member.domain.Member;
import com.example.dev_jpa.api.member.enums.Address;
import com.example.dev_jpa.api.team.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MemberDto {

    private int id;

    private String loginId;

    private String password;

    private String email;

    private String userName;

    private String phoneNumber;

    private Address address;

    private Team team;
}
