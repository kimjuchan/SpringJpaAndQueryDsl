package com.example.dev_jpa.api.team.repository;

import com.example.dev_jpa.api.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {


}
