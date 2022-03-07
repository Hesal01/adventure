DROP TABLE IF EXISTS rarities;

CREATE TABLE rarities (
                id serial PRIMARY KEY NOT NULL,
                name varchar NOT NULL,
                color varchar NOT NULL

);

ALTER TABLE rarities
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO rarities (id, name, color) values (1, 'COMMUN', 'gray');
INSERT INTO rarities (id, name, color) values (2, 'RARE', 'blue');
INSERT INTO rarities (id, name, color) values (3, 'EPIQUE', 'yellow');

ALTER TABLE items
    ADD CONSTRAINT fk_rarity FOREIGN KEY(rarity_id) references rarities(id);