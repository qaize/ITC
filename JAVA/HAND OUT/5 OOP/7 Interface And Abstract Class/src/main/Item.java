package main;
/*
 * Item merupakan abstract class, karena aplikasi ini tidak mengijin kan program
 * untuk membuat object tanpa item yang spesifik.
 */
import java.math.*;

public abstract class Item {
    private String itemCode;
    private String name;
    private String brand;
    private BigDecimal price;
    protected double taxPercentage;
    
    public String getItemCode() {
    	return this.itemCode;
    }
    public void setItemCode(String itemCode) {
    	this.itemCode = itemCode;
    }
    
    public String getName() {
    	return this.name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getBrand() {
    	return this.brand;
    }
    public void setBrand(String brand) {
    	this.brand = brand;
    }
    
    public BigDecimal getPrice() {
    	return this.price;
    }
    public void setPrice(BigDecimal price) {
    	this.price = price;
    }
    
    public abstract double getTaxPercentage();
    public abstract void setTaxPercentage(double taxPercentage);

    public Item(String itemCode, String name, String brand, BigDecimal price) {
        this.itemCode = itemCode;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    
    public BigDecimal calculatePriceAndTax() {
    	BigDecimal taxPercentage = new BigDecimal(this.taxPercentage);
    	taxPercentage = taxPercentage.divide(new BigDecimal(100));
    	BigDecimal tax = taxPercentage.multiply(this.price);
    	BigDecimal total = this.price.add(tax);
    	return total; 	
    }

    public abstract String getInformationPerPack();
}
