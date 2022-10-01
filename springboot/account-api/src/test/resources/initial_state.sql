Drop table account_permission;
Drop table account_role;
Drop table permission;
Drop table role;
Drop table user_account;


create table permission
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table role
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);


create table user_account
(
    id       bigint auto_increment
        primary key,
    password varchar(255) null,
    username varchar(255) null,
    constraint UK_castjbvpeeus0r8lbpehiu0e4
        unique (username)
);

create table account_permission
(
    account_id    bigint not null,
    permission_id bigint not null,
    primary key (account_id, permission_id),
    constraint FK4pl4ktiq7hgfchxntsjyj4uco
        foreign key (permission_id) references permission (id),
    constraint FK7ihnumowwa622419guuj9vgsp
        foreign key (account_id) references user_account (id)
);

create table account_role
(
    account_id bigint not null,
    role_id    bigint not null,
    constraint FKiks5kpk3t1tu82w4cd0ol1pq1
        foreign key (account_id) references user_account (id),
    constraint FKrs2s3m3039h0xt8d5yhwbuyam
        foreign key (role_id) references role (id)
);

insert into user_account (id, password, username)
values (1,'$2a$10$9y0Ln5gfzf.xrBzVNWxAP.9m3xPSnDTwTphtDitpMN6fBaY5rVglO','testdev1664407134797');

insert into role (id, name) values (1,'ROLE_ADMIN');
insert into permission (id, name) values (1,'user_account:read');
insert into permission (id, name) values (2,'user_account:write');
insert into permission (id, name) values (3,'user_account:update');

insert INTO account_role (account_id, role_id) VALUES (1,1);
insert INTO account_permission (account_id, permission_id) VALUES (1,1);
insert INTO account_permission (account_id, permission_id) VALUES (1,2);