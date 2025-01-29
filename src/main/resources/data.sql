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


-- Insertar datos de prueba para la tabla itineray
INSERT INTO itinerary (id, local_departure_time, local_departure_date, local_arrival_time, local_arrival_date, id_origin, id_destini)
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

INSERT INTO flight (id, capacity_seats, booked_seats, id_itinerary, airplane_model, flight_number) VALUES
(1, 180, 10, 1, 'Boeing 777', 'AA101'),
(2, 200, 10, 2, 'Airbus A380', 'BA202'),
(3, 160, 10, 3, 'Boeing 787', 'JL303'),
(4, 220, 10, 4, 'Boeing 737', 'DL404'),
(5, 250, 10, 5, 'Airbus A350', 'AF505'),
(6, 190, 10, 6, 'Boeing 767', 'LH606'),
(7, 210, 10, 7, 'Boeing 747', 'UA707'),
(8, 170, 10, 8, 'Airbus A320', 'VS808'),
(9, 230, 10, 9, 'Boeing 737 MAX', 'AC909'),
(10, 260, 10, 10, 'Boeing 777X', 'QF1010');

INSERT INTO roles (id, role) VALUES (1, 'ROLE_CUSTOMER');
INSERT INTO roles (id, role) VALUES (2, 'ROLE_ADMIN');

INSERT INTO users (id, username, password) VALUES
(1, 'admin', '$2a$10$N9qo8uLOickgx2ZMRZo5i.PU.BxRNOEFA9mFo5iERlA0jVJjT9b2K'), -- 1234
(2, 'cliente', '$2a$10$N9qo8uLOickgx2ZMRZo5i.PU.BxRNOEFA9mFo5iERlA0jVJjT9b2K'); -- 1234

INSERT INTO roles_users (user_id, role_id) VALUES
(1, 2), -- admin -> ROLE_ADMIN
(2, 1); -- cliente -> ROLE_CUSTOMER


