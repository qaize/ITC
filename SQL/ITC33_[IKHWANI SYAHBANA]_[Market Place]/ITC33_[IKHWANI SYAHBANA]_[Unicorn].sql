--1) All Available Subject.sql



create Proc dbo.avilableSubject
@tanggal date
as
begin
	select DISTINCT p.StartDate,p.EndDate, s.Name,FORMAT(s.Cost,'c','en-US') Cost from Period p
	JOIN Competency c on p.CompetencyID = c.ID
	JOIN Subject s on s.ID = c.SubjectID
	where p.StartDate = @tanggal
end

exec dbo.avilableSubject 
	@tanggal = '2013-06-01'

exec dbo.avilableSubject 
	@tanggal = '2014-01-01'




--2) Student Certificate.sql

select * from Certificate
select * from Student
select * from City

select CONCAT(st.FirstName,' ',st.MiddleName,' ',st.LastName) [Nama Lengkap],
CONCAT(ct.[Name],',', FORMAT(st.BirthDate,'dd MMMM yyyy','id-ID')) as Kelahiran,
CASE	
	When cer.[Level] = 'B' then 'Bachelor'
	When cer.[Level] = 'P' then 'PhD'
	When cer.[Level] = 'M' then 'Master'
	END AS [Level],
AcademicTitle, 
CASE
	When cer.Grade = 'PAS' then 'Pass'
	When cer.Grade = 'CRE' then 'Credit'
	When cer.Grade = 'DIS' then 'Distinction'
	When cer.Grade = 'HDIS' then 'High Distinction'
	END AS Grade,
FORMAT(GraduateDate,'dd MMMM yyyy','id-ID') as [Graduate Date]

 from Student st
JOIN City ct on st.BirthCityID = ct.ID
JOIN Certificate cer on cer.StudentNumber = st.StudentNumber


--15) Debt List.sql


select * from Enrollment


select st.StudentNumber,CONCAT(st.FirstName,' ',st.MiddleName,' ',st.LastName) [Nama Lengkap],SUM(sb.Cost) Hutang from Student st
JOIN Enrollment e on e.StudentNumber = st.StudentNumber
JOIN Period pd on e.PeriodID = pd.ID
JOIN Competency cp on cp.ID = pd.CompetencyID
JOIN Subject sb on sb.ID = cp.SubjectID
WHERE e.Status = 'PEN'
Group by st.StudentNumber,CONCAT(st.FirstName,' ',st.MiddleName,' ',st.LastName)

--3) Transaction Completing Enrollment.sql

select * from Enrollment
select * from Student
select * from Subject
select * from Period

create proc dbo.TransactionPending
@payment varchar(2)
as
begin
	
	UPDATE en
	SET en.TransactionDate = GETDATE(), en.PaymentMethod = @payment, en.Fee = s.Cost, Status = 'COM'
	FROM Enrollment en
	JOIN [Period] p on p.ID = en.PeriodID
	JOIN Competency c on c.ID = p.CompetencyID
	JOIN [Subject] s on s.ID = c.SubjectID
	where en.[Status] = 'PEN'
end 

exec dbo.TransactionPending
	@payment = 'AC'


--4) All Tutor and Student Involved.sql
select * from Subject
select * from Period

create proc dbo.tutorAndStudent
(
	@sCode varchar(10),
	@tanggal date
)
as
begin

select CONCAT(st.FirstName,' ',st.MiddleName,' ',st.LastName) [Nama Lengkap Siswa],
CONCAT(t.FirstName,' ',t.MiddleName,' ',t.LastName) [Nama Lengkap Tutor] from Student st
	JOIN Enrollment e on e.StudentNumber = st.StudentNumber
	JOIN Period p on p.ID = e.PeriodID
	JOIN Competency cp on cp.ID = p.CompetencyID
	JOIN Tutor t on t.StaffNumber = cp.StaffNumber
	JOIN Subject s on s.ID= cp.SubjectID
		Where p.StartDate =@tanggal  AND s.Code = @sCode
