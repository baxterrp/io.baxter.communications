package io.baxter.communications.application.models;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountModel {
    String userId;
    String email;
    String firstName;
    String lastName;
}
