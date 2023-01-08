package main;

import java.time.LocalDate;
import java.util.*;
import java.text.*;
import java.math.*;

public class Customer extends Person {
	protected String customerNumber;
	protected BigDecimal balance;
	protected BigDecimal voucher;
	protected Calendar registerationDate;
    
    public Customer(){
    	super();
    }

    public Customer(String customerNumber, String name, LocalDate birthDate, String birthPlace,
                    String gender, String identityCardNumber){
        super(name, birthDate, birthPlace, gender, identityCardNumber);
        this.customerNumber = customerNumber;
    }

    public Customer(String customerNumber, String name, Calendar birthDate, String birthPlace,
                    String gender, String identityCardNumber){
        super(name, birthDate, birthPlace, gender, identityCardNumber);
        this.customerNumber = customerNumber;
    }

    public Customer(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber,
        String customerNumber, BigDecimal balance, BigDecimal voucher, Calendar registerationDate){
    	super(name, birthDate, birthPlace, gender, identityCardNumber);
        this.customerNumber = customerNumber;
        this.balance = balance;
        this.voucher = voucher;
        this.registerationDate = registerationDate;
    }
    public Customer(String name, Calendar birthDate, String birthPlace, String gender, String identityCardNumber, String religion, String bloodType, int height, double weight, String citizenship,
        String customerNumber, BigDecimal balance, BigDecimal voucher, Calendar registerationDate){
    	super(name, birthDate, birthPlace, gender, identityCardNumber, religion, bloodType, height, weight, citizenship);
        this.customerNumber = customerNumber;
        this.balance = balance;
        this.voucher = voucher;
        this.registerationDate = registerationDate;
    }

    public void setCustomerNumber(String customerNumber) {
    	this.customerNumber = customerNumber;
    }
    public String getCustomerNumber() {
    	return this.customerNumber;
    }
    public void setBalance(BigDecimal balance) {
    	this.balance = balance;
    }
    public BigDecimal getBalance() {
    	return this.balance;
    }
    public void setVoucher(BigDecimal voucher) {
    	this.voucher = voucher;
    }
    public BigDecimal getVoucher() {
    	return this.voucher;
    }
    public void setRegisterationDate(Calendar registerationDate) {
    	this.registerationDate = registerationDate;
    }
    public Calendar getRegisterationDate() {
    	return this.registerationDate;
    }
    
    public void printCustomerInfo() {
    	SimpleDateFormat fullFormat = new SimpleDateFormat("dd-MMMM-yyyy");
    	String formatedRegisterationDate = fullFormat.format(this.registerationDate.getTime());
        System.out.printf("Customer Number: %s\nBalance: %s\nVoucher: %s\nRegisteration: %s\n", this.customerNumber, balance.toString(), voucher.toString(), formatedRegisterationDate);
    }
    
}
