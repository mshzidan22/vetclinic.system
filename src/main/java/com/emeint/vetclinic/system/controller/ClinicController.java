package com.emeint.vetclinic.system.controller;

import com.emeint.vetclinic.system.dto.ClinicDTO;
import com.emeint.vetclinic.system.dto.DoctorDTO;
import com.emeint.vetclinic.system.service.ClinicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
@RequiredArgsConstructor
public class ClinicController {
    private final ClinicService clinicService;

    @PostMapping
    public ResponseEntity<ClinicDTO> createClinic(@Valid @RequestBody ClinicDTO clinicDTO) {
        ClinicDTO createdClinic = clinicService.createClinic(clinicDTO);
        return ResponseEntity.ok(createdClinic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicDTO> getClinicById(@PathVariable Long id) {
        ClinicDTO clinic = clinicService.getClinicById(id);
        return ResponseEntity.ok(clinic);
    }

    @GetMapping
    public ResponseEntity<List<ClinicDTO>> getAllClinics() {
        List<ClinicDTO> clinics = clinicService.getAllClinics();
        return ResponseEntity.ok(clinics);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClinicDTO>> searchClinics(@RequestParam(required = false) String phone,
                                                         @RequestParam(required = false) String address) {
        List<ClinicDTO> clinics = clinicService.searchClinics(phone, address);
        return ResponseEntity.ok(clinics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicDTO> updateClinic(@PathVariable Long id, @Valid @RequestBody ClinicDTO clinicDTO) {
        ClinicDTO updatedClinic = clinicService.updateClinic(id, clinicDTO);
        return ResponseEntity.ok(updatedClinic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinic(@PathVariable Long id) {
        clinicService.deleteClinic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/doctors")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByClinic(@PathVariable Long id) {
        List<DoctorDTO> doctors = clinicService.getDoctorsByClinicId(id);
        return ResponseEntity.ok(doctors);
    }
}