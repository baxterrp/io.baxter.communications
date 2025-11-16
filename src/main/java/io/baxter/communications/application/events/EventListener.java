package io.baxter.communications.application.events;

import io.baxter.communications.application.httpclients.AccountServiceClient;
import io.baxter.communications.application.services.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventListener {
    private final AccountServiceClient accountServiceClient;
    private final EmailService emailService;

    @KafkaListener(topics = "AccountRegistered")
    public void onRegistered(AccountRegisteredEvent event) {
        log.info("fetching user with id : {}", event.getUserId());

        final var message = "Welcome %s %s to io.baxter!";

        accountServiceClient.GetAccount(event.getUserId())
                .doOnNext(user -> log.info("found user {} {} with Email {}", user.getFirstName(), user.getLastName(), user.getEmail()))
                .flatMap(account -> emailService.saveEmail(account, String.format(message, account.getFirstName(), account.getLastName())))
                .doOnError(error -> log.error(error.getMessage()))
                .subscribe();
    }
}
