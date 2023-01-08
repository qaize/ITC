package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Nasabah extends Person {

    private String NoRekening;
    private String Password;
    private BigDecimal Saldo;
    private Bank bank;
    private List<String> log = new LinkedList<>();

    public Nasabah(){super();};
    public Nasabah(String NoRekening, String Password, BigDecimal Saldo, String nama, String tmptLahir, LocalDate tglLahir,
                   String alamat,Bank bank){
        super(nama,tmptLahir,tglLahir,alamat);
        this.NoRekening = NoRekening;
        this.Password = Password;
        this.Saldo = Saldo;
        this.bank = bank;

    }

    public void setNoRekening (String NoRekening){this.NoRekening = NoRekening;}
    public String getNoRekening (){return this.NoRekening;}

    public void setPassword (String Password){this.Password = Password;}
    public String getPassword (){return this.Password;}

    public void setSaldo (BigDecimal Saldo){this.Saldo = Saldo;}
    public BigDecimal getSaldo (){return this.Saldo;}

    public void printallInformation(){
        System.out.println(String.format("No Rekening : %s",this.NoRekening));
        System.out.println(String.format("Password : %s",this.Password));
        System.out.println("Saldo : "+this.Saldo);

    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<String> getLog() {
        return this.log;
    }
    public void showPrevLog(){
        for(String st : log){
            System.out.println(st);
        }
    }

    public void setLog(List<String> log) {
        this.log = log;
    }

    public void addLog(String data){
        log.add(data);
    }
}
