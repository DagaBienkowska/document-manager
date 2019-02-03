insert into roles values (1, 'Admin');
insert into roles values (2, 'Moderator');
insert into roles values (3, 'User');

insert into users values (1, 'froggy', 'qazwsxedc', 'active', 'zabiasta', 'zaba');

insert into user_role values (1, 1);
insert into user_role values (1, 2);
insert into user_role values (1, 3);