package main;
/*
 * Manager adalah class yang meng-inherit Employee dan IResident.
 */
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.math.*;
import java.text.NumberFormat;

public class Manager extends Employee implements IResident {
    public String visaStatus;
    public String taxFileNumber;
    public LocalDate visaGrantTime;
    public String firstName;
    public String lastName;
    public String gender;
    public LocalDate birthDate;
    public String birthPlace;
    public String iDCardNumber;
    public String citizenship;
    public String maritalStatus;
    
	@Override
    public String getFirstName() {
    	return this.firstName;
    }   
    @Override
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    } 
    @Override
    public String getLastName() {
    	return this.lastName;
    }
    @Override
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    @Override
    public String getGender() {
    	return this.gender;
    }
    @Override
    public void setGender(String gender) {
    	this.gender = gender;
    } 
    @Override
    public LocalDate getBirthDate() {
    	return this.birthDate;
    }
    @Override
    public void setBirthDate(LocalDate birthDate) {
    	this.birthDate = birthDate;
    }
    @Override
    public String getBirthPlace() {
    	return this.birthPlace;
    }
    @Override
    public void setBirthPlace(String birthPlace) {
    	this.birthPlace = birthPlace;
    }
    @Override
    public String getIDCardNumber() {
    	return this.iDCardNumber;
    }
    @Override
    public void setIDCardNumber(String idCardNumber) {
    	this.iDCardNumber = idCardNumber;
    }
    @Override
    public String getCitizenship() {
    	return this.citizenship;
    }
    @Override
    public void setCitizenship(String citizenship) {
    	this.citizenship = citizenship;
    }
    @Override
    public String getMaritalStatus() {
    	return this.maritalStatus;
    }
    @Override
    public void setMaritalStatus(String maritalStatus) {
    	this.maritalStatus = maritalStatus;
    }   
    
    @Override
	public String getVisaStatus() {
		return this.visaStatus;
	}	
	@Override
	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}	
	@Override
	public String getTaxFileNumber() {
		return this.taxFileNumber;
	}	
	@Override
	public void setTaxFileNumber(String taxFileNumber) {
		this.taxFileNumber = taxFileNumber;
	}
	@Override
	public LocalDate getVisaGrantTime() {
		return this.visaGrantTime;
		
	}
	@Override
	public void setVisaGrantTime(LocalDate visaGrantTime) {
		this.visaGrantTime = visaGrantTime;
	}
    
    public Manager(String visaStatus, String taxFileNumber, LocalDate visaGrantTime, String firstName, String lastName, 
    		String gender, LocalDate birthDate, String birthPlace, String iDCardNumber, String citizenship, String maritalStatus) {
        this.visaStatus = visaStatus;
        this.taxFileNumber = taxFileNumber;
        this.visaGrantTime = visaGrantTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.iDCardNumber = iDCardNumber;
        this.citizenship = citizenship;
        this.maritalStatus = maritalStatus;
    }
    
    public long calculateAge() {
       long years = ChronoUnit.YEARS.between(this.birthDate, LocalDate.now());
       return years;
    }
    
    @Override
    public void employeeInformation() {
        DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatted = shortFormat.format(this.hireDate);
    	System.out.printf("The employee number of %s is %s, and he/she is start working from %s\n", this.firstName, this.employeeNumber, formatted);
    }
    
    public void payTax() {
        BigDecimal annualSalary = getAnnualSalary();
        BigDecimal totalTax;
        if (annualSalary.compareTo(new BigDecimal(40000000)) == 1) {
            totalTax = annualSalary.multiply(new BigDecimal(0.1));
        } else {
            totalTax = annualSalary.multiply(new BigDecimal(0.05));
        }
        Locale locale = new Locale("id", "ID");
        String formatted = NumberFormat.getCurrencyInstance(locale).format(totalTax);
        System.out.printf("%s must pay %s annually from his/her salary", this.firstName, formatted);
    }

    public void printBiodata() {
        String fullName = String.format("%s %s", this.firstName, this.lastName);
        System.out.printf("Nama dari orang ini %s, Jenis Kelamin %s, Status Pernikahan %s\n", fullName, this.gender, this.maritalStatus);
    }
    
    public void printPersonIdentity() {
        System.out.printf("Nomor Kartu Identitas %s, Kewarganegaraan %s\n", this.iDCardNumber, this.citizenship);
    }

    public void residencyInformation() {
        System.out.printf("%s grant a %s, on %s\n", this.firstName, this.visaStatus, this.visaGrantTime);
    }    
}
