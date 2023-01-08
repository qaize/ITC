package main;

import java.util.*;
import java.math.*;

public class Program {

	public static void main(String[] args) {
		
	    /*
	     * OOP atau object oriented programming adalah pemrogramman berbasis object, dimana segala sesuatu data dan informasi disimpan dan diproses oleh setiap object.
	     * 
	     * Setiap object memiliki:
	     * Class: Class adalah kategori atau penggolongan object berdasarkan clasifikasinya di dalam table data.
	     * Attribute: Adalah seluruh data dan informasi yang dimiliki object tersebut. Atau bisa dikatakan seluruh variable yang ekslusif milik object tersebut.
	     * Method: Adalah seluruh function yang dimiliki dan digunakan oleh sebuah object.
	     */
		
		//Membuat 2 buah object Company dengan menggunakan class yang sama.
		Company indocyber = new Company("Indocyber Global Technology", "Bharat Ongso");
		Company idStar = new Company("IDStar", "Bharat Ongso");
		
		//menggunakan getter untuk mendapatkan value field
		String indocyberSummary = getSummaryPerusahaan(indocyber.getName(), indocyber.getOwner());
		System.out.println(indocyberSummary);
		
		idStar.setOwner("Ariva Tan");//menggunakan setter untuk merubah field
		String idStarSummary = getSummaryPerusahaan(idStar.getName(), idStar.getOwner());
		System.out.println(idStarSummary);
		
		Mobil avanza = new Mobil("Avanza", "Toyota", 2017, 180, "Silver"); //Mobil tidak memiliki setter method, sehingga tidak bisa di ubah valuenya.
		
		//Daripada menulis method summary di class program, lebih baik menggunakan method yang dimiliki oleh Karyawan.
		avanza.summaryMobil();
		
		MobilePhone iphone = new MobilePhone("Iphone 6s", "Apple");
		//Karena penggunaan public field, sehingga bisa di assign valuenya secara langsung, tapi ini bukan best practice.
		iphone.warna = "Grey";
		iphone.ukuranLayar = 5.5;
		iphone.ramSize = 4;
		iphone.phoneSummary();
		
		Karyawan ben = new Karyawan();
		ben.setNama("Ben Triyadi");
		ben.setJenisKelamin("Laki-laki");
		ben.setDepartment("Information Technology");
		ben.setNomorKTP("123");
		ben.setPerusahaan(indocyber);
	
		ben.setGaji(new BigDecimal(12000000));
		
		Calendar tanggalLahir = Calendar.getInstance();
		tanggalLahir.set(1988, 10, 27);
		ben.setTanggalLahir(tanggalLahir);
		
		List<Mobil> koleksiMobil = new LinkedList<Mobil>();
		koleksiMobil.add(avanza);
		
		Mobil honda = new Mobil("Brio", "Brio", 2017, 180, "Merah");
		koleksiMobil.add(honda);
		
		ben.setKoleksiMobil(koleksiMobil);
		
		List<MobilePhone> koleksiPhone = new LinkedList<MobilePhone>();
		koleksiPhone.add(iphone);
		MobilePhone samsung = new MobilePhone("Galaxy S8", "Samsung", "Hitam", 5.5, 4);
		koleksiPhone.add(samsung);
		ben.setKoleksiPhone(koleksiPhone);
		
		ben.summaryKaryawan();
		
	}
	
	public static String getSummaryPerusahaan(String namaPerusahaan, String pemilik) {
		String result = String.format("Nama dari perusahaannya %s\nPemilik dari perusahaannya: %s", namaPerusahaan, pemilik);
		return result;
	}
	
}