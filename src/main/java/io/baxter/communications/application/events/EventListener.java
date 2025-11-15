package io.baxter.communications.application.events;

import io.baxter.communications.application.httpclients.AccountServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventListener {
    private final AccountServiceClient accountServiceClient;

    @KafkaListener(topics = "AccountRegistered")
    public void onRegistered(AccountRegisteredEvent event) {
        log.info("fetching user with id : {}", event.getUserId());

        accountServiceClient.GetAccount(event.getUserId())
                .doOnNext(user -> log.info("found user {} {} with email {}", user.getFirstName(), user.getLastName(), user.getEmail()))
                .doOnError(error -> log.error(error.getMessage()))
                .subscribe();

    }
}
