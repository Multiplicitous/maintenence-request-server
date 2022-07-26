package com.miller.adrian.maintencerequestserver.domain.maintenceRequest.services;

import com.miller.adrian.maintencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.miller.adrian.maintencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.miller.adrian.maintencerequestserver.domain.maintenceRequest.models.MaintenceRequest;

import java.util.List;

public interface RequestService {
    MaintenceRequest create(MaintenceRequest request) throws ResourceCreationException;
    List<MaintenceRequest> getAll();
    MaintenceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenceRequest getAllByEmail(String email) throws ResourceNotFoundException;
    MaintenceRequest updateById(Long id, MaintenceRequest request) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
