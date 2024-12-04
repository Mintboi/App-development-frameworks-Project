Assignment-ChatGPT: Pet and Household Management Application
This project is a Spring Boot application that manages pet and household data. It provides a RESTful API and GraphQL endpoints for CRUD operations and is secured using Spring Security.

Features
REST API for CRUD operations on pets and households.
GraphQL support for querying and mutating data.
Validation using @Valid annotations for data integrity.
Aspect-Oriented Programming (AOP) for logging service layer methods.
Role-based security using Spring Security with flexible role management.
Modular architecture with clear separation of concerns across controllers, services, and repositories.
Project Structure
1. Entities
Pet and Household represent the data models, with a one-to-many relationship.
Each entity is mapped to a database table using JPA.
2. DTOs
Java records (PetDTO, HouseholdDTO) are used to transfer data between layers.
3. Repositories
PetRepository and HouseholdRepository extend JpaRepository for CRUD operations.
