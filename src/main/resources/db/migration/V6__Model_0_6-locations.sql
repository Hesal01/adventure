DROP TABLE IF EXISTS locations;

CREATE TABLE locations
(
    id                        serial PRIMARY KEY NOT NULL,
    name                      varchar            NOT NULL,
    checkpoint                boolean            NOT NULL,
    next_location_main        bigint,
    next_location_secondary_1 bigint,
    next_location_secondary_2 bigint,
    next_location_secondary_3 bigint,
    next_location_secondary_4 bigint,
    next_location_secondary_5 bigint,
    area_id                   bigint             NOT NULL,
    constraint fk_area FOREIGN KEY (area_id) references areas (id)

);

ALTER TABLE locations
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO locations (id, name, checkpoint, next_location_main, area_id)
values (1, 'Le Faubourg', false, 2, 1);
INSERT INTO locations (id, name, checkpoint, next_location_main, area_id)
values (2, 'La Lisière de la forêt', false, 3, 1);
INSERT INTO locations (id, name, checkpoint, next_location_main, area_id)
values (3, 'Pont-Sur-Eaux', false, 4, 1);
INSERT INTO locations (id, name, checkpoint, next_location_main, area_id)
values (4, 'La Colline', false, 5, 1);
INSERT INTO locations (id, name, checkpoint, area_id)
values (5, 'La Clairière', true, 1);

UPDATE areas
SET start_location = 1
WHERE areas.id = 1;

ALTER TABLE characters
    ADD CONSTRAINT fk_location FOREIGN KEY (current_location_id) references locations (id);