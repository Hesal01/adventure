DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id bigint PRIMARY KEY not null,
                       username VARCHAR NOT NULL,
                       password VARCHAR NOT NULL,
                       role VARCHAR NOT NULL
);

INSERT INTO users (id, username, password, role) values (1, 'test', 'passwordtest', 'USER');