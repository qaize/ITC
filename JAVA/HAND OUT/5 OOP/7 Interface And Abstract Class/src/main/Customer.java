package main;
import java.math.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Customer implements IPerson{
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate birthDate;
	private String birthPlace;
	private String iDCardNumber;
	private String citizenship;
	private String maritalStatus;	
	
    public String memberCode;
    public BigDecimal balance;
	
    public Customer() {
    	
    }
    
    public Customer(String memberCode, BigDecimal balance) {
    	this.memberCode = memberCode;
    	this.balance = balance;
    }
    
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

    public String getMemberCode() {
    	return this.memberCode;
    }
    public void setMemberCode(String memberCode) {
    	this.memberCode = memberCode;
    }
    
    public BigDecimal getBalance() {
    	return this.balance;
    }
    public void setBalance(BigDecimal balance) {
    	this.balance = balance;
    }
    
    @Override
    public void printBiodata() {
        String fullName = String.format("%s %s", this.firstName, this.lastName);
        System.out.printf("Nama dari orang ini %s, Jenis Kelamin %s, Status Pernikahan %s\n", fullName, this.gender, this.maritalStatus);    	
    }
    
    @Override
    public void printPersonIdentity() {
        System.out.printf("Nomor Kartu Identitas %s, Kewarganegaraan %s\n", this.iDCardNumber, this.citizenship);    	
    }
    
    public void printMemberInformation() {
        System.out.printf("Member with code: %s, still has %s\n", this.memberCode, this.balance);
    }    
    
    @Override
    public long calculateAge() {
        LocalDate today = LocalDate.now();
        long yearsPeriod = ChronoUnit.YEARS.between(this.birthDate, today);
        return yearsPeriod;
    }

}