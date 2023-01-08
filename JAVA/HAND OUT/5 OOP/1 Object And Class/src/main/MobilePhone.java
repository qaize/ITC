package main;

public class MobilePhone {
    public String type;
    public String brand;
    public String warna;
    public double ukuranLayar;
    public int ramSize;
    
    //Constructor sama seperti method lainnya, sehingga bisa di overloading
    public MobilePhone(String type, String brand) {
    	this.type = type;
    	this.brand = brand;
    } 
    public MobilePhone(String type, String brand, String warna, double ukuranLayar) {
    	this.type = type;
    	this.brand = brand;
    	this.warna = warna;
    	this.ukuranLayar = ukuranLayar;
    }  
    public MobilePhone(String type, String brand, String warna, double ukuranLayar, int ramSize) {
    	this.type = type;
    	this.brand = brand;
    	this.warna = warna;
    	this.ukuranLayar = ukuranLayar;
    	this.ramSize = ramSize;
    }
    
    public String getType() {
    	return this.type;
    }  
    public void setType(String type) {
    	this.type = type;
    }
    
    public String getBrand() {
    	return this.brand;
    }
    public void setBrand(String brand) {
    	this.brand = brand;
    }
    
    public String getWarna() {
    	return this.warna;
    }
    public void setWarna(String warna) {
    	this.warna = warna;
    }
    
    public double getUkuranLayar() {
    	return this.ukuranLayar;
    }   
    public void setUkuranLayar(double ukuranLayar) {
    	this.ukuranLayar = ukuranLayar;
    }
    
    public int getRamSize() {
    	return this.ramSize;
    }   
    public void setRamSize(int ramSize) {
    	this.ramSize = ramSize;
    }
    
    public void phoneSummary() {
    	String summary = String.format("Type: %s, Brand: %s, Warna: %s, Ukuran layar: %.2f, Ram size: %d", 
    			this.type, this.brand, this.warna, this.ukuranLayar, this.ramSize);
    	System.out.println(summary);
    }
    
}
