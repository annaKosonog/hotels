DROP TABLE IF EXISTS room;

create table room
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT not null,
    bed      varchar(255)                      not null,
    capacity varchar(255)                      not null,
    type     varchar(255)                      not null
);
INSERT INTO room (bed, capacity, type)
VALUES ('single', 1, 'single'),
       ('double', 2, 'superior'),
       ('double', 2, 'apartment');
