DROP TABLE IF EXISTS user;
create table user
(
    id        bigint       not null auto_increment primary key,
    active    int          not null,
    email     varchar(255) not null,
    last_name varchar(255) not null,
    name      varchar(255) not null,
    password  varchar(255) not null
);

INSERT INTO user (active, email, last_name, name, password)
VALUES (1, 'wujek@wp.pl', 'Kurka', 'Wlodzimierz', '123'),
       (1, 'ciocia@wp.pl', 'Borowik', 'Natalia', 'admin');

