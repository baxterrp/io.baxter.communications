package io.baxter.communications.application.models;

import lombok.*;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthToken{
    String userName;
    UUID userId;
    String accessToken;
    String refreshToken;
}
