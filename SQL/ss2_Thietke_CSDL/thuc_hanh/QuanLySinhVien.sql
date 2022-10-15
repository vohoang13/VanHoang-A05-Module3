Create Table class(
	ClassID Int  Not Null Primary Key Auto_Increment,
    ClassName Varchar(60) Not Null,
    StartDate Datetime Not Null,
    Statuss  Bit
);

Create Table student(
	StudentID Int Not Null Primary Key Auto_Increment,
    StudentName Varchar(30) Not Null,
    Address Varchar(50),
    Phone Varchar(20),
	Statuss Bit,
    ClassID Int Not Null,
    Foreign Key(ClassID)References class(ClassID)
);

Create Table subjects(
	SubID Int Not Null Primary Key Auto_Increment,
    SubName Varchar(30) Not Null,
    Credit Tinyint Not Null Default 1 Check(Credit >=1),
    Statuss Bit Default 1
);

Create Table mark(
	MarkID Int Not Null Primary Key Auto_Increment,
    SubID Int Not Null Unique Key,
    StudentID Int Not Null Unique Key,
    Mark Float Default 0 Check (Mark Between 0 And  100),
    ExamTimes Tinyint Default 1,
    Foreign Key(SubID)References subjects(SubID),
    Foreign Key(StudentID)References student(StudentID)
);

