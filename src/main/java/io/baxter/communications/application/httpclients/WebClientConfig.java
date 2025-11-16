package io.baxter.communications.application.httpclients;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    @Bean("accountServiceWebClient")
    public WebClient accountServiceWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://accounts-api:8080")
                .build();
    }

    @Bean("authServiceWebClient")
    public WebClient authServiceWebClient(WebClient.Builder builder){
        return builder
                .baseUrl("http://authentication-api:8080")
                .build();
    }
}