end

exec dbo.tutorAndStudent 
	@sCode = '31251',
	@tanggal = '2013-06-01'


--5) Clueless Student.sql
select * from Student
select * from Enrollment


select CONCAT(st.FirstName,' ',st.MiddleName,' ',st.LastName) [Nama Lengkap],
	st.[Address] from Student st
	Where st.StudentNumber NOT IN (select StudentNumber from Enrollment)


--6) Major Total Cost.sql

select * from Major
select * from [Subject]
 
select DENSE_RANK() over (Order by tb.total ASC) as [Rank],tb.Name,tb.Type,tb.total from (
select m.[Name],
CASE
	When m.[Type] = 'FM' then 'Full Major'
	when m.[Type] = 'SM' then 'Sub Major'
	when m.[Type] = 'EL' then 'Elective'
END AS[Type],SUM(s.Cost) as total from Major m
JOIN [Subject] s on m.ID = s.MajorID
group by m.[Name],m.[Type]
)tb

--7) Payment Method Percentage.sql
select * from Enrollment

select 
CASE	
	When e.PaymentMethod = 'CC' then 'Credit Card'
	when e.PaymentMethod = 'AC' then 'Auto Collection'
	when e.PaymentMethod = 'CH' then 'Cheque'
	when e.PaymentMethod = 'BT' then 'Bank Transfer'
END AS [Payment Method],
FORMAT(CAST(COUNT(e.PaymentMethod) as decimal)/(select COUNT(PaymentMethod) From Enrollment where PaymentMethod IS NOT NULL),'P') as [Percentage]
 from Enrollment e
 where PaymentMethod IS NOT NULL
 Group by PaymentMethod

 --8) Check Prerequisite.sql

Create function dbo.PrerequisiteToF(@StudentNumber varchar(20),@scode as varchar(10))
returns int as
begin
	declare @check as varchar(10) = @scode
	declare @ToF as bit
	IF ( @check =  (select sb.Code from Enrollment en
	JOIN Period pd on pd.ID = en.PeriodID
	JOIN Competency cm on cm.ID = pd.CompetencyID
	JOIN [Subject] sb  on sb.ID = cm.SubjectID
	where en.StudentNumber = @StudentNumber AND sb.Code = @scode AND sb.ID NOT IN (select SubjectID from Prerequisite)) )
	 BEGIN
		SET @ToF = 1
	 END
	ELSE 
		SET @ToF = 0	

Return @ToF
end

select dbo.PrerequisiteToF('2012/01/0005','48024') as [Boleh/Tidak]


--9) Study Transcript.sql

select * from StudentReportCard

	Create proc dbo.StudyTranscript
	(
		@sNumber varchar(20)
	)
	AS
	BEGIN
		select  CONCAT(st.FirstName,' ',st.MiddleName,' ',st.LastName) [Nama Lengkap],
				CASE
					When st.Gender = 'F' then 'Female'
					when st.Gender = 'M' then 'Male'
					END AS [Gender],
				FORMAT(RegisterDate,'dd MMMM yyyy','id-ID') [Register Date],
				TotalCreditPoint	
		 from Student st
			where st.StudentNumber = @sNumber
			

		 select sb.Code, sb.[Name],m.[Name],SUM(src.Mark*src.WeightedMark) as [Total Mark],
				 p.EndDate as [End Period Date]  from Student st
		 JOIN Enrollment e on st.StudentNumber = e.StudentNumber
		 JOIN StudentSubject stb on stb.EnrollmentID = e.ID
		 JOIN StudentReportCard src on src.StudentSubjectID = stb.ID
		 JOIN [Period] p on p.ID = e.PeriodID
		 JOIN Competency cm on cm.ID = p.CompetencyID
		 JOIN [Subject] sb on sb.ID = cm.SubjectID
		 JOIN Major m on m.ID = sb.MajorID
		 where st.StudentNumber = @sNumber
		 Group by sb.Code, sb.[Name],m.[Name],p.EndDate
		 
	END
	select * from Student

	exec dbo.StudyTranscript 
		@sNumber = '2012/01/0001'

	
	exec dbo.StudyTranscript 
		@sNumber = '2012/01/0005'

