package com.emeint.vetclinic.system.repository;

import com.emeint.vetclinic.system.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepo extends JpaRepository<Visit, Long> {
}
