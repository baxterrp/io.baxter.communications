package io.baxter.communications.application.httpclients;

import io.baxter.communications.application.models.*;
import reactor.core.publisher.Mono;

public interface AuthServiceClient {
    Mono<AuthToken> getToken();
    Mono<RefreshToken> getNewRefreshToken();
}

