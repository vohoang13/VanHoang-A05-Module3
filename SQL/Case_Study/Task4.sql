Select hop_dong.ma_Khach_Hang, count(hop_dong.ma_Khach_Hang) as `SoLanDatPhong` from hop_dong
join khach_hang on khach_hang.ma_Khach_Hang = hop_dong.ma_Khach_Hang
where khach_hang.ma_Loai_Khach = 1
group by hop_dong.ma_Khach_Hang
order by `SoLanDatPhong` desc;
