package io.baxter.communications.application.httpclients;

import io.baxter.communications.application.models.AccountModel;
import io.baxter.communications.infrastructure.behavior.exceptions.InvalidLoginException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceClientImpl implements AccountServiceClient{
    @Qualifier("accountServiceWebClient")
    private final WebClient accountServiceWebClient;

    @Override
    public Mono<AccountModel> GetAccount(UUID userId) {
        String url = String.format("api/accounts/%s", userId);
        return accountServiceWebClient
                .post()
                .uri(url)
                .retrieve()
                .onStatus(status -> !status.is2xxSuccessful(), clientResponse -> Mono.error(new InvalidLoginException()))
                .bodyToMono(AccountModel.class);
    }
}