--10) In Progress.sql

select CONCAT(st.FirstName,' ',st.MiddleName,' ',st.LastName) [Nama Lengkap],
CONCAT(ct.[Name],',', FORMAT(st.BirthDate,'dd MMMM yyyy','id-ID')) as Kelahiran,
m.[Name]
from Student st
JOIN StudentMajor sm on sm.StudentNumber = st.StudentNumber
JOIN Major m on m.ID = sm.MajorID
JOIN City ct on ct.ID = st.BirthCityID
where st.StudentNumber NOT IN (select StudentNumber from Certificate)


-- 11) Check Student Major.sql'

create proc dbo.CheckStudentMajor

(
	@StudentNumber varchar(20),
	@sCode varchar(10)

)
as
begin
		select CONCAT(t.FirstName,' ',t.MiddleName,' ',t.LastName) [Tutor FullName],
		s.[Name],m.[Name],IIF(COUNT(en.StudentNumber)<=1,0,COUNT(en.StudentNumber)-1) as [Total Ulang]
		from Tutor t
		JOIN Competency cp on t.StaffNumber = cp.StaffNumber
		JOIN Period p on p.CompetencyID = cp.ID
		JOIN Enrollment en on en.PeriodID = p.ID
		JOIN [Subject] s on s.ID = cp.SubjectID
		JOIN Major m on m.ID = s.MajorID
		JOIN Student st on st.StudentNumber = en.StudentNumber
		where en.StudentNumber = @StudentNumber AND s.Code = @sCode
		Group by CONCAT(t.FirstName,' ',t.MiddleName,' ',t.LastName),
		s.[Name],m.[Name]

end

select * from Student

exec dbo.CheckStudentMajor
	@StudentNumber = '',
	 @scode = ''



--12) Subject of Major.sql


	create proc dbo.SearchSubject
	(
		@major varchar(MAX)
	)
	AS
	BEGIN
		
		select s.[Name] as [Subject Name],ISNULL(s.[Description],'Ask student call center for this subject information') as Deskripsi,
		s.[Level],s.Cost
		
		 from Student st
		JOIN StudentMajor sm on sm.StudentNumber = st.StudentNumber
		JOIN Major m on m.ID = sm.MajorID
		JOIN [Subject] s on m.ID = s.MajorID
		Where m.[Name] Like '%'+@major+'%'
		
	END

	exec dbo.SearchSubject
		@major = 'network'

	exec dbo.SearchSubject
		@major = 'Artif'

--13) Incoming Fee.sql

Create function dbo.IncomingFee(@tanggal date)
Returns Table as return
	select tb1.TransactionDate,ISNULL(tb1.[Incoming Fee],0) [Incoming Fee] from (
	select en.TransactionDate,SUM(en.Fee) as [Incoming Fee] from Enrollment en 
	JOIN Period p on en.PeriodID = p.ID
	where EnrollDate < @tanggal
	Group by en.TransactionDate
	) tb1

select * from dbo.IncomingFee('2013-10-01')

--14) Previous Grade.sql

select * from EducationHistory

select eh.Institution,AVG(eh.Grade) [Rata rata ] from EducationHistory eh
JOIN Student st on st.StudentNumber = eh.StudentNumber
Group by eh.Institution




--16)Tutor Payroll.sql

