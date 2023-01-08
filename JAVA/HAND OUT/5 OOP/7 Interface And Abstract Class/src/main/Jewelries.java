package main;
import java.math.*;

public class Jewelries extends Item {
	private String material;
	private double weight;
	
	public String getMaterial() {
		return this.material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public double getWeight() {
		return this.weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
    public double getTaxPercentage() {
    	return this.taxPercentage;
    }
	
	@Override
    public void setTaxPercentage(double taxPercentage) {
    	if((this.getPrice().compareTo(new BigDecimal(20000000)))==1) {
    		this.setPrice(new BigDecimal(15));
    	}
    	this.setPrice(new BigDecimal(10));
    }

    public Jewelries(String itemCode, String name, String brand, BigDecimal price, String material){
    	super(itemCode, name, brand, price);
        this.material = material;
    }	
	
    @Override
    public String getInformationPerPack() {
        return "Jelewries item has no pack";
    }
    
    public String jewelryInformation() {
        String information = String.format("the jewelry consist of %s gram of %f.2\n", this.material, this.weight);
        return information;
    }
}