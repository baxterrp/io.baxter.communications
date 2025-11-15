package io.baxter.communications.application.events;

import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class AccountRegisteredEvent {
    Integer id;
    UUID userId;
    String email;
}