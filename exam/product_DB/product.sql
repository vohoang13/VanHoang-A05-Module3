create table category(
	category_id int,
    category_name varchar(50),
    constraint pk_id primary key(category_id)
);
create table product(
	product_id int unique not null auto_increment,
	product_name varchar(120),
    product_price float,
    amount int,
    color varchar(20),
    descriptions text,
	category_id int,
    constraint pk_pID primary key (product_id),
    constraint fk_cID foreign key(category_id) references category(category_id)
);
insert into category
values(1,"Phone");
insert into category
values(2,"TV");
insert into category
values(3,"Computer");
insert into product
values(1,'Iphone14',14000000,10,'pink','new 99%',1);


drop table product;

