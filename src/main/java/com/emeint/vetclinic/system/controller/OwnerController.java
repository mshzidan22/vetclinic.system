package com.emeint.vetclinic.system.controller;


import com.emeint.vetclinic.system.dto.OwnerDTO;
import com.emeint.vetclinic.system.dto.PetDTO;
import com.emeint.vetclinic.system.model.Owner;
import com.emeint.vetclinic.system.model.Pet;
import com.emeint.vetclinic.system.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@Valid @RequestBody OwnerDTO ownerDTO) {
        Owner savedOwner = ownerService.createOwner(ownerDTO.toEntity());
        return ResponseEntity.ok(OwnerDTO.fromEntity(savedOwner));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id) {
        Owner owner = ownerService.getOwnerById(id);
        return ResponseEntity.ok(OwnerDTO.fromEntity(owner));
    }

    @GetMapping("/{ownerId}/pets")
    public ResponseEntity<List<PetDTO>> getPetsByOwnerId(@PathVariable Long ownerId) {
        List<Pet> pets = ownerService.getPetsByOwnerId(ownerId);
        return ResponseEntity.ok(pets.stream().map(PetDTO::fromEntity).toList());
    }
}