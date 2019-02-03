insert into roles values (1, 'Admin');
insert into roles values (2, 'Moderator');
insert into roles values (3, 'User');

insert into users values (1, 'froggy', '$2a$10$StzSIoHQa0cvdCe5l7nF8uiy6FfA30La55JWJBAqYuFehpQn8S.X.', 'active', 'zabiasta', 'zaba');

insert into user_role values (1, 1);
insert into user_role values (1, 2);
insert into user_role values (1, 3);