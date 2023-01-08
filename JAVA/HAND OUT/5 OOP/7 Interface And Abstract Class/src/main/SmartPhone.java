package main;
/*
 * SmartPhone merupakan salah satu jenis Electronic, tetapi juga mewariskan template dari IMobilePhone
 */

import java.util.*;
import java.math.*;

public class SmartPhone extends Electronic implements IMobilePhone {
	
    public String phoneType;
    public double displaySize;
    public int batteryCapacity;
    public String operatingSystem;
    public List<String> applications;
     
    @Override
    public String getPhoneType() {
    	return this.phoneType;
    }
    
    @Override
    public void setPhoneType(String phoneType) {
    	this.phoneType = phoneType;
    }
    
    @Override
    public double getDisplaySize() {
    	return this.displaySize;
    }
    
    @Override
    public void setDisplaySize(double displaySize) {
    	this.displaySize = displaySize;
    }
    
    @Override
    public int getBatteryCapacity() {
    	return this.batteryCapacity;
    }
    
    @Override
    public void setBatteryCapacity(int batteryCapacity) {
    	this.batteryCapacity = batteryCapacity;
    }
    
    @Override
    public String getOperatingSystem()
    {
    	return this.operatingSystem;
    }
    
    @Override
    public void setOperatingSystem(String operatingSystem) {
    	this.operatingSystem = operatingSystem;
    }
    
    public List<String> getApplications(){
    	return this.applications;
    }
    
    public void setApplications(List<String> applications) {
    	this.applications = applications;
    }
    
    public SmartPhone(String itemCode, String name, String brand, BigDecimal price, int yearsOfWarranty, String phoneType, String operatingSystem) {
    	super(itemCode, name, brand, price, yearsOfWarranty);
        this.phoneType = phoneType;
        this.operatingSystem = operatingSystem;
    }
    
    @Override
    public void executeCalling(String phoneNumber) {
    	System.out.printf("Calling this number %s\n", phoneNumber);
    }
    
    @Override
    public void operatingSystemInformation() {
    	System.out.printf("Operating system in this phone is %s", this.operatingSystem);    	
    }
}
