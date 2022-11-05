-- TASK 10

select hop_dong.ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc, sum(hop_dong_chi_tiet.so_Luong) as so_luon_dich_vu_di_kem 
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by ma_hop_dong 
order by ma_hop_dong asc;

-- TASK 11 

select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
where kh.ma_loai_khach = 1 and dvdk.ma_dich_vu_di_kem in (select hdct.ma_dich_vu_di_kem 
from hop_dong_chi_tiet hdct) and kh.dia_chi like '%_Vinh' or kh.dia_chi like '%_Quảng Ngãi';

-- TASK 12

select hd.ma_hop_dong, kh.ho_ten as ho_ten_kh, nv.ho_ten as Ho_ten_nv, kh.so_dien_thoai, dv.ten_dich_vu, tien_dat_coc, sum(hdct.so_Luong) as so_luon_dich_vu_di_kem 
from hop_dong hd
join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
where not (month(hd.ngay_lam_hop_dong) between 1 and 6 and year(hd.ngay_lam_hop_dong) = '2021') 
and (month(hd.ngay_lam_hop_dong) between 10 and 12 and year(hd.ngay_lam_hop_dong) = '2020') 
group by ma_hop_dong;

-- TASK 13

select dvdk.ma_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem,sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by ma_dich_vu_di_kem
having  sum(hdct.so_luong) = (select max(max.soluong)
from (select  sum(hdct.so_luong)as soluong from hop_dong_chi_tiet hdct 
group by hdct.ma_dich_vu_di_kem)as max);

-- TASK 14
select hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong hd
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hdct.ma_dich_vu_di_kem
having so_lan_su_dung = 1
order by ma_hop_dong ;

-- TASK 15
select nv.ma_nhan_vien, ho_Ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
from nhan_vien nv
join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
group by nv.ma_nhan_vien -- Gộp nhóm theo mã nhân viên có trong hợp đồng
having count(hd.ma_nhan_vien) between 1 and 3; -- tính số lượng hợp đồng  từng nhân viên làm được

-- TASK 16
delete from nhanvien
where nhan_vien.ma_nhan_vien not in (select ma_nhan_vien
from hop_dong);

