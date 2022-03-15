DROP TABLE IF EXISTS characters;

CREATE TABLE characters (
                       character_id serial PRIMARY KEY NOT NULL,
                       health bigint NOT NULL,
                       max_health bigint NOT NULL,
                       strength bigint NOT NULL,
                       defense bigint NOT NULL,
                       agility bigint NOT NULL,
                       user_id bigint NOT NULL,
                       current_location_id bigint NOT NULL DEFAULT 1,
                       constraint fk_user FOREIGN KEY(user_id) references users(id)
);

ALTER TABLE characters
    ALTER COLUMN character_id SET DEFAULT nextval('adventure_id_seq');

INSERT INTO characters (character_id, health, max_health, strength, defense, agility, user_id) values (1, 10, 10, 1, 0, 2, 1);