package com.emeint.vetclinic.system.model;

import com.emeint.vetclinic.system.Constants.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(unique = true, nullable = false)
    @Email(message = "Email should be valid")
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?20\\d{9}$|^0020\\d{9}$", message = "Phone number must be a valid [Egyptian numbers only]")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    @NotBlank(message = "Address is required")
    private String address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Pet> pets = new ArrayList<>();
}
