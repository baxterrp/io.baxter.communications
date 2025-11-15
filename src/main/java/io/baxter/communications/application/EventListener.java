package io.baxter.communications.application;

import io.baxter.communications.application.events.AccountRegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventListener {
    @KafkaListener(topics = "AccountRegistered")
    public void onRegistered(AccountRegisteredEvent event) {
        log.info("SAVING USER WITH ID : {}", event.getUserId());
    }
}
