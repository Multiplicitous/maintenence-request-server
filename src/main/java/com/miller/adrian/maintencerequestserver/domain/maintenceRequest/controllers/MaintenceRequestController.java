package com.miller.adrian.maintencerequestserver.domain.maintenceRequest.controllers;

import com.miller.adrian.maintencerequestserver.domain.maintenceRequest.models.MaintenceRequest;
import com.miller.adrian.maintencerequestserver.domain.maintenceRequest.services.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class MaintenceRequestController {
    RequestServiceImpl requestService;

    @Autowired
    public MaintenceRequestController(RequestServiceImpl requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<MaintenceRequest> create(@RequestBody MaintenceRequest request){
        request = requestService.create(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MaintenceRequest>> getAll(){
        List<MaintenceRequest> maintenceRequests = requestService.getAll();
        return new ResponseEntity<>(maintenceRequests, HttpStatus.OK);
    }

    @GetMapping("{/id}")
    public ResponseEntity<MaintenceRequest> getById(@PathVariable("id") Long id){
        MaintenceRequest maintenceRequest = requestService.getById(id);
        return new ResponseEntity<>(maintenceRequest, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<MaintenceRequest> getByEmail(@RequestParam String email){
        MaintenceRequest maintenceRequest = requestService.getAllByEmail(email);
        return new ResponseEntity<>(maintenceRequest, HttpStatus.OK);
    }

    @PutMapping("{/id}")
    public ResponseEntity<MaintenceRequest> update(@PathVariable("id") Long id, MaintenceRequest request){
        request = requestService.updateById(id, request);
        return new ResponseEntity<>(request, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        requestService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
