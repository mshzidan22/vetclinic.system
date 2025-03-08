package com.emeint.vetclinic.system.dto;

import com.emeint.vetclinic.system.model.Clinic;
import com.emeint.vetclinic.system.model.Doctor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?20\\d{9}$|^0020\\d{9}$", message = "Phone number must be a valid Egyptian number")
    private String phone;

    private String profilePhoto;

    @Size(max = 1000, message = "Bio must be at most 1000 characters")
    private String bio;

    private Long clinicId;

    public static DoctorDTO fromEntity(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setPhone(doctor.getPhone());
        dto.setProfilePhoto(doctor.getPhoto());
        dto.setBio(doctor.getBio());
        dto.setClinicId(doctor.getClinic() != null ? doctor.getClinic().getId() : null);
        return dto;
    }

    public static Doctor toEntity(DoctorDTO dto, Clinic clinic) {
        Doctor doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setPhone(dto.getPhone());
        doctor.setPhoto(dto.getProfilePhoto());
        doctor.setBio(dto.getBio());
        doctor.setClinic(clinic);
        return doctor;
    }
}
