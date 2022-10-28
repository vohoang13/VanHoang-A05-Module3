Create Database demo;

Create Table Products(
	Id Int,
	ProductCode Int,
    ProductName Varchar(50),
    ProductPrice Float,
    ProductAmount Int,
    ProductDescription Text,
    ProductStatus bit,
    Constraint pk_Id Primary Key(Id)
);

Insert into Products
Values(1,1,'May Lanh',15000.0,2,'',1);
Insert into Products
Values(2,2,'Quat Lanh',20000.0,10,'',1);
Insert into Products
Values(3,3,'Tu Lanh',14000.0,5,'',0);
Insert into Products
Values(4,4,'Dien Lanh',16000.0,2,'',1);

Explain Select * 
From Products
Where ProductCode = 1; 


Create Unique Index index_unique On products(ProductCode);

Create Index index_composite On products(ProductName, ProductPrice);

Explain Select * 
From Products
Where ProductCode = 1; 

Create View View_Products AS
Select productCode, productName, productPrice, productStatus
from products;

Alter View view_products As
select ProductCode, ProductName
from Products;

Drop view view_products;

DELIMITER //
Create Procedure procedure_infor ()
Begin
	select * 
    from Products;
End //
DELIMITER ;

DELIMITER //
Create Procedure procedure_add (IN id int, IN productCode int, IN productName varchar(50), IN price float, IN amount int, IN descriptions text, IN statuss bit )
Begin
	Insert into products
    Values(id,productCode,productName,price,amount,descriptions,statuss);
End //
DELIMITER ;

call procedure_add(5,5,'Camera',250000,1,' ',0);

DELIMITER //
Create Procedure procedure_update (IN id int)
Begin
	Update products
    Set ProductName = 'May Say Toc'
    Where products.Id = id;
End //
DELIMITER ;

call procedure_update(1);
DELIMITER //
Create Procedure procedure_remove (IN id int)
Begin
	Delete From products
    Where products.Id = id;
End //
DELIMITER ;

call procedure_remove(5);




