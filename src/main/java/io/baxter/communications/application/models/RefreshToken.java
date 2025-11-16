package io.baxter.communications.application.models;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {
    String refreshToken;
    String accessToken;
}
