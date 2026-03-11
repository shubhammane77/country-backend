
INSERT INTO countries (id, name) VALUES (1, 'USA');
INSERT INTO countries (id, name) VALUES (2, 'France');
INSERT INTO countries (id, name) VALUES (3, 'Brazil');
INSERT INTO countries (id, name) VALUES (4, 'Italy');
INSERT INTO countries (id, name) VALUES (5, 'Canada');



-- USA
INSERT INTO cities (id, name, country_id) VALUES (1, 'New York', 1);
INSERT INTO cities (id, name, country_id) VALUES (2, 'Los Angeles', 1);
INSERT INTO cities (id, name, country_id) VALUES (3, 'Chicago', 1);
INSERT INTO cities (id, name, country_id) VALUES (4, 'Houston', 1);
INSERT INTO cities (id, name, country_id) VALUES (5, 'Miami', 1);

-- France
INSERT INTO cities (id, name, country_id) VALUES (6, 'Paris', 2);
INSERT INTO cities (id, name, country_id) VALUES (7, 'Lyon', 2);
INSERT INTO cities (id, name, country_id) VALUES (8, 'Marseille', 2);
INSERT INTO cities (id, name, country_id) VALUES (9, 'Nice', 2);
INSERT INTO cities (id, name, country_id) VALUES (10, 'Toulouse', 2);

-- Brazil
INSERT INTO cities (id, name, country_id) VALUES (11, 'São Paulo', 3);
INSERT INTO cities (id, name, country_id) VALUES (12, 'Rio de Janeiro', 3);
INSERT INTO cities (id, name, country_id) VALUES (13, 'Brasília', 3);
INSERT INTO cities (id, name, country_id) VALUES (14, 'Salvador', 3);
INSERT INTO cities (id, name, country_id) VALUES (15, 'Fortaleza', 3);

-- Italy
INSERT INTO cities (id, name, country_id) VALUES (16, 'Rome', 4);
INSERT INTO cities (id, name, country_id) VALUES (17, 'Milan', 4);
INSERT INTO cities (id, name, country_id) VALUES (18, 'Naples', 4);
INSERT INTO cities (id, name, country_id) VALUES (19, 'Turin', 4);
INSERT INTO cities (id, name, country_id) VALUES (20, 'Florence', 4);

-- Canada
INSERT INTO cities (id, name, country_id) VALUES (21, 'Toronto', 5);
INSERT INTO cities (id, name, country_id) VALUES (22, 'Vancouver', 5);
INSERT INTO cities (id, name, country_id) VALUES (23, 'Montreal', 5);
INSERT INTO cities (id, name, country_id) VALUES (24, 'Calgary', 5);
INSERT INTO cities (id, name, country_id) VALUES (25, 'Ottawa', 5);