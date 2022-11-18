select dich_vu.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue
from dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where dich_vu.ma_dich_vu not in 
(select ma_dich_vu from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = '2021' and month(hop_dong.ngay_lam_hop_dong) between 1 and 3)
group by dich_vu.ma_dich_vu;