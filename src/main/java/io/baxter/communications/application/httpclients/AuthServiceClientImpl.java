package io.baxter.communications.application.httpclients;

import io.baxter.communications.application.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceClientImpl implements AuthServiceClient{

    private final WebClient authServiceWebClient;

    @Value("${account-username}") private String accountUserName;
    @Value("${account-password}") private String accountPassword;

    @Override
    public Mono<AuthToken> getToken() {
        final var request = new AuthRequest(accountUserName, accountPassword);
        final var uri = "/api/auth/login";

        return authServiceWebClient
                .post()
                .uri(uri)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(AuthToken.class);
    }

    @Override
    public Mono<RefreshToken> getNewRefreshToken() {
        var refreshToken = "get from cache";
        final var uri = String.format("/api/auth/refresh/%s", refreshToken);

        return authServiceWebClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(RefreshToken.class);
    }
}
