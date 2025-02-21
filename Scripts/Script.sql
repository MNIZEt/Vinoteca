

CREATE DATABASE IF NOT EXISTS vinos;
use vinos; 
CREATE TABLE regiones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre TEXT NOT NULL,
    region TEXT
);

CREATE TABLE bodegas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre TEXT NOT NULL,
    ubicacion TEXT,
    anho_establecimiento INT,
    region_id BIGINT,
    
    FOREIGN KEY (region_id) REFERENCES regiones(id)
);

CREATE TABLE vinos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre TEXT NOT NULL,
    cantidad INT,
    bodega_id BIGINT,
    variedad_uva TEXT,
    anho INT,
    precio DECIMAL(10, 2),
    descripcion TEXT,
    FOREIGN KEY (bodega_id) REFERENCES bodegas(id)
);

CREATE TABLE resenhas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) not null,
    vino_id BIGINT,
    texto TEXT,
    calificacion INT CHECK (calificacion >= 1 AND calificacion <= 5),
    fecha DATE,
    FOREIGN KEY (vino_id) REFERENCES vinos(id)
);



-- Crear tabla usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre TEXT NOT NULL,
    email VARCHAR(255) UNIQUE,
    fecha_registro DATE
);

-- Modificar la tabla reseñas_vinos_nuevas para incluir usuario_id
ALTER TABLE resenhas
ADD COLUMN usuario_id BIGINT,
ADD FOREIGN KEY (usuario_id) REFERENCES usuarios(id);


-- Actualizar datos de ejemplo en reseñas_vinos_nuevas para incluir usuario_id
UPDATE resenhas SET usuario_id = 1 WHERE id = 1;
UPDATE resenhas SET usuario_id = 2 WHERE id = 2;