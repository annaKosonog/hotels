DROP TABLE IF EXISTS hotel_review;

create table hotel_review
(
    hotel_id    BIGINT not null,
    comments_id bigint not null
);

INSERT INTO hotel_review (hotel_id,
                          comments_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (3, 2),
       (2, 2);

