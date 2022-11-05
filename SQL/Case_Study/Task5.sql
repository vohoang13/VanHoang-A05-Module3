select khach_hang.ma_Khach_Hang,khach_hang.ho_Ten, loai_khach.ten_Loai_Khach, hop_dong.ma_Hop_Dong, dich_vu.ten_Dich_Vu, hop_dong.ngay_Lam_Hop_Dong, hop_dong.ngay_Ket_Thuc,
(dich_vu.chi_phi_Thue + ifnull(hop_dong_chi_tiet.so_Luong * dich_vu_di_kem.gia,0)) as `TongTien`
from khach_hang
left join loai_khach  on khach_hang.ma_Loai_Khach = loai_khach.ma_Loai_Khach
left join hop_dong on khach_hang.ma_Khach_Hang = hop_dong.ma_Khach_Hang
left join dich_vu on dich_vu.ma_Dich_Vu = hop_dong.ma_Dich_Vu
left join hop_dong_chi_tiet on hop_dong.ma_Hop_Dong = hop_dong_chi_tiet.ma_Hop_Dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_Dich_Vu_Di_Kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by khach_hang.ma_Khach_Hang;	