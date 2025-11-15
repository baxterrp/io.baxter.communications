package io.baxter.communications.application.events;

import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class AccountRegisteredEvent {
    UUID userId;
}