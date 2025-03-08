package com.emeint.vetclinic.system.dto;

import com.emeint.vetclinic.system.Constants.AnimalKind;
import com.emeint.vetclinic.system.Constants.Gender;
import com.emeint.vetclinic.system.model.Owner;
import com.emeint.vetclinic.system.model.Pet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PetDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Animal kind is required")
    private AnimalKind animalKind;

    @Positive(message = "Weight must be a positive number")
    private Double weight;
    @NotNull(message = "Owner ID is required")
    private Long ownerId;

    private List<String> imageUrls;

    public static PetDTO fromEntity(Pet pet) {
        PetDTO dto = new PetDTO();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setGender(pet.getGender());
        dto.setDateOfBirth(pet.getDateOfBirth());
        dto.setAnimalKind(pet.getAnimalKind());
        dto.setWeight(pet.getWeight());

        if (pet.getPhotos() != null) {
            dto.setImageUrls(new ArrayList<>(pet.getPhotos()));
        }

        if (pet.getOwner() != null) {
            dto.setOwnerId(pet.getOwner().getId());
        }

        return dto;
    }

    public static Pet toEntity(PetDTO dto, Owner owner) {
        Pet pet = new Pet();
        pet.setId(dto.getId());
        pet.setName(dto.getName());
        pet.setGender(dto.getGender());
        pet.setDateOfBirth(dto.getDateOfBirth());
        pet.setAnimalKind(dto.getAnimalKind());
        pet.setWeight(dto.getWeight());
        pet.setOwner(owner);
        return pet;
    }
}