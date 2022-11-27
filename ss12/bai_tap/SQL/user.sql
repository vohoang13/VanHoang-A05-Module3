create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 user_name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 constraint pk_id primary key(id)
);