DROP TABLE IF EXISTS hotel_room;

create table hotel_room
(
    hotel_id bigint not null,
    room_id  bigint not null
);

INSERT INTO hotel_room (hotel_id, room_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (3, 1),
       (3, 2),
       (3, 3),
       (4, 1),
       (4, 2),
       (5, 2),
       (5, 3),
       (21, 2),
       (21, 3);
