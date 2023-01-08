
/* 
select * from Employees
Penggunaan value Max dapat memperbesar jumlah Memory pada penyimpanan, gunakan 
dengan bijak
*/

select * from Employees

--Memasukan suatu Querry pada sebuah String

Declare @querryString varchar(MAX) = 'select * from Employees'

exec (@querryString)
execute (@querryString)

go
--Fungsi dari variable dapat digunakan untuk memasukan data dari luar Querry
Declare @paramCity varchar(10) = 'London'

select * from Employees
where City = @paramCity

select * from Employees
where City = 'London'


select  DISTINCT CategoryID FROM Products


select QUOTENAME(CategoryID)  as test from Categories order by CategoryID ASC

declare @panjang as int = (select COUNT(0) from Categories )+1

while(@panjang > 1)
BEGIN
	SET @panjang = @panjang - 1

	print @panjang
END


declare @param int = (select  COUNT(DISTINCT CategoryID) FROM Products)
declare @category varchar(max);
declare @kotak int = 1

while(@param >= @kotak)
begin

	IF(@param=@kotak)
	begin
	SET @category = CONCAT(@category,'[',@kotak,']')
	end

	else
	begin
	SET @category = CONCAT(@category,'[',@kotak,']',',')
	end

	SET @kotak = @kotak+1
end

--declare @columnPiv varchar(MAX) = '[1],[2],[3],[4],[5],[6],[7],[8],[9],[10]'
declare @QuerryString varchar(MAX)
--PIVOT
set @QuerryString  = '
select * from (
	select SupplierID, CategoryID, COUNT(10) TotalProduct 
		From Products
			Where SupplierID Is not null and CategoryID is not null
		group by SupplierID, CategoryID
	) tb1
PIVOT(COUNT(tb1.TotalProduct) for CategoryID in ('+@category+')) pvt
'

exec (@QuerryString)


--VIEW -> Virtual Table (divetable, cte,subquerry) : orderby harus dengan offset/TOP
/* VIEW ini tidak bersifat sementara dan yang disimpan hanya querry
	sifat view tidak dapat menyimpan data atau memanipulasi data
	hanya menampilkan saja sesuai dengan querry yang disimpan saja

	ALANGKAHBAIK kalo update langsung dari table master 
	JANGAN update value dari view

*/
	--UPDATE pake alter
	alter view /*[nama view]*/ Vw_InfromasiProduct as
		(
			select pro.ProductID, pro.ProductName, cat.CategoryName, sp.CompanyName
				from Products pro
				JOIN Suppliers sp on sp.SupplierID = pro.SupplierID
				JOIN Categories cat on cat.CategoryID = pro.CategoryID
		)
	--MEMBUAT VIEW
	create view /*[nama view]*/ Vw_InfromasiProduct as
		(
			select prod.ProductID, prod.ProductName, cat.CategoryName, sp.CompanyName
				from Products prod
				JOIN Suppliers sp on sp.SupplierID = prod.SupplierID
				JOIN Categories cat on cat.CategoryID = prod.CategoryID
		)
	--DROP VIEW
	drop view [nama view]



	--Select View
	select * from Vw_InfromasiProduct

	--update table
	update Products set ProductName = 'chai' where ProductID = 1

	--update master table melalui view (Not Recomended)
	update Vw_InfromasiProduct set ProductName = 'chooooi' where ProductID = 1

	Select * from Vw_InfromasiProduct vw
	JOIN [Order Details] od on od.ProductID = vw.ProductID
		


-- nama lengkpa emp, wilayah territory, region mana
create view Vw_EmployeeTerritoryDescription as
	(
		select CONCAT(em.FirstName,' ',em.LastName)as [Nama Lengkap], tt.TerritoryDescription, rg.RegionDescription
			FROM Employees em
			JOIN EmployeeTerritories emt on emt.EmployeeID = em.EmployeeID
			JOIN Territories tt on tt.TerritoryID = emt.TerritoryID
			JOIN Region rg on rg.RegionID = tt.RegionID
	)

	select * from Vw_EmployeeTerritoryDescription

--querry untuk melihat detail/informasi kolom pada sebuah databases yang diselect
select * from INFORMATION_SCHEMA.COLUMNS


--PENGKODISIAN IF, IF ELSE, IF ELSE IF CASE, CASE WHEN
-- IF STATEMENT BEGIN END = if {}