select 
	StaffNumber,
	CONCAT(t.FirstName,' ',t.MiddleName,' ',t.LastName) [Nama Lengkap Tutor],
	CASE
		when t.EmployeeType = 'CA' then 'Casual'
		when t.EmployeeType = 'FC' then 'Full-Time Contract'
		when t.EmployeeType = 'FP' then 'Full-Time Permanent'
		when t.EmployeeType = 'PC' then 'Part-Time Contract'
		END AS [EmployeeType],

	CASE
		when t.EmployeeType = 'CA' then t.BasicSalary * 2
		when t.EmployeeType = 'FC' then t.BasicSalary 
		when t.EmployeeType = 'FP' then t.BasicSalary + (t.BasicSalary * (t.Allowance/100))
		when t.EmployeeType = 'PC' then t.BasicSalary * 2
		END AS [Take Home Pay]

	from Tutor t

--17) Tutor Subject.sql
select * from Tutor
Create proc dbo.TutorSubject
(
	@staffNum varchar(20)
)
as
BEGIN
	
	select 
		CONCAT(t.Title,' ',t.FirstName,' ',t.MiddleName,' ',t.LastName) [Nama Lengkap Tutor],
		CASE
			When t.Gender = 'F' then 'Female'
			when t.Gender = 'M' then 'Male'
			END AS [Gender],
		Format(t.HireDate,'dd MMMM yyyy','id-ID') [Hire Date],
		CASE
		when t.EmployeeType = 'CA' then 'Casual'
		when t.EmployeeType = 'FC' then 'Full-Time Contract'
		when t.EmployeeType = 'FP' then 'Full-Time Permanent'
		when t.EmployeeType = 'PC' then 'Part-Time Contract'
		END AS [EmployeeType]
	
	 from Tutor t
		where t.StaffNumber = @staffNum

	 select s.Code [Subject Code], s.[Name] as [Subject Name], m.[Name] as [Major Name], m.[Level] as [Level Major],m.[Type] as [Type Major] from Tutor t
	 JOIN Competency c on t.StaffNumber=c.StaffNumber
	 JOIN [Subject] s on s.ID = c.SubjectID
	 JOIN Major m on m.ID = s.MajorID
		where t.StaffNumber = @staffNum

END

EXEC dbo.TutorSubject
	@StaffNum = 'FC01'


--18) Different Point.sql

	select m.[Name] as [Major Name],m.TotalCreditPoint,
	CASE
		When SUM(sb.CreditPoint)=SUM(sb.CreditPoint) then m.TotalCreditPoint-SUM(sb.CreditPoint)
		END AS [Diffrent With Subject]
	 from Major m
	JOIN [Subject] sb on m.ID = sb.MajorID
	Group by m.[Name],m.TotalCreditPoint

--19) Add New Competency.sql

select StaffNumber from Tutor
select Code from Subject

create proc dbo.NewCompetency
(
	@StaffNumber varchar(20),
	@SubjectCode varchar(10)
)
as
begin
	Insert Into Competency
	Values(@StaffNumber,(select s.ID from [Subject] s where s.Code = @SubjectCode ))
end
-------------------	
	BEGIN TRY
		BEGIN TRANSACTION
		exec dbo.NewCompetency
			@StaffNumber = 'CA02',
			@SubjectCode = '21591' 

		PRINT 'TRANSACTION COMMITED'
		COMMIT TRANSACTION

	END TRY


	BEGIN CATCH
		PRINT ERROR_MESSAGE()
		ROLLBACK TRANSACTION
	END CATCH


--20) Citizenship Group.sql

select ct.[Name] [Kebangsaan],COUNT(DISTINCT en.StudentNumber) [Jumlah Mahasiswa] from Student st
JOIN Country ct on ct.ID = st.BirthCountryID
JOIN Enrollment en on en.StudentNumber = st.StudentNumber
Group by ct.[Name]


--21) Cost Changes.sql

--s.code,s.name,currentPrice,en.TransactionDate, Price On Transaction

