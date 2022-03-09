DROP TABLE IF EXISTS drops;

CREATE TABLE drops (
                       location_id bigint REFERENCES locations(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       item_id bigint REFERENCES items(id) ON UPDATE CASCADE ON DELETE CASCADE,
                       constraint items_locations_pkey PRIMARY KEY (location_id, item_id)
);

INSERT INTO drops (location_id, item_id) values (1, 1);
INSERT INTO drops (location_id, item_id) values (1, 3);
INSERT INTO drops (location_id, item_id) values (2, 2);
INSERT INTO drops (location_id, item_id) values (2, 4);
INSERT INTO drops (location_id, item_id) values (3, 2);
INSERT INTO drops (location_id, item_id) values (3, 3);
INSERT INTO drops (location_id, item_id) values (3, 5);
