package io.baxter.communications.application.services;

import io.baxter.communications.application.models.*;
import io.baxter.communications.data.models.EmailDataModel;
import io.baxter.communications.data.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Clock;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final Clock clock;
    private final EmailRepository emailRepository;

    @Override
    public Mono<Email> saveEmail(AccountModel account, String message) {
        var email = new EmailDataModel(
                account.getUserId(),
                account.getEmail(),
                message);

        log.info("saving email for user {} with address {}", account.getUserId(), message);

        return emailRepository.save(email)
                .map(saved -> new Email(
                        saved.getUserId(),
                        saved.getEmailAddress(),
                        saved.getMessage(),
                        saved.getCreatedDate()));
    }
}
