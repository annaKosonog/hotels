DROP TABLE IF EXISTS user_role;

create table user_role
(
    user_id BIGINT not null,
    role_id bigint not null,
    primary key (user_id, role_id)
);

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 2);
