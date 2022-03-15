DROP TABLE IF EXISTS inventories;

CREATE TABLE inventories (
                       character_id bigint REFERENCES characters(character_id) ON UPDATE CASCADE ON DELETE CASCADE,
                       item_id bigint REFERENCES items(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       amount numeric not null,
                       constraint characters_items_pkey PRIMARY KEY (character_id, item_id)
);

INSERT INTO inventories (character_id, item_id, amount) values (1, 1, 1);
INSERT INTO inventories (character_id, item_id, amount) values (1, 2, 1);