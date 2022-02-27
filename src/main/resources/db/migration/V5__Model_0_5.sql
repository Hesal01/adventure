DROP TABLE IF EXISTS areas;

CREATE TABLE areas (
                id serial PRIMARY KEY NOT NULL,
                name varchar NOT NULL
);

ALTER TABLE areas
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO areas (id, name) values (10000000, 'Le Faubourg');