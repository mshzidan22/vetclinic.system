package com.emeint.vetclinic.system.controller;

import com.emeint.vetclinic.system.dto.VisitDTO;
import com.emeint.vetclinic.system.service.VisitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitController {
    private final VisitService visitService;

    @PostMapping
    public ResponseEntity<VisitDTO> createVisit(@Valid @RequestBody VisitDTO visitDTO) {
        VisitDTO createdVisit = visitService.createVisit(visitDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVisit);
    }

    @GetMapping
    public List<VisitDTO> getAllVisits() {
        return visitService.getAllVisits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDTO> getVisitById(@PathVariable Long id) {
        return ResponseEntity.ok(visitService.getVisitById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
        return ResponseEntity.noContent().build();
    }
}
