package io.baxter.communications.application.httpclients;

import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean(name = "accountServiceWebClient")
    public WebClient accountServiceWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://accounts-api:8080")
                .build();
    }
}
