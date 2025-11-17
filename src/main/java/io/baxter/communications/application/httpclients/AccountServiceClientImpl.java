package io.baxter.communications.application.httpclients;

import io.baxter.communications.application.models.AccountModel;
import io.baxter.communications.infrastructure.behavior.exceptions.InvalidLoginException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceClientImpl implements AccountServiceClient{
    private final WebClient accountServiceWebClient;
    private final AuthServiceClient authServiceClient;

    @Override
    public Mono<AccountModel> GetAccount(UUID userId) {
        final var url = String.format("api/accounts/%s", userId);

        return authServiceClient.getToken()
                .flatMap(token -> {
                    log.info("Fetching account with userid {}", userId);

                    return accountServiceWebClient
                            .get()
                            .uri(url)
                            .header("Authorization", String.format("Bearer %s", token.getAccessToken()))
                            .retrieve()
                            .onStatus(status -> !status.is2xxSuccessful(), clientResponse -> Mono.error(new InvalidLoginException()))
                            .bodyToMono(AccountModel.class)
                            .doOnError(exception -> log.error("could not fetch account {} with error {}", userId, exception.getMessage()));
                });
    }
}
