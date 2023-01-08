use Northwind
select pvt.Title,pvt.Northern,pvt.Southern,pvt.Eastern,pvt.Western,SUM([Northern]+[Southern]+[Eastern]+[Western]) as Total from(
select DISTINCT em.EmployeeID as ID, em.Title, r.RegionDescription
From Employees em
JOIN EmployeeTerritories et on em.EmployeeID = et.EmployeeID
JOIN Territories t ON et.TerritoryID = t.TerritoryID
JOIN Region r ON r.RegionID = t.RegionID
) as tbl1
PIVOT(COUNT(tbl1.ID) for tbl1.RegionDescription in ([Northern],[Southern],[Eastern],[Western])) as pvt

group by pvt.Title,pvt.Northern,pvt.Southern,pvt.Eastern,pvt.Western
UNION ALL

select 'Total' as Title, SUM(Northern), SUM(Southern), SUM(Eastern), SUM(Western),SUM([Northern]+[Southern]+[Eastern]+[Western]) From (
select DISTINCT em.EmployeeID as ID, em.Title, r.RegionDescription
	From Employees em
	JOIN EmployeeTerritories et on em.EmployeeID = et.EmployeeID
	JOIN Territories t ON et.TerritoryID = t.TerritoryID
	JOIN Region r ON r.RegionID = t.RegionID
) tbl2
PIVOT(COUNT(tbl2.ID) for tbl2.RegionDescription in ([Northern],[Southern],[Eastern],[Western])) as pvt
