package com.emeint.vetclinic.system.controller;

import com.emeint.vetclinic.system.dto.PetDTO;
import com.emeint.vetclinic.system.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @PostMapping
    public ResponseEntity<PetDTO> createPet(
            @RequestPart("pet") PetDTO petDTO,
            @RequestPart(value = "images", required = false) List<MultipartFile> images) {

        PetDTO createdPet = petService.createPet(petDTO, images);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
        PetDTO pet = petService.getPetById(id);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPets() {
        List<PetDTO> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }
}
