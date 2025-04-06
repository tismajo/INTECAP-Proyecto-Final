# 🚗 Parking Management System

Final project developed with **Spring Boot**, implementing a REST API and a basic web interface to manage the entry and exit of vehicles in a parking lot.

## 📌 Objective

The purpose of the project is to demonstrate the use of the **MVC** pattern and tools from the Spring ecosystem such as:

- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL Database

In addition, the system implements **CRUD** operations on a `Vehicle` entity, error handling, use of models, and simple interaction with a database.

---

## 🛠️ Technologies Used

- Java 24
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap 5

---

## 📦 Features

- Register a new vehicle (automatic entry time).
- Display all parked vehicles.
- Mark the exit time of a vehicle.
- Time-based validation: only allows vehicle entry between 7:00 a.m. and 9:00 p.m.
- Display vehicle type and color.
- Basic error handling when loading data or registering vehicles.

---

## ⚙️ Project Setup

### 1. Clone the repository

```bash
git clone https://github.com/youruser/parking-system.git
cd parking-system
```

### 2. Set up the database

Make sure you have MySQL installed and create a database named `parkingApp`:

```sql
CREATE DATABASE parkingApp;
```

Then, run the script found at [`src/main/resources/script.sql`](src/main/resources/script.sql) to create the necessary tables and load initial data (vehicle colors and types).

### 3. Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/parkingApp
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

### 4. Run the project

You can run the project from your IDE or with Maven:

```bash
./mvnw spring-boot:run
```

---

## 🧪 Main Endpoints

| Method | Route                            | Description                    |
|--------|----------------------------------|--------------------------------|
| GET    | `/park-station/menu`            | Main menu                      |
| GET    | `/park-station/display`         | Show all vehicles              |
| GET    | `/park-station/add`             | Form to add a new vehicle      |
| POST   | `/park-station/new-vehicle-form`| Save new vehicle               |
| POST   | `/park-station/mark-exit/{id}`  | Register vehicle exit          |

---

## 🗃️ Project Structure

```
├── Controller
│   └── VehicleController.java
├── Model
│   ├── VehicleModel.java
│   ├── ColorModel.java
│   └── TypeModel.java
├── Repository
│   ├── VehicleRepository.java
│   ├── ColorRepository.java
│   └── VehicleTypeRepository.java
└── resources
   └── templates
      ├── menu.html
      ├── addVehicles.html
      └── showVehicles.html
   └── script.sql
```

---

## 📚 Author

**María José Girón Isidro**  
Developed as part of a course at **INTECAP**.

--- 