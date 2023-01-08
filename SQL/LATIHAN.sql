Create Database material

use material


--membuat tabel
--tabel mastermaterial
drop table  MasterMaterial
Create table MasterMaterial
(
	CdMaterial varchar(10) PRIMARY KEY NOT NULL,
	MaterialName varchar (50) NOT NULL,
	MaterialWeight Varchar (10) NOT NULL

)

--MasterProduct
Create table MasterProduct
(
	CdProduct varchar(10) PRIMARY KEY NOT NULL,
	ProductName varchar (50) NOT NULL,
	ProductWeight Varchar (10) NOT NULL

)

--master Process
Create table MasterProcess
(
	CdProduct varchar(10) NOT NULL,
	CdMaterial varchar (10) NOT NULL,
	MatUsed int NOT NULL,
	Primary Key (CdProduct,CdMaterial)

)

--TRANSPRODUCTION

Create table TransProduction
(
	CdProduction varchar(20) PRIMARY KEY NOT NULL,
	YearProduction int NOT NULL,
	Qty int,
	PricePerQty money,
	SuccessRatio Decimal(5,2) NOT NULL

)

/*     INSERT DATA          */
UPDATE  MasterMaterial
SET MaterialWeight = '3000'
	where CdMaterial = 'MAT002'

INSERT INTO MasterMaterial
Values  ('MAT001','Plastic','500'),
		('MAT002','Steel','3.000'),
		('MAT003','Foam','80'),
		('MAT004','Liquid','300')

select * from MasterMaterial

INSERT INTO MasterProduct
Values  ('PR001','Product A','3.000'),
		('PR002','Product B','3.000'),
		('PR003','Product C','700')

UPDATE MasterProduct
SET ProductWeight = '3000'
	where ProductWeight = '3.000'

select * from MasterProduct

INSERT INTO MasterProcess
Values  ('PR001','MAT001','5'),
		('PR001','MAT004','4'),
		('PR002','MAT002','1'),
		('PR002','MAT003','5'),
		('PR002','MAT004','1'),
		('PR003','MAT001','1'),
		('PR003','MAT003','5')

select SUM(MatUsed) from MasterProcess

TRUNCATE TABLE TransProduction
INSERT INTO TransProduction
Values  ('PR001/22/01',2019,100,1000000,0.60),
		('PR002/22/01',2019,200,3500000,0.70),
		('PR003/22/01',2019,100,300000,0.80),
		('PR001/24/01',2019,250,1100000,0.70),
		('PR002/26/01',2019,300,3550000,0.80),
		('PR003/28/01',2019,500,350000,0.80),
		('PR001/30/01',2019,400,1300000,0.80),
		('PR002/01/02',2019,500,3400000,0.90),
		('PR003/03/02',2019,600,400000,0.90)

select * from TransProduction



--LATIHAN  NOTE :  NOMOR 2-5 MEMPUNYAI TEMPORARY TABLE YANG SAMA
select * from MasterMaterial
--1. Berat total material yang dipakai untuk Proses pembuatan setiap produk
select mp.CdProduct, mp.ProductName, mp.ProductWeight, SUM(Parse(mm.MaterialWeight as int)*mpo.MatUsed) as TotalWeight
From MasterProduct as mp 
JOIN MasterProcess as mpo on mp.CdProduct = mpo.CdProduct
JOIN MasterMaterial as mm on mpo.CdMaterial = mm.CdMaterial
group by mp.CdProduct,mp.ProductName,mp.ProductWeight

--2.Persentase penyusutan produksi untuk setiap produknya (2 angka dibelakang koma)			
--  dimana rumus penyusutan adalah ProductWeight / TotalMaterialWeight * 100

select mp.CdProduct, mp.ProductName, mp.ProductWeight, SUM(Parse(mm.MaterialWeight as int)*mpo.MatUsed) as TotalWeight
INTO ##TempTotalWeight
From MasterProduct as mp 
JOIN MasterProcess as mpo on mp.CdProduct = mpo.CdProduct
JOIN MasterMaterial as mm on mpo.CdMaterial = mm.CdMaterial
group by mp.CdProduct,mp.ProductName,mp.ProductWeight


