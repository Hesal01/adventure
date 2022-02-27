DROP TABLE IF EXISTS items;

CREATE TABLE items (
                       id serial PRIMARY KEY not null,
                       title       varchar NOT NULL
);

CREATE SEQUENCE adventure_id_seq;

ALTER TABLE items
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO items (id, title) values (10000000, 'Panier en osier');