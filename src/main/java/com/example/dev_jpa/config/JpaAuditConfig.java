package com.example.dev_jpa.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class JpaAuditConfig {

    public static class AuditorAwareImpl implements AuditorAware<String>{
        @Override
        public Optional<String> getCurrentAuditor() {
            //TODO : Security 적용 시 Security 인증 객체 정보 가져와서 설정해주면됨.
            return Optional.of("default_JC");
        }
    }

    @Bean
    AuditorAware<String> auditorProvider() {
        //AuditorAware 인터페이스 구현체
        return new AuditorAwareImpl();
    }

}
