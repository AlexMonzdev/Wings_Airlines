-- Insertar datos de aeropuertos de origen
INSERT INTO origin (id, airport, city, cod_city) VALUES (1, 'John F. Kennedy International Airport', 'New York', 'JFK');
INSERT INTO origin (id, airport, city, cod_city) VALUES (2, 'Los Angeles International Airport', 'Los Angeles', 'LAX');
INSERT INTO origin (id, airport, city, cod_city) VALUES (3, 'Heathrow Airport', 'London', 'LHR');
INSERT INTO origin (id, airport, city, cod_city) VALUES (4, 'Charles de Gaulle Airport', 'Paris', 'CDG');
INSERT INTO origin (id, airport, city, cod_city) VALUES (5, 'Tokyo Haneda Airport', 'Tokyo', 'HND');

-- Insertar datos de aeropuertos de destino
INSERT INTO destiny (id, airport, city, cod_city) VALUES (1, 'Dubai International Airport', 'Dubai', 'DXB');
INSERT INTO destiny (id, airport, city, cod_city) VALUES (2, 'Changi Airport', 'Singapore', 'SIN');
INSERT INTO destiny (id, airport, city, cod_city) VALUES (3, 'Frankfurt Airport', 'Frankfurt', 'FRA');
INSERT INTO destiny (id, airport, city, cod_city) VALUES (4, 'Sydney Kingsford Smith Airport', 'Sydney', 'SYD');
INSERT INTO destiny (id, airport, city, cod_city) VALUES (5, 'Toronto Pearson International Airport', 'Toronto', 'YYZ');


-- Insertar datos de prueba para la tabla journey_plan
INSERT INTO journey_plan (id, local_departure_time, local_departurel_date, local_arrival_time, local_arrival_date, id_origin, id_destini)
VALUES
(1, '08:00:00', '2025-06-01', '12:30:00', '2025-06-01', 1, 2), -- Nueva York (JFK) -> Dubái (DXB)
(2, '10:15:00', '2025-06-02', '14:45:00', '2025-06-02', 3, 4), -- Londres (LHR) -> Sídney (SYD)
(3, '14:00:00', '2025-06-03', '18:25:00', '2025-06-03', 5, 1), -- Tokio (HND) -> Dubái (DXB)
(4, '09:30:00', '2025-06-04', '13:50:00', '2025-06-04', 2, 3), -- Los Ángeles (LAX) -> Frankfurt (FRA)
(5, '16:45:00', '2025-06-05', '21:10:00', '2025-06-05', 4, 5), -- París (CDG) -> Toronto (YYZ)
(6, '07:20:00', '2025-06-06', '11:55:00', '2025-06-06', 1, 3), -- Nueva York (JFK) -> Frankfurt (FRA)
(7, '12:10:00', '2025-06-07', '16:35:00', '2025-06-07', 2, 5), -- Los Ángeles (LAX) -> Toronto (YYZ)
(8, '18:50:00', '2025-06-08', '23:15:00', '2025-06-08', 3, 1), -- Londres (LHR) -> Nueva York (JFK)
(9, '05:30:00', '2025-06-09', '09:45:00', '2025-06-09', 4, 2), -- París (CDG) -> Los Ángeles (LAX)
(10, '11:00:00', '2025-06-10', '15:30:00', '2025-06-10', 5, 4); -- Tokio (HND) -> Sídney (SYD)


