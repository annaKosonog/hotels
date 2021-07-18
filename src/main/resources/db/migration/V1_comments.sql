create table comment
(
    id               bigint PRIMARY KEY AUTO_INCREMENT,
    comfort          int          not null,
    content          varchar(255) not null,
    create_date_time datetime     not null,
    facilities       int          not null,
    free_wi_fi       int          not null,
    location         int          not null,
    purity           int          not null,
    staff            int          not null,
    update_date_time datetime     not null,
    value_for_money  int          not null,
    user_app         bigint       not null
);

INSERT INTO comment (comfort, content, create_date_time, facilities, free_wi_fi, location, purity,
                                 staff, update_date_time, value_for_money, user_app)
VALUES (5, 5, 11 - 03 - 2021, 5, 5, 5, 5, 5, 21 - 03 - 2021, 5, 1),
       (5, 5, 10 - 03 - 2020, 5, 5, 5, 5, 5, 21 - 03 - 2021, 5, 1),
       (5, 5, 15 - 03 - 2018, 5, 5, 5, 5, 5, 11 - 03 - 2020, 5, 2);


