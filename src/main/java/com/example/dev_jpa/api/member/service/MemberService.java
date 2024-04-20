package com.example.dev_jpa.api.member.service;


import com.example.dev_jpa.api.member.domain.Member;
import com.example.dev_jpa.api.member.dto.MemberDto;
import com.example.dev_jpa.api.member.dto.MemberRequest;
import com.example.dev_jpa.api.member.enums.Address;
import com.example.dev_jpa.api.member.event.RegisteredEvent;
import com.example.dev_jpa.api.member.repository.MemberRepository;
import com.example.dev_jpa.api.team.domain.Team;
import com.example.dev_jpa.api.team.repository.TeamRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.metamodel.model.domain.internal.MapMember;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    @PersistenceContext
    private final EntityManager em;

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    private final ApplicationEventPublisher eventPublisher;

    public List<MemberDto> getMemberList(){
        return Optional.of(memberRepository.findAll().stream()
                .map(Member::of)
                .toList()).orElseThrow(() -> new NullPointerException("조회되는 유저 정보가 없습니다."));
    }

    public Long createMember(List<MemberRequest> request){
        Session session = em.unwrap(Session.class);
        //random team insert
        for (int index=1; index < 10; index++) {
            Team team = new Team();
            team.setTeamName("team" + index);
            teamRepository.save(team);
        }

        Random random = new Random();
        Long insertCnt = 0L;

        //Dirty Checking
        for(MemberRequest data : request){
            Long intValue = (long) (random.nextInt(10) + 1);
            Member member = MemberRequest.toEntity(data);
            Optional<Team> team = teamRepository.findById(intValue);
            Address address = new Address("서울특별시","관악구","신림동 " + intValue + "번지");
            member.addTeam(team.get());
            member.setAddress(address);

            //Member save
            memberRepository.save(member);
            //session.save(member);
            insertCnt++;
        }

        //Member getMember = session.getReference(Member.class, 1L);
        return insertCnt;
    }

    public void member_registered_EventListener_test(MemberRequest request) {

        //TEST용 유저 생성.
        Team team = new Team();
        team.setTeamName("teamEvent");
        teamRepository.save(team);

        Member member = MemberRequest.toEntity(request);
        Address address = new Address("서울특별시","관악구","신림동 " + "412" + "번지");
        member.addTeam(team);
        member.setAddress(address);

        //Member save
        memberRepository.save(member);
        log.info("=============Member created===========");

        // 회원가입 후 event 로직 실행.
        eventPublisher.publishEvent(new RegisteredEvent(member.getUserName()));
    }



}
