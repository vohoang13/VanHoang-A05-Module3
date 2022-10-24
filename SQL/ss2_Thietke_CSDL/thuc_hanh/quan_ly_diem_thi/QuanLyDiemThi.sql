CREATE TABLE HocSinh(
	MaHS int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TenHS nvarchar(50) NOT NULL,
    NgaySinh Date,
    Lop varchar(10),
    GT varchar(5)
);

CREATE TABLE GiaoVien(
	MaGV int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	TenGV nvarchar(50) NOT NULL,
    SDT int(10)
);

CREATE TABLE MonHoc(
	MaMH int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TenMH nvarchar(50),
    MaGV int, FOREIGN KEY(MaGV)REFERENCES GiaoVien(MaGV)
);

CREATE TABLE BangDiem(
	MaMH int NOT NULL,
    MaHS int NOT NULL,
    DiemThi float,
    NgayKT DateTime,
    PRIMARY KEY(MaMH,MaHS),
    FOREIGN KEY(MaMH)REFERENCES MonHoc(MaMH),
    FOREIGN KEY(MaHS)REFERENCES HocSinh(MaHS)
);

SELECT * FROM hocsinh;