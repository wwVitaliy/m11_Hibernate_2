-- Create tables
CREATE TABLE Client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL
        CHECK (LENGTH(name) >= 3)
);

CREATE TABLE Planet (
    id VARCHAR PRIMARY KEY
        CHECK (id ~ '^[A-Z]+$'),
    name VARCHAR(500) NOT NULL
        CHECK (LENGTH(name) >= 1)
);

CREATE TABLE Ticket (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT (now() AT TIME ZONE 'UTC'),
    client_id bigint REFERENCES Client(id),
    from_planet_id VARCHAR REFERENCES Planet(id),
    to_planet_id VARCHAR REFERENCES Planet(id)
);