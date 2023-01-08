use Northwind;

--11 Product with Highest Asset.sql


select ProductName,UnitPrice,UnitsInStock+UnitsOnOrder as [Total Unit],(UnitsInStock+UnitsOnOrder)*UnitPrice as [Harga Total]
 from Products
	where Discontinued != 1
order by (UnitsInStock+UnitsOnOrder)*UnitPrice DESC



--12 Old To Young.sql
select CONCAT(FirstName, ' ', LastName) as [Nama Karyawan],( 2022-YEAR(BirthDate)) as [Usia Sekarang]
from Employees
order by ( 2022-YEAR(BirthDate)) DESC

--13 Product in XML.sql

Select top 2 p.ProductName as [Name], ct.CategoryName as [Category],CompanyName as Supplier, UnitPrice as price
from Products as p 
JOIN Categories as ct ON p.CategoryID = ct.CategoryID  
JOIN Suppliers s on s.SupplierID=p.SupplierID
for XML RAW('Product'), ROOT('ProductList'), elements

--14 Total Variation in Invoice.sql


select od.OrderID as ID, FORMAT(o.OrderDate, 'dd MMMM yyyy', 'id-ID') as [Tanggal Order], COUNT(p.CategoryID) as [Total Jenis Kategori] 
from [Order Details] as od
JOIN Products as p on od.ProductID = p.ProductID
JOIN Categories c on p.CategoryID = c.CategoryID
JOIN Orders as o on o.OrderID = od.OrderID
Group by od.OrderID, o.OrderDate
Order by o.OrderDate


select * from [Order Details]