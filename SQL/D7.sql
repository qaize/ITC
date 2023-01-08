--FUNCTION
/*
	1.FUNCTION(FC) MEMILIKI PARAMETER/TIDAK
	2. MEMPUNYAI RETURN TIPE DATA
	3. FN YANG DIBUAT SENDIRI - User Defined Function

*/


create function dbo.Penjumlahan(@par1 as int,@par2 as int)
RETURNS INT AS

BEGIN
RETURN @par1+@par2
END

select dbo.Penjumlahan(1,2) as hasil



select * from Products
create function ChangeValueDiscontinued(@val as int)
returns varchar(20) as
	begin
	declare @hasil varchar(MAX) = 'Continued'
	if(@val = 1)
		begin
			set @hasil = 'Discontinued'
		end
		return (@hasil)
	end

select ProductID,ProductName,Discontinued
from Products
select ProductID,ProductName,dbo.ChangeValueDiscontinued(Discontinued) as keterangan 
from Products

alter function ChangeValueDiscontinued(@discontinued as int, @unitinstock as int)
returns varchar(20) as
begin
	--declare @hasil varchar(MAX) = 'Continued'
	declare @hasil varchar(MAX) = ' '
	if(@discontinued = 1)
		begin
			set @hasil = 'Discontinued'
		end
	else
		begin
			IF (@unitinstock = 0)
			begin
				set @hasil = 'Discontinued'
			end
			else
			begin
			set @hasil = 'Continued'
			end
		end
	return (@hasil)
end
go


--latihan yang soal nomor 3 kmarin di jadikan function

alter function dbo.soaltiga(@soal1 as varchar(MAX))
returns varchar(max) as
BEGIN
declare @tampung varchar(max) = LOWER(@soal1)
declare @jumlahKata int = DATALENGTH(@soal1)
declare @jum int = 1;

while (@jumlahKata>0 )
BEGIN
	IF(@jumlahKata = 1)
		BEGIN
			SET @tampung = STUFF(@tampung, 1, 1, UPPER(SUBSTRING(@tampung,1,1)));
		END

	ELSE IF (SUBSTRING(@tampung,@jum,1) = ' ' ) 
		begin
	
			SET @tampung = STUFF(@tampung, @jum+1, 1, UPPER(SUBSTRING(@tampung,@jum+1,1)));
		
		end

	SET @jum = @jum + 1
	SET @jumlahKata = @jumlahKata - 1
END
	return (@tampung)
END

select dbo.soaltiga('sAya sAngAt berSEMAngat Kali INI') as kata



------------table function
create function dbo.ViewInformasiProdukByUnitPrice(@unitPrice as money)
returns table as return
select prod.ProductID, prod.ProductName, cat.CategoryName, sp.CompanyName,
	prod.UnitPrice from Products prod
	JOIN Suppliers sp on sp.SupplierID = prod.SupplierID
	JOIN Categories cat on cat.CategoryID = prod.CategoryID
	where prod.UnitPrice > @unitPrice

select * from dbo.ViewInformasiProdukByUnitPrice(50)

--informasi lengkap employee buat pencariannnya by Employee ID

create function dbo.InformasiEmployee(@IdEmploye as int)
returns table as return
	select * from Employees
	where EmployeeID = @IdEmploye

select * from dbo.InformasiEmployee(1)

--schema bending
/*
	schema bending tidak bisa di alter
	- tujuannya untuk security untuk menetapkan tabel yang fix tidak dapat 
	  diubah2

	  WITH SHCEMABENDING
*/
--WINDOW RANKING
/*

*/
SELECT emp.EmployeeID, emp.FirstName, emp.LastName,
ROW_NUMBER() OVER (ORDER BY emp.FirstName) As RowNumber
FROM dbo.Employees emp
ORDER BY emp.EmployeeID;

SELECT emp.EmployeeID, emp.FirstName, emp.LastName,
ROW_NUMBER() OVER (ORDER BY emp.FirstName) As RowNumber
FROM dbo.Employees emp
ORDER BY RowNumber;
/*
PARTITTION BY dapat mengelompokan berdasarkan rownya
*/

SELECT emp.EmployeeID, emp.FirstName, emp.LastName, emp.Country,
ROW_NUMBER() OVER (PARTITION BY emp.Country ORDER BY emp.FirstName) As RowNumber
FROM dbo.Employees emp
--ORDER BY RowNumber;