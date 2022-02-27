DROP TABLE IF EXISTS inventories;

CREATE TABLE inventories (
                       character_id bigint REFERENCES characters(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       item_id bigint REFERENCES items(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       amount numeric not null default 1,
                       constraint characters_items_pkey PRIMARY KEY (character_id, item_id)
);

INSERT INTO inventories (character_id, item_id) values (10000000, 10000000);