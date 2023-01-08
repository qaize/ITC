package main;

import java.util.*;
import java.text.*;
import java.math.*;

public class Employee extends Person{
	protected String employeeNIK;
	protected String department;
	protected int grade;
	protected BigDecimal salary;
	protected Calendar hiredDate;

    //super keyword, digunakan pada consturctor untuk menginherit constructor parentnya
    public Employee() {
    	super();
    }
    public Employee(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber,
        String employeeNIK, String department, int grade, BigDecimal salary, Calendar hiredDate){
    	super(name, birthDate, birthPlace, gender, identityCardNumber);
        this.employeeNIK = employeeNIK;
        this.department = department;
        this.grade = grade;
        this.salary = salary;
        this.hiredDate = hiredDate;
    }
    public Employee(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber, String religion, String bloodType, int height, double weight, String citizenship,
       String employeeNIK, String department, int grade, BigDecimal salary, Calendar hiredDate){
    	super(name, birthDate, birthPlace, gender, identityCardNumber, religion, bloodType, height, weight, citizenship);
        this.employeeNIK = employeeNIK;
        this.department = department;
        this.grade = grade;
        this.salary = salary;
        this.hiredDate = hiredDate;
    }

    public void setEmployeeNIK(String employeeNIK) {
    	this.employeeNIK = employeeNIK;
    }
    public String getEmployeeNIK() {
    	return this.employeeNIK;
    }
    public void setDepartment(String department) {
    	this.department = department;
    }
    public String getDepartment() {
    	return this.department;
    }
    public void setGrade(int grade) {
    	this.grade = grade;
    }
    public int getGrade() {
    	return this.grade;
    }
    public void setSalary(BigDecimal salary) {
    	this.salary = salary;
    }
    public BigDecimal getSalary() {
    	return this.salary;
    }
    public void setHiredDate(Calendar hiredDate) {
    	this.hiredDate = hiredDate;
    }
    public Calendar getHiredDate() {
    	return this.hiredDate;
    }
    
    public void printEmployeeInfo() {
        String printInformation = String.format("Employee NIK: %s\nDepartment: %s\nGrade : %d", this.employeeNIK, this.department, this.grade);
        System.out.println(printInformation);
    }
    public int workingDurationInYears() {
    	GregorianCalendar hariIni = new GregorianCalendar();
    	int tahunHariIni = hariIni.get(hariIni.YEAR);
    	int bulanHariIni = hariIni.get(hariIni.MONTH) + 1;
    	int tanggalHariIni = hariIni.get(hariIni.DAY_OF_MONTH);
    	
    	int tahunHireTahun = this.hiredDate.get(this.hiredDate.YEAR);
    	int bulanHireTahun = this.hiredDate.get(this.hiredDate.MONTH) + 1;
    	int tanggalHireTahun = this.hiredDate.get(this.hiredDate.DAY_OF_MONTH);
    	
    	int durasi = tahunHariIni - tahunHireTahun;
    	if((bulanHireTahun < bulanHariIni) || (bulanHireTahun == bulanHariIni && tanggalHireTahun < tanggalHariIni)) {
    		--durasi;
    	}
		return durasi;
    }
    public BigDecimal annualSalary() {
        BigDecimal annualSalary = this.salary.multiply(new BigDecimal(12));
        return annualSalary;
    }	

}
