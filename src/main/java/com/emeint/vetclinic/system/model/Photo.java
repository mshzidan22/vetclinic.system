package com.emeint.vetclinic.system.model;

//@Data
//@Entity
//public class Photo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    //It's not recommended to store the image data directly in the database, but it's done here for simplicity
//    @Lob
//    private byte[] imageData;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private EntityType entityType; // "PET", "DOCTOR", "CLINIC"
//
//    @Column(nullable = false)
//    private Long entityId; // ID of the related entity
//}