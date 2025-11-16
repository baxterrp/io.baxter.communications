package io.baxter.communications.application.models;

import lombok.*;

@Getter
@AllArgsConstructor
public class AuthRequest {
    String userName;
    String password;
}
