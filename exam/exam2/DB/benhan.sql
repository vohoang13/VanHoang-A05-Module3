create table benh_an(
	id_ba varchar(20) ,
    id_bn varchar(20),
    ngay_nhap_vien date,
    ngay_ra_vien date,
    ly_do varchar(150),
    constraint pk_id primary key (id_ba),
    constraint fk_id_bn foreign key(id_bn) references benh_nhan(id)
);

create table benh_nhan(
	id varchar(20),
    ten_benh_nhan varchar(120),
    constraint pk_id primary key(id)
);

drop table benh_nhan;