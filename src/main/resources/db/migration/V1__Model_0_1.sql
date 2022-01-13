DROP TABLE IF EXISTS items;

CREATE TABLE items (
                       id bigint PRIMARY KEY not null,
                       title       varchar NOT NULL
);

INSERT INTO items (id, title) values (1, 'Panier en osier');