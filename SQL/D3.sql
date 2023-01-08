USE Northwind;


Select *
From (Select prod.ProductName,prod.SupplierID From
Products as prod 
where Discontinued = 1) as pd
ORDER by pd.ProductName DESC

--nested 3 join tampilkan productname,company name, contactName,categoryName

Select prod.ProductID, prod.ProductName, sup.CompanyName, sup.ContactName, cat.CategoryName From
(Select ProductID, ProductName, SupplierID,CategoryID From Products 
	Where Discontinued = 0) as prod
JOIN 
(Select SupplierID, CompanyName, ContactName From Suppliers
	Where city in (select city from Suppliers)
) as sup ON prod.SupplierID = sup.SupplierID
JOIN 
(Select CategoryID,CategoryName from Categories) as cat ON prod.CategoryID = cat.CategoryID

use Northwind

Select emps.City,Count(1) as jumKot From(
select emp.City
from Employees emp) as emps
group by emps.City
order by count(1) DESC

select sup.Country,count(1) as jum From(
select sups.Country from Suppliers sups) as sup
group by sup.Country
order by count(1) DESC

-- SUB QUERRY 

select * from Products
select * from Suppliers
select * from Categories

--keluarin informasi produk berupa nama produk, nama suplier, suppl  dari negara jepang
--kategori bukan daging
Select  *
from Products
where Discontinued = 1

select * From Suppliers
where Country = 'Japan'

select * from Categories 
where CategoryName !='Daging'

--in sub querrynya
select prod.ProductName, prod.SupplierID,sup.CompanyName,ct.CategoryName from 
(
	Select  ProductName,SupplierID,CategoryID
	from Products
		where Discontinued = 1

) as prod
LEFT JOIN (
	select SupplierID,CompanyName From Suppliers
		where Country = 'Japan' 
)  as sup ON prod.SupplierID = sup.SupplierID
left Join (
select CategoryID, CategoryName from Categories 
where CategoryName !='Daging'
) as ct ON prod.CategoryID = ct.CategoryID

-- products menyeseuaikan data yang ada pada tabel supplier
select * from Suppliers sup
where exists (
	select SupplierID
		from Products
			where SupplierID = sup.SupplierID AND  UnitsInStock>0

)
--select exist null
select * from Suppliers sup
where exists (
	select null
)

select * from Suppliers sup
where NOT exists (
	select null
)

--where isi fungsi ANY harus di sesuaikan sama kolom yang di select
select * from Suppliers sup
where SupplierID = ANY (
select SupplierID from Products where Discontinued = 1
)
-- ANY harus menggunakan list dan skalar value
select * from Products
	where ProductID = ANY(
		select od.ProductID
		from [Order Details] od
		where od.ProductID > 5
	)

select * from Products
	where ProductID = ALL(
		select od.ProductID
		from [Order Details] od
	
	)

--ISNULL fungsi yang digunakan untuk merubah nilai null menjadi sesuatu
select Region,ISNULL(Region, 'N/A')
from Employees


--derived table
select tablebaru.NamaProduk from 
(Select ProductName as NamaProduk from Products)
as tablebaru

--penggunan derived table menggunakan order by
select * from (
select  SupplierID,ProductName
from Products
order by ProductName ASC
) tb


--
with TotalProdukSuppCat5(SupplierID,TotalProduct) as (
	select SupplierID, Count(1) TotalProduct
	from Products
	where CategoryID = 5
	group by SupplierID
),
TotalProdukSuppNotCat5(SupplierID,TotalProduct) as (
	select SupplierID, Count(1) TotalProduct
	from Products
	where CategoryID != 5
	group by SupplierID
)



select sup.CompanyName,prod.TotalProduct from TotalProdukSuppCat5 prod
join Suppliers sup on prod.SupplierID = sup.SupplierID
union
select sup.CompanyName,prod.TotalProduct from TotalProdukSuppNotCat5 prod
join Suppliers sup on prod.SupplierID = sup.SupplierID



