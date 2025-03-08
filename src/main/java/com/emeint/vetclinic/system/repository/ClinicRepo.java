package com.emeint.vetclinic.system.repository;

import com.emeint.vetclinic.system.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicRepo extends JpaRepository<Clinic, Long> {
    List<Clinic> findByPhoneContainingOrAddressContaining(String phone, String address);

}
