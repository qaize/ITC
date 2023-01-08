package main;

import java.util.*;
import java.math.*;

public class Karyawan {
    private String nama;
    private Calendar tanggalLahir;
    private String nomorKTP;
    private String jenisKelamin;
    private List<Mobil> koleksiMobil;
    private List<MobilePhone> koleksiPhone;
    private Company perusahaan;
    private String department;
    private BigDecimal gaji;
    
    /*Karyawan tidak dituliskan constructornya, oleh karena itu secara otomatis dibuatkan default constructor oleh java.
      Default constructor merupakan blank constructor.
     */
    
    public String getNama() {
        return this.nama;
    }
    public void setNama(String argNama) {
        this.nama = argNama;
    }

    public Calendar getTanggalLahir() {
        return this.tanggalLahir;
    }
    public void setTanggalLahir(Calendar argTanggalLahir) {
        this.tanggalLahir = argTanggalLahir;
    }

    public String getNomorKTP() {
        return this.nomorKTP;
    }
    public void setNomorKTP(String argNomorKTP) {
        this.nomorKTP = argNomorKTP;
    }

    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    public void setJenisKelamin(String argJenisKelamin) {
        this.jenisKelamin = argJenisKelamin;
    }
    
    public List<Mobil> getKoleksiMobil() {
        return this.koleksiMobil;
    }
    public void setKoleksiMobil(List<Mobil> argKoleksiMobil) {
        this.koleksiMobil = argKoleksiMobil;
    }

    public List<MobilePhone> getKoleksiPhone() {
        return this.koleksiPhone;
    }
    public void setKoleksiPhone(List<MobilePhone> argKoleksiPhone) {
        this.koleksiPhone = argKoleksiPhone;
    }

    public Company getPerusahaan() {
        return this.perusahaan;
    }
    public void setPerusahaan(Company argPerusahaan) {
        this.perusahaan = argPerusahaan;
    }

    public String getDepartment() {
        return this.department;
    }
    public void setDepartment(String argDepartment) {
        this.department = argDepartment;
    }

    public BigDecimal getGaji() {
        return this.gaji;
    }
    public void setGaji(BigDecimal argGaji) {
        this.gaji = argGaji;
    }    
    
    public int hitungUmur() {
    	GregorianCalendar hariIni = new GregorianCalendar();
    	int tahunHariIni = hariIni.get(hariIni.YEAR);
    	int bulanHariIni = hariIni.get(hariIni.MONTH) + 1;
    	int tanggalHariIni = hariIni.get(hariIni.DAY_OF_MONTH);
    	
    	int tahunUlangTahun = this.tanggalLahir.get(this.tanggalLahir.YEAR);
    	int bulanUlangTahun = this.tanggalLahir.get(this.tanggalLahir.MONTH) + 1;
    	int tanggalUlangTahun = this.tanggalLahir.get(this.tanggalLahir.DAY_OF_MONTH);
    	
    	int umur = tahunHariIni - tahunUlangTahun;
    	if((bulanUlangTahun < bulanHariIni) || (bulanUlangTahun == bulanHariIni && tanggalUlangTahun < tanggalHariIni)) {
    		--umur;
    	}
		return umur;
    }
    
    public void printAllMobil() {
    	System.out.println("==============================Mobil yang digunakan=========================");
    	for(Mobil mobil : this.koleksiMobil) {
    		mobil.summaryMobil();
    	}
    }
    
    public void printAllPhone() {
    	System.out.println("==============================HP yang digunakan=========================");
    	for(MobilePhone phone : this.koleksiPhone) {
    		phone.phoneSummary();
    	}
    }
    
    public void summaryKaryawan() {	
    	System.out.println("================================================================");
    	String biodata = String.format("Nama: %s, Umur: %d tahun, Nomor KTP: %s, Jenis Kelamin: %s", 
    			this.nama, this.hitungUmur(), this.nomorKTP, this.jenisKelamin);
    	System.out.println(biodata);
    	printAllMobil();
    	printAllPhone();
    	String professionInfo = String.format("Department: %s, Salary: Rp. %.2f", this.department, this.gaji);
    	System.out.println(professionInfo);
    }
}
