package main;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TaxResident implements ICitizen, IResident{
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
    public boolean citizenMedicalInsuranceProgram;
    public boolean citizenLifeInsuranceProgram;
    public boolean citizenRetirementProgram;
    
    public String getFirstName() {
    	return this.firstName;
    }   

    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

    public String getLastName() {
    	return this.lastName;
    }

    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }  

    public String getGender() {
    	return this.gender;
    }

    public void setGender(String gender) {
    	this.gender = gender;
    }    

    public LocalDate getBirthDate() {
    	return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
    	this.birthDate = birthDate;
    }

    public String getBirthPlace() {
    	return this.birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
    	this.birthPlace = birthPlace;
    }

    public String getIDCardNumber() {
    	return this.iDCardNumber;
    }

    public void setIDCardNumber(String idCardNumber) {
    	this.iDCardNumber = idCardNumber;
    }

    public String getCitizenship() {
    	return this.citizenship;
    }
    
    public void setCitizenship(String citizenship) {
    	this.citizenship = citizenship;
    }

    public String getMaritalStatus() {
    	return this.maritalStatus;
    }

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

	@Override
    public boolean getCitizenMedicalInsuranceProgram() {
		return this.citizenMedicalInsuranceProgram;
	}
	
	@Override
    public void setCitizenMedicalInsuranceProgram(boolean citizenMedicalInsuranceProgram) {
		this.citizenMedicalInsuranceProgram = citizenMedicalInsuranceProgram;
	}
	
	@Override
    public boolean getCitizenLifeInsuranceProgram() {
		return this.citizenLifeInsuranceProgram;
	}
	
	@Override
    public void setCitizenLifeInsuranceProgram(boolean citizenLifeInsuranceProgram) {
		this.citizenLifeInsuranceProgram = citizenLifeInsuranceProgram;
	}
	
	@Override
    public boolean getCitizenRetirementProgram() {
		return this.citizenRetirementProgram;
	}
	
	@Override
    public void setCitizenRetirementProgram(boolean citizenRetirementProgram) {
		this.citizenRetirementProgram = citizenRetirementProgram;
	}
	
	@Override
	public void payTax() {
        double taxPercentage = 5;
        if (this.citizenMedicalInsuranceProgram == true) {
            taxPercentage += 5;
        }
        if (this.citizenLifeInsuranceProgram == true) {
            taxPercentage += 5;
        }
        if (this.citizenRetirementProgram == true) {
            taxPercentage += 5;
        }
        System.out.printf("Total percentage of tax is %.2f %%, paid by %s\n", taxPercentage, this.visaStatus);		
	}
	
	@Override
	public void residencyInformation() {
		DateTimeFormatter shortFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String grantTime = shortFormat.format(this.visaGrantTime);
		System.out.printf("%s grant a %s, on %s\n", this.firstName, this.visaStatus, grantTime);		
	}
	
    //Ini hanya contoh, tetapi pada dasarnya kalau ini semua satu aplikasi, ini contoh yang tidak baik, karena double code dengan Customer
    public long calculateAge() {
        LocalDate today = LocalDate.now();
        long yearsPeriod = ChronoUnit.YEARS.between(this.birthDate, today);
        return yearsPeriod;
    }

    public void printBiodata() {
        String fullName = String.format("%s %s", this.firstName, this.lastName);
        System.out.printf("Nama dari orang ini %s, Jenis Kelamin %s, Status Pernikahan %s\n", fullName, this.gender, this.maritalStatus);    	
    }
    
    public void printPersonIdentity() {
        System.out.printf("Nomor Kartu Identitas %s, Kewarganegaraan %s\n", this.iDCardNumber, this.citizenship);    	
    }

}
