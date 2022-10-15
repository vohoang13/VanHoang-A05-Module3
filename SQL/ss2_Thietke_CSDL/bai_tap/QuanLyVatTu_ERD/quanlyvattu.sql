Create Table PHIEUXUAT(
	SoPX Int Not Null Primary Key Auto_Increment,
    NgayXuat DateTime
);

Create Table VATTU(
	MaVTU Int Not Null Primary Key Auto_Increment,
    TenVTU Varchar(60)
);

Create Table CHITIETPHIEUXUAT(
	SoPX Int Not Null,
    MaVTU Int Not Null,
    DGXuat Float Not Null,
    SLXuat Int,
    Primary Key(SoPX, MaVTU),
    Foreign Key(SoPX)References PHIEUXUAT(SoPX),
    Foreign Key(MaVTU)References VATTU(MaVTU)
);

Create Table PHIEUNHAP(
	SoPN Int Not Null Primary Key Auto_Increment,
    NgayNhap DateTime
);

Create Table CHITIETPHIEUNHAP(
	MaVTU Int Not Null,
    SoPN Int Not Null,
    Primary Key(MaVTU,SoPN),
    Foreign Key(MaVTU)References VATTU(MaVTU),
    Foreign Key(SoPN)References PHIEUNHAP(SoPN),
    DGNhap Int Not Null,
    SLNhap Int Not Null
);

Create Table NHACC(
	MaNCC Int Not Null Primary Key Auto_Increment,
    TenNCC Varchar(50) Not Null,
    DiaChi Varchar(100) Not Null
);

Create Table DONDH(
	SoDH Int Not Null Primary Key Auto_Increment,
    NgayDH DateTime,
    MaNCC Int Not Null,
    Foreign Key(MaNCC)References NHACC(MaNCC)
);

Create Table SDT_NHACC(
	MaNCC Int Not Null,
    SDT Varchar(20) Not Null,
    Primary Key (MaNCC,SDT),
    Foreign Key (MaNCC)References NHACC(MaNCC)
);