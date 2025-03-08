package com.emeint.vetclinic.system.dto;

import com.emeint.vetclinic.system.model.Clinic;
import com.emeint.vetclinic.system.model.Doctor;
import com.emeint.vetclinic.system.model.Pet;
import com.emeint.vetclinic.system.model.Visit;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitDTO {
    private Long id;

    @NotNull(message = "Pet ID is required")
    private Long petId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotNull(message = "Clinic ID is required")
    private Long clinicId;

    @FutureOrPresent(message = "Visit date must be in the present or future")
    private LocalDateTime date;

    public static VisitDTO fromEntity(Visit visit) {
        VisitDTO dto = new VisitDTO();
        dto.setId(visit.getId());
        dto.setPetId(visit.getPet().getId());
        dto.setDoctorId(visit.getDoctor().getId());
        dto.setClinicId(visit.getClinic().getId());
        dto.setDate(visit.getDate());
        return dto;
    }

    public static Visit toEntity(VisitDTO dto, Pet pet, Doctor doctor, Clinic clinic) {
        Visit visit = new Visit();
        visit.setPet(pet);
        visit.setDoctor(doctor);
        visit.setClinic(clinic);
        visit.setDate(dto.getDate());
        return visit;
    }
}
