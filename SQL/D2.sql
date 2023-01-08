use Northwind;

select * from Customers

select * from Suppliers

--error karene=a ambigu
select cu.CompanyName, su.CompanyName
from Customers cu,Suppliers su
--solusi
select cu.CompanyName, su.CompanyName
from Customers cu,Suppliers su


--klausa Where
select * from Employees

select * from Employees
	where City = 'London'

-- Multi Where OR AND
select * from Employees
	where (City = 'London') AND (City = 'Seattle')
	OR (City = 'Tacoma') OR (EmployeeID < 3) AND (EmployeeID NOT BETWEEN 2 AND 6)

--multi kondisi dengan IN dengan syarat sumber data/kolom yang sama
select * from Employees
	where City IN ('London','Tacoma')

select * from Employees
	where City NOT IN ('London','Tacoma')


--Sintaks select dalam klausa IN dimana syaratnya harus sesuai dengan data yang di select
select * from Employees
	where City IN (Select City from Suppliers 
	
	Where City ='London' OR City='Osaka')

--tipe value

--scalar value
select 10 

--list Value
select City From Employees

--Table Value
select * from Employees


select * from Suppliers
where City = 'Osaka' OR City='Tokyo'


select * from Suppliers
--akhiran pencarian kata SON %a    ,,,,,awal a%
select * from Suppliers
	Where ContactName Like '%son'

--pencarian yang ada kata pet
select * from Suppliers
	Where ContactName Like '%Pet%'

--mencari null

select * from Employees
where Region is null

--Not Null
select * from Employees
where Region is NOT null

--format date yyyy-mm-dd  atau MM-DD-YYY
--format time HH:MM:SS

select * from Employees Where
BirthDate > '1948-12-08'




--Summary Record
-- AVG MAX MIN SUM COUNT
select * from Employees
--banyak data yang ada pada suatu kolom9=(jmlh Data)
select Count(Region) from Employees;
--Count menggunakan penambahan Data
select SUM(100)from Employees;

--Jumlah Value dari suatu data
select SUM(EmployeeID) from Employees;

--MAX data ter gede
select MAX(EmployeeID) from Employees;

--MIN Data ter Rendah
select MIN(EmployeeID) from Employees;

--RATA2
select AVG(EmployeeID) from Employees;



--GROUP BY

Select City, COUNT(0) as jumlahData 
From Employees  Group by City

Select City, COUNT(0) as jumlahData 
From Employees Where City='London'  Group by City


select * from Employees

Select Country, City, COUNT(EmployeeID) as jumlahData 
From Employees  Group by Country,City

--manipulasi menghitung jenis data duplikat atau membuang 

select Distinct City from Employees

select Distinct City,Country from Employees

select Distinct City from Employees

select COUNT(Distinct City) from Employees

select SUM(se.tit) as 'Total Employee' from (
select TitleOfCourtesy as test,COUNT( TitleOfCourtesy) tit from Employees
Group by TitleOfCourtesy ) as se


select * from Employees

--order BY

select * from Employees
Order by FirstName DESC, LastName ASC

select * from Employees
Order by FirstName ASC, LastName DESC


Select CONCAT(FirstName,LastName) as 'fullName' from Employees
where City = 'London' order by CONCAT(FirstName,LastName) DESC


--penggunaan having
select City, Count (EmployeeID) TotalEmp
From Employees Where City != 'London'
Group by City
HAVING COUNT(EmployeeID)  > 0

--menampilkan nilai custom

Select * from Customers 
order by CustomerID
offset 4 rows--memangkas nilai 4 teratas
 fetch next 3 rows only--menampilkan nilai teratas setelah adanya offset

 --aayo dong optimis ,jangan malas tod
 Select * from Employees
 Select City, COUNT(EmployeeID) EmpTERBANYAK
 from Employees Group by City
 order by COUNT(0) DESC
 offset 0 rows
 fetch next 1 rows only


 select City, Count (EmployeeID) TotalEmp
