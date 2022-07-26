package com.miller.adrian.maintencerequestserver.domain.maintenceRequest.services;

import com.miller.adrian.maintencerequestserver.domain.core.exceptions.ResourceCreationException;
import com.miller.adrian.maintencerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.miller.adrian.maintencerequestserver.domain.maintenceRequest.models.MaintenceRequest;
import com.miller.adrian.maintencerequestserver.domain.maintenceRequest.repos.MaintenceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {
    public MaintenceRequestRepository maintenceRequestRepository;

    public RequestServiceImpl(MaintenceRequestRepository maintenceRequestRepository) {
        this.maintenceRequestRepository = maintenceRequestRepository;
    }

    @Override
    public MaintenceRequest create(MaintenceRequest request) throws ResourceCreationException {
        Optional<MaintenceRequest> requestOptional = maintenceRequestRepository.findByEmail(request.getEmail());
        if (requestOptional.isPresent())
            throw new ResourceCreationException("Email already exist");
        request = maintenceRequestRepository.save(request);
        return request;
    }

    @Override
    public List<MaintenceRequest> getAll() {
        return maintenceRequestRepository.findAll();
    }

    @Override
    public MaintenceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = maintenceRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id doesn't exist"));
        return maintenceRequest;
    }

    @Override
    public MaintenceRequest getAllByEmail(String email) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = maintenceRequestRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("Email doesn't exist"));
        return maintenceRequest;
    }

    @Override
    public MaintenceRequest updateById(Long id, MaintenceRequest request) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = maintenceRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id doesn't exist"));
        maintenceRequest.setFirstName(request.getFirstName());
        maintenceRequest.setLastName(request.getLastName());
        maintenceRequest.setAptNum(request.getAptNum());
        maintenceRequest.setDescription(request.getDescription());
        maintenceRequest.setCreateAt(request.getCreateAt());
        return maintenceRequest;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        MaintenceRequest maintenceRequest = getById(id);
        maintenceRequestRepository.delete(maintenceRequest);
    }
}
