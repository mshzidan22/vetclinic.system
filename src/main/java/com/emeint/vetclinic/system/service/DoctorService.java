package com.emeint.vetclinic.system.service;

import com.emeint.vetclinic.system.Constants.AppConstants;
import com.emeint.vetclinic.system.dto.DoctorDTO;
import com.emeint.vetclinic.system.exception.EntityNotFoundException;
import com.emeint.vetclinic.system.model.Clinic;
import com.emeint.vetclinic.system.model.Doctor;
import com.emeint.vetclinic.system.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepo doctorRepo;
    private final ClinicService clinicService;

    public List<DoctorDTO> getDoctorsByClinicId(Long clinicId) {
        return doctorRepo.findByClinicId(clinicId).stream()
                .map(DoctorDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public DoctorDTO assignDoctorToClinic(Long doctorId, Long clinicId) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
        Clinic clinic = clinicService.getClinicEntityById(clinicId);
        doctor.setClinic(clinic);
        return DoctorDTO.fromEntity(doctorRepo.save(doctor));
    }

    public DoctorDTO removeDoctorFromClinic(Long doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
        doctor.setClinic(null);
        return DoctorDTO.fromEntity(doctorRepo.save(doctor));
    }

    public Doctor getDoctorEntityById(Long doctorId) {
        return doctorRepo.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }
}
