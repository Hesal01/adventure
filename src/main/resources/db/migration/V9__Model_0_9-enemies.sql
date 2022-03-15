DROP TABLE IF EXISTS enemies;

CREATE TABLE enemies (
                       id serial PRIMARY KEY NOT NULL,
                       name varchar NOT NULL,
                       health bigint NOT NULL,
                       max_health bigint NOT NULL,
                       strength bigint NOT NULL,
                       defense bigint NOT NULL,
                       agility bigint NOT NULL,
                       pop_per_ten_thousand bigint NOT NULL
);

ALTER TABLE enemies
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO enemies (id, name, health, max_health, strength, defense, agility, pop_per_ten_thousand) values (1, 'Chat des bois', 5, 5, 2, 0, 3, 10000);
INSERT INTO enemies (id, name, health, max_health, strength, defense, agility, pop_per_ten_thousand) values (2, 'Serpent strié', 3, 3, 1, 2, 5, 10000);
INSERT INTO enemies (id, name, health, max_health, strength, defense, agility, pop_per_ten_thousand) values (3, 'Cerf aux bois', 8, 8, 2, 3, 2, 10000);
INSERT INTO enemies (id, name, health, max_health, strength, defense, agility, pop_per_ten_thousand) values (4, 'Ecureil gourmand', 2, 2, 5, 1, 2, 10000);
INSERT INTO enemies (id, name, health, max_health, strength, defense, agility, pop_per_ten_thousand) values (5, 'Hibou pas chouette', 3, 3, 1, 0, 1, 10000);
