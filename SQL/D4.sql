
--deklarasi variabel
DECLARE @[test] as [tipe];

--Deklarasi variable dengan value
DECLARE @[nama vairabel] as [tipe data] = [value]

--SET digunakan untuk mengisi nilai dari variable yang bellum terdeklarasi
DECLARE @angkaPertama as INT = 1,
		@test as varchar(10) = 'coy',
		@employe as varchar(10),
		@angkaKedua as INT = 2,
		@pen as int 

		--PRINT @angkaPertama + @angkaKedua

		--PRINT @test
SET @pen = @angkaPertama + @angkaKedua
SET @angkaPertama = 100

select @pen 
--isi dari variable dapat diisikan dengan sebuah custom querry value
--harus sesuai dengan tipe data
select [@angkaPertama @test]

--deklarasi variable
DECLARE @test1 as varchar(3)
-- cara 1
select @test1 = Country from Employees
where EmployeeID = 3
--cara 2
SET @test1 = (select Country from Employees
where EmployeeID = 1)

select @test1


DECLARE @angkaPertama as INT = 4,
		@test as varchar(10) = 'coy',
		@employe as varchar(10),
		@angkaKedua as INT = 2,
		@pen as int 
select 'Hasil penjumlahan' as jenis, CONCAT(' ',@angkaPertama + @angkaKedua) as Hasil,
		'Hasil Pengurangan' as jenis, CONCAT(' ',@angkaPertama - @angkaKedua) as Hasil,
		'Hasil PErkalian' as jenis, CONCAT(' ',@angkaPertama * @angkaKedua) as Hasil,
		'Hasil Pembagian' as jenis, CONCAT(' ',@angkaPertama / @angkaKedua) as Hasil,
		'Hasil Modulus' as jenis, CONCAT(' ',@angkaPertama % @angkaKedua) as Hasil

--akar
select SQRT(625)
--pangkat
select POWER(5,3)


--pembulatan bilangan
declare @decimal as decimal(8,5) = 1.105675
select @decimal
--pembulatan angka naik 10.2 = 11
select CEILING(@decimal)
--pembulatan angka turun 10.8 = 11
select FLOOR(@decimal)
--pembulatan relatif 5 bakal naik, dibwah 5 turun
select ROUND(@decimal,0)

--digit yang dibulatkan 2 angka dibelakang koma
select ROUND(@decimal,1)


select @decimal


--LEN mirip length untuk mengetahui jumlah karater pada sebuah kata
--spasi tidak di hitung apabila tidak ada diikuti
select LEN('TEST BOIS         ')+LEN('hum')


select DATALENGTH(12345);

--uppercase
select UPPER('sat')
--LOwer
select LOWER('SAT')

--PATINDEX sm kyk LIKE mencari kalimat tapi kalimat yg di return adalah awalan indeks kata string yang ditemui 

select PATINDEX('%sat%', 'ssyat, gua satngantuk')

select RTRIM('hai nama saya                    ')
select LTRIM('              hai nama saya                   ')
select LTRIM(RTRIM('              hai nama saya            '))

--paramternya kalimat,startPosisition,END position
select SUBSTRING('NAMA SAYA TELOR',5,10)

--sama kayak patindex tapi parameternya (pencarian,kalimatnya,index mulai)
select CHARINDEX('TELOR','NAMA SAYA TELOR',5)

--mengambil nilai sesuai index 
select RIGHT('saya ngantok',5)
select LEFT('saya ngantok',5)

--parameter repleace ('data','kata yanng akan di repleace', 'data baru')

select REPLACE('testimoni','testi','lesti')

--mengulangi kata('kata',jumlah peprulangan)
select REPLICATE('test',4)


--split data menggunakan delimiter + bisa bebas
--delimiter ini adalah kata sebagai acuan untuk membuat list
declare @nama as varchar(max) = 'santi+lilis+ganda'

select @nama[1]
select value as [karyawan] from string_split(@nama, '+')


--reverse membalikan kalimat

select REVERSE('kasurrusak')

--merubah data menjadi sebuah string
select STR(0010011123)

select FORMAT('34',)

--currency C, N Numerik


