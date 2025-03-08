package com.emeint.vetclinic.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Address is required")
    private String address;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?20\\d{9}$|^0020\\d{9}$", message = "Phone number must be a valid [Egyptian numbers only]")
    private String phone;

    @Column(nullable = false)
    @NotBlank(message = "Working days and hours are required")
    private String workingDaysAndHours;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @ElementCollection
    private List<String> socialNetworks = new ArrayList<>();

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Doctor> doctors = new ArrayList<>();
}
