-- user profile db
CREATE TABLE IF NOT EXISTS USER_PROFILE(
    id UUID primary key,
    first_name varchar(100) not null,
    last_name varchar(100),
    email varchar(100) not null
);
