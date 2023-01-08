package main;

import java.util.*;
import java.math.*;
import java.text.*;

public class Manager extends Employee {
    private double bonusPercentage;
    private String managerType;
    private String branch;
    private List<Employee> subordinates;

    public Manager(){
    	super();
    }
    public Manager(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber, String employeeNIK, 
    		String department, int grade, BigDecimal salary, Calendar hiredDate, double bonusPercentage, String managerType, String branch, List<Employee> subordinates){  	
    	super(name, birthDate, birthPlace, gender, identityCardNumber, employeeNIK, department, grade, salary, hiredDate); 	
        this.bonusPercentage = bonusPercentage;
        this.managerType = managerType;
        this.branch = branch;
        this.subordinates = subordinates;
    }
    public Manager(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber, String religion, String bloodType, 
    		int height, double weight, String citizenship, String employeeNIK, String department, int grade, BigDecimal salary, Calendar hiredDate, double bonusPercentage, String managerType, String branch, List<Employee> subordinates){      
    	super(name, birthDate, birthPlace, gender, identityCardNumber, religion, bloodType, height, weight, citizenship, employeeNIK, department, grade, salary, hiredDate);
        this.bonusPercentage = bonusPercentage;
        this.managerType = managerType;
        this.branch = branch;
        this.subordinates = subordinates;
    }

    public void setBonusPercentage(double bonusPercentage) {
    	this.bonusPercentage = bonusPercentage;
    }
    public double getBonusPercentage() {
    	return this.bonusPercentage;
    }
    public void setManagerType(String managerType) {
    	this.managerType = managerType;
    }
    public String getManagerType() {
    	return this.managerType;
    }
    public void setBranch(String branch) {
    	this.branch = branch;
    }
    public String getBranch() {
    	return this.branch;
    }
    public void setSubordinates(List<Employee> subordinates) {
    	this.subordinates = subordinates;
    }
    public List<Employee> getSubordinates(){
    	return this.subordinates;
    }
    
    public BigDecimal calculateAnnualBonus() {
        BigDecimal percentage = new BigDecimal(this.bonusPercentage);
        BigDecimal annual =  this.salary.multiply(new BigDecimal(12));
        BigDecimal annualBonus = annual.multiply(percentage);
        return annualBonus;
    }
    public void printManagerialInfo() {
        String managerialInfo = String.format("He/She is %s of %s.", this.managerType, this.branch);
        System.out.println(managerialInfo);
    }
    //Overriding method adalah proses dimana class yang menurunkan menggunakan method yang sama, pada saat object manager dibuat, method dengan signature yang sama akan di replace.
    @Override
    public void printEmployeeInfo() {
        String printInformation = String.format("Manager NIK: %s\nDepartment: %s\nGrade : %d", this.employeeNIK, this.department, this.grade);
        System.out.println(printInformation);
    }
}


