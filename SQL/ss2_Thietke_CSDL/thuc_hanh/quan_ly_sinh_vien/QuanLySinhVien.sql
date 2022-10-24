alter table class
modify StartDate Date Not Null;

Insert Into class
Values(1,'A1','2008-12-20',1);
Insert Into class
Values(2,'A2','2008-12-22',1);
Insert Into class
Values(3,'B3',current_date(),1);

Insert Into student 
Values(1,'Hung','Ha Noi','0912113113',1,1);
Insert Into student 
Values(2,'Hoa','Hai Phong','',1,1);
Insert Into student 
Values(3,'Manh','HCM','0123123123',1,2);

Insert Into subjects 
Values(1,'CF',5,1);
Insert Into subjects 
Values(2,'C',6,1);
Insert Into subjects 
Values(3,'HDJ',5,1);
Insert Into subjects 
Values(4,'RDBMS',10,1);

Drop Table Mark;

Create Table Mark(
	MarkID Int Not Null Primary Key,
    SubID Int Not Null,
    StudentID Int Not Null,
    Mark Float Default 0 Check ( Mark Between 0 And 100),
    Foreign Key(SubID) References subjects(SubID),
    Foreign Key(StudentID) References student(StudentID),
    ExamTimes TINYINT DEFAULT 1
);

Insert Into mark
Values(1,1,1,8,1);
Insert Into mark
Values(2,1,2,10,2);
Insert Into mark
Values(3,2,1,12,1);

select * from student;

select * from student
where statuss = 1;

select * from subjects
where credit < 10;

select student.StudentID, student.StudentName,student.ClassID, student.Address, student.Phone, student.Statuss, class.ClassName
from student
join class on student.ClassID = class.ClassID
where class.ClassName = 'A1';

select student.StudentID,student.StudentName,subjects.SubName, mark.MarkID,mark.SubID,mark.Mark
from (student
join mark on student.StudentID = mark.StudentID)
join subjects on subjects.SubID = mark.SubID
where subjects.SubName = 'CF';



