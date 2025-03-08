package com.emeint.vetclinic.system.model;

import com.emeint.vetclinic.system.Constants.AnimalKind;
import com.emeint.vetclinic.system.Constants.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AnimalKind animalKind;

    @ElementCollection
    private List<String> photos;

    @Column(nullable = false)
    @Positive(message = "Weight must be positive")
    private Double weight;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
}
