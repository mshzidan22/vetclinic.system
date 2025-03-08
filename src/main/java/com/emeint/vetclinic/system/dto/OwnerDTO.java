package com.emeint.vetclinic.system.dto;

import com.emeint.vetclinic.system.Constants.Gender;
import com.emeint.vetclinic.system.model.Owner;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class OwnerDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotBlank(message = "Address is required")
    private String address;

    public static OwnerDTO fromEntity(Owner owner) {
        OwnerDTO dto = new OwnerDTO();
        dto.setId(owner.getId());
        dto.setName(owner.getName());
        dto.setEmail(owner.getEmail());
        dto.setPhone(owner.getPhone());
        dto.setGender(owner.getGender());
        dto.setAddress(owner.getAddress());
        return dto;
    }

    public Owner toEntity() {
        Owner owner = new Owner();
        owner.setName(this.name);
        owner.setEmail(this.email);
        owner.setPhone(this.phone);
        owner.setGender(this.gender);
        owner.setAddress(this.address);
        return owner;
    }
}

