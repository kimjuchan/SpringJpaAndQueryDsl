package com.example.dev_jpa.api.member.event;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RegisteredEvent {
    private final String name;
}
