package com.emeint.vetclinic.system.service;

import com.emeint.vetclinic.system.dto.VisitDTO;
import com.emeint.vetclinic.system.model.Clinic;
import com.emeint.vetclinic.system.model.Doctor;
import com.emeint.vetclinic.system.model.Pet;
import com.emeint.vetclinic.system.model.Visit;
import com.emeint.vetclinic.system.repository.VisitRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepo visitRepo;
    private final PetService petService;
    private final DoctorService doctorService;
    private final ClinicService clinicService;

    public VisitDTO createVisit(VisitDTO visitDTO) {
        Pet pet = petService.getPetEntityById(visitDTO.getPetId());
        Doctor doctor = doctorService.getDoctorEntityById(visitDTO.getDoctorId());
        Clinic clinic = clinicService.getClinicEntityById(visitDTO.getClinicId());

        Visit visit = VisitDTO.toEntity(visitDTO, pet, doctor, clinic);
        visit = visitRepo.save(visit);
        return VisitDTO.fromEntity(visit);
    }

    public List<VisitDTO> getAllVisits() {
        return visitRepo.findAll().stream()
                .map(VisitDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public VisitDTO getVisitById(Long id) {
        Visit visit = visitRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Visit not found"));
        return VisitDTO.fromEntity(visit);
    }

    public void deleteVisit(Long id) {
        if (!visitRepo.existsById(id)) {
            throw new RuntimeException("Visit not found");
        }
        visitRepo.deleteById(id);
    }
}
