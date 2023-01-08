package main;
/*
 * Electronic merupakan jenis Item yang sifatnya abstract class,
 * artinya belum bisa di instantiate tanpa mengetahui jelas ini electronic macam apa.
 */

import java.math.*;
import java.time.*;

public abstract class Electronic extends Item {
	private int yearsOfWarranty;
	
	public int getYearsOfWarranty() {
		return this.yearsOfWarranty;
	}
	
	public void setYearsOfWarranty(int yearsOfWarranty) {
		this.yearsOfWarranty = yearsOfWarranty;
	}
	
	@Override
    public double getTaxPercentage() {
		return this.taxPercentage;
	};
	
	@Override
    public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	};
	
    public Electronic(String itemCode, String name, String brand, BigDecimal price, int yearsOfWarranty) {
    	super(itemCode, name, brand, price);
    	this.yearsOfWarranty = yearsOfWarranty;
    }
    
    @Override
    public String getInformationPerPack() {
        return "Electronic item has no pack";
    }    
    
    public LocalDate calculateWarrantyExpire(LocalDate purchaseDate) {
        LocalDate warrantyExpireDate = purchaseDate.plusYears(yearsOfWarranty);
        return warrantyExpireDate;
    }    
}
