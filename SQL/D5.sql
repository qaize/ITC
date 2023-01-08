--membuat database dan memanipulasi konstruksi tabel
CREATE/ADD
ALTER 
DROP

--mengisi isi tabel atau memanipulasi isi tabel
INSERT
UPDATE
DELETE/TRUNCATE 


/*
	Create digunakan untuk membuat database

*/

CREATE DATABASE	 [NAMA DATABASE]

CREATE DATABASE University

--drop database yang digunakan untuk menghapus database
DROP DATABASE [Nama Database]

DROP DATABASE University

--ALTER yang digunakan untuk mengubah struktur darai database

ALTER DATABASE [NAMA DATABASE] MODIFY NAME = [NAMA BARU]

ALTER DATABASE University MODIFY NAME = [UniversityIglo]


declare @nama as varchar(20) = 'jon'

begin
	declare @nama2 as varchar (20) = 'jonita'
	select @nama

	begin
	end
end

--error
select @nama2

/*
create table [nama tabel]
 (
 [namaKolom1] [tipedata(length)],
 [namaKolom2] [tipedata(length)]
 )
*/
use UniversityIglo
drop table mahasiswa
create table mahasiswa (
	
	NIM varchar(20) not null PRIMARY KEY,
	NamaDepan varchar(20) not null,
	NamaBelakang varchar(40),
	JenisKelamin varchar(10)not null,
	TempatLahir varchar(20) not null,
	TanggalLahir Datetime not null,
	Alamat varchar(200) not null,
	Email varchar (100) null,
	NomorTelepon varchar(18) not null unique,
	TanggalRegistrasi datetime not null Constraint DF_TanggalRegistrasi Default
	GetDate()
)


create table MataKuliah(
	ID int,
	NamaMataKuliah varchar(50) not null,
	deskripsi varchar(50)

)
--subject tidak bisa direct memasukan PK harus querry lagi dibawahnya
--composite key
create table subject(
	Major varchar(20) not null,
	[subjectname] varchar(50) not null,
	[Desscription] varchar(500) null,

	Primary key (Major, [Subjectname])


)

drop table Topic
create table Topic(

	IdTopic int Primary key identity(1,1) not null,
	Major varchar(20) not null,
	[subjectname] varchar(50) not null,
	[Desscription] varchar(500) null,
	Foreign Key (Major, [Subjectname]) references Subject (Major, [Subjectname])
)

--foreign key sebuah key yang digunakan untuk menghubungkan tabel dengan syarat
--primary key tabel harus di hubungkan dengan foreign key

drop table Kelas
create table Kelas(
	IdKelas int identity (1,1),
	NamaKelas varchar(50) not null,
	IdMataKuliah int not null,
	deskripsi varchar(50)null,
	Constraint PK_Kelas_IdKelas Primary Key (IdKelas),
	Constraint FK_MataKuliah_IdMataKuliah Foreign Key (IdMataKuliah) References MataKuliah(ID)

)





--modifikasi tabel
alter table mahasiswa
	alter column NIM varchar(15)

alter table mahasiswa
	drop Column NomorTelepon

alter table mahasiswa
	add NomorTelepon varchar(13) null




--penambahan contraints
alter table mahasiswa
	add Constraint DF_Mahasiswa_TanggalRegistrasi DEFAULT 
	 getDate() for TanggalRegistrasi

alter table Kelas
	drop constraint FK__Kelas__IdMataKul__300424B4

alter table Kelas
	add constraint FK_MataKuliah_IdMataKuliah foreign Key (ID) references MataKuliah(ID)


--manipulasi data

/*
insert
update
delete/TRUNCATE

*/


select * from mahasiswa

--insert harus sesuai dengan urutan tabel
insert into mahasiswa
Values (
'MHS001',
'Arya',
'Wiguna',
'L',
'Jakarta',
'2000-10-10',
' Jakarta Timur',
'arya@gmail.com',
'081805508805',
'2020-11-11'

)
--harus sesuai dengan urutan kolom yang terdeklarasi
insert into mahasiswa( NIM,NamaDepan,NamaBelakang,JenisKelamin,TempatLahir,TanggalLahir,
				Alamat,Email,NomorTelepon,TanggalRegistrasi)
Values (
'MHS003',
'Aya',
'una',
'P',
'Jakarta',
'2001-11-10',
' Jakarta Barat',
'ara@gmail.com',
'021805507805',
GETDATE()
),
 (
'MHS004',
'raya',
'Wina',
'L',
'Jakarta',
'2001-11-10',
' Jakarta Barat',
'ara@gmail.com',
'021805502805',
'2020-11-11'
)




select * from MataKuliah

--inserted untuk mengetahui data baru
--deleted bisa hanya bisa deleted
--update bisa delted bisa inserted
insert into MataKuliah 
OUTPUT INSERTED.NamaMataKuliah
Values ('JARKOM',NULL)

update MataKuliah
	SET NamaMataKuliah = 'Math'
	OUTPUT Deleted.NamaMataKuliah, Inserted.Deskripsi
		where ID = 4

delete from MataKuliah 
	OUTPUT deleted.NamaMataKuliah, deleted.deskripsi
		where ID = 4


			


drop table MataKuliah
insert into MataKuliah
	Values('Database 2',NULL),
	('JAVA',NULL),
	('JAVA SPRING',NULL)

--menghapus data tapi tidak menghapus/reset identity nya
delete from MataKuliah where ID = 1

--TRUNCATE menghapus data dan reset identitynya
TRUNCATE Table MataKuliah

select * from mahasiswa
--merubah value dari tabel
UPDATE mahasiswa SET Email = 'aya@gmail.com'
	where NIM = 'MHS003'

UPDATE mahasiswa SET NamaDepan = 'Uciha', NamaBelakang = 'Obito'
	where NIM = 'MHS004'


