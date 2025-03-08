package com.emeint.vetclinic.system.service;

import com.emeint.vetclinic.system.exception.EntityNotFoundException;
import com.emeint.vetclinic.system.model.Owner;
import com.emeint.vetclinic.system.model.Pet;
import com.emeint.vetclinic.system.repository.OwnerRepo;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepo ownerRepo;

    @Transactional
    public Owner createOwner(@NotNull Owner owner) {
        return ownerRepo.save(owner);
    }

    public Owner getOwnerById(@NotNull Long id) {
        return ownerRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Owner not found with ID: " + id));
    }

    public List<Pet> getPetsByOwnerId(@NotNull Long ownerId) {
        Owner owner = getOwnerById(ownerId);
        return owner.getPets();
    }
}