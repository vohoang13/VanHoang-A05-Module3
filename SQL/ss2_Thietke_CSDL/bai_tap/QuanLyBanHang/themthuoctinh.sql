Alter Table orderdetail
	Modify odQTY Int Not Null Check(odQTY > 1 OR odQTY = 1);