declare @angka int =2

if (@angka = 2)
begin 
	print 'SEMONGKO'
end

else 
begin print 'sad' end

--mirip2 kek ini

if (kondisi)
{
}

else if (kondisi)
{

}

else
	{ }


IIF(paramterkondiisi = 1,'Discontinued', iif(Discontinued = 0,'Continued','N/A') )


select pd.ProductID, pd.ProductName, Discontinued,
IIF(Discontinued = 1,'Discontinued',
IIF(Discontinued = 0,'Continued','N/A')) as Discontinued
from Products pd

select EmployeeID,FirstName,
case when Region = 'WA' then 'WA'
	else 'NO REGION'
 END AS TEST
 from Employees

 /*
 Untuk Querry ini lebih ke memberi Value pada sebuah kolom yang sesuai dengan kondisi
 yang diberikan

 strukturnya :
 IIF()
 
 */
select EmployeeID,FirstName,
IIF(Country = 'USA','Amerika',
IIF(Country = 'UK', 'Inggris','no COuntry'
)
) AS Negara
 from Employees

 select * from Employees

 select ProductName,
 CASE WHEN UnitsInStock >50 then 'Banyak'
	  When UnitsInStock>20 AND UnitsInStock<50 then 'Lumayan'
	  when UnitsInStock<20 then 'sedikit'
	  else 'tidak teridentifikasi'
	 END AS Kriteria 
  from Products


--PERULANGAN
-- break itu untuk berhenti
--continue itu untuk mengulang ke kondisi atas

DECLARE @angka int = 0

while (@angka <= 10)
begin
	
	set @angka = @angka + 1
	print 'sad'
	break
	IF(@angka % 2 = 0 )
	BEGIN
	Print CONCAT(@angka,' Adalah Genap')
	continue
	END

	ELSE
	BEGIN
	Print CONCAT(@angka,' Adalah Ganjil')
	END
end



---

CREATE TABLE #temp(ColumnA VARCHAR(10),ColumnB INT ,ColumnC VARCHAR(10))
--insert rows
insert into #temp
values( 'abv',12,'sxd'),( 'abv',12,'sxd'),( 'abv',12,'sxd')


