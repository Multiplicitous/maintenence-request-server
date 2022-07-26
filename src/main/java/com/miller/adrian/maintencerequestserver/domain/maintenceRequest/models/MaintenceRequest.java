package com.miller.adrian.maintencerequestserver.domain.maintenceRequest.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Entity
@Slf4j
@Data
@NoArgsConstructor
public class MaintenceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String aptNum;
    @NonNull
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    protected void onCreate(){
        createAt = new Date();
    }
}
