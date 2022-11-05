Select * from nhan_vien
where ((nhan_vien.ho_Ten Like '% h%' OR '% k%') OR (nhan_vien.ho_Ten like '% t%')) AND length(trim(nhan_vien.ho_Ten)) = '15';