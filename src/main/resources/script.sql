CREATE DATABASE parkingApp;
USE parkingApp;

-- Store vehicle colors
CREATE TABLE colors (
    c_id INT AUTO_INCREMENT PRIMARY KEY,
    c_name VARCHAR(50) NOT NULL UNIQUE
);

-- Types of vehicles
CREATE TABLE vehicle_types (
    vt_id INT AUTO_INCREMENT PRIMARY KEY,
    vt_name VARCHAR(50) NOT NULL UNIQUE
);

-- Table with the vehicles that use the parking service
CREATE TABLE vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    v_plate VARCHAR(6) NOT NULL UNIQUE,
    v_color INT NOT NULL,
    v_type INT NOT NULL,
    entrance_time DATETIME NOT NULL,
    exit_time DATETIME,
    FOREIGN KEY (v_color) REFERENCES colors(c_id),
    FOREIGN KEY (v_type) REFERENCES vehicle_types(vt_id)
);

-- Inerts for the types and colors
INSERT INTO vehicle_types (vt_name) VALUES 
('Automóvil'),
('Motocicleta'),
('Camioneta'),
('Camión'),
('SUV'),
('Pickup'),
('Bus'),
('Bicicleta');

INSERT INTO colors (c_name) VALUES 
('Rojo'),
('Azul'),
('Negro'),
('Blanco'),
('Gris'),
('Plateado'),
('Verde'),
('Amarillo');

select * from vehicles;
