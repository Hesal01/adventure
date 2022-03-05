DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id serial PRIMARY KEY NOT NULL,
                       username VARCHAR NOT NULL UNIQUE,
                       password VARCHAR NOT NULL,
                       role VARCHAR NOT NULL
);

ALTER TABLE users
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO users (id, username, password, role) values (1, 'test', 'passwordtest', 'ADMIN');