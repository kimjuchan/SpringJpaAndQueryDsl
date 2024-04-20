package com.example.dev_jpa.api.member.controller;


import com.example.dev_jpa.api.member.domain.Member;
import com.example.dev_jpa.api.member.dto.MemberDto;
import com.example.dev_jpa.api.member.dto.MemberRequest;
import com.example.dev_jpa.api.member.repository.MemberRepository;
import com.example.dev_jpa.api.member.service.MemberService;
import com.example.dev_jpa.common.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRestController {

    private final MemberService memberService;
    @GetMapping("/list")
    public ApiResponse<List<MemberDto>> getMemberList(){
        List<MemberDto> memList = memberService.getMemberList();
        return ApiResponse.create(memList);
    }


    @PostMapping
    public ApiResponse<Long> createMember(@RequestBody List<MemberRequest> request){
            Long createCount = memberService.createMember(request);
            return ApiResponse.create(createCount);
    }


    @PostMapping("/create/event")
    public void createEvenetListener(@RequestBody MemberRequest request){
        log.info("============Member created Event Listener Method START============");
        memberService.member_registered_EventListener_test(request);
        log.info("============Member created Event Listener Method END============");
    }

}
