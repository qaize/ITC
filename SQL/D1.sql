USE Northwind;


select 'test'
select dbo.Username 'user alias',[Password], 'Role' [rollll] from Account as dbo;

select Username [user alias],[Password] from dbo.Account;

select Username [user alias],[Password],'TEST' as 'tambahan kolom' from Account;


Select EmployeeID 'ID',(FirstName+' '+LastName) as 'nama Lengkap'
from Employees


Select EmployeeID 'ID',CONCAT(FirstName, ' ' ,LastName) as 'nama Lengkap'
from Employees

Select * from Employees

Select EmployeeID, CONCAT(FirstName, ' ' ,LastName) as 'Fullname',
 CONCAT([City],', ',[Address],', ',[Region],', ',[PostalCode]) as Alamat 
from Employees


Select FirstName,CompanyName from Employees,Customers
Select CompanyName,FirstName from Employees,Customers

Select cust.CompanyName as namaPerusahaan from Customers as cust
select * from Employees
Select EmployeeID, CONCAT(FirstName, ' ' ,LastName) as 'Fullname',
 (City+ ' '+[Address]+' '+'Region'+' '+PostalCode) as Alamat 
from Employees

Select EmployeeID, CONCAT(FirstName, ' ' ,LastName) as 'Fullname',
 CONCAT([City],', ',[Address],', ',[Region],', ',[PostalCode]) as Alamat 
from Employees