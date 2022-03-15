DROP TABLE IF EXISTS enemy_drops;

CREATE TABLE enemy_drops (
                       enemy_id bigint REFERENCES enemies(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       item_id bigint REFERENCES items(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       constraint items_enemy_pkey PRIMARY KEY (enemy_id, item_id)
);

INSERT INTO enemy_drops (enemy_id, item_id) values (1, 6);
INSERT INTO enemy_drops (enemy_id, item_id) values (1, 7);
INSERT INTO enemy_drops (enemy_id, item_id) values (2, 8);
INSERT INTO enemy_drops (enemy_id, item_id) values (3, 9);
INSERT INTO enemy_drops (enemy_id, item_id) values (4, 10);
INSERT INTO enemy_drops (enemy_id, item_id) values (5, 11);
