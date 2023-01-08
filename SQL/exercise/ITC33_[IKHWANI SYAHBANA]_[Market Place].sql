
Create Database MarketPlace3
use MarketPlace3

--create table

--tabel KOTA

CREATE TABLE Kota
(
	IdKota varchar(10) NOT NULL PRIMARY KEY ,
	NamaKota varchar(20)

)

--tabel registrasi
Create Table Registrasi
(
	IdRegistrasi varchar(10) PRIMARY KEY NOT NULL,
	username varchar(50) unique NOT NULL,
	[Password] varchar(50) NOT NULL,
	JenisUser varchar(10) NOT NULL,
	TanggalRegistrasi Datetime
)

--Admin
Create table [Admin]
(
	IdAdmin varchar(10) NOT NULL PRIMARY KEY,
	IdRegistrasi varchar(10) not null,
	NamaAdmin varchar(50),
	Foreign key (IdRegistrasi) References Registrasi(IdRegistrasi)
)

--penjual

Create Table Penjual
(
	IdPenjual Varchar(10) PRIMARY KEY NOT NULL,
	IdRegistrasi varchar(10) NOT NULL,
	NamaDepan varchar(50) NOT NULL,
	NamaBelakang varchar(50) NOT NULL,
	IdKota Varchar(10) NOT NULL,
	CONSTRAINT FK_KOTA_IdKota Foreign Key (IdKota) References Kota(IdKota),
	CONSTRAINT FK_Registrasi_IdRegistrasi Foreign Key (IdRegistrasi) References Registrasi(IdRegistrasi)
)


--Pembeli
Create Table Pembeli
(
	IdPembeli varchar(10) PRIMARY KEY NOT NULL,
	NamaDepan varchar(50) NOT NULL,
	NamaBelakang varchar(50) NOT NULL,
	IdKota Varchar(10) NOT NULL,
	IdRegistrasi varchar(10)  NOT NULL,
	TempatLahir Varchar(50),
	JenisKelamin Varchar(10),
	email varchar(50),
	CONSTRAINT FK_KOTA_IdKotaPembeli Foreign Key (IdKota) References Kota(IdKota),
	CONSTRAINT FK_Registrasi_IdRegistrasiPembeli Foreign Key (IdRegistrasi) References Registrasi(IdRegistrasi)
)

--Toko
Create table Toko
(
	IdToko varchar(10) PRIMARY KEY NOT NULL,
	IdPenjual varchar(10) NOT NULL,
	IdKota varchar(10) Not NULL,
	NamaToko varchar (100) NOT NULL,
	AlamatToko varchar (100) NOT NULL,
	Foreign key (IdPenjual) references Penjual(IdPenjual),
	Foreign Key (IdKota) References Kota(IdKota)

)

--Tabungan Penjual

Create Table [Tabungan Penjual]
(
IdTabunganPenjual varchar(10) NOT NULL Primary Key,
IdPenjual varchar(10) NOT NULL,
Saldo Money,
Foreign Key (IdPenjual) References Penjual(IdPenjual)

)

--Tabungan Pembeli

Create Table [Tabungan Pembeli]
(
IdTabunganPembeli varchar(10) NOT NULL Primary Key,
IdPembeli varchar(10) NOT NULL,
Saldo Money,
Foreign Key (IdPembeli) References Pembeli(IdPembeli)

)

--Kategori
Create Table Kategori
(
	IdKategori varchar(10) NOT NULL PRIMARY KEY,
	NamaKategori varchar(20)
)

--produk

Create Table Produk
(
	IdProduk varchar(10) NOT NULL PRIMARY KEY,
	IdToko varchar(10) NOT NULL,
	IdKategori varchar(10) NOT NULL,
	NamaProduk varchar(100),
	Stock int,
	Harga money,
	minPembelian int,
	TanggalPost datetime,
	foreign key (IdToko) References Toko(IdToko),
	foreign key (IdKategori) References Kategori(IdKategori)

)
--jasaPengirim
Create table [JasaPengiriman]
(
	IdJasa varchar(10) PRIMARY KEY NOT NULL,
	NamaJasaPengirim varchar(50),
	tarif money not null
)

--Keranjang
Create Table Keranjang
(
	IdKeranjang varchar(10) NOT NULL PRIMARY KEY,
	IdPembeli varchar(10) NOT NULL,
	IdProduk varchar(10) NOT  NULL,
	JumlahBarang Int Not NUll,
	KotaAsal varchar(50) NOT NULL,
	KotaTujuan varchar(50),
	tarifTujuan money,
	TotalHarga money,
	IdJasa varchar(10),
	tanggalPesanan datetime not null,
	foreign key (IdJasa) References JasaPengiriman(IdJasa),
	foreign key (IdPembeli) References Pembeli(IdPembeli),
	foreign key (IdProduk) References Produk(IdProduk)
)


