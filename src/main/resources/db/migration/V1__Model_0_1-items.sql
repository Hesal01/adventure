DROP TABLE IF EXISTS items;

CREATE TABLE items (
                       id serial PRIMARY KEY not null,
                       title varchar NOT NULL,
                       drop_per_ten_thousand bigint NOT NULL,
                       rarity_id bigint NOT NULL DEFAULT 1
);

CREATE SEQUENCE adventure_id_seq MINVALUE 1000000;

ALTER TABLE items
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO items (id, title, drop_per_ten_thousand, rarity_id) values (1, 'Pomme', 8000, 1);
INSERT INTO items (id, title, drop_per_ten_thousand, rarity_id) values (2, 'Poire', 7000, 1);
INSERT INTO items (id, title, drop_per_ten_thousand, rarity_id) values (3, 'Noix', 2000, 2);
INSERT INTO items (id, title, drop_per_ten_thousand, rarity_id) values (4, 'Baies rouges', 1000, 2);
INSERT INTO items (id, title, drop_per_ten_thousand, rarity_id) values (5, 'Menthe', 10, 3);