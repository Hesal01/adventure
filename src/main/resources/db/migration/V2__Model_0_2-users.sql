DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id serial PRIMARY KEY NOT NULL,
                       username VARCHAR NOT NULL UNIQUE,
                       password VARCHAR NOT NULL,
                       role VARCHAR NOT NULL
);

ALTER TABLE users
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO users (id, username, password, role) values (1, 'test', '$2a$10$NAfv0ziMtVLaMlofXIlxq.2VC76CZr4XNkBc5ao0m/fHpwWo6d1kC', 'ADMIN');