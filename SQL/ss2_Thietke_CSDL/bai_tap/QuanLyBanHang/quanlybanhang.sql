Create Table Customer(
	cID Int Not Null Auto_Increment Primary Key,
    cName Varchar(50),
    cAge Int 
);

Create Table Orders(
	oID Int Not Null Auto_Increment Primary Key,
    cID Int Not Null,
    Foreign Key(cID)References Customer(cID),
    oDate Date,
    oTotalPrice Int
);

Create Table Product(
	pID Int Not Null Auto_Increment Primary Key,
    pName Varchar(50),
    pPrice Int
);

Create Table OrderDetail(
	oID Int Not Null,
    pID Int Not Null,
    Primary Key(oID,pID),
    Foreign Key(oID)References Orders (oID),
    Foreign Key(pID)References Product (pID),
    odQTY Int Not Null 
);