--diskusi
--drop table diskusi
create table diskusi
	(
		idDiskusi int identity (1,1) PRIMARY KEY NOT NULL,
		IdPenjual varchar(10) not null Foreign key (IdPenjual) References Penjual(IdPenjual),
		IdPembeli varchar(10) not null Foreign key (IdPembeli) References Pembeli(IdPembeli),
		IdProduk varchar(10) Not null Foreign key (IdProduk) References Produk(IdProduk),
		diskusiPembeli varchar(500),
		diskusiPenjual varchar(500)
	)


	
--review
create table review
	(
		idReview int identity (1,1) PRIMARY KEY NOT NULL,
		IdPenjual varchar(10) not null Foreign key (IdPenjual) References Penjual(IdPenjual),
		IdPembeli varchar(10) not null Foreign key (IdPembeli) References Pembeli(IdPembeli),
		IdProduk varchar(10) Not null Foreign key (IdProduk) References Produk(IdProduk),
		reviewBintang varchar(1),
		reviewPembeli varchar(500)

	)


--sejarah Pembelian

Create table sejarahPembelian
(
	IdSejarahPembelian varchar(10) NOT NULL PRIMARY KEY,
	IdKeranjang varchar(10) NOT NULL,
	TanggalPesanan datetime NOT NULL,
	TanggalTerima Datetime NOT NULL,
	Penjual varchar(200) NOT NULL,
	NamaPembeli varchar(200) NOT NULL,
	NamaProduk varchar(50) NOT NULL,
	JumlahBarang int NOT NULL,
	TotalHargaPembeli money NOT NULL,
	TotalPemasukanPenjual money NOT NULL,
	StatusPengiriman varchar(10) NOT NULL,
	FOreign key (IdKeranjang) References Keranjang(IdKeranjang) 
)






--INSERT DATA

--tabel registrasi
INSERT INTO Registrasi
Values  --('REG01','admin1','abcdefg','Admin',GETDATE()),
		--('REG02','admin2','abcdefg','Admin',GETDATE()),
		('REG07','Pelanggan3','asdf','Pembeli',GETDATE()),
		('REG08','Pelanggan4','asdf','Pembeli',GETDATE()),
		('REG09','Penjual3','12345','Penjual',GETDATE())

select * from Registrasi

--Tabel Admin
INSERT INTO [Admin]
Values  ('ADM1','REG01','Ikhwani'),
		('ADM2','REG02','Syahbana')

select * from Admin

--tabel Kota
select * from Kota
INSERT INTO Kota
	values ('KT1','Mataram'),
			('KT2','Jakarta'),
			('KT3','Bogor'),
			('KT4','Bekasi')

--Tabel Penjual
select * from Penjual

Insert Into Penjual
	values ('PNJ01','REG05','Joi','Alparizi','KT1'),
			('PNJ03','REG09','Asep','udin','KT3')

--tabel pembeli
select * from Pembeli

Insert Into Pembeli
	values  ('COS1','Iwan','sasa','KT1','REG03','MATARAM','LakiLaki','Madara@sda.com'),
			('COS2','losd','forger','KT2','REG04','Jakarta','LakiLaki','loido@uciha.com')
			('COS3','eri','siniga','KT2','REG07','Jakarta','LakiLaki','eri@sda.com'),
			('COS4','anya','arlo','KT3','REG08','Bogor','Perempuan','anya@uciha.com')



--tabel Tabungan Penjual
Insert Into [Tabungan Penjual]
	values ('TABPNJ01','PNJ01',5000000),
			('TABPNJ03','PNJ03',2000000)
		
select * from [Tabungan Penjual]

--tabel Tabungan Pembeli
Insert Into [Tabungan Pembeli]
	values ('TABCOS1','COS3',7000000),
			('TABCOS2','COS4',1000000),
			('TABCOS3','COS3',7000000),
			('TABCOS4','COS4',1000000)

--Tabel Toko 
select * from Toko
insert into Toko
values ('TOKO1','PNJ01','KT1','DAPURKU','Jalan Sahabat Mataram'),
		('TOKO2','PNJ02','KT2','RUMAH ELKTRONIKA','Jalan Sahabat Jakarta')
		('TOKO3','PNJ02','KT3','RUMAH ELKTRONIKA II','Jalan Raya Bogor'),
		('TOKO4','PNJ03','KT4','RUMAH ALAT DAPUR','Jalan Suka suka Bekasi')


--Kategori
insert Into Kategori
	values ('CAT01','Elektronik'),
			('CAT02','Peralatan Dapur')



--Produk
select * from Produk
Insert into Produk
	values  --('PROD1','TOKO1','CAT02','Panci',100,15000,1,GETDATE()),
			--('PROD2','TOKO1','CAT02','Sendok',100,5000,1,GETDATE()),
			--('PROD5','TOKO3','CAT01','Lampu Pijar',100,9000,1,GETDATE()),
			--('PROD6','TOKO4','CAT02','Spatula',100,32000,1,GETDATE())

--keranjang
--select * from Keranjang