SELECT t.[ColumnA] ,
         [ColumnB] = STUFF((SELECT  ','+cast([ColumnB] AS VARCHAR ) FROM  #Temp WHERE  [ColumnA]  = t.[ColumnA]  FOR XML PATH('')),1,1,''),
         [ColumnC] = STUFF((SELECT  ','+[ColumnC] FROM #Temp WHERE [ColumnA] = t.[ColumnA] FOR XML PATH('')),1,1,'')
FROM #Temp t

drop table #temp

--------------------------
create table #t 
(
id int,
displayname nvarchar(max)
)

insert into #t values    
 (1 ,'Editor')
,(1 ,'Reviewer')
,(1 ,'EIC')
,(1 ,'Editor')
,(1 ,'Reviewer')
,(1 ,'Editor')
,(1,'EIC')
,(1,'Editor')
,(1,'Reviewer')

SELECT id, displayname = 
    STUFF((
	
	SELECT DISTINCT ', ' + displayname
           FROM #t b 
           WHERE b.id = a.id 
          FOR XML PATH('')), 1, 1, '')
FROM #t a
GROUP BY id
-------------------------------------------------------------------------------
DECLARE @par varchar(MAX)

SET @par = STUFF(
					(SELECT CONCAT ( ',[' ,CategoryID ,']')
						FROM Categories ORDER BY CategoryID FOR XML PATH('') ), 1, 1, '')

declare @col varchar(max)
set @col = STUFF(
				(SELECT CONCAT(',ISNULL([', CategoryID , '],0) AS [', CategoryID, ']')
				FROM Categories 
				ORDER BY CategoryID FOR XML PATH ('')
				), 1, 1, '')


declare @QuerryString varchar(MAX)
--PIVOT
set @QuerryString  =
 '
select pvt.SupplierID,'+@col+' from (
	select SupplierID, CategoryID, COUNT(10) TotalProduct 
		From Products
			Where SupplierID Is not null and CategoryID is not null
		group by SupplierID, CategoryID
	) tb1
PIVOT(SUM(tb1.TotalProduct) for CategoryID in ('+@par+')) pvt
'

exec (@QuerryString)







declare @tab as table (id varchar(MAX))




DECLARE @test as int = (select COUNT(CategoryID) from Categories)

while (@test>0)

begin

insert into @tab
select CONCAT(',[',CategoryID,']') from Categories where CategoryID = @test

SET @test = @test -1

end
select * from @tab 





--try catch
declare @angka varchar(20) = '10a'

select try_PARSE(@angka as int)


begin try
	select PARSE(@angka as int)
end try

begin catch
	--print 'Gona wrong'
	--select 'salah '
	PRINT ERROR_MESSAGE() PRINT ERROR_LINE()
end catch

--label goto
declare @pilihan int = 1

if @pilihan = 1 GOTO pilihansatu
if @pilihan = 2 GOTO pilihandua


pilihansatu:
	select 'pilihan 1'
pilihandua:
	select 'pilihan 2'




--Menjumlahkan angka yang ada dalam sebuah value

declare @soal1 as varchar(max) = 'IND0CYB3R GL0B4L T3KNOL0G1'
declare @jumlahKata int = DATALENGTH(@soal1)
declare @jum int = 1;
declare @inserted varchar (1) = ''
declare @into as int
declare @ge int = 0

while (@jumlahKata>=0 )
BEGIN
	
	BEGIN TRY 
		--ini mencari nilai satu per satu dari dara
		SET @inserted =  substring(@soal1,@jum,1)
		--menambahkan nilai parameter substring
		SET @jum = @jum+1
		--mengurangin looping
		SET @jumlahKata = @jumlahKata - 1
		--memasukan nilai angka ke variable kalo bukan angka dia akan ke CATCH 
		SET @into = parse(@inserted as int)
		--menjumlahkan nilai
		SET @ge = @into + @ge
	END TRY
	BEGIN CATCH
		print 'Cant Convert VARCHAR'
	END CATCH
END
select @ge as Jumlah



--angka terbesar dari sebuah value
declare @soal1 as varchar(max) = 'IND0CYB3R GL0B4L T3KNOL0G1'
declare @jumlahKata int = DATALENGTH(@soal1)
declare @jum int = 1;
declare @inserted varchar (1) = ''
declare @into int
declare @tabelTemp as table (id int)


while (@jumlahKata>=0 )
BEGIN
	
	BEGIN TRY 
		--ini mencari nilai satu per satu dari dara
		SET @inserted =  substring(@soal1,@jum,1)
		--menambahkan nilai parameter substring
		SET @jum = @jum+1
		--mengurangin looping
		SET @jumlahKata = @jumlahKata - 1
		--memasukan nilai angka ke variable kalo bukan angka dia akan ke CATCH 
		SET @into = parse(@inserted as int)
		--memasukan nilai pada vairable tabel
		insert into @tabelTemp
			values (@into)


	END TRY
	BEGIN CATCH
		print 'Cant Convert VARCHAR'
	END CATCH
END
select MAX(id) nilaiMaksimal from @tabelTemp 




--3.membuat kalimat dengan penulisan yang sesuai
declare @soal3 varchar(30) = 'hARI iNI TiDaK HuJaN'
/*
	MEKANISME SOAL 3
	1. DECLARE VARIABLE
	2. LOWER VAIRABLE
	3. SELECT SUBSTRING SATU PER SATU
	4. JIKA SUBSTRING PERTAMA UPPER
	5. ELSE IF SUBSTRING = SPASI MAKA UPPER NEXT CHARCHTER
	6. TAMPILKAN


*/

declare @soal1 as varchar(max) = LOWER('sAya sAngAt berSEMAngat Kali INI')
declare @jumlahKata int = DATALENGTH(@soal1)
declare @jum int = 1;

while (@jumlahKata>0 )
BEGIN
	IF(@jumlahKata = 1)
		BEGIN
			SET @soal1 = STUFF(@soal1, 1, 1, UPPER(SUBSTRING(@soal1,1,1)));
		END

	ELSE IF (SUBSTRING(@soal1,@jum,1) = ' ' ) 
		begin
	
			SET @soal1 = STUFF(@soal1, @jum+1, 1, UPPER(SUBSTRING(@soal1,@jum+1,1)));
		
		end

	ELSE 
	BEGIN
		print 'GG'
	END
	SET @jum = @jum + 1
	SET @jumlahKata = @jumlahKata - 1
END

select @soal1

