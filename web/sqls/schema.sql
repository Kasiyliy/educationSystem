create table roles
(
    id   bigint unsigned auto_increment primary key,
    name varchar(255)
);

create table users
(
    id       bigint unsigned auto_increment primary key,
    username varchar(255) unique not null,
    password varchar(255)        not null,
    role_id  bigint unsigned     not null,
    active   boolean default 1,
    constraint fk_users_roles foreign key (role_id) references
        roles (id) on update restrict on delete restrict
) ENGINE InnoDB;
create table courses
(
    id          bigint unsigned auto_increment primary key,
    title       varchar(255) not null,
    description text         null,
    visible     boolean      default 0,
    active      boolean      default 1,
    like_count  int unsigned default 0
) ENGINE InnoDB;

create table likes
(
    course_id bigint unsigned not null,
    user_id   bigint unsigned not null,
    CONSTRAINT unique_likes UNIQUE (course_id, user_id),
    constraint fk_likes_courses foreign key (course_id) references courses (id)
        on UPDATE restrict on delete restrict,
    constraint fk_likes_users foreign key (user_id) references users (id)
        on UPDATE restrict on delete restrict
) ENGINE InnoDB;

create table lessons
(
    id          bigint unsigned auto_increment primary key,
    title       varchar(255)    not null,
    description text            null,
    course_id   bigint unsigned not null,
    ordering    int unsigned    null,
    active      boolean default 1,
    constraint fk_lessons_courses foreign key (course_id) references
        courses (id) on update restrict on delete restrict

) ENGINE InnoDB;

create table accesses
(
    course_id bigint unsigned not null,
    user_id   bigint unsigned not null,
    CONSTRAINT unique_access UNIQUE (course_id, user_id),
    constraint fk_accesses_courses foreign key (course_id) references courses (id)
        on UPDATE restrict on delete restrict,
    constraint fk_accesses_users foreign key (user_id) references users (id)
        on UPDATE restrict on delete restrict
) ENGINE InnoDB;

