create table role
(
    id   bigint not null auto_increment primary key,
    role varchar(255) not null
);

INSERT INTO role (id,
                  role)
VALUES (1, 'ADMIN'),
       (2, 'USER');
