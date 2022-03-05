DROP TABLE IF EXISTS locations;

CREATE TABLE locations (
                id serial PRIMARY KEY NOT NULL,
                name varchar NOT NULL,
                checkpoint boolean NOT NULL,
                area_id bigint NOT NULL,
                constraint fk_area FOREIGN KEY(area_id) references areas(id)

);

ALTER TABLE locations
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO locations (id, name, checkpoint, area_id) values (1, 'La lisière de la forêt', false, 1);
INSERT INTO locations (id, name, checkpoint, area_id) values (2, 'Pont-Sur-Eaux', false, 1);
INSERT INTO locations (id, name, checkpoint, area_id) values (3, 'La clairière', true, 1);