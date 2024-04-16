package com.example.dev_jpa.api.member.dto;


import com.example.dev_jpa.api.member.domain.Member;
import com.example.dev_jpa.api.member.enums.Address;
import com.example.dev_jpa.api.team.domain.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;

@Getter
public class MemberRequest {

    private String loginId;
    private String password;
    private String userName;
    private String phoneNumber;
    private String email;
    @Setter
    private Address address;



    public static MemberDto of(MemberRequest request){
        return MemberDto.builder()
                .loginId(request.loginId)
                .password(request.password)
                .userName(request.userName)
                .phoneNumber(request.phoneNumber)
                .email(request.email)
                .address(request.address)
                .build();
    }

    public static Member toEntity(MemberRequest request){
        return Member.builder()
                .loginId(request.loginId)
                .password(request.password)
                .userName(request.userName)
                .phoneNumber(request.phoneNumber)
                .email(request.email)
                .address(request.address)
                .build();
    }

}
