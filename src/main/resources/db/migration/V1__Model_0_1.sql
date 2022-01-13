DROP TABLE IF EXISTS films;

CREATE TABLE films (
                       id bigint PRIMARY KEY not null,
                       title       varchar NOT NULL
);

INSERT INTO films (id, title) values (1, 'film 1');