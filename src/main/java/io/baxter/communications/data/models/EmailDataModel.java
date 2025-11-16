package io.baxter.communications.data.models;

import lombok.*;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

import java.time.Instant;
import java.util.Date;

@Table("emails")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDataModel {
    @Id
    Integer id;

    @Column("user_Id")
    String userId;

    @Column("emailAddress")
    String emailAddress;

    @Column("message")
    String message;

    @Column("createdDate")
    Instant createdDate;

    public EmailDataModel(String userId, String emailAddress, String message){
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.message = message;
    }
}
