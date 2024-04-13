package com.example.dev_jpa.config;


import com.example.dev_jpa.api.member.domain.Member;
import com.example.dev_jpa.api.member.enums.Address;
import com.example.dev_jpa.api.team.domain.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AppRunner implements ApplicationRunner {


    @PersistenceContext
    private final EntityManager em;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("======Init Account Create Start======");
        Address addr = new Address("서울특별시","관악구","신림동");

        for(int idx=0; idx<5; idx++){
            var team = new Team();
            team.setTeamName("Hamster-" + idx);
            em.persist(team);
        }
        Team teamA = new Team();
        teamA.setTeamName("Hamster");

        Member member = Member.builder()
                .loginId("admin")
                .userName("JC")
                .password("1234")
                .phoneNumber("01012341234")
                .email("kjuchan92@naver.com")
                .address(addr)
                .build();

        em.persist(teamA);
        member.addTeam(teamA);
        em.persist(member);
        em.flush();
        log.info("======Init Account Create End======");
    }
}
