package com.example.dev_jpa.api.member.event.handler;

import com.example.dev_jpa.api.member.event.RegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegisteredEventListener {

    //RegisteredEvent 이벤트가 발생될때 해당 @EventListener로 등록된 메소드가 동작된다.
    @EventListener // 1
    public void sendSms(RegisteredEvent event) {
        log.info("================" +event.getName() + "님 ::  축하 sms 발송 이벤트==========");
    }
    @EventListener
    public void makeCoupon(RegisteredEvent event) {
        log.info("================" +event.getName() + "님 ::  쿠폰을 발송 이벤트=============");
    }

}
