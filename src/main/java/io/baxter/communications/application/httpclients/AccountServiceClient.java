package io.baxter.communications.application.httpclients;

import io.baxter.communications.application.models.AccountModel;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountServiceClient {
    Mono<AccountModel> GetAccount(UUID userId);
}
