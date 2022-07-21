package com.miller.adrian.maintencerequestserver.domain.maintenceRequest.repos;

import com.miller.adrian.maintencerequestserver.domain.maintenceRequest.models.MaintenceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaintenceRequestRepository extends JpaRepository<MaintenceRequest, Long> {
    Optional<MaintenceRequest> findByEmail(String email);
}
