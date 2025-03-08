package com.emeint.vetclinic.system.dto;

import com.emeint.vetclinic.system.model.Clinic;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class ClinicDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?20\\d{9}$|^0020\\d{9}$", message = "Phone number must be a valid Egyptian number")
    private String phone;

    @NotBlank(message = "Working days and hours are required")
    private String workingDaysAndHours;

    @Email(message = "NOT Valid Email")
    private String email;

    private List<String> socialNetworks;

    public static ClinicDTO fromEntity(Clinic clinic) {
        ClinicDTO dto = new ClinicDTO();
        dto.setId(clinic.getId());
        dto.setName(clinic.getName());
        dto.setAddress(clinic.getAddress());
        dto.setPhone(clinic.getPhone());
        dto.setWorkingDaysAndHours(clinic.getWorkingDaysAndHours());
        dto.setEmail(clinic.getEmail());
        dto.setSocialNetworks(clinic.getSocialNetworks());
        return dto;
    }

    public static Clinic toEntity(ClinicDTO dto) {
        Clinic clinic = new Clinic();
        clinic.setId(dto.getId());
        clinic.setName(dto.getName());
        clinic.setAddress(dto.getAddress());
        clinic.setPhone(dto.getPhone());
        clinic.setWorkingDaysAndHours(dto.getWorkingDaysAndHours());
        clinic.setEmail(dto.getEmail());
        clinic.setSocialNetworks(dto.getSocialNetworks());
        return clinic;
    }
}