select s.Code [Subject Code],s.[Name] as [Subject Name],s.Cost as [Current Price],en.TransactionDate,en.Fee as [Price on Transaction] from Enrollment en
JOIN Period p on p.ID = en.PeriodID
JOIN Competency c on c.ID = p.CompetencyID
JOIN [Subject] s on c.SubjectID = s.ID
Where en.Fee != s.Cost


--22) Most Popular Major.sql

select * from StudentMajor
select * from Major
select * from Student


Create proc dbo.PopularMajor
(
	@year int
)
as

begin
	Select m.[Name],COUNT(sm.StudentNumber) [Banyak Major di ambil] from Student st
	JOIN StudentMajor sm on st.StudentNumber = sm.StudentNumber
	JOIN Major m on m.ID = sm.MajorID
	Where YEAR(SetDate) = @year
	Group by m.[Name]
end

exec dbo.PopularMajor
	@year = 2012


--23) Major Popularity on Gender.sql

select * from (
select m.[Name],sm.StudentNumber,
IIF(st.Gender = 'F','Female',
IIF(st.Gender = 'M','Male','')
) as gender
	
	--when st.Gender = 'F' then 'Female'
	--when st.Gender = 'M' then 'Male'
	--END AS Gender

 from Student st
JOIN StudentMajor sm on st.StudentNumber = sm.StudentNumber
JOIN Major m on m.ID = sm.MajorID
) tb
PIVOT(COUNT(tb.StudentNumber) for tb.Gender in([Female],[Male])) pvt


--24) Add New Time Table.sql



--25) Unmatch Subject.sql

select m.Name [Major Name],s.[Name] [Subjek Name] from Subject s
JOIN Major m on s.MajorID = m.ID
where s.NonActiveDate IS NULL 
AND m.Level = 'P' AND s.Level='M' 
OR m.Level = 'P' AND s.Level='B' 
OR m.Level = 'M' AND s.Level='B' 


--26) Payment Enrollment.sql

select * from (
select
CASE
	When e.[Status] = 'CAN' then 'Cancelled'
	when e.[Status] = 'COM' then 'Complete'
	when e.[Status] = 'PEN' then 'Pending'
	END AS [Status Endrollment],
CASE
	when e.PaymentMethod  = 'AC' then 'Auto Collection'
	when e.PaymentMethod = 'CC' then 'Credit Card'
	WHEN e.PaymentMethod = 'CH' then 'Cheque'
	WHEN e.PaymentMethod = 'BT' then 'Bank Transfer'
	ELSE 'Other'
	END AS PaymentMethod,

	e.StudentNumber

 from Enrollment e


 ) tb2
 PIVOT(COUNT(tb2.StudentNumber) for tb2.PaymentMethod in ([Auto Collection],[Credit Card],[Cheque],[Bank Transfer],[Other])) pvt

 --PENDING TIDAK DITAMPILKAN KARENA SUDAH TER UPDATE MENJADI COMPLATE PADA SOAL NOMOR 3


 select * from (
select 
CASE
	When e.[Status] = 'CAN' then 'Cancelled'
	when e.[Status] = 'COM' then 'Complete'
	when e.[Status] = 'PEN' then 'Pending'
	END AS [Status Endrollment],
CASE
	when e.PaymentMethod  = 'AC' then 'Auto Collection'
	when e.PaymentMethod = 'CC' then 'Credit Card'
	WHEN e.PaymentMethod = 'CH' then 'Cheque'
	WHEN e.PaymentMethod = 'BT' then 'Bank Transfer'
	ELSE 'Other'
	END AS PaymentMethod,
	COUNT(1) test

 from Enrollment e
 group by e.[Status],e.PaymentMethod


 ) tb2
 PIVOT(SUM(tb2.test) for tb2.PaymentMethod in ([Auto Collection],[Credit Card],[Cheque],[Bank Transfer],[Other])) pvt


 use Unicorn


 select * from Subject