package io.baxter.communications.application.services;

import io.baxter.communications.application.models.*;
import reactor.core.publisher.Mono;

public interface EmailService {
    Mono<Email> saveEmail(AccountModel account, String message);
}
