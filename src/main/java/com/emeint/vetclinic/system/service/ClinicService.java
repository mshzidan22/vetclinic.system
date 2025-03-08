package com.emeint.vetclinic.system.service;

import com.emeint.vetclinic.system.dto.ClinicDTO;
import com.emeint.vetclinic.system.dto.DoctorDTO;
import com.emeint.vetclinic.system.exception.EntityNotFoundException;
import com.emeint.vetclinic.system.model.Clinic;
import com.emeint.vetclinic.system.model.Doctor;
import com.emeint.vetclinic.system.repository.ClinicRepo;
import com.emeint.vetclinic.system.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private final ClinicRepo clinicRepo;
    private final DoctorRepo doctorRepo;

    public ClinicDTO createClinic(ClinicDTO clinicDTO) {
        Clinic clinic = ClinicDTO.toEntity(clinicDTO);
        return ClinicDTO.fromEntity(clinicRepo.save(clinic));
    }

    public ClinicDTO getClinicById(Long id) {
        Clinic clinic = clinicRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clinic not found with ID: " + id));
        return ClinicDTO.fromEntity(clinic);
    }

    public Clinic getClinicEntityById(Long id) {
        return clinicRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Clinic not found with ID: " + id));
    }


    public List<ClinicDTO> getAllClinics() {
        return clinicRepo.findAll().stream()
                .map(ClinicDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ClinicDTO> searchClinics(String phone, String address) {
        List<Clinic> clinics = clinicRepo.findByPhoneContainingOrAddressContaining(phone, address);
        return clinics.stream().map(ClinicDTO::fromEntity).collect(Collectors.toList());
    }

    public List<DoctorDTO> getDoctorsByClinicId(Long clinicId) {
        List<Doctor> doctors = doctorRepo.findByClinicId(clinicId);
        return doctors.stream()
                .map(DoctorDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ClinicDTO updateClinic(Long id, ClinicDTO updatedClinic) {
        Clinic existingClinic = clinicRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clinic not found with ID: " + id));

        existingClinic.setName(updatedClinic.getName());
        existingClinic.setAddress(updatedClinic.getAddress());
        existingClinic.setPhone(updatedClinic.getPhone());
        existingClinic.setWorkingDaysAndHours(updatedClinic.getWorkingDaysAndHours());
        existingClinic.setEmail(updatedClinic.getEmail());
        existingClinic.setSocialNetworks(updatedClinic.getSocialNetworks());

        return ClinicDTO.fromEntity(clinicRepo.save(existingClinic));
    }

    public void deleteClinic(Long id) {
        clinicRepo.deleteById(id);
    }
}