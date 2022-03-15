DROP TABLE IF EXISTS areas;

CREATE TABLE areas (
                id serial PRIMARY KEY NOT NULL,
                name varchar NOT NULL,
                start_location bigint DEFAULT 1
);

ALTER TABLE areas
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO areas (id, name) values (1, 'Le Faubourg');