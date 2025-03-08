package com.emeint.vetclinic.system.repository;

import com.emeint.vetclinic.system.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet, Long> {
}
