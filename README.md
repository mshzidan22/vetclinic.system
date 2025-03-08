# Vet Clinic System

## Overview
This project is a **Vet Clinic System** implemented using **Spring Boot** and provides RESTful APIs for managing clinics, doctors, owners, pets, and visits.

## Technologies Used
- **Java** (Spring Boot)
- **H2** 
- **JPA** 
- **Lombok** 
- **Maven** 
- **Swagger** 

## Features
1. **CRUD Operations** for all entities: Pet, Owner, Clinic, Doctor, and Visit.
2. **List Operations**:
   - List all pets of an owner.
   - List all doctors in a clinic.
3. **Search Functionality**:
   - Search clinics by phone number or address.
4. **Doctor Management**:
   - Assign/de-assign a doctor to a clinic.
5. **Data Validation & Constraints**:
   - Unique constraints on relevant fields.
   - Proper validation on input fields (e.g., email, phone, etc.).

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/owners` | Create a new owner |
| `POST` | `/pets` | Create a new pet |
| `POST` | `/clinics` | Create a new clinic |
| `POST` | `/doctors` | Create a new doctor |
| `POST` | `/visits` | Create a new visit |
| `GET` | `/owners/{id}` | Get owner by ID |
| `GET` | `/pets/{id}` | Get pet by ID |
| `GET` | `/clinics/{id}` | Get clinic by ID |
| `GET` | `/doctors/{id}` | Get doctor by ID |
| `GET` | `/owners/{ownerId}/pets` | List all pets of an owner |
| `GET` | `/clinics/{clinicId}/doctors` | List all doctors in a clinic |
| `GET` | `/clinics/search?phone=xxx&address=yyy` | Search clinics by phone or address |
| `PUT` | `/clinics/{clinicId}/assign-doctor/{doctorId}` | Assign a doctor to a clinic |
| `PUT` | `/clinics/{clinicId}/deassign-doctor/{doctorId}` | De-assign a doctor from a clinic |

