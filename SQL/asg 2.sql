use Student

create table student 
(
	StudentNumber varchar(10) PRIMARY KEY NOT NULL,
	StudentName varchar(50) NOT NULL,
	[Address] varchar(100) NULL
)

create table [Subject]
(
	SubjectNumber varchar(10) PRIMARY KEY NOT NULL,
	SubjectName varchar(50) NOT NULL
)

create table Result (
	StudentNumber varchar(10) NOT NULL,
	SubjectNumber varchar(10) NOT NULL,
	Semester varchar (50) NOT NULL,
	Grade varchar(1) NOT NULL,
	Mark int,
	FOREIGN KEY (StudentNumber) References student(StudentNumber),
	FOREIGN KEY (SubjectNumber) References [Subject](SubjectNumber)

)

insert into student
VALUES  ('77777','Mr. X','100 BBB  Rd.'),
		('211100','Kevin Chan','11 BBB St.'),
		('211114','Regina Wong',NULL),
		('211116','Iris Chan','211 CCCC St.'),
		('211152','Abdallah Chan','711 AAA St.'),
		('211160','Howard CBrooks','611 BBB St.'),
		('211177','Tracey Chang','11 BBB St.'),
		('211199','Khalid Jones','811 BBB St.'),
		('211333','Jo  Smith',NULL),
		('211666','Rosy Ryan','411 BBB St..')


insert into [Subject]
values ('ABCD100','New subject'),
		('INFO117','Computer Architecture'),
		('INFO221','Programming Fundamentals'),
		('INFO321','Database Fundamentals '),
		('INFO328','Easy Fundamentals')

insert into Result
VALUES  ('211100','INFO117','Sem 1 2006','F','16'),
		('211116','INFO321','Sem 1 2006','P','52'),
		('211116','INFO221','Sem 1 2006','P','60'),
		('211116','INFO117','Sem 1 2009','P','50'),
		('211114','INFO117','Sem 1 2006','F','22'),
		('211114','INFO117','Sem 1 2009','P','51'),
		('211177','INFO321','Sem 1 2006','D','83'),
		('211666','INFO117','Sem 1 2006','F','14'),
		('211666','INFO117','Sem 1 2009','C','66'),
		('211666','INFO221','Sem 1 2006','D','77'),
		('211666','INFO321','Sem 1 2009','D','80'),
		('211333','INFO328','Sem 1 2009','F','44'),
		('211160','INFO321','Sem 1 2008','C','55'),
		('211160','INFO221','Sem 1 2006','D','81'),
		('211152','INFO321','Sem 1 2009','P','62'),
		('211199','INFO321','Sem 1 2006','C','67'),
		('211100','INFO321','Sem 1 2008','D','79')

/*
	1.	Berapa banyak mata pelajaran yang telah dipelajari oleh setiap siswa? 
	Urutkan dalam urutan jumlah subjek (naik).	
*/

	select rs.StudentNumber, COUNT(rs.SubjectNumber) as [JumlahSubject] from Result rs
		JOIN student st on rs.StudentNumber = st.StudentNumber
		JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
		Group by rs.StudentNumber
		Order by COUNT(rs.SubjectNumber) ASC

/*
2.	Berapa banyak siswa yang telah mempelajari setiap 
mata pelajaran? Daftar dalam urutan abjad nama subjek.
*/

	select sb.SubjectName,COUNT(rs.StudentNumber) as JumlahStudent from Result rs
		JOIN student st on rs.StudentNumber = st.StudentNumber
		JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
		group by sb.SubjectName
		order by sb.SubjectName


/*
	3.	Siswa mana yang tidak tinggal di BBB St. 
	telah mempelajari jumlah mata pelajaran terbesar.
*/
select * from student

select subjek from (
select TOP 1 sb.SubjectName subjek,COUNT(rs.StudentNumber) as JumlahStudent from Result rs
		JOIN student st on rs.StudentNumber = st.StudentNumber
		JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
		group by sb.SubjectName
		order by COUNT(rs.StudentNumber) DESC
		)tb1

	select st.StudentName from Result rs
		JOIN student st on rs.StudentNumber = st.StudentNumber
		JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
		where [Address] NOT LIKE '%BBB St.%' AND
		 sb.SubjectName = (select subjek from (
		select TOP 1 sb.SubjectName subjek,COUNT(rs.StudentNumber) as JumlahStudent from Result rs
		JOIN student st on rs.StudentNumber = st.StudentNumber
		JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
		group by sb.SubjectName
		order by COUNT(rs.StudentNumber) DESC
		)tb1)
/*

4.	Tampilkan informasi siswa yang alamatnya tidak diketahui
*/

	
	select  st.StudentNumber, st.StudentName, COUNT(rs.SubjectNumber) as banyakMapel from Result rs
	JOIN student st on st.StudentNumber = rs.StudentNumber
	JOIN Subject sb on sb.SubjectNumber = rs.SubjectNumber
	where st.[Address] IS NULL
	group by st.StudentNumber, st.StudentName
	
	

/*
5
*/

--ini kasus kalo sesuai sama new subject
	select * from(
	select st.StudentName,COUNT(sb.SubjectName) JumlahKelas from Result rs
	JOIN student st on rs.StudentNumber = st.StudentNumber
	JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
	Group by st.StudentName
	) tb
	where JumlahKelas = (select COUNT(SubjectName) from [Subject])

	--ini tanpa new subject
	select * from(
	select st.StudentName,COUNT(sb.SubjectName) JumlahKelas from Result rs
	JOIN student st on rs.StudentNumber = st.StudentNumber
	JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
	Group by st.StudentName
	) tb
	where JumlahKelas = (select COUNT(SubjectName) from [Subject] where SubjectNumber != 'ABCD100')

/*

*/


select  rs.Grade, COUNT( StudentNumber) jumlahStudent from Result rs
group by rs.Grade 
order by CASE
			WHEN rs.Grade = 'D' Then 1
			WHEN rs.Grade = 'C' Then 2
			WHEN rs.Grade = 'P' Then 3
			WHEN rs.Grade = 'F' Then 4
			END ASC

/*

*/


select st.StudentName,sb.SubjectName, rs.Mark as nilai from Result rs
	JOIN student st on rs.StudentNumber = st.StudentNumber
	JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
	where Semester LIKE '%Sem 1 2006%'

/*

*/
select st.StudentName, AVG(rs.Mark) as nilaiRata2 from Result rs
	JOIN student st on rs.StudentNumber = st.StudentNumber
	JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
	group by st.StudentName


/*

*/

select sb.SubjectName, AVG(rs.Mark) as nilaiRata2 from Result rs
	JOIN student st on rs.StudentNumber = st.StudentNumber
	JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
	group by sb.SubjectName

/*

*/

select tb2.subjek, tb2.smester,MAX(tb2.ratarata) as rata  from (
	select  sb.SubjectName subjek ,rs.Semester smester,AVG(rs.Mark) as ratarata from Result rs
		JOIN student st on rs.StudentNumber = st.StudentNumber
		JOIN [Subject] sb on sb.SubjectNumber = rs.SubjectNumber
		Group by  sb.SubjectName,rs.Semester
		order by AVG(rs.Mark) DESC 
		OFFSET 0 ROWS
	) tb2
	group by tb2.subjek, tb2.smester
	order by (select NULL)
	OFFSET 3 ROWS





	

	

	
/*

*/

/*

*/