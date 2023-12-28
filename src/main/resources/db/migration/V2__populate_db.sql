-- Add clients
INSERT INTO Client (name)
VALUES
    ('Bruce Wayne'),
    ('Diana Prince'),
    ('Barry Allen'),
    ('Wally West'),
    ('Arthur Curry'),
    ('Oliver Queen'),
    ('John Constantine'),
    ('Billy Batson'),
    ('Kara Zor-El'),
    ('Kyle Rayner');

-- Add planets
INSERT INTO Planet (id, name)
VALUES
    ('EAR', 'Earth'),
    ('KRY', 'Krypton'),
    ('ATL', 'Atlantis'),
    ('RAN', 'Rann'),
    ('XAN', 'Xanador');

-- Add tickets
INSERT INTO Ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'EAR', 'ATL'),
    (1, 'ATL', 'RAN'),
    (2, 'EAR', 'KRY'),
    (3, 'KRY', 'ATL'),
    (4, 'RAN', 'EAR'),
    (5, 'ATL', 'XAN'),
    (6, 'XAN', 'ATL'),
    (7, 'KRY', 'XAN'),
    (7, 'XAN', 'RAN'),
    (7, 'RAN', 'EAR');


