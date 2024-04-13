package com.example.dev_jpa.api.member.repository;


import com.example.dev_jpa.api.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,Long> {
}
