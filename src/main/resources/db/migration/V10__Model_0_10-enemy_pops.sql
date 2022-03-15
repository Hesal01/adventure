DROP TABLE IF EXISTS enemy_pops;

CREATE TABLE enemy_pops (
                       location_id bigint REFERENCES locations(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       enemy_id bigint REFERENCES enemies(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       constraint enemy_location_pkey PRIMARY KEY (location_id, enemy_id)
);

INSERT INTO enemy_pops (location_id, enemy_id) values (2, 1);
INSERT INTO enemy_pops (location_id, enemy_id) values (2, 3);
INSERT INTO enemy_pops (location_id, enemy_id) values (3, 2);
INSERT INTO enemy_pops (location_id, enemy_id) values (3, 4);
INSERT INTO enemy_pops (location_id, enemy_id) values (4, 2);
INSERT INTO enemy_pops (location_id, enemy_id) values (4, 3);
INSERT INTO enemy_pops (location_id, enemy_id) values (4, 5);