WITH ProdCTE as (

	select SupplierID, ProductName ,CategoryID
	from Products 
	where SupplierID = 1

)

select pc.* from ProdCTE as pc















use Company

WITH EmpHirarkie as (

select emp.ID,emp.[Name], emp.Gender,emp.DepartmentID, emp.SupervisorID
from Employee as emp
where emp.SupervisorID is null
Union ALL
select emp.ID,emp.[Name], emp.Gender,emp.DepartmentID, emp.SupervisorID  
from Employee as emp
join EmpHirarkie as cte on emp.SupervisorID = cte.ID



)

select * from EmpHirarkie;

select * FROM PRO

--PIVOT
select * from(
select CategoryID, SupplierId, UnitsInStock
from Products
where CategoryID is not Null
) tb
PIVOT (SUM(UnitsInStock) for SupplierID in ([1],[2])) as pvt


select * from ( 

select sup.CompanyName Supplier, cat.CategoryName as Category, COUNT(1) TotalProduk
from Products  prod
JOIN Categories cat on prod.CategoryID = cat.CategoryID
JOIN Suppliers sup on prod.SupplierID = sup.SupplierID
where prod.CategoryID is not null
Group by sup.CompanyName,cat.CategoryName

) tbl

PIVOT(SUM(TotalProduk) for Category in ([Beverages],[Condiments],[Confections])) as pvt

--

select pvv.Supplier, pvv.CategoryName, TotalProduk from (
select * from ( 

select sup.CompanyName Supplier, cat.CategoryName as Category, COUNT(1) TotalProduk
from Products  prod
JOIN Categories cat on prod.CategoryID = cat.CategoryID
JOIN Suppliers sup on prod.SupplierID = sup.SupplierID
where prod.CategoryID is not null
Group by sup.CompanyName,cat.CategoryName

) tbl

PIVOT(SUM(TotalProduk) for Category in ([Beverages],[Condiments],[Confections])) as pvt


) as tblpvt
UNPIVOT (TotalProduk for CategoryName in([Beverages],[Condiments],[Confections])) as pvv

--employeeName dan total teritorie
select * from Territories
select * from EmployeeTerritories

select * from (
select top 10 concat(FirstName,' ',LastName) as FULLNAME,COUNT(0) as totalTet
From Employees as em
JOIN EmployeeTerritories as et 
ON em.EmployeeID=et.EmployeeID
group by concat(FirstName,' ',LastName)
order by concat(FirstName,' ',LastName) DESC
)  emp

PIVOT(SUM(totalTet) For FULLNAME in (

[Andrew Fuller],
[Anne DodsWorth],
[Janet Leverling],
[Laura Callahan],
[Margaret Peacock],
[Michael Suyama],
[Nancy Davolio],
[Robert King],
[Steven Buchanan])) as pvt

select * from (
select concat(FirstName,' ',LastName) as fullname,em.EmployeeID as employee,COUNT(0) as totalTet
From Employees as em
JOIN EmployeeTerritories as et 
ON em.EmployeeID=et.EmployeeID
JOIN Territories as tt ON et.TerritoryID = tt.TerritoryID
group by concat(FirstName,' ',LastName),em.EmployeeID
)  emp

PIVOT(SUM(totalTet) For employee in (

[Andrew Fuller],
[Anne DodsWorth],
[Janet Leverling],
[Laura Callahan],
[Margaret Peacock],
[Michael Suyama],
[Nancy Davolio],
[Robert King],
[Steven Buchanan])) as pvt


--Unpivot
select * from (

)  emp

PIVOT(SUM(totalTet) For employee in (

[Andrew Fuller],
[Anne DodsWorth],
[Janet Leverling],
[Laura Callahan],
[Margaret Peacock],
[Michael Suyama],
[Nancy Davolio],
[Robert King],
[Steven Buchanan])) as pvt


