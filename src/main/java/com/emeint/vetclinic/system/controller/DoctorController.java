package com.emeint.vetclinic.system.controller;

import com.emeint.vetclinic.system.dto.DoctorDTO;
import com.emeint.vetclinic.system.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/clinic/{clinicId}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByClinicId(@PathVariable Long clinicId) {
        List<DoctorDTO> doctors = doctorService.getDoctorsByClinicId(clinicId);
        return ResponseEntity.ok(doctors);
    }

    @PostMapping("/{doctorId}/assign/{clinicId}")
    public ResponseEntity<DoctorDTO> assignDoctorToClinic(@PathVariable Long doctorId, @PathVariable Long clinicId) {
        DoctorDTO doctor = doctorService.assignDoctorToClinic(doctorId, clinicId);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping("/{doctorId}/remove")
    public ResponseEntity<DoctorDTO> removeDoctorFromClinic(@PathVariable Long doctorId) {
        DoctorDTO doctor = doctorService.removeDoctorFromClinic(doctorId);
        return ResponseEntity.ok(doctor);
    }
}