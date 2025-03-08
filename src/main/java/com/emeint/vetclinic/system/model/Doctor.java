package com.emeint.vetclinic.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?20\\d{9}$|^0020\\d{9}$", message = "Phone number must be a valid [Egyptian numbers only]")
    private String phone;

    private String photo;

    @Column(length = 1000)
    @Size(max = 1000, message = "Bio must be at most 1000 characters")
    private String bio;

    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    @ToString.Exclude
    private Clinic clinic;
}
