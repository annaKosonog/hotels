create table room
(
    id       bigint       not null auto_increment primary key,
    bed      varchar(255) not null,
    capacity varchar(255) not null,
    type     varchar(255) not null
);

INSERT INTO room (id, bed, capacity, type)
VALUES (1,'single', 1, 'single'),
       (2,'double', 2, 'superior'),
       (3,'double', 2, 'apartment');
