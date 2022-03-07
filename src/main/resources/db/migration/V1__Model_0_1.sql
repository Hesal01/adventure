DROP TABLE IF EXISTS items;

CREATE TABLE items (
                       id serial PRIMARY KEY not null,
                       title varchar NOT NULL,
                       rarity_id bigint NOT NULL DEFAULT 1
);

CREATE SEQUENCE adventure_id_seq MINVALUE 1000000;

ALTER TABLE items
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO items (id, title) values (1, 'Panier en osier');