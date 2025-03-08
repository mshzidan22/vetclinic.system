package com.emeint.vetclinic.system.repository;

import com.emeint.vetclinic.system.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    List<Doctor> findByClinicId(Long clinicId);
}
