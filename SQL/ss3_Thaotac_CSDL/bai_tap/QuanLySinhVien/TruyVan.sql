-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student
where StudentName LIKE 'h%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.	
select * from class 
where month(quanlysinhvien.class.StartDate) = '12';

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5
select * from subjects
where Credit between 3 and 5;

-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần
select student.StudentName, subjects.SubName, mark.Mark 
from (student join mark on student.StudentID = mark.StudentID)
join subjects on mark.SubID = subjects.SubID
order by Mark desc;