package com.miller.adrian.maintencerequestserver.domain.maintenceRequest.services;

import com.miller.adrian.maintencerequestserver.domain.maintenceRequest.models.MaintenceRequest;

import java.util.List;

public interface RequestService {
    MaintenceRequest create(MaintenceRequest request);
    List<MaintenceRequest> getAll();
    MaintenceRequest getById(Long id);
    MaintenceRequest getAllByEmail(String email);
    MaintenceRequest updateById(Long id, MaintenceRequest request);
    void delete(MaintenceRequest request);
}
