package io.baxter.communications.data.repository;

import io.baxter.communications.data.models.EmailDataModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends ReactiveCrudRepository<EmailDataModel, Integer> {
}
