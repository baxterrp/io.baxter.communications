package io.baxter.communications.infrastructure.behavior.redis;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenResponse {
    String refreshToken;
    String accessToken;
}