select * from mahasiswa


use Northwind
use UniversityIglo

--membuat data dari tabel database lain
select IDENTITY(int,1,1) ID, em.EmployeeID, 
CONCAT(TitleOfCourtesy,' ',FirstName, ' ' , LastName) Fullname,
em.HireDate,tt.TerritoryDescription
--perintah untuk membuat table
into DetailTerritoryEmployees
from Northwind.dbo.Employees em 
JOIN Northwind.dbo.EmployeeTerritories et on em.EmployeeID = et.EmployeeID
JOIN Northwind.dbo.Territories tt on tt.TerritoryID = et.TerritoryID


--memasukan data ke tabel syaratnya harus sesuai dengan tabel
--syaratnya harus sudah ada tabel yang sesuai dengan data
 insert into DetailTerritoryEmployees
 select em.EmployeeID, 
CONCAT(TitleOfCourtesy,' ',FirstName, ' ' , LastName) Fullname,
em.HireDate,tt.TerritoryDescription
from Northwind.dbo.Employees em 
JOIN Northwind.dbo.EmployeeTerritories et on em.EmployeeID = et.EmployeeID
JOIN Northwind.dbo.Territories tt on tt.TerritoryID = et.TerritoryID
--ngosongin isi tabel
truncate table DetailTerritoryEmployees

select * from DetailTerritoryEmployees

select * from Northwind.dbo.Employees

--tempororay table harus ada pager terus ada into2 nya
select  em.EmployeeID, 
CONCAT(TitleOfCourtesy,' ',FirstName, ' ' , LastName) Fullname,
em.HireDate,tt.TerritoryDescription
--perintah untuk membuat table
into ##TempDetailTerritoryEmployee
from Northwind.dbo.Employees em 
JOIN Northwind.dbo.EmployeeTerritories et on em.EmployeeID = et.EmployeeID
JOIN Northwind.dbo.Territories tt on tt.TerritoryID = et.TerritoryID


select * from #TempDetailTerritoryEmployee


insert into #TempDetailTerritoryEmployee
select em.EmployeeID, 
CONCAT(TitleOfCourtesy,' ',FirstName, ' ' , LastName) Fullname,
em.HireDate,tt.TerritoryDescription
from Northwind.dbo.Employees em 
JOIN Northwind.dbo.EmployeeTerritories et on em.EmployeeID = et.EmployeeID
JOIN Northwind.dbo.Territories tt on tt.TerritoryID = et.TerritoryID

TRUNCATE table #TempDetailTerritoryEmployee
DROP table #TempDetailTerritoryEmployee

--# LOKAL TEMPORARY hanya bisa diakses oleh lembar
--## GLOBAL TEMPORARY dapat diakses di lembar lain
--Temporary table  untuk Keperluan Querry LANJUTAN! katanya mbak vina



Declare @NamaEmployee as  varchar (50) = (select FirstName from Employees

where EmployeeID = 1)

declare @detailTerritoryEmployee as table (
	EmployeeID varchar(20),
	FullName varchar(100),
	HireDate datetime,
	Territory varchar(100)

)


Insert into @detailTerritoryEmployee
select em.EmployeeID, CONCAT(FirstName, ' ', LastName),
 em.HireDate,t.TerritoryDescription from
Employees as em
JOIN EmployeeTerritories as et on em.EmployeeID = et.EmployeeID
JOIN Territories t ON t.TerritoryID = et.TerritoryID

select * from @detailTerritoryEmployee

Drop table ##TempDetailTerritoryEmployee
select * from Emplo

--pointnya disini adalah kalo variable bentuknya tabel ya tabelR
--declare harus jalan juga


GO

select * from DetailTerritoryEmployees

---------------------harus di run barengan------------------
declare @tableDetailEmployee as Table (
	ID int,
	NamaLengkap Varchar(200),
	Alamat varchar (500)
)
insert into @tableDetailEmployee
select *from  #SST


 select * from @tableDetailEmployee

 ----------------------------------------------------------

 use UniversityIglo
 select * from MataKuliah

 insert into mataKuliah
 output inserted.ID,inserted.NamaMataKuliah, inserted.deskripsi
 values ('ALGODAT', 'algoritma data')





 --user define table sebuah variable yang dapaat digunakan berulang kali
 select * from MataKuliah
 declare @outputMataKuliah as table (
		ID int,
		namaMatkul varchar(200),
		deskripsi varchar(200)
 )


 delete from MataKuliah
 Output deleted.ID,deleted.NamaMataKuliah, deleted.deskripsi
 into @outputMataKuliah
 where ID = 1


 select *  into #tempDeletedMatkul
 from @outputMataKuliah


 select * from #tempDeletedMatkul

 --ini objek yang dapat di declare sebagai value pada sebuah variable

 /*
 SUSUNAN DEKLARASI TABEL
 1.Deklarasi variable tabel
 2. memasukan Isi tabel kedalam variable (kalo sudah ada data yang masuk)
 
 susunan OUPUT
 insert/delete/update
 ouput
 into variable
 where

 
 */

 --user defined table akan terus-terusan ada
 create type Matkul as table (
		ID int,
		namaMatkul varchar(200),
		deskripsi varchar(200)
 )

 declare @tableMataKuliah as Matkul


 insert into MataKuliah
 
 values ('Test',NULL)

 insert into @tableMataKuliah
 select * from MataKuliah 

 select * from @tableMataKuliah


 --newID auto generate sama kyk identity
 select NEWID()

 create table MatKul(
	ID UniqueIdentifier not null,
	[name] varchar(50)
 )

 insert into MatKul 
 values (NEWID(), 'Kalkulus 2'),
		(NEWID(), 'Kalkulus 3')


