DROP TABLE IF EXISTS role;

create table role
(
    id   BIGINT not null  PRIMARY KEY AUTO_INCREMENT,
    role varchar(255) not null
);

INSERT INTO role (id,
                  role)
VALUES (1, 'ADMIN'),
       (2, 'USER');
