package main;

import java.time.LocalDate;
import java.util.*;
import java.text.*;

public class Person {
    protected String name;
    protected LocalDate tglLahir;
    protected Calendar birthDate;
    protected String birthPlace;
    protected String gender;
    protected String identityCardNumber;
    protected String religion;
    protected String bloodType;
    protected int height;
    protected double weight;
    protected String citizenship;

    public Person() {

    }
    public Person(String name, LocalDate birthDate, String birthPlace,
                  String gender, String identityCardNumber) {
        this.name = name;
        this.tglLahir = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.identityCardNumber = identityCardNumber;
    }

    public Person(String name, Calendar birthDate, String birthPlace,
                  String gender, String identityCardNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.identityCardNumber = identityCardNumber;
    }
    public Person(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber, String religion, String bloodType, int height, double weight, String citizenship) {
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.identityCardNumber = identityCardNumber;
        this.religion = religion;
        this.bloodType = bloodType;
        this.height = height;
        this.weight = weight;
        this.citizenship = citizenship;
    }

    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return this.name;
    }
    public void setBirthDate(Calendar birthDate) {
    	this.birthDate = birthDate;
    }
    public Calendar getBirthDate() {
    	return this.birthDate;
    }
    public void setBirthPlace(String birthPlace) {
    	this.birthPlace = birthPlace;
    }
    public String getBirthPlace() {
    	return this.birthPlace;
    }
    public void setGender(String gender) {
    	this.gender = gender;
    }
    public String getGender() {
    	return this.gender;
    }
    public void setIdentityCardNumber(String identityCardNumber) {
    	this.identityCardNumber = identityCardNumber;
    }
    public String getIdentityCardNumber() {
    	return this.identityCardNumber;
    }
    public void setReligion(String religion) {
    	this.religion = religion;
    }
    public String getReligion() {
    	return this.religion;
    }
    public void setBloodType(String bloodType) {
    	this.bloodType = bloodType;
    }
    public String getBloodType() {
    	return this.bloodType;
    }
    public void setHeight(int height) {
    	this.height = height;
    }
    public int getHeight() {
    	return this.height;
    }
    public void setWeight(double weight) {
    	this.weight = weight;
    }
    public double getWeight() {
    	return this.weight;
    }
    public void setCitizenship(String citizenship) {
    	this.citizenship = citizenship;
    }
    public String getCitizenship() {
    	return this.citizenship;
    }
    
    public void printPersonalInformation() {     
    	SimpleDateFormat fullFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String birthDate = fullFormat.format(this.birthDate.getTime());
        String bloodType = this.bloodType;
        String completeInformation = String.format(
            "Nama: %s\nBirth Date: %s\nBirth Place: %s\nGender: %s\nIdentity Card: %s\nReligion: %s\nBlood Type: %s\nHeight: %d\nWeight: %.2f\nCitizenship: %s",
            this.name, birthDate, this.birthPlace, this.gender, this.identityCardNumber, this.religion, bloodType, this.height, this.weight, this.citizenship);
        System.out.println(completeInformation);
    }
    public int calculateAge() {
    	GregorianCalendar hariIni = new GregorianCalendar();
    	int tahunHariIni = hariIni.get(hariIni.YEAR);
    	int bulanHariIni = hariIni.get(hariIni.MONTH) + 1;
    	int tanggalHariIni = hariIni.get(hariIni.DAY_OF_MONTH);
    	
    	int tahunUlangTahun = this.birthDate.get(this.birthDate.YEAR);
    	int bulanUlangTahun = this.birthDate.get(this.birthDate.MONTH) + 1;
    	int tanggalUlangTahun = this.birthDate.get(this.birthDate.DAY_OF_MONTH);
    	
    	int umur = tahunHariIni - tahunUlangTahun;
    	if((bulanUlangTahun < bulanHariIni) || (bulanUlangTahun == bulanHariIni && tanggalUlangTahun < tanggalHariIni)) {
    		--umur;
    	}
		return umur;
    }
}
