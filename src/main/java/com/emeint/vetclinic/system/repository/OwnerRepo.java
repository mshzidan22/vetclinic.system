package com.emeint.vetclinic.system.repository;

import com.emeint.vetclinic.system.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Long> {
}
