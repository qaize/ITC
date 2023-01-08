package main;

public class Mobil {
    //Private Field
    private String type;
    private String brand;
    private int tahunProduksi;
    private int maxSpeed;
    private String warna;
    
    public Mobil(String type, String brand, int tahunProduksi, int maxSpeed, String warna) {
    	this.type = type;
    	this.brand = brand;
    	this.tahunProduksi = tahunProduksi;
    	this.maxSpeed = maxSpeed;
    	this.warna = warna;
    }
    
    public String getType() {
    	return type;
    } 
    public String getBrand() {
    	return brand;
    } 
    public int getTahunProduksi() {
    	return tahunProduksi;
    }
    public int getMaxSpeed() {
    	return maxSpeed;
    }
    public String getWarna() {
    	return warna;
    }
    
    //Selain field, constructor, getter dan setter, kita juga bisa menempatkan method lain ekslusif untuk object dengan class ini.
    public void summaryMobil() {
    	String summary = String.format("Tipe: %s, Merek: %s, Tahun Produksi: %d, Kecepatan Maximum: %d, Warna: %s", 
    			this.type, this.brand, this.tahunProduksi, this.maxSpeed, this.warna);
    	System.out.println(summary);
    }
}
