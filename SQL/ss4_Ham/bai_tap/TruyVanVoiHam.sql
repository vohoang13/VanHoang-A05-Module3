-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
Select *
from subjects s
where s.Credit >= ALL(select subjects.Credit from subjects);


-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select subjects.SubID, subjects.SubName, subjects.Credit, subjects.Statuss, mark.Mark
from subjects
join mark on subjects.SubID = mark.MarkID
where mark.Mark >= All(select mark.Mark from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.StudentID, s.StudentName, s.ClassID,s.Phone, s.Statuss, s.Address, avg(mark.Mark) as 'Điểm trung bình'
from student s
join mark on s.StudentID = mark.StudentID
group by s.StudentID
order by 'Điểm trung bình' desc;