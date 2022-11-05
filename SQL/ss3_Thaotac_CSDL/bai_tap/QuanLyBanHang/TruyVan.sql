-- Bảng Customer 
Insert into customer
Values(1,'Minh Quan',10);
Insert into customer
Values(2,'Ngoc Oanh',20);
Insert into customer
Values(3,'Hong Ha',50);

-- Bảng Order
Insert Into orders
Values(1,1,'2006-03-21',Null);
Insert Into orders
Values(2,2,'2006-03-23',Null);
Insert Into orders
Values(3,1,'2006-03-16',Null);

-- Bảng Product
Insert Into product
Values(1,'May Giat',3);
Insert Into product
Values(2,'Tu Lanh',5);
Insert Into product
Values(3,'Dieu Hoa',7);
Insert Into product
Values(4,'Quat',1);
Insert Into product
Values(5,'Bep Dien',2);

-- Bảng OrderDetail 
Insert Into orderdetail
Values(1,1,3);
Insert Into orderdetail
Values(1,3,7);
Insert Into orderdetail
Values(1,4,2);
Insert Into orderdetail
Values(2,1,1);
Insert Into orderdetail
Values(3,1,8);
Insert Into orderdetail
Values(2,5,4);
Insert Into orderdetail
Values(2,3,3);

-- Truy Vấn:

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
Select orders.oID, orders.oDate, orders.oTotalPrice
From orders;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
Select customer.cID, customer.cName, customer.cAge, product.pID, product.pName, product.pPrice
From ((Customer
join orders on orders.cID = customer.cID)
join orderdetail on orders.oID = orderdetail.oID )
join product on product.pID = orderdetail.pID
Where customer.cID In ( Select cID from orders);

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
Select cName 
From customer
Where cID not In ( Select cID
From orders);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
Select orders.oID, orders.oDate, sum(orderdetail.odQTY * product.pPrice) As 'Tổng đơn'
From orders
join orderdetail on orders.oID = orderdetail.oID
join product on orderdetail.pID = product.pID
Group by orders.oID;