From Employees
Group by City
HAVING COUNT(EmployeeID)  > 0



-- Join 

select * from Employees
select * from EmployeeTerritories
select * from Territories

/* Inner Join
   left/right Join
   Outer Join'Full Join */

   --Inner Join
   --tabel yang smua data di left akan ditampilkan dan irisan 
   select P.ProductId, P.ProductName,P.CategoryID,c.CategoryID
   From Products P left JOIN Categories C ON P.CategoryID = C.CategoryID

   --tabel yang smua data di right akan ditampilkan dan irisannya
      select P.ProductId, P.ProductName,P.CategoryID,c.CategoryID
   From Products P Right JOIN Categories C ON P.CategoryID = C.CategoryID

   --irisan saja, data yang sama akan ditampilkan
      select P.ProductId, P.ProductName,P.CategoryID,c.CategoryID
   From Products P  JOIN Categories C ON P.CategoryID = C.CategoryID

   --menampilkan left dan right join
         select P.ProductId, P.ProductName,P.CategoryID,c.CategoryID
   From Products P FULL JOIN Categories C ON P.CategoryID = C.CategoryID

         select P.ProductId, P.ProductName,P.CategoryID,c.CategoryID
   From Products P  CROSS JOIN Categories C  order by c.CategoryID DESC

   select * from Products

   select * from Categories

  -- INNER JOIN 
  select DISTINCT c.City
  from Customers s 
  INNER JOIN Suppliers c ON s.City = c.city

  --cara old 
  select DISTINCT s.City
  from Customers s where s.City in (Select City from Suppliers)

   --syarat  union dan intersect jumlah kolom harus sama 
   /* tipe data kolom tidak boleh berbeda*/
   --seperti join
   Select DISTINCT City from Customers
   INterSeCt
   SELECT DISTINCT City from Suppliers

   -- Union ini jumlah kolom harus sesuai 

     Select * from Customers
  -- Union all
   SELECT * from Suppliers

   --union automtasid distinct, untuk menampilkan semua tinggal tambah syntax all

   Select City from Customers
   Union 
   SELECT City from Suppliers
   order by City DESC

   (Select City, CustomerID as id from Customers
   Union 
   SELECT City,CONCAT('',SupplierID) from Suppliers)
   order by City DESC

   select DISTINCT * From

      (Select City, CustomerID as id from Customers
   Union 
   SELECT City,CONCAT('',SupplierID) from Suppliers
   where SupplierID = 3
   ) as tbl
   where tbl.City like '%o%'
   
   
   order by tbl.City DESC



   --ini sub querry
   select (select city from Employees),* From

      (Select City, CustomerID as id from Customers
   Union 
   SELECT City,CONCAT('',SupplierID) from Suppliers
   where SupplierID = 3
   ) as tbl
   where tbl.City like '%o%'
   
   
   order by tbl.City DESC

   select DISTINCT s.city,count(0) as jumlahCust
   From Customers s JOIN Suppliers c
   on s.city = c.city 
   group by s.city
   order by COUNt(0) DESC
   offset 0 rows
   fetch next 3 rows only

	Select * from
   (select DISTINCT c.city,count(0) as jumlahCust
   From Customers s LEFT JOIN Suppliers c
   on s.city = c.city where c.city is not null
   group by c.city
   order by COUNt(0) DESC
   offset 0 rows
   fetch next 3 rows only) as cus

   UNION
   select * From
   (select DISTINCT s.city,count(0) as jumlahsupp
   From Customers s RIGHT JOIN Suppliers c 
   on s.city = c.city where s.city is not null
   group by s.city
   order by COUNt(0) DESC
   offset 0 rows
   fetch next 1 rows only) as sup

   select * from Suppliers

 select City,Count(1) as JumlahCust from Customers
   group by city
   Order by Count(City) DESC

   select City,Count(1) as JumlahCust from Suppliers
   group by city
   Order by Count(City) DESC

select 

select Country,count(1) as [jumlah kota] from Suppliers
group by Country
order by Count(SupplierID) DESC
