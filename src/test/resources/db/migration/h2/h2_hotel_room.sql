DROP TABLE IF EXISTS hotel_room;

create table hotel_room
(
    hotel_id BIGINT not null,
    room_id  BIGINT not null
);

INSERT INTO hotel_room (hotel_id, room_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 2),
       (3, 3),
       (4, 2),
       (5, 2),
       (5, 3);
