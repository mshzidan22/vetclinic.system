package com.emeint.vetclinic.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    @ToString.Exclude
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @ToString.Exclude
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    @ToString.Exclude
    private Clinic clinic;

    @FutureOrPresent(message = "Visit date must be in the present or future")
    private LocalDateTime date;
}