select CdProduct, ProductName, ROUND(CONVERT(decimal(10,2), CONVERT(decimal(10,2),ProductWeight)/TotalWeight*100),0) from
##TempTotalWeight 

			

/*3. Harga rata-rata transaksi produksi untuk setiap bulan nya dan diurutkan berdasarkan bulan (1,2,etc..)			
dimana rumus transaksi produksi adalah Qty * PricePerQty			
*/
--drop table ##tempTanggalProduksi
--INI TEMPORARY ##TempTanggalProduksi
select CONCAT(SUBSTRING(CdProduction,10,2),SUBSTRING(CdProduction,6,3),'/',YearProduction) as [MonthName], CdProduction, Qty, PricePerQty, SuccessRatio
INTO ##tempTanggalProduksi
from TransProduction

DECLARE @datetime as table (
		waktu datetime,
)

INSERT INTO @datetime
select [MonthName] from ##tempTanggalProduksi

select DATENAME(MONTH,[MonthName]) as [MonthName], ROUND(AVG(Qty*PricePerQty),2) AverageProductionPrice
from ##tempTanggalProduksi
group by DATENAME(MONTH,[MonthName]) 
Order by DATENAME(MONTH,[MonthName]) DESC


--4.Total Berat Produk untuk seluruh Produksi yang diproduksi pada bulan januari dan tahun 2019, Tampilkan Nama Produk dan Total Berat per Produknya	
--drop table ##TempProdukJanuari

--TEMPORARRY ##TempProdukJanuari dari ##tempTanggalProduksi
select SUBSTRING(CdProduction,1,5) as CdProduction, SUM(qty) as TotalQty
INTO ##TempProdukJanuari From ##tempTanggalProduksi
where DATENAME(MONTH,[MonthName]) = 'January'
group by SUBSTRING(CdProduction,1,5)

select mp.ProductName,SUM(parse(mp.ProductWeight as INT)*tj.TotalQty) as TotalProductWeight from ##TempProdukJanuari tj
JOIN MasterProduct mp ON tj.CdProduction = mp.CdProduct
group by mp.ProductName


--5. Perbandingan rata-rata Success Ratio antara bulan Februari dan bulan januari di tahun 2019 (Beri nama kolom SuccessRatioGrowthPct)			
--dimana rumus SuccessRatioGrowthPct yang dimaksud adalah rata-rata success ratio Feb / rata-rata success ratio Jan * 100)	
select * from TransProduction
--januari
--drop table ##TempSRJanuari
select AVG(SuccessRatio) as januari
INTO ##TempSRJanuari From ##tempTanggalProduksi
where DATENAME(MONTH,[MonthName]) = 'January'
select * from ##TempSRJanuari

--februari (SCALAR VALUE)
--drop table ##TempSRFebruary
select AVG(SuccessRatio) as februari
INTO ##TempSRFebruary From ##tempTanggalProduksi
where DATENAME(MONTH,[MonthName]) = 'February'
select * from ##TempSRFebruary

DECLARE @rataJanuari as DECIMAL(7,6) = (select januari from ##TempSRJanuari),
		@rataFebruari as DECIMAL(7,6) = (select februari from ##TempSRFebruary)

select CONVERT(decimal(8,5), (@rataFebruari/@rataJanuari*100)) as SuccessRatioGrowthPct





drop table ##temptest
select CONCAT( SUBSTRING(CdProduction,10,2),'/',SUBSTRING(CdProduction,7,2),'/',YearProduction) as [MonthName], CdProduction, Qty, PricePerQty, SuccessRatio
INTO ##temptest
from TransProduction
select * from  ##temptest

DECLARE @datetime as datetime = (select [MonthName] from ##temptest where Qty=600 )


select FORMAT(@datetime,'dd MMMM yyyy', 'id-ID')