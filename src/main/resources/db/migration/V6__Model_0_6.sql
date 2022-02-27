DROP TABLE IF EXISTS locations;

CREATE TABLE locations (
                id serial PRIMARY KEY NOT NULL,
                name varchar NOT NULL,
                area_id bigint NOT NULL,
                constraint fk_area FOREIGN KEY(area_id) references areas(id)

);

ALTER TABLE locations
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO locations (id, name, area_id) values (1, 'La lisière de la forêt', 1);