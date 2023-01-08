use Northwind

--15) Sales Customer Relation.sql

create view Vw_HistoryOrderSalesman as( 
select CONCAT(em.TitleOfCourtesy, ' ',FirstName,' ',LastName ) as [Salesman],cst.ContactName [Nama Costumer] from Orders od
JOIN Employees em on em.EmployeeID = od.EmployeeID
JOIN Customers cst on cst.CustomerID = od.CustomerID
WHERE em.TitleOfCourtesy NOT IN ('Ms.','Mrs.') AND em.Title LIKE '%Representative%'  
order by Salesman
OFFSET 0 ROWS
)

select * from Vw_HistoryOrderSalesman

--16) Grouping By Stock.sql


select * from ProductS
alter function StokProduk(@unit as int)
returns varchar(100) as
begin
	declare @label varchar(50) = ''
	IF(@unit < 20)
		begin
			SET @label = '(INSFUCIENT)'
		end
	ELSE IF(@unit >=20 AND @unit<=80)
		begin
			SET @label = '(Sufficient)'
		end
	ELSE
		begin
			SET @label = '(Adbundant)'
		end 
		return (@label)
end
select UnitsInStock,ProductName+dbo.StokProduk(UnitsInStock) as productName from Products
order by UnitsInStock ASC

--17) Expensive Showoff.sql
select pd.ProductName,sp.CompanyName,UnitPrice,
RANK() OVER ( ORDER BY pd.UnitPrice DESC) As [Rank]
from Products pd
JOIN Suppliers sp on sp.SupplierID = pd.SupplierID
JOIN (
		select sp.SupplierID, MAX(UnitPrice) [Harga Tertinggi] from Products pd
			JOIN Suppliers sp  on pd.SupplierID = sp.SupplierID
			group by sp.SupplierID
			order by [Harga Tertinggi] DESC
			OFFSET 0 ROWS		
) tabel on sp.SupplierID = tabel.SupplierID
where sp.SupplierID = pd.SupplierID AND tabel.[Harga Tertinggi]=pd.UnitPrice
group by pd.ProductName,sp.CompanyName,UnitPrice



--18) Reordering Calculator.sql

create function dbo.HargaTotalReorder()
returns table as return
select ProductName,UnitPrice as [harga per unit],ReorderLevel as[jumlah reorder],UnitPrice*ReorderLevel as [Total Harga] from Products

select * from dbo.HargaTotalReorder()


--19) Count Meat Order.sql
select YEAR(OrderDate) from Orders

create function ShortDagingByYear(@tahun as int)
returns table as return
select pd.ProductName,cat.CategoryName as Kategori, COUNT(pd.ProductID) [Jumlah Order] from Products pd
JOIN [Order Details] odet on odet.ProductID = pd.ProductID
JOIN Orders od on odet.OrderID = od.OrderID
JOIN Categories cat on cat.CategoryID = pd.CategoryID
where cat.CategoryName = 'Daging' AND  YEAR(OrderDate) = @tahun
GROUP BY pd.ProductName,cat.CategoryName

select * from dbo.ShortDagingByYear(1998)

--20) Salesman Performance.sql

create function dbo.BonusSalesman (@id as int,@tahun as int)
returns table as return
select tb1.EmployeeID,SUM(Total)*0.10 as [Total Bonus Tahun ini] from (
select em.EmployeeID,od.OrderID, odet.UnitPrice*odet.Quantity as Total from Orders od
JOIN [Order Details] odet on odet.OrderID = od.OrderID
JOIN Employees em on od.EmployeeID = em.EmployeeID
where YEAR(od.OrderDate) = @tahun AND em.EmployeeID = @id
) tb1
group by tb1.EmployeeID

select * from dbo.BonusSalesman(2,1998)

--21) Total Quantity Product Sold.sql

create function dbo.JumlahProdukTerjual (@bulan as int,@tahun as int)
returns table as return
select pd.ProductName,DATENAME(MONTH,od.OrderDate) as bulan,YEAR(od.OrderDate) as tahun, COUNT(odet.OrderID) as JumlahOrder  from Orders od
JOIN [Order Details] odet on odet.OrderID = od.OrderID
JOIN Products pd on odet.ProductID = pd.ProductID
where MONTH(od.OrderDate)=@bulan AND YEAR(od.OrderDate)=@tahun
Group by pd.ProductName,DATENAME(MONTH,od.OrderDate),YEAR(od.OrderDate)

select * from dbo.JumlahProdukTerjual(11,1997)

--22) Income Fluctuation.sql

select od.OrderDate,(odet.Quantity*odet.UnitPrice) as [Total Harga],
LAG (odet.Quantity*odet.UnitPrice) OVER (ORDER BY odet.Quantity*odet.UnitPrice) AS Perubahan
from Orders od
JOIN [Order Details] odet on od.OrderID = odet.OrderID


