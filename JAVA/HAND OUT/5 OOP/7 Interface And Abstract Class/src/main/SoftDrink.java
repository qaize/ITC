package main;
/*
 * Softdrink adalah salah satu jenis Item dan merupakan class regular
 */
import java.time.*;
import java.math.*;
import java.time.temporal.*;

public class SoftDrink extends Item {
	private LocalDate expireDate;
	private int totalPerPack;
	private int type;
	private int volume;
	
	@Override
    public double getTaxPercentage() {
    	return this.taxPercentage;
    };
    
    @Override
    public void setTaxPercentage(double taxPercentage) {
    	this.taxPercentage = taxPercentage;
    };	
    
    public LocalDate getExpireDate() {
    	return this.expireDate;
    }
    public void setExpireDate(LocalDate expireDate) {
    	this.expireDate = expireDate;
    }
    
    public int getTotalPerPack() {
    	return this.totalPerPack;
    }
    public void setTotalPerPack(int totalPerPack) {
    	this.totalPerPack = totalPerPack;
    }
    
    public int getType() {
    	return this.type;
    }
    public void setType(int type) {
    	this.type = type;
    }
    
    public int getVolume() {
    	return this.volume;
    }
    public void setVolume(int volume) {
    	this.volume = volume;
    }
  
    public SoftDrink(String itemCode, String name, String brand, BigDecimal price, LocalDate expireDate){
    	super(itemCode, name, brand, price);
        this.expireDate = expireDate;
    } 
    
    @Override
    public String getInformationPerPack() {
        String information = String.format("%d %d of %d per pack\n", this.totalPerPack, this.volume, this.type);
        return information;
    }    
    
    public long daysToExpire() {
    	long range = ChronoUnit.DAYS.between(LocalDate.now(), this.expireDate);
    	return range;
    }    
}
