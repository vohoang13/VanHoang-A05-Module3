select * from khach_Hang
where (year(curdate())-year(ngay_Sinh) between 18 and 50) and ((dia_chi like '%_Da Nang') or (dia_chi like '%_Quang Tri'));

select * from khach_Hang
where (timestampdiff(Year,ngay_Sinh,Curdate()) between 18 and 50) and ((dia_chi like '%_Da Nang') or (dia_chi like '%_Quang Tri'));