SET TotalHarga  = 1*150000+12000 where IdKeranjang = 'KRJ02'
Insert into Keranjang
	values  ('KRJ01','COS1','PROD1',10,'Mataram','Mataram',15000,10*15000+15000,'JP01',GETDATE()),
			('KRJ02','COS2','PROD3',1,'Jakarta','Mataram',12000,1*150000+12000,'JP02',GETDATE())



--jasa pengiriman
select
insert into JasaPengiriman
	values ('JP01','JNE',15000),('JP02','JNT',12000)



--sejarah Pembelian
select * from sejarahPembelian

Insert into sejarahPembelian
values ('SPB01', 'KRJ01',(Select TanggalPesanan from Keranjang where IdKeranjang = 'KRJ01' ),GETDATE(),'Joi Alparizi',' Iwan sasa', 'Panci',10,(select TotalHarga From Keranjang where IdKeranjang = 'KRJ01'),10*15000,'Selesai'),
		('SPB02', 'KRJ02',GETDATE(),GETDATE(),'Lina Putri',' Losd forger', 'Kipas Angin',1,1*150000+12000,1*150000,'Selesai')



--insert diskusi
select * from diskusi
insert into diskusi
	values ('PNJ01','COS1','PROD1','Apakah produk ini tersedia ?','Tersedia kak, silahkan di Order'),
		  ('PNJ02','COS2','PROD3','Apakah produk ini Awet ?','sangat awaet dan Bisa nyala tanpa listrik')

select * from review	
insert into review
	values ('PNJ01','COS1','PROD1','5','Barang sampai dengan selamat'),
		  ('PNJ02','COS2','PROD3','4','Barang sangat bagus sesuai ekspetasi')

--transaksi pertama
select * from [Tabungan Pembeli]
UPDATE [Tabungan Penjual]
	SET Saldo = Saldo + (select TotalPemasukanPenjual  FROM sejarahPembelian where IdKeranjang = 'KRJ01')
	where IdPenjual = 'PNJ01'

UPDATE [Tabungan Pembeli]
	SET Saldo = Saldo - (select TotalHargaPembeli  FROM sejarahPembelian where IdKeranjang = 'KRJ02' )
	where IdTabunganPembeli = 'TABCOS1'

Update Produk
	SET Stock = Stock - (select kj.JumlahBarang from Keranjang kj where kj.IdKeranjang = 'KRJ02' )
	where IdProduk = (select kj.IdProduk from Keranjang kj JOIN Produk pd on kj.IdProduk = pd.IdProduk where kj.IdKeranjang = 'KRJ02')



	--update jumlah stok produk
Update Produk
	SET Stock = Stock - (select kj.JumlahBarang from Keranjang kj where kj.IdKeranjang = 'KRJ02' )
	where IdProduk = (select kj.IdProduk from Keranjang kj JOIN Produk pd on kj.IdProduk = pd.IdProduk where kj.IdKeranjang = 'KRJ02')

--transaksi kedua

UPDATE [Tabungan Penjual]
	SET Saldo = Saldo + (select TotalPemasukanPenjual  FROM sejarahPembelian where IdPesanan=1)
	where IdPenjual = 1

UPDATE [Tabungan Pembeli]
	SET Saldo = Saldo - (select TotalHargaPembeli  FROM sejarahPembelian where IdPesanan=1 )
	where IdTabunganPembeli = 1

Update Produk
	SET Stock = Stock - (select kj.JumlahBarang from Keranjang kj where kj.IdKeranjang = 'KRJ02' )
	where IdProduk = (select kj.IdProduk from Keranjang kj JOIN Produk pd on kj.IdProduk = pd.IdProduk where kj.IdKeranjang = 'KRJ02')



select * from Keranjang kj
JOIN Produk pd on kj.IdProduk = pd.IdProduk
join Toko tk on tk.IdToko = pd.IdToko
Join Penjual pj on tk.IdPenjual = pj.IdPenjual
join Pembeli pb on pb.IdPembeli = kj.IdPembeli
where tk.IdKota = pb.IdKota



select DISTINCT tk.NamaToko,koo.NamaKota, pb.NamaDepan,kot.NamaKota , tr.Tarif
from Toko tk
CrosS join Pembeli pb  
JOIN Kota kot on pb.IdKota = kot.IdKota
JOIN Kota koo on koo.IdKota = tk.IdKota
CROSS JOIN tarif tr
 where tr.[Kota Tujuan] = (select koot.NamaKota from Pembeli pem join Kota koot on koot.IdKota = pem.IdKota where pem.IdPembeli = 'COS1')
 AND 
 pb.IdPembeli = 'COS1'

-- select * from Pembeli
 --select * from tarif

 UPDATE Pembeli
 SET TempatLahir = 'Mataram' where IdPembeli = 'COS1'

 select * from Pembeli

 DECLARE @Selisih as int

 SET @Selisih =


 select TanggalPesanan,TanggalTerima, PARSE(DAY(TanggalPesanan-TanggalTerima)) [LamaPesanan] from sejarahPembelian