--format data
DECLARE @mon as money = 2009000
select FORMAT(@mon,'C','id-ID')
select FORMAT(@mon,'C','en-US')

--merubah nilai
select PARSE('626'+'20' as int) 

--merubah nilai tapi salah
select PARSE('626.23r' as float) 

--error tapi null
select TRY_PARSE('626.23zz' as float) 
select TRY_PARSE('626.23' as float) 

---yang diatas itu ngeparse dari string ke interger atau tipe data lain




--merubah data ke berbagai tipe data
select CONVERT(int,'234') *2

select CONVERT(varchar(10),'477179')



--cara lama CAST ing, sebelum ada Convert

select CAST('888723123' as INT) * 2


--jadi dia mengganti sekaligus menambah atau mengurangi sesuai indeks parameternya (data, start,end,data sisipan)
select STUFF('Indocyber Global Teknlogi',1,4,'INDs')





--data and time

--fungsi ini digunakan untuk mengambil data pada saat ini
declare @now as dateTime = GETDATE()
select @now


set @now = GETUTCDATE()
select @now


--waktu
declare @time as time = '21:23:12'
select @time


--interval yyy,mm,dd
declare @now as dateTime = GETDATE()
select DATENAME(YEAR,@now)
select DATENAME(MONTH,@now)
select DATENAME(WEEKDAY,@now)


--mengambil tahun bulan hari dari GETDATE

select DATEPART(YEAR,GETDATE())
select DATEPART(MONTH,GETDATE())


select YEAR(GETDATE())
select MONTh(GETDATE())
select DAY(GETDATE())


--operasi hari, mengurangi(-) atau menjumlahkan ()
select DATEADD(DAY,-3,GETDATE())


select DATEDIFF(MONTH,GETDATE(),'2023-10-31')
select DATEDIFF(YEAR,GETDATE(),'2023-12-31')
DECLARE @asd as int = select DATEDIFF(YEAR,GETDATE(),'2023-12-31')

select @asd



declare @hari as datetime = '2022-10-10'
select ISDATE('2022-10-10')
select ISDATE('12-10-2022')


--yyyy mm dd
--mm dd yyyy
select FORMAT(GETDATE(),'dd MM yyyy','id-ID')
select FORMAT(GETDATE(),'dd MMM yyyy','id-ID')
select FORMAT(GETDATE(),'dd MMMM yyyy','id-ID')
select FORMAT(GETDATE(),'dddd MMMM yyyy','id-ID')
select FORMAT(GETDATE(),'dddd,dd MMMM yyyy','id-ID')

DECLARE @tanggalan DATETIME = '10/12/2011';
PRINT FORMAT(@tanggalan, 'dd MMMM yyyy', 'en-US');
PRINT FORMAT(@tanggalan, 'dd MMMM yyyy', 'id-ID');
DECLARE @testDate AS DATETIME = '08/01/2011';
PRINT FORMAT(@testDate, 'dd MMMM yyyy', 'id-ID');

go
declare @tanggal as datetime = '2020.10.01'

select CONVERT(datetime,@tanggal,101)


--variable global

SELECT *
FROM dbo.Employees;
SELECT @@ROWCOUNT AS [Total Number of Employee];
SELECT @@ROWCOUNT AS [Total Number of Employee];

select @@SERVERNAME

select @@LANGUAGE

select @@IDENTITY


--XML
--perintah for xml raw digunakan untuk menubah format sql menjadi xml
select EmployeeID,FirstName from Employees
for XML RAW ('Employee'),root('selebew')


select EmployeeID,CONCAT(FirstName,' ',LastName) as [NamaKaryawan] from Employees
for XML RAW ('Karyawan'),root('ListKaryawan')

select EmployeeID,CONCAT(FirstName,' ',LastName) as [NamaKaryawan] from Employees
for XML RAW ('Karyawan'),root('ListKaryawan'),elements

select EmployeeID,CONCAT(FirstName,' ',LastName) as [NamaKaryawan],Region from Employees
for XML RAW ('Karyawan'),root('ListKaryawan'),elements

select EmployeeID,CONCAT(FirstName,' ',LastName) as [NamaKaryawan],Region from Employees
for XML RAW ('Karyawan'),root('ListKaryawan'),elements XSINIL