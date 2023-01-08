package main;

import java.time.*;
import java.math.*;
import java.time.temporal.ChronoUnit;

/*
 * Employee adalah abstract class yang akan di inherit oleh setiap class pekerja.
 */
public abstract class Employee {
	protected String employeeNumber;
	protected LocalDate hireDate;
	private BigDecimal salary;
	
	public String getEmployeeNumber() {
		return this.employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	public LocalDate getHireDate() {
		return this.hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	public BigDecimal getSalary() {
		return this.salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public abstract void employeeInformation();
	
    public BigDecimal getAnnualSalary() {
        return this.salary.multiply(new BigDecimal(12));
    }
    
    public long yearsOfWorking() {
    	long years = ChronoUnit.YEARS.between(this.hireDate, LocalDate.now());
    	return years;
    }
}