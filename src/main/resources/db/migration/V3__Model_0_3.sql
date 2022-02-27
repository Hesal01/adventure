DROP TABLE IF EXISTS characters;

CREATE TABLE characters (
                       id serial PRIMARY KEY NOT NULL,
                       health bigint NOT NULL,
                       max_health bigint NOT NULL,
                       strength bigint NOT NULL,
                       defense bigint NOT NULL,
                       user_id bigint NOT NULL,
                       constraint fk_user FOREIGN KEY(user_id) references users(id)
);

ALTER TABLE characters
    ALTER COLUMN id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO characters (id, health, max_health, strength, defense, user_id) values (10000000, 10, 10, 0, 0, 10000000);