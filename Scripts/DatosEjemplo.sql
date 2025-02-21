use vinos;

INSERT INTO regiones (nombre, region) VALUES
('La Rioja', 'Norte de España'),
('Bordeaux', 'Suroeste de Francia');

-- Insertar datos de ejemplo en bodegas
INSERT INTO bodegas (nombre, ubicacion, anho_establecimiento, region_id) VALUES
('Bodega A', 'Haro', 1890, 1),
('Château B', 'Saint-Émilion', 1750, 2);

-- Insertar datos de ejemplo en vinos
INSERT INTO vinos (nombre, cantidad, bodega_id, variedad_uva, anho, precio, descripcion) VALUES
('Vino Tinto A', 100, 1, 'Tempranillo', 2018, 15.50, 'Un vino tinto con cuerpo y notas afrutadas.'),
('Vino Blanco B', 50, 2, 'Sauvignon Blanc', 2020, 25.00, 'Un vino blanco refrescante y bien equilibrado.');

-- Insertar datos de ejemplo en usuarios
INSERT INTO usuarios (nombre, email, fecha_registro) VALUES
('Juan Pérez', 'juan.perez@example.com', '2022-11-01'),
('María López', 'maria.lopez@example.com', '2023-01-10');

-- Insertar datos de ejemplo en resenhas
INSERT INTO resenhas (titulo, vino_id, texto, calificacion, fecha, usuario_id) VALUES
('Excelente Vino', 1, 'Excelente vino con notas afrutadas.', 5, '2023-01-15', 1),
('Refrescante y Equilibrado', 2, 'Muy refrescante y bien equilibrado.', 4, '2023-02-20', 2);