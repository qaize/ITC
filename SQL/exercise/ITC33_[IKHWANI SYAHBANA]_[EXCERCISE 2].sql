Use Northwind;

--7)Total Employee in Every Region.sql

select t.region,count(1) as total from(
select distinct rg.regiondescription region,em.employeeid id
from Employees as em
JOIN EmployeeTerritories as et ON em.EmployeeID = et.EmployeeID
JOIN Territories as tt ON et.TerritoryID = tt.TerritoryID
JOIN Region as rg ON rg.RegionID = tt.RegionID
) as t
group by t.region
order by count(1) DESC


select distinct rg.regiondescription region,em.employeeid id,
from Employees as em
JOIN EmployeeTerritories as et ON em.EmployeeID = et.EmployeeID
JOIN Territories as tt ON et.TerritoryID = tt.TerritoryID
JOIN Region as rg ON rg.RegionID = tt.RegionID

group by rg.regiondescription
order by count(1) DESC


--8) General Phone Book.sql

select * from(
select CONCAT(FirstName,' ',LastName)as FullName, HomePhone as [Nomor Telepon],' Employee ' as Jenis
	from Employees
UNION
select  ContactName as FullName, Phone as [Nomor Telepon],' Customer ' as Jenis
	from Customers
Union
Select ContactName as FullName, Phone as [Nomor Telepon], ' Supplier ' as Jenis
	from Suppliers

) as tab
order by FullName ASC


--9) Familiar Location.sql

WITH employee(Country,NamaKaryawan, HomePhone) as (
Select Country,CONCAT(em.FirstName,' ',em.LastName)as NamaKaryawan, HomePhone
From Employees as em),
Suppliers1(Country,NamaSupplier, Phone) as (
select Country,ContactName as NamaSupplier, Phone
	from Suppliers as su)

select e.Country, e.NamaKaryawan as namaKaryawan, sp.NamaSupplier as Namasupplier, e.HomePhone as [Nomor Hp Karyawan],
 sp.Phone as [Nomor HP Supplier]
From employee  as e
JOIN Suppliers1 as sp ON e.Country = sp.Country

select * From(
select e.Country
from Employees as e
Intersect
select s.Country
from Suppliers as s
) tbl

Join Employees emp on tbl.Country = emp.Country
Join Suppliers s on s.Country = tbl.Country

--10) Job Title Per Region.sql


select pvt.job_title,[Northern],[Eastern],[Southern],[Western],SUM([Northern]+[Eastern]+[Southern]+[Western]) Total from(
select distinct em.EmployeeID as ID, em.Title as job_title, d.RegionDescription as region
 from Employees em
inner join EmployeeTerritories b on em.EmployeeID = b.EmployeeID
inner join Territories c on b.TerritoryID = c.TerritoryID
inner join Region d on c.RegionID = d.RegionID
) as tb
pivot(COUNT(tb.ID) for tb.region in ([Northern],[Eastern],[Southern],[Western])) as pvt

Group by pvt.job_title, [Northern],[Eastern],[Southern],[Western]

UNION ALL
select 'Total' as job_title, SUM(Northern)as[Northern],SUM(Eastern)as[Eastern],SUM(Southern)as[Southern],SUM(Western)as[Western],SUM([Northern]+[Eastern]+[Southern]+[Western]) as Total from(
select distinct em.EmployeeID as ID, em.Title as job_title, d.RegionDescription as region
 from Employees em
inner join EmployeeTerritories b on em.EmployeeID = b.EmployeeID
inner join Territories c on b.TerritoryID = c.TerritoryID
inner join Region d on c.RegionID = d.RegionID
) as tb
pivot(COUNT(tb.ID) for tb.region in ([Northern],[Eastern],[Southern],[Western])) as pvt



