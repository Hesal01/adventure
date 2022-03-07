DROP TABLE IF EXISTS items;

CREATE TABLE items (
                       id serial PRIMARY KEY not null,
                       title varchar NOT NULL,
                       drop_in_percent bigint NOT NULL,
                       rarity_id bigint NOT NULL DEFAULT 1
);

CREATE SEQUENCE adventure_id_seq MINVALUE 1000000;

ALTER TABLE items
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO items (id, title, drop_in_percent, rarity_id) values (1, 'Pomme', 80, 1);
INSERT INTO items (id, title, drop_in_percent, rarity_id) values (2, 'Poire', 70, 1);
INSERT INTO items (id, title, drop_in_percent, rarity_id) values (3, 'Noix', 20, 2);
INSERT INTO items (id, title, drop_in_percent, rarity_id) values (4, 'Baies rouges', 10, 2);
INSERT INTO items (id, title, drop_in_percent, rarity_id) values (5, 'Menthe', 0.1, 3);