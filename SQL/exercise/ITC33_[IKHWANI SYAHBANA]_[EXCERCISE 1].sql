Use Northwind;

--1) USA Employee Phone Book.sql

Select CONCAT(TitleOfCourtesy,' ',FirstName,' ',LastName) as [Nama Lengkap], HomePhone as [Nomor Telepon]
From Employees; 


--2) Territories With All Employee.sql

Select CONCAT(e.FirstName,' ',e.LastName) as [Nama Lengkap], t.TerritoryDescription as [DESKRIPSI]
From Employees e  full JOIN EmployeeTerritories et ON e.EmployeeID = et.EmployeeID
full JOIN Territories t ON t.TerritoryID = et.TerritoryID


--3) Depleted Category.sql
select    c.CategoryName,Count(UnitsInStock) as stockterendah
From Products p JOIN Categories c ON p.CategoryID = c.CategoryID
group by c.CategoryName
order by Count(UnitsInStock) ASC

select * from Products where CategoryID = 10
select * from Categories


--4) Fragile Products.sql

select pc.ProductName as namaProduk, sp.CompanyName as namaPerusahaan,ct.CategoryName as kategori,
pc.QuantityPerUnit as jumlahUnit,pc.UnitsInStock
From  Suppliers sp JOIN Products pc ON pc.SupplierID = sp.SupplierID
JOIN Categories ct ON ct.CategoryID = pc.CategoryID 
where pc.QuantityPerUnit like '%bottles%' OR pc.QuantityPerUnit like '%glasses%' 

select * from products
select * from suppliers
select * from categories



--5) European Product Average Price.sql
select * from Products;
select * from Suppliers;
select sp.Country,AVG(unitPrice) as ratarata
From Suppliers sp JOIN Products pc ON sp.SupplierID = pc.SupplierID
--where Country in ('Germany', 'Spain', 'Sweden', 'Italy', 'Norway', 'Denmark', 'Netherland', 'Finland', 'France') 
group by sp.Country
HAVING AVG(UnitPrice)<50
ORDER by AVG(UnitPrice) DESC

select sp.Country,AVG(unitPrice) as ratarata
From Suppliers sp JOIN Products pc ON sp.SupplierID = pc.SupplierID
where Country in ('Germany', 'Spain', 'Sweden', 'Italy', 'Norway', 'Denmark', 'Netherland', 'Finland', 'France') 
group by sp.Country
HAVING AVG(pc.UnitPrice)<50
ORDER by AVG(pc.UnitPrice) DESC




--6)Favourite Shipper.sql

select TOP 1 sp.CompanyName as namaperusahaan,Count(0) as jumlahOrderan
from shippers sp JOIN Orders o ON sp.ShipperID = o.ShipVia 
group by sp.CompanyName
order by count(o.ShipVia) DESC

select * from orders



