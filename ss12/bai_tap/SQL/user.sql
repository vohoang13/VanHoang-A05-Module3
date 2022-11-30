create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 user_name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 constraint pk_id primary key(id)
);

DELIMITER //
create procedure findbyid (In id int)
begin 
	select * from users
    where users.id = id;
end //
DELIMITER ;

DELIMITER //
create procedure updatebyname (In username varchar(120), In email varchar(220), In country varchar(120))
begin 
	update users set 
    users.email = email,
    users.country = country
    where users.user_name like  username;
end //
DELIMITER ;

DELIMITER //
create procedure deleteuser (In username varchar(120))
begin 
	delete from users
    where users.user_name like username;
end //
DELIMITER ;


drop procedure updatebyName;
