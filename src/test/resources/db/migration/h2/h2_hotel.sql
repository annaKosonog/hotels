DROP TABLE IF EXISTS hotel;

create table hotel
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    country          varchar(255) not null,
    create_date_time datetime     not null,
    partner_code     varchar(36)  null,
    rate             int          not null,
    title            varchar(255) not null,
    update_date_time datetime     null
);
INSERT INTO hotel (id,country, create_date_time, partner_code, rate, title, update_date_time)
VALUES (1,'Poland', '2021-06-20 22:29:03', 'a372b512-9a48-4107-8d4e-3fbc3fa22ccd', 5,
        'EnergyLandia', '2021-06-20 22:29:03'),
       (3,'Poland', '2021-06-20 22:29:46', 'd36b7579-39ff-488d-8551-d811c4f1c0b9', 5, 'Sobieski Hotel',
        '2021-06-20 22:29:46'),
       (4,'Hungary', '2021-06-20 22:30:54', '0b25d2b9-5573-4d38-a81f-de982bb554b6', 4, 'Hotel Clark Budapest',
        '2021-06-20 22:30:54'),
       (5,'Deutschland', '2021-06-20 22:31:18', '5578b39c-f59b-4635-8c2a-d592008703f8', 3, 'Hitler Resort Hotel',
        '2021-06-20 22:31:18'),
       (21,'Poland', '2021-06-21 21:52:08', 'e07d0943-31c1-493f-ab2b-e6fc384f1757', 3, 'Hotel Liberum',
        '2021-06-21 21:52:08');


