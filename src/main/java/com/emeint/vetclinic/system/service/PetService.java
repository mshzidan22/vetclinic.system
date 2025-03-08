package com.emeint.vetclinic.system.service;
import com.emeint.vetclinic.system.dto.PetDTO;
import com.emeint.vetclinic.system.exception.EntityNotFoundException;
import com.emeint.vetclinic.system.model.Owner;
import com.emeint.vetclinic.system.model.Pet;
import com.emeint.vetclinic.system.repository.PetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepo petRepo;
    private final OwnerService ownerService;
    private final ImageService imageService;

    public PetDTO createPet(PetDTO petDTO, List<MultipartFile> images) {
        Owner owner = ownerService.getOwnerById(petDTO.getOwnerId());

        Pet pet = PetDTO.toEntity(petDTO, owner);
        pet.setPhotos(saveImages(images));

        Pet savedPet = petRepo.save(pet);
        return PetDTO.fromEntity(savedPet);
    }

    private List<String> saveImages(List<MultipartFile> images) {
        if (images == null || images.isEmpty()) return List.of();

        return images.stream()
                .map(file -> {
                    try {
                        return imageService.saveImage(file);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to save image", e);
                    }
                })
                .collect(Collectors.toList());
    }


    public PetDTO getPetById(Long id) {
        Pet pet = petRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found with ID: " + id));
        return PetDTO.fromEntity(pet);
    }

    public List<PetDTO> getAllPets() {
        return petRepo.findAll().stream()
                .map(PetDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Pet getPetEntityById(Long id) {
        return petRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found with ID: " + id));
    }
}