package io.baxter.communications.application.models;

import lombok.*;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    String userId;
    String emailAddress;
    String message;
    Instant createdDate;
}
