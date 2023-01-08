package com.company;

import java.math.BigDecimal;

public class Bank {
    private String kodeBank;
    private String nama;
    private BigDecimal biayaAdmin;
    private BigDecimal biayaBulananBank;

    public Bank(){}
    public Bank (String kode,String nama,BigDecimal biayaAdmin,BigDecimal biayaBulananBank){
        this.kodeBank = kode;
        this.nama = nama;
        this.biayaAdmin = biayaAdmin;
        this.biayaBulananBank = biayaBulananBank;
    }

    public void setKodeBank(String kodeBank){
        this.kodeBank = kodeBank;
    }
    public String getKodeBank(){return this.kodeBank;}

    public void setNama(String nama){
        this.nama = nama;

    }
    public String getNama(){
        return this.nama;
    }

    public void setBiayaAdmin(BigDecimal biayaAdmin){
        this.biayaAdmin = biayaAdmin;
    }

    public BigDecimal getBiayaAdmin(){return this.biayaAdmin;}

    public void setBiayaBulananBank(BigDecimal biayaBulananBank){
        this.biayaBulananBank = biayaBulananBank;
    }
    public BigDecimal getBiayaBulananBank(){return  this.biayaBulananBank;}

    public void printInfoBank(){

        System.out.println("Kode Bank : "+this.kodeBank);
        System.out.println("Nama Bank : "+this.nama);
        System.out.println("Biaya Admin : "+this.biayaAdmin);
        System.out.println("Biaya Bulanan : "+this.biayaBulananBank);
    }
}
