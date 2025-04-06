# 🚗 Sistema de Gestión de Parqueo

Proyecto final desarrollado con **Spring Boot**, que implementa una API REST y una interfaz web básica para gestionar el ingreso y salida de vehículos en un parqueo.

## 📌 Objetivo

El propósito del proyecto es demostrar el uso del patrón **MVC** y herramientas del ecosistema de Spring como:

- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Base de datos MySQL

Además, el sistema implementa operaciones **CRUD** sobre una entidad `Vehículo`, captura de errores, uso de modelos y consumo sencillo a una base de datos.

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap 5

---

## 📦 Funcionalidades

- Registrar un nuevo vehículo (hora de entrada automática).
- Mostrar todos los vehículos estacionados.
- Marcar la hora de salida de un vehículo.
- Validación por horario: solo se permite ingresar vehículos entre las 7:00 a.m. y las 9:00 p.m.
- Visualización de tipo y color del vehículo.
- Captura básica de errores al cargar datos o registrar vehículos.

---

## ⚙️ Configuración del proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/tuusuario/sistema-parqueo.git
cd sistema-parqueo
```

### 2. Configurar la base de datos

Asegúrate de tener MySQL instalado y crear una base de datos llamada `parkingApp`:

```sql
CREATE DATABASE parkingApp;
```

Luego, ejecuta el script que se encuentra en [`src/main/resources/script.sql`](src/main/resources/script.sql) para crear las tablas necesarias y cargar datos iniciales (colores y tipos de vehículos).

### 3. Configura `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/parkingApp
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
```

### 4. Ejecutar el proyecto

Puedes ejecutar el proyecto desde tu IDE o con Maven:

```bash
./mvnw spring-boot:run
```

---

## 🧪 Endpoints principales

| Método | Ruta                           | Descripción                      |
|--------|--------------------------------|----------------------------------|
| GET    | `/park-station/menu`          | Menú principal                   |
| GET    | `/park-station/display`       | Mostrar todos los vehículos     |
| GET    | `/park-station/add`           | Formulario para nuevo vehículo  |
| POST   | `/park-station/new-vehicle-form` | Guardar nuevo vehículo       |
| POST   | `/park-station/mark-exit/{id}`  | Registrar salida del vehículo |

---

## 🗃️ Estructura del proyecto

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
   └──templates
      │   ├── menu.html
      │   ├── addVehicles.html
      │   └── showVehicles.html
      └─ script.sql
```
---

## 📚 Autor

**María José Girón Isidro**  
Desarrollado como parte del curso en **INTECAP**.

---
