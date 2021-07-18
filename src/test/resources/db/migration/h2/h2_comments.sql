DROP TABLE IF EXISTS comments;

create table comments
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    comfort          int          not null,
    content          varchar(255) not null,
    create_date_time datetime     not null,
    facilities       int          not null,
    free_wi_fi       int          not null,
    purity           int          not null,
    location         int          not null,
    staff            int          not null,
    update_date_time datetime     not null,
    value_for_money  int          not null,
    user_app         bigint       not null
);

INSERT INTO comments (comfort, content, create_date_time, facilities, free_wi_fi, location, purity,
                      staff, update_date_time, value_for_money, user_app)
VALUES (5, 5, '2021-01-03 19:43:48', 5, 5, 5, 5, 5, '2021-03-21 21:12:25' , 5, 1),
       (5, 5, '2021-05-02 21:12:25', 5, 5, 5, 5, 5, '2021-01-10 15:25:33', 5, 1),
       (5, 5, '2021-03-25 08:12:56', 5, 5, 5, 5, 5, '2021-12-24 21:12:25', 5, 2);


